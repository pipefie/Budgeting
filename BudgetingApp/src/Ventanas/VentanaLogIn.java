package Ventanas;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Clases.ConexionMySQL;
import Clases.Usuario;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JInternalFrame;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.logging.*;
import java.util.regex.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JSplitPane;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;

public class VentanaLogIn extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldUsuario;
	private JPasswordField passwordField;
	private JTextField textField;
	private JPasswordField passwordField_1;
	private JTextField textField_1;
	private JTextField textField_2;
	private ConexionMySQL conexion =  new ConexionMySQL();
	private static Usuario usuario = new Usuario();
	private static Logger logger;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public VentanaLogIn() {
		try {
			logger = Logger.getLogger( "Ventanas" );
			Handler h = new FileHandler( "VentanaLogIn.log.xml", true );
			logger.addHandler( h ); 
			logger.setLevel( Level.ALL );  
			h.setLevel( Level.ALL );  
			logger.getParent().getHandlers()[0].setLevel( Level.ALL );  
		} catch (Exception e) {}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(true);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JInternalFrame internalFrameSignUp = new JInternalFrame("New JInternalFrame");
		internalFrameSignUp.setBorder(null);
		internalFrameSignUp.getContentPane().setBackground(new Color(255, 255, 255));
		internalFrameSignUp.getContentPane().setLayout(null);
		
		JPanel panelCubreLogIn_1 = new JPanel();
		panelCubreLogIn_1.setBackground(new Color(255, 128, 64));
		panelCubreLogIn_1.setBounds(399, 0, 399, 433);
		internalFrameSignUp.getContentPane().add(panelCubreLogIn_1);
		
		JPanel panelLogIn_1 = new JPanel();
		panelLogIn_1.setLayout(null);
		panelLogIn_1.setBackground(Color.WHITE);
		panelLogIn_1.setBounds(0, 0, 399, 406);
		internalFrameSignUp.getContentPane().add(panelLogIn_1);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(21, 39, 93, 14);
		panelLogIn_1.add(lblNombre);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setColumns(10);
		textField.setBackground(Color.WHITE);
		textField.setBounds(21, 57, 339, 37);
		panelLogIn_1.add(textField);
		
		JLabel lblContrasea_1 = new JLabel("Contrasena:");
		lblContrasea_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblContrasea_1.setBounds(21, 231, 93, 14);
		panelLogIn_1.add(lblContrasea_1);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passwordField_1.setBounds(21, 249, 339, 37);
		panelLogIn_1.add(passwordField_1);
		
		
		JLabel lblNewLabel_3 = new JLabel("Ya tienes una cuenta? ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(71, 370, 165, 14);
		panelLogIn_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2_1 = new JLabel("Tiene que tenener Mayus, Minus, Num, Char");
		lblNewLabel_2_1.setForeground(Color.RED);
		lblNewLabel_2_1.setBounds(21, 286, 271, 14);
		panelLogIn_1.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_4 = new JLabel("Crea una cuenta nueva:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(21, 14, 314, 14);
		panelLogIn_1.add(lblNewLabel_4);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_1.setColumns(10);
		textField_1.setBackground(Color.WHITE);
		textField_1.setBounds(21, 121, 339, 37);
		panelLogIn_1.add(textField_1);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblApellidos.setBounds(21, 103, 93, 14);
		panelLogIn_1.add(lblApellidos);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(21, 169, 93, 14);
		panelLogIn_1.add(lblEmail);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_2.setColumns(10);
		textField_2.setBackground(Color.WHITE);
		textField_2.setBounds(21, 187, 339, 37);
		panelLogIn_1.add(textField_2);
		internalFrameSignUp.setVisible(true);
		
		((javax.swing.plaf.basic.BasicInternalFrameUI)internalFrameSignUp.getUI()).setNorthPane(null);
		
		JInternalFrame internalFrame = new JInternalFrame("New JInternalFrame");
		internalFrame.setBorder(null);
		internalFrame.getContentPane().setBackground(new Color(255, 255, 255));
		internalFrame.getContentPane().setLayout(null);
		internalFrame.setVisible(true);
		
		
		
		JPanel panelLogIn = new JPanel();
		panelLogIn.setBackground(new Color(255, 255, 255));
		panelLogIn.setBounds(399, 0, 399, 406);
		internalFrame.getContentPane().add(panelLogIn);
		panelLogIn.setLayout(null);
		((javax.swing.plaf.basic.BasicInternalFrameUI)internalFrame.getUI()).setNorthPane(null);
		internalFrame.setBounds(224, 125, 798, 433);
		contentPane.add(internalFrame);
		
		JLabel lblNewLabel_1 = new JLabel("Sign Up");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				internalFrame.setVisible(false);
				internalFrameSignUp.setVisible(true);

			}
		});
		lblNewLabel_1.setForeground(new Color(255, 128, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(201, 368, 73, 16);
		panelLogIn.add(lblNewLabel_1);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsuario.setBounds(21, 166, 93, 14);
		panelLogIn.add(lblUsuario);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setBackground(new Color(255, 255, 255));
		textFieldUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldUsuario.setBounds(21, 184, 339, 37);
		panelLogIn.add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrasena:");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblContrasea.setBounds(21, 236, 93, 14);
		panelLogIn.add(lblContrasea);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passwordField.setBounds(21, 261, 339, 37);
		panelLogIn.add(passwordField);
		
		
		JProgressBar progressBar = new JProgressBar(0,100);
		progressBar.setBounds(10, 392, 379, 14);
		panelLogIn.add(progressBar);
		
		
		JButton btnNewButton = new JButton("Log In");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (textFieldUsuario.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Rellena todos los campos.");
				}else {
					if (passwordField.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Rellena todos los campos.");
					}else {
						//Codigo Login
						ArrayList<String> datosusuario = conexion.inicioSesion(textFieldUsuario.getText(), passwordField.getText());
						if(datosusuario != null) {
							usuario = new Usuario();
							usuario.setNombre(datosusuario.get(1));
							usuario.setApellidos(datosusuario.get(2));
							usuario.setCorreo(datosusuario.get(3));
							usuario.setId(datosusuario.get(0));
							usuario.setCuentasUsuario(conexion.cargacuentas(usuario.getId()));
							try {
								BufferedWriter ficheroUsuAct = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("UsuarioAct.txt")));
								ficheroUsuAct.write(usuario.getCorreo()+" es el ultimo usuario en iniciar sesion\n");
					            ficheroUsuAct.close();
							}catch (Exception ex) {
								
							}
							Thread hiloFin = new Thread() {

								@Override
								public void run() {
									 //synchronized (this) {
										 for (int i=0;i<=100;i++) {
											 progressBar.setValue(i);
											 try {
												Thread.sleep(50);
											} catch (InterruptedException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
											 
										 }
											dispose();
											VentanaPrincipal ventana = new VentanaPrincipal(usuario, conexion);
											ventana.setVisible(true);
										 
								//} 
									 }
								
							};
							
							hiloFin.start();

							logger.log( Level.FINE, "El usuario " + usuario.getCorreo() + "ha iniciado sesion.");
						}else {
							 JOptionPane.showMessageDialog(null,"inicio de sesión fallido");
							 logger.log( Level.WARNING, "Se ha producido un inicio de sesion fallido");
						}
						
						 
					}
					
				}
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(255, 128, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(21, 322, 339, 37);
		panelLogIn.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("No tienes una cuenta? ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(71, 370, 165, 14);
		panelLogIn.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("");
		ImageIcon icUser = new ImageIcon(new ImageIcon(VentanaLogIn.class.getResource("/Imagenes/User.png")).getImage().getScaledInstance(130, 130, Image.SCALE_DEFAULT));
		lblNewLabel_2.setIcon(icUser);	
		lblNewLabel_2.setBounds(121, 26, 141, 126);
		panelLogIn.add(lblNewLabel_2);

		JPanel panelCubreLogIn = new JPanel();
		panelCubreLogIn.setBounds(0, 0, 399, 433);
		internalFrame.getContentPane().add(panelCubreLogIn);
		panelCubreLogIn.setBackground(new Color(255, 128, 64));
		internalFrameSignUp.setBounds(224, 125, 798, 433);
		contentPane.add(internalFrameSignUp);
		internalFrameSignUp.setVisible(false);
		
		JLabel lblNewLabel_1_1 = new JLabel("Log In");
		lblNewLabel_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				internalFrame.setVisible(true);
				internalFrameSignUp.setVisible(false);
			}
		});
		lblNewLabel_1_1.setForeground(new Color(255, 128, 0));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(201, 368, 73, 16);
		panelLogIn_1.add(lblNewLabel_1_1);
		
		
		JLabel lblExit = new JLabel("");
		lblExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				logger.log( Level.WARNING, "Se cierra la aplicacion.");
				System.exit(0);
			}
		});
		lblExit.setBounds(1253, 11, 27, 14);
		contentPane.add(lblExit);
		
		
		ImageIcon imageIcon = new ImageIcon(new ImageIcon(VentanaLogIn.class.getResource("/Imagenes/X.png")).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
		lblExit.setIcon(imageIcon);		
		
		JButton btnNewButton_1 = new JButton("Sign Up");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (isValidPassword(passwordField_1.getText()) && isValidEmail(textField_2.getText())) {
					if (textField.getText().isEmpty()){
						JOptionPane.showMessageDialog(null, "Rellena todos los campos.");
					}else {
						if (textField_1.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Rellena todos los campos.");
						}else {
							//Aqui va el codigo de Signup
							System.out.println(textField_2.getText());
							ArrayList<String> datosusuario = conexion.registro(textField_2.getText(),passwordField_1.getText(),textField.getText(),textField_1.getText());
							 if(  datosusuario != null ) {
								//pasar a la siguiente ventana con esto 
								 usuario = new Usuario();
								usuario.setNombre(datosusuario.get(1));
								usuario.setApellidos(datosusuario.get(2));
								usuario.setCorreo(datosusuario.get(3));
								usuario.setId(datosusuario.get(0));
	//							conexion.creacuenta(usuario.getId(),"1","1","0");
								VentanaCuenta nuevaCuenta = new VentanaCuenta(usuario, conexion);
								nuevaCuenta.setVisible(true);
								dispose();
								logger.log( Level.INFO, "Se ha creado una cuenta nueva con el correo " + usuario.getCorreo());
								 
								 
							 }else{
								 JOptionPane.showMessageDialog(null,"cuenta existente");
								 logger.log( Level.WARNING, "El usuario ha intentado crear una cuenta que ya existia.");
							 }
							
						}
						
					}
					
				}else {
					if (isValidPassword(passwordField_1.getText())) {
						JOptionPane.showMessageDialog(null, "E-mail no valido.");
					}else {
						JOptionPane.showMessageDialog(null, "Contrasena no valida. Recuerda que debe tener:\n · Entre 8 y 20 caracteres.\n · Como minimo un digito.\n · Como minimo una mayuscula.\n · Como minimo una minuscula.\n · Como minimo un caracter especial.\n");
					}
					
				}
				
				
			}
		});
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBackground(new Color(255, 128, 0));
		btnNewButton_1.setBounds(21, 322, 339, 37);
		panelLogIn_1.add(btnNewButton_1);

	}
	
	public static boolean isValidPassword(String password)
    {
		String regex = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=-_\\.])" + "(?=.*\\S).{8,20}$";

 
        Pattern p = Pattern.compile(regex);
 
        if (password == null) {
            return false;
        }
 
        Matcher m = p.matcher(password);
 
        return m.matches();
    }
	
	public static boolean isValidEmail(String email){  

        String regex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";  

        Pattern pattern = Pattern.compile(regex);  

        Matcher matcher = pattern.matcher(email);  
        return matcher.matches();  

    }  
}
