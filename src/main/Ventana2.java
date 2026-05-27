package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;


public class Ventana2 extends JFrame {

    public Ventana2() {

        this.setTitle("Sistema de Gestión - Recuperación");
        this.setSize(900, 700); 
        this.setMinimumSize(new Dimension(600, 500));
        this.setMaximumSize(new Dimension(1200, 900));
        this.setLayout(null); 
        this.setLocationRelativeTo(null);
        
        
        this.getContentPane().setBackground(new Color(240, 248, 255)); 
        this.setOpacity(1.0f);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        // this.crearPanelTabla():

        
        this.crearRegistroUsuario();

        this.setVisible(true);
    }

    
    private void crearRegistroUsuario() {
        
        JPanel panelPrincipal = new JPanel(new BorderLayout(15, 15));
        panelPrincipal.setBounds(20, 20, 840, 620);
        panelPrincipal.setOpaque(false);

       
        JLabel lblTitulo = new JLabel("Formulario de Registro", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 32));
        lblTitulo.setForeground(new Color(25, 25, 112)); 
        panelPrincipal.add(lblTitulo, BorderLayout.NORTH);

        
        JPanel panelCuadrantes = new JPanel(new GridLayout(2, 2, 20, 20));
        panelCuadrantes.setOpaque(false);

        Color colorPaneles = new Color(224, 255, 255); 
        Font fuenteTitulados = new Font("Arial", Font.BOLD, 14);

      
        JPanel pnlGenerales = new JPanel(new GridLayout(4, 2, 10, 20));
        pnlGenerales.setBackground(colorPaneles);
        pnlGenerales.setBorder(BorderFactory.createTitledBorder(
        BorderFactory.createLineBorder(Color.GRAY), "Datos Generales", TitledBorder.LEFT, TitledBorder.TOP, fuenteTitulados, Color.DARK_GRAY));

        pnlGenerales.add(new JLabel(" Nombres:"));
        pnlGenerales.add(new JTextField());
        pnlGenerales.add(new JLabel(" Apellidos:"));
        pnlGenerales.add(new JTextField());
        pnlGenerales.add(new JLabel(" CURP:"));
        pnlGenerales.add(new JTextField());
        pnlGenerales.add(new JLabel(" Telefono:"));
        pnlGenerales.add(new JTextField());
        
        panelCuadrantes.add(pnlGenerales);

       
        JPanel pnlPerfil = new JPanel(new GridLayout(4, 2, 10, 20));
        pnlPerfil.setBackground(colorPaneles);
        pnlPerfil.setBorder(BorderFactory.createTitledBorder(
        BorderFactory.createLineBorder(Color.GRAY), "Perfil del Usuario",
        TitledBorder.LEFT, TitledBorder.TOP, fuenteTitulados, Color.DARK_GRAY));

        pnlPerfil.add(new JLabel(" F. Nacimiento:"));
        pnlPerfil.add(new JTextField(" DD/MM/AAAA"));
        pnlPerfil.add(new JLabel(" Email:"));
        pnlPerfil.add(new JTextField());
        
        
        pnlPerfil.add(new JLabel(" Genero:"));
        JPanel pnlGenero = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        pnlGenero.setOpaque(false);
        JRadioButton rbMasc = new JRadioButton("Masc.");
        JRadioButton rbFem = new JRadioButton("Fem.");
        rbMasc.setOpaque(false); rbFem.setOpaque(false);
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbMasc); bg.add(rbFem);
        pnlGenero.add(rbMasc); pnlGenero.add(rbFem);
        pnlPerfil.add(pnlGenero);

        pnlPerfil.add(new JLabel(" Nacionalidad:"));
        pnlPerfil.add(new JComboBox<>(new String[]{"Mexico", "Peru", "Colombia", "España"}));

        panelCuadrantes.add(pnlPerfil);

        
        JPanel pnlOpcionales = new JPanel(new BorderLayout(10, 10));
        pnlOpcionales.setBackground(colorPaneles);
        pnlOpcionales.setBorder(BorderFactory.createTitledBorder(
        BorderFactory.createLineBorder(Color.GRAY), "Datos Opcionales",
        TitledBorder.LEFT, TitledBorder.TOP, fuenteTitulados, Color.DARK_GRAY));

        
        JPanel pnlPreferencias = new JPanel(new GridLayout(4, 1));
        pnlPreferencias.setOpaque(false);
        pnlPreferencias.setBorder(BorderFactory.createTitledBorder("Preferencias"));
        pnlPreferencias.add(new JCheckBox("Leer"));
        pnlPreferencias.add(new JCheckBox("Música"));
        pnlPreferencias.add(new JCheckBox("Deportes"));
        pnlPreferencias.add(new JCheckBox("Videojuegos"));

        
        JPanel pnlDesc = new JPanel(new BorderLayout());
        pnlDesc.setOpaque(false);
        pnlDesc.setBorder(BorderFactory.createTitledBorder("Descripcion"));
        JTextArea txtDesc = new JTextArea();
        txtDesc.setLineWrap(true);
        pnlDesc.add(new JScrollPane(txtDesc), BorderLayout.CENTER);

        pnlOpcionales.add(pnlPreferencias, BorderLayout.WEST);
        pnlOpcionales.add(pnlDesc, BorderLayout.CENTER);

        panelCuadrantes.add(pnlOpcionales);

      
        JPanel pnlBotones = new JPanel(new GridBagLayout()); 
        pnlBotones.setBackground(colorPaneles);
        pnlBotones.setBorder(BorderFactory.createTitledBorder(
        BorderFactory.createLineBorder(Color.GRAY), "Acciones",
        TitledBorder.LEFT, TitledBorder.TOP, fuenteTitulados, Color.DARK_GRAY));

        JPanel wrapperBotones = new JPanel(new GridLayout(3, 1, 0, 15));
        wrapperBotones.setOpaque(false);
        
        
        JButton btnNuevo = new JButton("Nuevo");
        JButton btnGuardar = new JButton("Guardar");
        JButton btnSalir = new JButton("Salir");
        
        btnNuevo.setBackground(new Color(60, 179, 113)); btnNuevo.setForeground(Color.WHITE);
        btnGuardar.setBackground(new Color(70, 130, 180)); btnGuardar.setForeground(Color.WHITE);
        btnSalir.setBackground(new Color(220, 20, 60)); btnSalir.setForeground(Color.WHITE);

        wrapperBotones.add(btnNuevo);
        wrapperBotones.add(btnGuardar);
        wrapperBotones.add(btnSalir);

        pnlBotones.add(wrapperBotones);
        panelCuadrantes.add(pnlBotones);

       
        panelPrincipal.add(panelCuadrantes, BorderLayout.CENTER);
        this.add(panelPrincipal);
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