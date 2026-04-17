package main;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.*;

public class Memorama extends JPanel {
    private Ventana parent;
    private JLabel lblMovimientos, lblPares;
    private int movimientos = 0, paresEncontrados = 0;
    
    private JButton firstCard = null, secondCard = null;
    private int firstVal = -1, secondVal = -1;
    private int firstIdx = -1;
    private boolean isWaiting = false;

    private Integer[] valores = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8};
    private ArrayList<Integer> listaCartas;
    private JButton[] botones = new JButton[16];
    private boolean[] fijadas = new boolean[16]; 

    public Memorama(Ventana parent) {
        this.parent = parent;
        this.setLayout(new BorderLayout());
        this.setBounds(50, 50, 500, 600);

        
        JPanel top = new JPanel();
        top.setBackground(Color.CYAN);
        lblMovimientos = new JLabel("Movimientos: 0");
        lblMovimientos.setFont(new Font("Arial", Font.BOLD, 14));
        lblPares = new JLabel("Pares: 0");
        lblPares.setFont(new Font("Arial", Font.BOLD, 14));
        top.add(lblMovimientos);
        top.add(lblPares);
        this.add(top, BorderLayout.NORTH);

       
        JPanel tablero = new JPanel(new GridLayout(4, 4, 10, 10));
        tablero.setBackground(Color.GRAY);
        tablero.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        iniciarJuegoLogica();

        for (int i = 0; i < 16; i++) {
            botones[i] = new JButton();
            botones[i].setFocusPainted(false);
            botones[i].setIcon(cargarIcono("/images/dino_back.png"));
            
            final int index = i;
            botones[i].addActionListener(e -> intentarVoltear(index));
            tablero.add(botones[i]);
        }
        this.add(tablero, BorderLayout.CENTER);

       
        JPanel bottom = new JPanel();
        JButton reiniciar = new JButton("Reiniciar");
        reiniciar.addActionListener(e -> reiniciarJuego());
        bottom.add(reiniciar);
        this.add(bottom, BorderLayout.SOUTH);
    }

    private void iniciarJuegoLogica() {
        listaCartas = new ArrayList<>();
        for (Integer v : valores) listaCartas.add(v);
        Collections.shuffle(listaCartas);
        for (int i = 0; i < 16; i++) fijadas[i] = false;
    }

    private void intentarVoltear(int index) {
        
        if (isWaiting || fijadas[index] || (firstCard != null && firstCard == botones[index])) return;

        int valor = listaCartas.get(index);
        botones[index].setIcon(cargarIcono("/images/dino" + valor + ".png"));

        if (firstCard == null) {
            
            firstCard = botones[index];
            firstVal = valor;
            firstIdx = index;
        } else {
            
            secondCard = botones[index];
            secondVal = valor;
            isWaiting = true; 
            
            
            movimientos++;
            lblMovimientos.setText("Movimientos: " + movimientos);
            
            validarPar(index);
        }
    }

    private void validarPar(int secondIdx) {
        if (firstVal == secondVal) {
           
            fijadas[firstIdx] = true;
            fijadas[secondIdx] = true;
            paresEncontrados++;
            lblPares.setText("Pares: " + paresEncontrados);
            limpiarTurno();
            
            if (paresEncontrados == 8) {
                JOptionPane.showMessageDialog(this, "¡Victoria! Movimientos totales: " + movimientos);
            }
        } else {
            
            Timer timer = new Timer(1000, e -> {
                firstCard.setIcon(cargarIcono("/images/dino_back.png"));
                secondCard.setIcon(cargarIcono("/images/dino_back.png"));
                limpiarTurno();
            });
            timer.setRepeats(false);
            timer.start();
        }
    }

    private void limpiarTurno() {
        firstCard = null;
        secondCard = null;
        firstVal = -1;
        secondVal = -1;
        firstIdx = -1;
        isWaiting = false;
    }

    private void reiniciarJuego() {
        movimientos = 0;
        paresEncontrados = 0;
        lblMovimientos.setText("Movimientos: 0");
        lblPares.setText("Pares: 0");
        iniciarJuegoLogica();
        for (JButton b : botones) {
            b.setIcon(cargarIcono("/images/dino_back.png"));
        }
        limpiarTurno();
    }

    private ImageIcon cargarIcono(String ruta) {
        try {
            java.net.URL imgURL = getClass().getResource(ruta);
            if (imgURL != null) {
                ImageIcon icon = new ImageIcon(imgURL);
                Image img = icon.getImage().getScaledInstance(100, 120, Image.SCALE_SMOOTH);
                return new ImageIcon(img);
            }
        } catch (Exception e) {}
        return null;
    }
}