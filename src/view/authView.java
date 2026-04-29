package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class authView {
	
	public authView() {
	
		
	}
	
	public void login()
	{
			JFrame ventana  = new JFrame();
			
			ventana.setSize(800, 950);
			ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			ventana.setMinimumSize(new Dimension(200, 200));
			ventana.setMaximumSize(new Dimension(800, 900));
			ventana.setLocationRelativeTo(null);
			ventana.setTitle("Gestión Escolar - UABCS");
			ventana.setLayout(null);

	        try {
	            Image iconImage = ImageIO.read(getClass().getResource("/images/alumno.png"));
	            ventana.setIconImage(iconImage);
	        } catch (Exception e) {
	            System.err.println("Error al cargar icono: " + e.getMessage());
	        }

	        /*
	        private JMenuItem crearItem(String texto, String target) {
	            JMenuItem item = new JMenuItem(texto);
	            item.addActionListener(e -> router(target));
	            return item;
	        }
	        JMenuBar barra = new JMenuBar();
	        ventana.setJMenuBar(barra);

	        
	        JMenu menuCuenta = new JMenu("Cuenta");
	        barra.add(menuCuenta);
	        menuCuenta.add(crearItem("Login", "login"));
	        menuCuenta.add(crearItem("Registro", "registro"));
	        menuCuenta.add(crearItem("Recuperación de cuenta", "recuperar"));

	        
	        JMenu menuUsuarios = new JMenu("Usuarios");
	        barra.add(menuUsuarios);
	        menuUsuarios.add(crearItem("Alta", "alta"));
	        menuUsuarios.add(crearItem("Baja", "baja"));
	        menuUsuarios.add(crearItem("Consultar", "users"));

	        
	        JMenu menuAyuda = new JMenu("Ayuda");
	        barra.add(menuAyuda);
	        menuAyuda.add(crearItem("¿Cómo crear un usuario?", "ayuda_crear"));
	        menuAyuda.add(crearItem("¿Cómo acceder al sistema?", "ayuda_acceso"));
	        menuAyuda.add(crearItem("¿Qué pasa si olvidé mi contraseña?", "ayuda_pass"));

	        
	        JMenu menuAct = new JMenu("Actividades");
	        barra.add(menuAct);
	        menuAct.add(crearItem("Mario Bros", "mario"));
	        menuAct.add(crearItem("Calculadora", "calc"));
	        menuAct.add(crearItem("Calculadora Interés", "interes"));
	        menuAct.add(crearItem("Pintar Figuras", "pintar"));
	        menuAct.add(crearItem("Pintar Casa", "casa"));
	        menuAct.add(crearItem("Paint App", "paint"));
			*/
			
	        JPanel login_container = new JPanel();
	        login_container.setSize(400, 500);
	        login_container.setLocation(300, 50);
	        login_container.setBackground(new Color(255, 255, 255, 200)); 
	        login_container.setLayout(null);
	        ventana.add(login_container);

	        JLabel title = new JLabel("USER LOGIN");
	        title.setBounds(0, 40, 400, 40);
	        title.setFont(new Font("Impact", Font.BOLD, 32));
	        title.setHorizontalAlignment(JLabel.CENTER);
	        login_container.add(title);

	        try {
	            JLabel userIcon = new JLabel();
	            ImageIcon imgUser = new ImageIcon(getClass().getResource("/images/user_icon.png"));
	            userIcon.setIcon(new ImageIcon(imgUser.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
	            userIcon.setBounds(40, 140, 30, 30);
	            login_container.add(userIcon);
	        } catch(Exception e) {}

	        JTextField txtUser = new JTextField();
	        txtUser.setBounds(80, 140, 260, 35);
	        txtUser.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1)); 
	        login_container.add(txtUser);

	        try {
	            JLabel passIcon = new JLabel();
	            ImageIcon imgPass = new ImageIcon(getClass().getResource("/images/pass_icon.png"));
	            passIcon.setIcon(new ImageIcon(imgPass.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
	            passIcon.setBounds(40, 210, 30, 30);
	            login_container.add(passIcon);
	        } catch(Exception e) {}

	        JPasswordField txtPass = new JPasswordField();
	        txtPass.setBounds(80, 210, 260, 35);
	        txtPass.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
	        login_container.add(txtPass);

	        JButton btnAcceder = new JButton("Login");
	        btnAcceder.setBounds(100, 300, 200, 45);
	        btnAcceder.setBackground(new Color(41, 128, 185));
	        btnAcceder.setForeground(Color.WHITE);
	        btnAcceder.setFont(new Font("Arial", Font.BOLD, 18));
	        btnAcceder.setBorder(BorderFactory.createRaisedBevelBorder());
	        
	        btnAcceder.addActionListener(e -> {
	            String user = txtUser.getText().trim();
	            String pass = new String(txtPass.getPassword());
	            boolean userOk = user.equals("admin@uabcs.mx");
	            boolean passOk = pass.equals("123456");

	            txtUser.setBorder(BorderFactory.createLineBorder(userOk ? Color.GREEN : Color.RED, 2));
	            txtPass.setBorder(BorderFactory.createLineBorder(passOk ? Color.GREEN : Color.RED, 2));

	            if (userOk && passOk) {
	                JOptionPane.showMessageDialog(ventana, "Bienvenido.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
	            } else {
	                JOptionPane.showMessageDialog(ventana, "Usuario o contraseña incorrectos.", "Error", JOptionPane.ERROR_MESSAGE);
	            }
	        });
	        login_container.add(btnAcceder);

	        JButton btnIrRegistro = new JButton("¿No tienes cuenta? Crea una aquí");
	        btnIrRegistro.setBounds(50, 380, 300, 30);
	        btnIrRegistro.setContentAreaFilled(false);
	        btnIrRegistro.setBorderPainted(false);
	        btnIrRegistro.setForeground(Color.BLUE);
	        btnIrRegistro.setCursor(new Cursor(Cursor.HAND_CURSOR));
	        
	        
	        //btnIrRegistro.addActionListener(e -> router("registro")); 
	        login_container.add(btnIrRegistro);

	        JLabel background = new JLabel();
	        background.setBounds(0, 0, 1000, 750);
	        try {
	            ImageIcon imgBg = new ImageIcon(getClass().getResource("/images/login_bg.jpg"));
	            background.setIcon(new ImageIcon(imgBg.getImage().getScaledInstance(1000, 750, Image.SCALE_SMOOTH)));
	            ventana.add(background);
	        } catch(Exception e) { ventana.getContentPane().setBackground(Color.BLACK); }
	        
	        ventana.setVisible(true);
	}
	
	
	public void registro()
	{
		
	}

}

