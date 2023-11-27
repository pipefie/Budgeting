package Ventanas;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Clases.Usuario;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JInternalFrame;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.regex.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JSplitPane;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.UIManager;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static Usuario usuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal(usuario);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param arrayList 
	 */
	public VentanaPrincipal(Usuario usuario) {
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
		
		JLabel Bienvenido = new JLabel("Bienvenido, ");
		Bienvenido.setFont(new Font("Tahoma", Font.BOLD, 20));
		Bienvenido.setBounds(31, 22, 137, 25);
		internalFrame.getContentPane().add(Bienvenido);
		
		JLabel Nombre = new JLabel(usuario.getNombre() );
		Nombre.setForeground(new Color(255, 128, 64));
		Nombre.setFont(new Font("Tahoma", Font.BOLD, 20));
		Nombre.setBounds(157, 22, 137, 25);
		internalFrame.getContentPane().add(Nombre);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 59, 1188, 111);
		internalFrame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel TusCuentas = new JLabel("Cuentas: ");
		TusCuentas.setFont(new Font("Tahoma", Font.BOLD, 16));
		TusCuentas.setBounds(31, 11, 137, 25);
		panel.add(TusCuentas);
		
		JButton btnNewButton = new JButton("Cuenta 1");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 128, 255));
		btnNewButton.setBounds(31, 38, 229, 50);
		panel.add(btnNewButton);
		
		JButton btnCuenta = new JButton("Cuenta 2");
		btnCuenta.setForeground(new Color(255, 255, 255));
		btnCuenta.setBackground(new Color(46, 202, 0));
		btnCuenta.setBounds(277, 38, 229, 50);
		panel.add(btnCuenta);
		
		JButton btnCuenta_2 = new JButton("Cuenta 3");
		btnCuenta_2.setForeground(new Color(255, 255, 255));
		btnCuenta_2.setBackground(new Color(198, 0, 0));
		btnCuenta_2.setBounds(525, 38, 229, 50);
		panel.add(btnCuenta_2);
		
		JButton AgregarCuenta = new JButton("+ Agregar Cuenta");
		AgregarCuenta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					VentanaCuenta frame = new VentanaCuenta();
					frame.setVisible(true);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		AgregarCuenta.setForeground(new Color(0, 0, 0));
		AgregarCuenta.setBackground(new Color(245, 245, 245));
		AgregarCuenta.setBounds(775, 38, 229, 50);
		panel.add(AgregarCuenta);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(21, 191, 382, 234);
		internalFrame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblPosicinTotal = new JLabel("Posición Total:");
		lblPosicinTotal.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPosicinTotal.setBounds(10, 11, 137, 17);
		panel_1.add(lblPosicinTotal);
		
		JLabel lblSaldo = new JLabel("Saldo:");
		lblSaldo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSaldo.setBounds(10, 39, 67, 17);
		panel_1.add(lblSaldo);
		
		JLabel lblPosicinTotal_1 = new JLabel("<euros>");
		lblPosicinTotal_1.setForeground(new Color(37, 187, 0));
		lblPosicinTotal_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPosicinTotal_1.setBounds(55, 39, 137, 17);
		panel_1.add(lblPosicinTotal_1);
		
		JLabel lblMovimientosltimos = new JLabel("Movimientos:");
		lblMovimientosltimos.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMovimientosltimos.setBounds(10, 67, 109, 17);
		panel_1.add(lblMovimientosltimos);
		
		JLabel lblPosicinTotal_1_1 = new JLabel("<balance>");
		lblPosicinTotal_1_1.setForeground(new Color(210, 0, 0));
		lblPosicinTotal_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPosicinTotal_1_1.setBounds(245, 66, 137, 17);
		panel_1.add(lblPosicinTotal_1_1);
		
		JLabel lblltimosDas = new JLabel("(últimos 31 días)");
		lblltimosDas.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lblltimosDas.setBounds(10, 83, 67, 17);
		panel_1.add(lblltimosDas);
		
		JLabel lblIngresos = new JLabel("Ingresos:");
		lblIngresos.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblIngresos.setBounds(10, 103, 91, 17);
		panel_1.add(lblIngresos);
		
		JLabel lblGastoss = new JLabel("Gastos:");
		lblGastoss.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblGastoss.setBounds(10, 163, 91, 17);
		panel_1.add(lblGastoss);
		
		JButton btnNewButton_1 = new JButton("Grafico1");
		btnNewButton_1.setBounds(10, 122, 362, 32);
		panel_1.add(btnNewButton_1);
		
		JLabel lblPosicinTotal_1_2 = new JLabel("<euros>");
		lblPosicinTotal_1_2.setForeground(new Color(0, 0, 0));
		lblPosicinTotal_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPosicinTotal_1_2.setBounds(315, 103, 67, 17);
		panel_1.add(lblPosicinTotal_1_2);
		
		JButton btnNewButton_1_1 = new JButton("Grafico2");
		btnNewButton_1_1.setBounds(10, 182, 362, 32);
		panel_1.add(btnNewButton_1_1);
		
		JLabel lblPosicinTotal_1_2_1 = new JLabel("<euros>");
		lblPosicinTotal_1_2_1.setForeground(Color.BLACK);
		lblPosicinTotal_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPosicinTotal_1_2_1.setBounds(315, 163, 67, 17);
		panel_1.add(lblPosicinTotal_1_2_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(423, 191, 338, 234);
		internalFrame.getContentPane().add(panel_1_1);
		
		JLabel lblEvolucin = new JLabel("Evolución:");
		lblEvolucin.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEvolucin.setBounds(10, 11, 137, 17);
		panel_1_1.add(lblEvolucin);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBounds(780, 191, 382, 234);
		internalFrame.getContentPane().add(panel_1_2);
		
		JLabel lblltimosMovimientos = new JLabel("Últimos Movimientos:");
		lblltimosMovimientos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblltimosMovimientos.setBounds(10, 11, 192, 17);
		panel_1_2.add(lblltimosMovimientos);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 486, 1188, 111);
		internalFrame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblOperaciones = new JLabel("Operaciones:");
		lblOperaciones.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblOperaciones.setBounds(34, 11, 137, 25);
		panel_2.add(lblOperaciones);
		
		JButton btnNewButton_2 = new JButton("Nuevo Ingreso");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					VentanaMovimientos frame = new VentanaMovimientos("INGRESO");
					frame.setVisible(true);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnNewButton_2.setForeground(new Color(0, 0, 0));
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.setBounds(33, 39, 273, 61);
		ImageIcon imageIng = new ImageIcon(new ImageIcon(VentanaLogIn.class.getResource("/Imagenes/Ingreso.png")).getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		btnNewButton_2.setIcon(imageIng);	
		panel_2.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("Nueva Transferencia");
		btnNewButton_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					VentanaMovimientos frame = new VentanaMovimientos("TRANSFERENCIA");
					frame.setVisible(true);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnNewButton_2_1.setForeground(new Color(0, 0, 0));
		btnNewButton_2_1.setBackground(new Color(255, 255, 255));
		btnNewButton_2_1.setBounds(614, 39, 273, 61);
		ImageIcon imageTrans = new ImageIcon(new ImageIcon(VentanaLogIn.class.getResource("/Imagenes/Transferencia.png")).getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
		btnNewButton_2_1.setIcon(imageTrans);
		panel_2.add(btnNewButton_2_1);
		
		JButton btnNewButton_2_1_1 = new JButton("Nuevo Gasto");
		btnNewButton_2_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					VentanaMovimientos frame = new VentanaMovimientos("GASTO");
					frame.setVisible(true);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnNewButton_2_1_1.setForeground(new Color(0, 0, 0));
		btnNewButton_2_1_1.setBackground(new Color(255, 255, 255));
		btnNewButton_2_1_1.setBounds(324, 39, 273, 61);
		ImageIcon imageGast = new ImageIcon(new ImageIcon(VentanaLogIn.class.getResource("/Imagenes/Gasto.png")).getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));
		btnNewButton_2_1_1.setIcon(imageGast);	
		panel_2.add(btnNewButton_2_1_1);
		
		JButton btnNewButton_2_1_2 = new JButton("Agregar cuenta");
		btnNewButton_2_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					VentanaCuenta frame = new VentanaCuenta();
					frame.setVisible(true);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnNewButton_2_1_2.setForeground(Color.BLACK);
		btnNewButton_2_1_2.setBackground(Color.WHITE);
		btnNewButton_2_1_2.setBounds(905, 39, 257, 61);
		ImageIcon imageAdd = new ImageIcon(new ImageIcon(VentanaLogIn.class.getResource("/Imagenes/Agregar.png")).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
		btnNewButton_2_1_2.setIcon(imageAdd);
		panel_2.add(btnNewButton_2_1_2);
		
		JLabel lblCerrarSesin = new JLabel("Cerrar Sesión");
		lblCerrarSesin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					dispose();
					VentanaLogIn frame = new VentanaLogIn();
					frame.setVisible(true);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		lblCerrarSesin.setForeground(new Color(255, 128, 64));
		lblCerrarSesin.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCerrarSesin.setBounds(1051, 19, 137, 25);
		internalFrame.getContentPane().add(lblCerrarSesin);
		
		JLabel lblCerrarSesin_1 = new JLabel();
		lblCerrarSesin_1.setBounds(990, 6, 61, 50);
		internalFrame.getContentPane().add(lblCerrarSesin_1);
		lblCerrarSesin_1.setForeground(new Color(255, 128, 64));
		ImageIcon imageUser = new ImageIcon(new ImageIcon(VentanaLogIn.class.getResource("/Imagenes/User.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
		lblCerrarSesin_1.setIcon(imageUser);	
		internalFrame.setVisible(true);
		((javax.swing.plaf.basic.BasicInternalFrameUI)internalFrame.getUI()).setNorthPane(null);
		internalFrame.setBounds(47, 49, 1188, 635);
		contentPane.add(internalFrame);
		
		
		JLabel lblExit = new JLabel("");
		lblExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblExit.setBounds(1253, 11, 27, 14);
		contentPane.add(lblExit);
		
		
		ImageIcon imageIcon = new ImageIcon(new ImageIcon(VentanaPrincipal.class.getResource("/Imagenes/X.png")).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
		lblExit.setIcon(imageIcon);

	}
}
