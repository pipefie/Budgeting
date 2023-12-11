package Ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Clases.ConexionMySQL;
import Clases.Usuario;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNombre = new JTextField();
		txtNombre.setText(user.getNombre());
		txtNombre.setBounds(173, 50, 116, 22);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setText(user.getApellidos());
		txtApellido.setBounds(173, 85, 116, 22);
		contentPane.add(txtApellido);
		txtApellido.setColumns(10);
		
		txtContrasea = new JTextField();
		txtContrasea.setText(user.getContrasena());
		txtContrasea.setBounds(173, 155, 116, 22);
		contentPane.add(txtContrasea);
		txtContrasea.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setText(user.getCorreo());
		txtEmail.setBounds(173, 120, 116, 22);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(47, 54, 56, 16);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(47, 89, 56, 16);
		contentPane.add(lblApellido);
		
		lblEmail = new JLabel("Email:");
		lblEmail.setBounds(47, 123, 56, 16);
		contentPane.add(lblEmail);
		
		lblContrasea = new JLabel("Contraseña:");
		lblContrasea.setBounds(47, 158, 70, 16);
		contentPane.add(lblContrasea);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				VentanaPrincipal principal = new VentanaPrincipal(user,conn);
				principal.setVisible(true);
				dispose();
			}
		});
		btnVolver.setBounds(47, 204, 97, 25);
		contentPane.add(btnVolver);
		
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
		btnGuardarCambios.setBounds(235, 204, 147, 25);
		contentPane.add(btnGuardarCambios);
	}
}
