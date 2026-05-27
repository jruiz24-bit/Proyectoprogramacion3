package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;


public class Ventana2 extends JFrame {

    public Ventana2() {
        
        this.setTitle("Gestion de Usuarios");
        this.setSize(800, 600);
        this.setMinimumSize(new Dimension(400, 300));
        this.setMaximumSize(new Dimension(1000, 800));
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        
        
        this.getContentPane().setBackground(Color.MAGENTA);
        this.setOpacity(1.0f);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        this.crearPanelTabla();

        this.setVisible(true);
    }

   
    private void crearPanelTabla() {
        
        JLabel lblTitulo = new JLabel("Usuarios", SwingConstants.CENTER);
        lblTitulo.setBounds(0, 20, 800, 60);
        this.add(lblTitulo);

        
        JPanel panelContenedor = new JPanel();
        panelContenedor.setBounds(50, 100, 680, 400);
        panelContenedor.setLayout(new BorderLayout());
        panelContenedor.setBackground(Color.WHITE);

      
        String[] columnas = {"ID", "Nombre", "Correo electrónico", "Edad", "Estado"};

       
        DefaultTableModel modeloTabla = new DefaultTableModel(null, columnas) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        
        modeloTabla.addRow(new Object[]{"1", "Luca Alexander", "luca@uabcs.mx", "21", "Activo"});
        modeloTabla.addRow(new Object[]{"2", "Leonardo Mata", "leo@uabcs.mx", "22", "Activo"});
        modeloTabla.addRow(new Object[]{"3", "Darnell Aguilar", "darnell@uabcs.mx", "20", "Inactivo"});
        modeloTabla.addRow(new Object[]{"4", "María González", "maria@uabcs.mx", "23", "Activo"});
        modeloTabla.addRow(new Object[]{"5", "Iran Ruiz", "Iran@uabcs.mx", "22", "Inactivo"});

       
        JTable tablaUsuarios = new JTable(modeloTabla);
        tablaUsuarios.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tablaUsuarios.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        tablaUsuarios.getTableHeader().setBackground(new Color(230, 230, 230));
        tablaUsuarios.setFont(new Font("Arial", Font.PLAIN, 12));
        tablaUsuarios.setRowHeight(25);

        
        JScrollPane scrollPane = new JScrollPane(tablaUsuarios);

       
        panelContenedor.add(scrollPane, BorderLayout.CENTER);
        this.add(panelContenedor);
    }
}