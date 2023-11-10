package Ventanas;

import java.awt.*;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Currency;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Clases.Cuenta;
import Clases.TipoCuenta;
import Clases.Usuario;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaCuenta extends JFrame {

	private Usuario user;
	private Cuenta cuenta;
	private String[] currencies = {"USD","EUR","COP","CHF","CNY"};
	
	private JPanel contentPane;
	private JTextField textNomCuenta;
	private JTextField textPais;
	private JTextField textFieldPais;
	private NumberFormat dineroFormat;

	

	//default constructor 
	public VentanaCuenta() {
		CreacionCuenta();
	}
	
	//constructor for users with more than one account
	public VentanaCuenta(Usuario user) {
		this.user = user;
		CreacionCuenta();
	}
	
	public void CreacionCuenta () {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		setResizable(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		
		setContentPane(contentPane);
		
		JPanel panelleft = new JPanel();
		panelleft.setBounds(0, 0, 632, 681);
		panelleft.setBackground(new Color(255, 128, 64));
		contentPane.add(panelleft);
		
		JPanel panelright = new JPanel();
		panelright.setBounds(632,0,632,681);
		panelright.setLayout(null);
		contentPane.add(panelright);
		
		JLabel lblNombreCuenta = new JLabel("Nombre cuenta");
		lblNombreCuenta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombreCuenta.setBounds(151, 81, 100, 20);
		panelright.add(lblNombreCuenta);
		
		textNomCuenta = new JTextField();
		textNomCuenta.setBounds(151, 111, 330, 30);
		panelright.add(textNomCuenta);
		textNomCuenta.setColumns(10);
		
		JLabel label_currency = new JLabel("Moneda");
		label_currency.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_currency.setBounds(151, 241, 57, 20);
		panelright.add(label_currency);
		
		DefaultComboBoxModel currenciesModel = new DefaultComboBoxModel<>(currencies);
		JComboBox currenciesComboBox = new JComboBox(currenciesModel);
		currenciesComboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		currenciesComboBox.setBounds(151, 271, 140, 30);
		currenciesComboBox.setSelectedIndex(-1);
		panelright.add(currenciesComboBox);
		
		JLabel lblTipoCuenta = new JLabel("Tipo de cuenta");
		lblTipoCuenta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTipoCuenta.setBounds(151, 321, 140, 20);
		panelright.add(lblTipoCuenta);
		
		DefaultComboBoxModel tipoCuentaModel = new DefaultComboBoxModel<>(TipoCuenta.values());
		JComboBox tipoCuentaBox = new JComboBox(tipoCuentaModel);
		tipoCuentaBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tipoCuentaBox.setBounds(151, 351, 260, 30);
		tipoCuentaBox.setSelectedIndex(-1);
		panelright.add(tipoCuentaBox);
		
		JLabel lblPais = new JLabel("Pais");
		lblPais.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPais.setBounds(151, 161, 100, 20);
		panelright.add(lblPais);
		
		textFieldPais = new JTextField();
		textFieldPais.setBounds(151, 191, 330, 30);
		panelright.add(textFieldPais);
		textFieldPais.setColumns(10);
		
		JLabel lblDinero = new JLabel("Dinero");
		lblDinero.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDinero.setBounds(151, 401, 77, 20);
		panelright.add(lblDinero);
		

		JFormattedTextField textFieldDinero = new JFormattedTextField(dineroFormat);
		textFieldDinero.setBounds(151, 431, 330, 30);
		panelright.add(textFieldDinero);
		
		JButton btnCrearCuenta = new JButton("Crear Cuenta");
		btnCrearCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				cuenta = new Cuenta();
				if (user.getCuentasUsuario() == null) {
					user.setCuentasUsuario(new ArrayList<Cuenta>());
				}
				
				ArrayList<Cuenta> cuentasUser = user.getCuentasUsuario();
				
				cuenta.setUsuario(user);
				cuenta.setNombreCuenta(textNomCuenta.getText());
				cuenta.setCurrency(Currency.getInstance((String) currenciesModel.getSelectedItem()));
				cuenta.setPais(textFieldPais.getText());
				cuenta.setTipocuenta((TipoCuenta)tipoCuentaModel.getSelectedItem());
				cuenta.setDinero(Long.parseLong(textFieldDinero.getText()));
				
				cuentasUser.add(cuenta);
				
				
			}
		});
		btnCrearCuenta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCrearCuenta.setBounds(482, 630, 117, 30);
		panelright.add(btnCrearCuenta);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//volver al main menu
				dispose();
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelar.setBounds(33, 630, 89, 30);
		panelright.add(btnCancelar);
		
		
		
		
		
		

		
		
		
	
		
		
	}
}
