package Ventanas;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Clases.ConexionMySQL;
import Clases.Cuenta;
import Clases.TipoCuenta;
import Clases.Usuario;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JInternalFrame;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JSplitPane;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JFormattedTextField;
import java.text.Format;
import java.text.NumberFormat;

import javax.swing.JComboBox;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

public class VentanaCuenta extends JFrame {

	private static final long serialVersionUID = 1L;
	private Usuario user;
	private Cuenta cuenta;
	private String[] currencies = {"USD","EUR","COP","CHF","CNY"};

	private JPanel contentPane;
	private JTextField textNomCuenta;
	private JTextField textPais;
	private JTextField textFieldPais;
	private NumberFormat dineroFormat;
	private static Logger logger;
	
	private ConexionMySQL conexion;
	
	//default constructor 
	public VentanaCuenta() {
		CreacionCuenta();
	}

	//constructor for users with more than one account
	public VentanaCuenta(Usuario user, ConexionMySQL conexion) {
		this.user = user;
		this.conexion = conexion;
		CreacionCuenta();
	}
	
	public int IDCurrency(String currency) {
		
		switch (currency) {
		case "EUR": 
			return 1;
		case "USD":
			return 2;
		case "COP":
			return 3;
		case "CHF":
			return 4;
		case "CNY":
			return 5;
		}
		return 0;
	}

	/**
	 * Launch the application.
	 *//*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCuentaAct frame = new VentanaCuentaAct();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 */
	public void CreacionCuenta() {
		try {
			logger = Logger.getLogger( "Ventanas" );
			Handler h = new FileHandler( "VentanaCuenta.log.xml", true );
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
		
		JInternalFrame internalFrame = new JInternalFrame("New JInternalFrame");
		internalFrame.setBorder(null);
		internalFrame.getContentPane().setBackground(new Color(255, 255, 255));
		internalFrame.getContentPane().setLayout(null);
		internalFrame.setVisible(true);
		((javax.swing.plaf.basic.BasicInternalFrameUI)internalFrame.getUI()).setNorthPane(null);
		internalFrame.setBounds(177, 84, 901, 529);
		contentPane.add(internalFrame);
		
		JPanel panelCubreLogIn = new JPanel();
		panelCubreLogIn.setBounds(0, 0, 434, 529);
		internalFrame.getContentPane().add(panelCubreLogIn);
		panelCubreLogIn.setBackground(new Color(255, 128, 64));
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(new Color(0, 0, 0));
		btnCancelar.setBackground(new Color(255, 128, 64));
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				logger.log( Level.INFO, "Se cancela la operacion.");
				VentanaPrincipal principal = new VentanaPrincipal(user, conexion);
				principal.setVisible(true);
				dispose();
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelar.setBounds(500, 439, 117, 41);
		internalFrame.getContentPane().add(btnCancelar);
		
		JFormattedTextField textFieldDinero = new JFormattedTextField(dineroFormat);
		textFieldDinero.setBounds(500, 371, 330, 30);
		internalFrame.getContentPane().add(textFieldDinero);
		
		JLabel lblDinero = new JLabel("Dinero");
		lblDinero.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDinero.setBounds(500, 341, 77, 20);
		internalFrame.getContentPane().add(lblDinero);
		
		DefaultComboBoxModel tipoCuentaModel = new DefaultComboBoxModel<>(TipoCuenta.values());
		JComboBox tipoCuentaBox = new JComboBox(tipoCuentaModel);
		tipoCuentaBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tipoCuentaBox.setBounds(500, 292, 260, 30);
		tipoCuentaBox.setSelectedIndex(-1);
		internalFrame.getContentPane().add(tipoCuentaBox);

		
		JLabel lblTipoCuenta = new JLabel("Tipo de cuenta");
		lblTipoCuenta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTipoCuenta.setBounds(500, 261, 140, 20);
		internalFrame.getContentPane().add(lblTipoCuenta);
		
		DefaultComboBoxModel currenciesModel = new DefaultComboBoxModel<>(currencies);
		JComboBox currenciesComboBox = new JComboBox(currenciesModel);
		currenciesComboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		currenciesComboBox.setBounds(500, 212, 140, 30);
		currenciesComboBox.setSelectedIndex(-1);
		internalFrame.getContentPane().add(currenciesComboBox);
		
		JLabel label_currency = new JLabel("Moneda");
		label_currency.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_currency.setBounds(500, 181, 57, 20);
		internalFrame.getContentPane().add(label_currency);
		
		textFieldPais = new JTextField();
		textFieldPais.setColumns(10);
		textFieldPais.setBounds(500, 131, 330, 30);
		internalFrame.getContentPane().add(textFieldPais);
		
		JLabel lblPais = new JLabel("Pais");
		lblPais.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPais.setBounds(500, 101, 100, 20);
		internalFrame.getContentPane().add(lblPais);
		
		textNomCuenta = new JTextField();
		textNomCuenta.setColumns(10);
		textNomCuenta.setBounds(500, 51, 330, 30);
		internalFrame.getContentPane().add(textNomCuenta);
		
		JLabel lblNombreCuenta = new JLabel("Nombre cuenta");
		lblNombreCuenta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombreCuenta.setBounds(500, 21, 100, 20);
		internalFrame.getContentPane().add(lblNombreCuenta);
		
		JButton btnCrearCuenta = new JButton("Crear Cuenta");
		btnCrearCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (textFieldDinero.getText().isEmpty() || textNomCuenta.getText().isEmpty() || textFieldPais.getText().isEmpty() || textFieldDinero.getText().isEmpty()
						|| currenciesComboBox.getSelectedIndex()==-1 || tipoCuentaBox.getSelectedIndex() == -1 ) {
					JOptionPane.showMessageDialog(null, "Rellena todos los campos.");
				}
				else {
					String userID = user.getId();
					cuenta = new Cuenta();
					cuenta.setCurrency(Currency.getInstance( currenciesModel.getSelectedItem().toString() ));
					cuenta.setDinero(new BigDecimal(Double.valueOf(textFieldDinero.getText())));
					cuenta.setIdcuenta("");
					cuenta.setIdusuario(userID);
					cuenta.setNombreCuenta(textNomCuenta.getText());
					cuenta.setTipocuenta((TipoCuenta)tipoCuentaModel.getSelectedItem());
					
					if (user.getCuentasUsuario() == null) {
						ArrayList<Cuenta> listaAcc = new ArrayList<>();
						user.setCuentasUsuario(listaAcc);
					}
					
					conexion.creacuenta(userID, tipoCuentaBox.getSelectedIndex()+1, IDCurrency(cuenta.getCurrency().toString()), new BigDecimal(textFieldDinero.getText()));
					ArrayList<Cuenta> cuentasUser = user.getCuentasUsuario();
					cuentasUser.add(cuenta);
					logger.log(Level.INFO, "Se ha creado existosamente una cuenta");
					JOptionPane.showMessageDialog(null, "Se ha creado tu cuenta");
					VentanaPrincipal ventana = new VentanaPrincipal(user, conexion);
					ventana.setVisible(true);
					dispose();
				}
			}
		});
		btnCrearCuenta.setForeground(new Color(0, 0, 0));
		btnCrearCuenta.setBackground(new Color(255, 128, 64));
		btnCrearCuenta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCrearCuenta.setBounds(713, 439, 117, 41);
		internalFrame.getContentPane().add(btnCrearCuenta);
		
		JLabel lblExit = new JLabel("");
		lblExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblExit.setBounds(1253, 11, 27, 14);
		contentPane.add(lblExit);
		
		
		ImageIcon imageIcon = new ImageIcon(new ImageIcon(VentanaLogIn.class.getResource("/Imagenes/X.png")).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
		lblExit.setIcon(imageIcon);

	}
}


