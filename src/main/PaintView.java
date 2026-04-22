package main;
//22
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class PaintView extends JPanel {
    private Ventana parent;
    private Color colorActual = Color.BLACK;
    private int grosorActual = 3;
    private String herramientaActual = "Pincel"; 
    private Lienzo lienzo;
    private JLabel lblGrosor;

    public PaintView(Ventana parent) {
        this.parent = parent;
      
        this.setBounds(0, 0, 800, 700); 
        this.setLayout(new BorderLayout());

     
        JPanel pnlHerramientas = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        pnlHerramientas.setBackground(new Color(230, 230, 230));
        pnlHerramientas.setBorder(BorderFactory.createTitledBorder("Herramientas"));

        
        JButton btnPincel = crearBotonHerramienta("Pincel", "Pincel");
        JButton btnBorrador = crearBotonHerramienta("Borrador", "Borrador"); 
        
        
        lblGrosor = new JLabel("G" + grosorActual + "px");
        JSlider sliderGrosor = new JSlider(1, 30, grosorActual);
        sliderGrosor.setPreferredSize(new Dimension(80, 20));
        sliderGrosor.addChangeListener(e -> {
            grosorActual = sliderGrosor.getValue();
            lblGrosor.setText("G" + grosorActual + "px");
        });

        
        JButton btnRect = crearBotonHerramienta("Rectángulo", "Rectangulo");
        JButton btnCirc = crearBotonHerramienta("Círculo", "Circulo");
        JButton btnLine = crearBotonHerramienta("Línea", "Linea");

        JButton btnLimpiar = new JButton("Limpiar Lienzo");
        btnLimpiar.addActionListener(e -> lienzo.limpiar());

        pnlHerramientas.add(btnPincel);
        pnlHerramientas.add(btnBorrador);
        pnlHerramientas.add(new JSeparator(SwingConstants.VERTICAL));
        pnlHerramientas.add(lblGrosor);
        pnlHerramientas.add(sliderGrosor);
        pnlHerramientas.add(new JSeparator(SwingConstants.VERTICAL));
        pnlHerramientas.add(btnRect);
        pnlHerramientas.add(btnCirc);
        pnlHerramientas.add(btnLine);
        pnlHerramientas.add(new JSeparator(SwingConstants.VERTICAL));
        pnlHerramientas.add(btnLimpiar);

        this.add(pnlHerramientas, BorderLayout.NORTH);

      
        lienzo = new Lienzo();
        this.add(lienzo, BorderLayout.CENTER);

       
        JPanel pnlColores = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        pnlColores.setBorder(BorderFactory.createTitledBorder("Colores"));
        Color[] colores = {Color.BLACK, Color.GRAY, Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.MAGENTA};
        
        for (Color c : colores) {
            JButton btnCol = new JButton();
            btnCol.setBackground(c);
            btnCol.setPreferredSize(new Dimension(25, 25));
            btnCol.addActionListener(e -> {
                colorActual = c;
                
                if(herramientaActual.equals("Borrador")) herramientaActual = "Pincel";
            });
            pnlColores.add(btnCol);
        }

        JButton btnVolver = new JButton("Volver");
        btnVolver.addActionListener(e -> parent.router("login"));
        pnlColores.add(btnVolver);
        this.add(pnlColores, BorderLayout.SOUTH);
    }

    private JButton crearBotonHerramienta(String texto, String toolName) {
        JButton btn = new JButton(texto);
        btn.addActionListener(e -> herramientaActual = toolName);
        return btn;
    }

 
    class Lienzo extends JPanel {
        private BufferedImage imagenBuffer;
        private Graphics2D g2Buffer;
        private int xPressed, yPressed, xCurrent, yCurrent, xAnterior, yAnterior;
        private boolean isDrawing = false;

        public Lienzo() {
            this.setBackground(Color.WHITE);
            this.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));

           
            this.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    if (g2Buffer == null) iniciarBuffer();
                    xPressed = e.getX();
                    yPressed = e.getY();
                    xAnterior = xPressed;
                    yAnterior = yPressed;
                    xCurrent = xPressed;
                    yCurrent = yPressed;
                    isDrawing = true;
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    isDrawing = false;
                  
                    configurarGraficos(g2Buffer);
                    dibujarFigura(g2Buffer, xPressed, yPressed, e.getX(), e.getY());
                    repaint();
                }
            });

            
            this.addMouseMotionListener(new MouseMotionAdapter() {
                @Override
                public void mouseDragged(MouseEvent e) {
                    xCurrent = e.getX();
                    yCurrent = e.getY();

                  
                    if (herramientaActual.equals("Pincel") || herramientaActual.equals("Borrador")) {
                        configurarGraficos(g2Buffer);
                        g2Buffer.drawLine(xAnterior, yAnterior, xCurrent, yCurrent);
                        xAnterior = xCurrent;
                        yAnterior = yCurrent;
                    }
                    
                    repaint(); 
                }
            });
        }

        private void iniciarBuffer() {
            imagenBuffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
            g2Buffer = imagenBuffer.createGraphics();
            g2Buffer.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            limpiar();
        }

        public void limpiar() {
            if (g2Buffer != null) {
                g2Buffer.setColor(Color.WHITE);
                g2Buffer.fillRect(0, 0, getWidth(), getHeight());
                repaint();
            }
        }

        
        private void configurarGraficos(Graphics2D g2d) {
            if (herramientaActual.equals("Borrador")) {
                g2d.setColor(Color.WHITE); 
            } else {
                g2d.setColor(colorActual); 
            }
           
            g2d.setStroke(new BasicStroke(grosorActual, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        }

        
        private void dibujarFigura(Graphics2D g2d, int x1, int y1, int x2, int y2) {
            int x = Math.min(x1, x2);
            int y = Math.min(y1, y2);
            int ancho = Math.abs(x1 - x2);
            int alto = Math.abs(y1 - y2);

            switch (herramientaActual) {
                case "Rectangulo": g2d.drawRect(x, y, ancho, alto); break;
                case "Circulo": g2d.drawOval(x, y, ancho, alto); break;
                case "Linea": g2d.drawLine(x1, y1, x2, y2); break;
                
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (imagenBuffer == null) iniciarBuffer();
            
           
            g.drawImage(imagenBuffer, 0, 0, null);
            
            
            if (isDrawing && !herramientaActual.equals("Pincel") && !herramientaActual.equals("Borrador")) {
                Graphics2D g2dPreview = (Graphics2D) g.create(); 
                configurarGraficos(g2dPreview);
                g2dPreview.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));  
                dibujarFigura(g2dPreview, xPressed, yPressed, xCurrent, yCurrent);
                g2dPreview.dispose();
            }
        }
    }
}