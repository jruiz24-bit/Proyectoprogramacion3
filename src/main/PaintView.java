package main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PaintView extends JPanel {
    private Ventana parent;
    private Color colorActual = Color.BLACK;
    private int grosorActual = 3;
    private String herramientaActual = "Pincel";

    public PaintView(Ventana parent) {
        this.parent = parent;
        
        this.setBounds(0, 0, 1000, 700); 
        this.setLayout(new BorderLayout());
        this.setBackground(Color.LIGHT_GRAY);

        
        JPanel pnlHerramientas = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        pnlHerramientas.setBackground(new Color(230, 230, 230));
        pnlHerramientas.setBorder(BorderFactory.createTitledBorder("Herramientas y Formas"));

        JButton btnPincel = new JButton("Pincel");
        JButton btnBorrador = new JButton("Borrador");
        JButton btnLimpiar = new JButton("Limpiar Lienzo");
        
        JLabel lblGrosor = new JLabel("Grosor:");
        JSlider sliderGrosor = new JSlider(1, 20, 3);
        sliderGrosor.setPreferredSize(new Dimension(100, 20));

        JButton btnRect = new JButton("Rectángulo");
        JButton btnCirc = new JButton("Círculo");
        JButton btnTria = new JButton("Triángulo");
        JButton btnLine = new JButton("Línea");

        pnlHerramientas.add(btnPincel);
        pnlHerramientas.add(btnBorrador);
        pnlHerramientas.add(lblGrosor);
        pnlHerramientas.add(sliderGrosor);
        pnlHerramientas.add(new JSeparator(SwingConstants.VERTICAL));
        pnlHerramientas.add(btnRect);
        pnlHerramientas.add(btnCirc);
        pnlHerramientas.add(btnTria);
        pnlHerramientas.add(btnLine);
        pnlHerramientas.add(btnLimpiar);

        this.add(pnlHerramientas, BorderLayout.NORTH);


        Lienzo lienzo = new Lienzo();
        this.add(lienzo, BorderLayout.CENTER);

       
        JPanel pnlColores = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        pnlColores.setBorder(BorderFactory.createTitledBorder("Paleta de Colores"));

        Color[] colores = {Color.WHITE, Color.BLACK, Color.GRAY, Color.BLUE, Color.RED, Color.GREEN};
        String[] nombresColores = {"Blanco", "Negro", "Gris", "Azul", "Rojo", "Verde"};

        for (int i = 0; i < colores.length; i++) {
            JButton btnCol = new JButton();
            btnCol.setBackground(colores[i]);
            btnCol.setPreferredSize(new Dimension(30, 30));
            btnCol.setToolTipText(nombresColores[i]);
            pnlColores.add(btnCol);
        }

        JButton btnVolver = new JButton("Volver al Menú");
        btnVolver.addActionListener(e -> parent.router("login"));
        pnlColores.add(btnVolver);

        this.add(pnlColores, BorderLayout.SOUTH);
    }

    class Lienzo extends JPanel {
        public Lienzo() {
            this.setBackground(Color.WHITE);
            this.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            
            
            g2d.setColor(Color.BLUE);
            g2d.drawRect(50, 50, 100, 60); 
            
            g2d.setColor(Color.RED);
            g2d.drawOval(200, 50, 80, 80); 
            
            g2d.setColor(Color.GREEN);
            g2d.drawPolygon(new int[]{400, 350, 450}, new int[]{50, 130, 130}, 3); 
            
            g2d.setColor(Color.BLACK);
            g2d.drawLine(500, 50, 600, 130); 
        }
    }
}