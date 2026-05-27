package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Ventana2 extends JFrame {

    public Ventana2() {
        this.setTitle("Hola we");
        this.setSize(400, 400);
        this.setMinimumSize(new Dimension(200, 200));
        this.setMaximumSize(new Dimension(800, 800));
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.MAGENTA);
        this.setOpacity(1.0f);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel tag_title = new JLabel();
        tag_title.setText("Bienvenido");
        tag_title.setBounds(125, 30, 150, 30);
        tag_title.setBackground(Color.WHITE);
        tag_title.setOpaque(true); 
        tag_title.setForeground(Color.BLACK);
        tag_title.setFont(new Font("Arial", Font.BOLD, 16));
        tag_title.setHorizontalAlignment(SwingConstants.CENTER);

        this.add(tag_title);

        this.setVisible(true);
    }
}