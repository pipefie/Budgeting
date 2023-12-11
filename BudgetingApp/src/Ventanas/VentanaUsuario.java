package Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Clases.ConexionMySQL;
import Clases.Usuario;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class VentanaUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtContrasea;
	private JTextField txtEmail;
	private JLabel lblEmail;
	private JLabel lblContrasea;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public VentanaUsuario(Usuario user, ConexionMySQL conn) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(true);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JInternalFrame internalFrame = new JInternalFrame("New JInternalFrame");
		internalFrame.setBorder(null);
		internalFrame.getContentPane().setBackground(new Color(255, 255, 255));
		internalFrame.getContentPane().setLayout(null);
		internalFrame.setVisible(true);
		((javax.swing.plaf.basic.BasicInternalFrameUI)internalFrame.getUI()).setNorthPane(null);
		internalFrame.setBounds(177, 140, 876, 372);
		contentPane.add(internalFrame);
		
		JPanel panelCubreLogIn = new JPanel();
		panelCubreLogIn.setBounds(0, 0, 434, 529);
		internalFrame.getContentPane().add(panelCubreLogIn);
		panelCubreLogIn.setBackground(new Color(255, 128, 64));
		
		txtNombre = new JTextField();
		txtNombre.setText(user.getNombre());
		txtNombre.setBounds(593, 62, 209, 22);
		internalFrame.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setText(user.getApellidos());
		txtApellido.setBounds(593, 109, 209, 22);
		internalFrame.getContentPane().add(txtApellido);
		txtApellido.setColumns(10);
		
		txtContrasea = new JTextField();
		txtContrasea.setText(user.getContrasena());
		txtContrasea.setBounds(593, 203, 209, 22);
		internalFrame.getContentPane().add(txtContrasea);
		txtContrasea.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setText(user.getCorreo());
		txtEmail.setBounds(593, 155, 209, 22);
		internalFrame.getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(467, 66, 97, 16);
		internalFrame.getContentPane().add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblApellido.setBounds(467, 113, 97, 16);
		internalFrame.getContentPane().add(lblApellido);
		
		lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(467, 158, 97, 16);
		internalFrame.getContentPane().add(lblEmail);
		
		lblContrasea = new JLabel("Contraseña:");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblContrasea.setBounds(467, 206, 97, 16);
		internalFrame.getContentPane().add(lblContrasea);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				VentanaPrincipal principal = new VentanaPrincipal(user,conn);
				principal.setVisible(true);
				dispose();
			}
		});
		btnVolver.setBounds(467, 252, 97, 38);
		btnVolver.setBackground(new Color(255, 128, 64));
		internalFrame.getContentPane().add(btnVolver);
		
		JButton btnGuardarCambios = new JButton("Guardar Cambios");
		btnGuardarCambios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				user.setNombre(txtNombre.getText());
				user.setApellidos(txtApellido.getText());
				user.setContrasena(txtContrasea.getText());
				user.setCorreo(txtEmail.getText());
				VentanaPrincipal principal = new VentanaPrincipal(user,conn);
				principal.setVisible(true);
				dispose();
			}
		});
		btnGuardarCambios.setBounds(574, 252, 228, 38);
		btnGuardarCambios.setBackground(new Color(255, 128, 64));
		internalFrame.getContentPane().add(btnGuardarCambios);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(467, 26, 123, 14);
		internalFrame.getContentPane().add(lblNewLabel);
	}
}
