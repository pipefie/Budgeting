package Ventanas;

import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.JInternalFrame;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Date;
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
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import com.toedter.calendar.JDateChooser;
import Clases.CategoryofTransaction;
import Clases.ConexionMySQL;
import Clases.Cuenta;
import Clases.DataObserver;
import Clases.Transaccion;
import Clases.Usuario;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.GridLayout;

public class VentanaMovimientos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static Logger logger;
	private Usuario user;
	private Transaccion transaccion;
	private ConexionMySQL conn = new ConexionMySQL();
	private ArrayList<Currency> currencies = conn.cargaCurrency();
	private VentanaPrincipal principal;
	private DataObserver dataObserver;
	/**
	 * Launch the application.
	 *//*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMovimientos frame = new VentanaMovimientos("GASTO");
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
	
	public VentanaMovimientos(String Operacion, Usuario usuarioCuenta, ConexionMySQL conn, VentanaPrincipal principal) {
		
		this.user = usuarioCuenta;
		this.principal = principal;
	        
		try {
			logger = Logger.getLogger( "Ventanas" );
			Handler h = new FileHandler( "VentanaMovimientos.log.xml", true );
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
		ImageIcon imageIngB = new ImageIcon(new ImageIcon(VentanaLogIn.class.getResource("/Imagenes/IngresoBar.png")).getImage().getScaledInstance(370, 35, Image.SCALE_DEFAULT));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 64));
		

		
		panel.setBounds(0, 0, 912, 250);
		internalFrame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblIng = new JLabel("");

		lblIng.setBounds(255, 44, 125, 37);
		panel.add(lblIng);
		
		JLabel lblGast = new JLabel("");
		lblGast.setBounds(379, 44, 125, 37);
		panel.add(lblGast);
		
		JLabel lblTrans = new JLabel("");
		lblTrans.setBounds(501, 44, 125, 37);
		panel.add(lblTrans);

		// modelo combobox cuentas
		
		
		
		JLabel lblNewLabel = new JLabel("Cuenta:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(317, 104, 101, 14);
		panel.add(lblNewLabel);
		
		
		SpinnerNumberModel spinnerModel = new SpinnerNumberModel(0,-9999999L,9999999999L,1);
		JSpinner spinnerCantidad = new JSpinner(spinnerModel);
		spinnerCantidad.setBounds(317, 190, 173, 30);
		panel.add(spinnerCantidad);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setForeground(Color.WHITE);
		lblCantidad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCantidad.setBounds(317, 172, 101, 14);
		panel.add(lblCantidad);
		
		DefaultComboBoxModel modeloDivisa = new DefaultComboBoxModel<>();
		for (int i = 0; i < currencies.size(); i++) {
			modeloDivisa.addElement(currencies.get(i));
		}
		
		JComboBox comboBoxDivisa = new JComboBox(modeloDivisa);
		comboBoxDivisa.setForeground(Color.BLACK);
		comboBoxDivisa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxDivisa.setBackground(Color.WHITE);
		comboBoxDivisa.setBounds(501, 190, 85, 30);
		panel.add(comboBoxDivisa);
		comboBoxDivisa.setSelectedIndex(-1);
		
		JLabel lblCurrencia = new JLabel("Divisa:");
		lblCurrencia.setForeground(Color.WHITE);
		lblCurrencia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCurrencia.setBounds(501, 172, 85, 14);
		panel.add(lblCurrencia);
		
		JLabel lblNewLabel_1 = new JLabel("Categoría:");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(189, 269, 101, 14);
		internalFrame.getContentPane().add(lblNewLabel_1);
		
		DefaultComboBoxModel modelComboCat = new DefaultComboBoxModel<>(CategoryofTransaction.values());
		JComboBox comboBoxCategoria = new JComboBox(modelComboCat);
		comboBoxCategoria.setForeground(Color.BLACK);
		comboBoxCategoria.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxCategoria.setBackground(Color.WHITE);
		comboBoxCategoria.setBounds(189, 287, 269, 30);
		internalFrame.getContentPane().add(comboBoxCategoria);
		comboBoxCategoria.setSelectedIndex(-1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Fecha:");
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(482, 269, 101, 14);
		internalFrame.getContentPane().add(lblNewLabel_1_1);
		
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(482, 287, 212, 30);
		internalFrame.getContentPane().add(dateChooser);
		
		JTextArea descripcion = new JTextArea();
		descripcion.setBackground(new Color(211, 211, 211));
		descripcion.setBounds(189, 351, 505, 100);
		internalFrame.getContentPane().add(descripcion);
		
		JLabel lblNewLabel_1_2 = new JLabel("Descripción:");
		lblNewLabel_1_2.setForeground(Color.BLACK);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(189, 332, 101, 14);
		internalFrame.getContentPane().add(lblNewLabel_1_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(275, 462, 339, 37);
		internalFrame.getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton btnBack = new JButton("Cancelar");
		panel_1.add(btnBack);
		btnBack.setForeground(new Color(255, 255, 255));
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBack.setBackground(new Color(255, 128, 0));
		btnBack.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				logger.log( Level.FINEST, "El usuario canceló la operación");
				VentanaPrincipal principal = new VentanaPrincipal(usuarioCuenta, conn);
				principal.setVisible(true);
				dispose();
			}
			
		});
		
		DefaultComboBoxModel comboModelCuenta = new DefaultComboBoxModel<>(user.getCuentasUsuario().toArray());
		JComboBox comboCuenta = new JComboBox(comboModelCuenta);
		comboCuenta.setForeground(new Color(0, 0, 0));
		comboCuenta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboCuenta.setBackground(new Color(255, 255, 255));
		comboCuenta.setBounds(317, 122, 269, 30);
		panel.add(comboCuenta);
		comboCuenta.setSelectedIndex(-1);
		comboCuenta.addActionListener(e -> comboBoxDivisa.setSelectedItem(((Cuenta) comboCuenta.getSelectedItem()).getCurrency()));
		
		
		JButton btnGenerarRegistro = new JButton("Generar Registro");
		panel_1.add(btnGenerarRegistro);
		btnGenerarRegistro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
	
				if (comboCuenta.getSelectedIndex() == -1  || comboBoxCategoria.getSelectedIndex() == -1) {
					
					JOptionPane.showMessageDialog(null, "Rellena todos los campos.");
				}
				else {
					transaccion = new Transaccion(); 
					Cuenta cuenta = (Cuenta)comboCuenta.getSelectedItem();
					transaccion.setCantidadTransaccion(new BigDecimal(Double.valueOf(String.valueOf(spinnerCantidad.getValue()))));
					transaccion.setCategoryofTransaction((CategoryofTransaction)comboBoxCategoria.getSelectedItem());
					transaccion.setComentarios(descripcion.getText());
					transaccion.setCuentaOrigen(cuenta);
					transaccion.setCurrencyTransaccion((Currency)comboBoxDivisa.getSelectedItem());
					transaccion.setFechaHora(dateChooser.getDate());
					
					if(Double.valueOf(String.valueOf(spinnerCantidad.getValue()))> 0) {
						cuenta.aniadirDinero(new BigDecimal(Double.valueOf(String.valueOf(spinnerCantidad.getValue()))));
					}
					else {
						//aqui multiplico por menso 1 porque los valores llegan negativos al ser un gasto o lo que sea y 
						// el método quitarDinero tiene implementada la funcion .substract(dinero) que resta el monto por ende hay que volverlo positivo
						// el negativo o positivo del monto de la transacción es solo para saber si es entrada o salida de dinero
						cuenta.quitarDinero(new BigDecimal(Double.valueOf(String.valueOf(spinnerCantidad.getValue()))*-1));
					}
					conn.subirMovimiento(comboBoxCategoria.getSelectedIndex()+1, Integer.parseInt(cuenta.getIdcuenta()), (double)spinnerCantidad.getValue(), dateChooser.getDate());
					conn.actualizarSaldo(cuenta.getIdcuenta(), cuenta.getDinero());
					
					if (dataObserver != null) {
			            dataObserver.updateData();}
					
				}
				logger.log( Level.FINE, "El usuario ha realizado una operacion");
				VentanaPrincipal principal = new VentanaPrincipal(user, conn);
				principal.setVisible(true);
				dispose();
			}
		});
		btnGenerarRegistro.setForeground(new Color(255, 255, 255));
		btnGenerarRegistro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGenerarRegistro.setBackground(new Color(255, 128, 0));
		internalFrame.setVisible(true);
		((javax.swing.plaf.basic.BasicInternalFrameUI)internalFrame.getUI()).setNorthPane(null);
		internalFrame.setBounds(189, 87, 912, 533);
		contentPane.add(internalFrame);
		
		
		JLabel lblBarra = new JLabel("");
		lblBarra.setIcon(imageIngB);
		lblBarra.setBounds(255, 44, 370, 37);
		if (Operacion == "INGRESO") {
			logger.log( Level.FINEST, "El usuario quiere hacer un ingreso");
			esIngreso(lblBarra, panel, btnGenerarRegistro);

		}
		if (Operacion == "GASTO") {
			logger.log( Level.FINEST, "El usuario quiere hacer un gasto");
			esGasto(lblBarra, panel, btnGenerarRegistro);
			
		

		}
		if (Operacion == "TRANSFERENCIA") {
			logger.log( Level.FINEST, "El usuario quiere hacer una transferencia");
			esTrans(lblBarra, panel, btnGenerarRegistro);
			String[] tiposTransferencia = {"internacional", "nacional", "Mis Cuentas"};
		//	modelComboCat = new DefaultComboBoxModel<>(tiposTransferencia);
			
		}
		

		panel.add(lblBarra);
		
		//Botones de menu (escucha)
		lblIng.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				logger.log( Level.FINEST, "El usuario quiere hacer un ingreso");
				esIngreso(lblBarra, panel, btnGenerarRegistro);
			}
		});
		
		lblGast.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				logger.log( Level.FINEST, "El usuario quiere hacer un gasto");
				esGasto(lblBarra, panel, btnGenerarRegistro);
			}
		});
		
		lblTrans.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				logger.log( Level.FINEST, "El usuario quiere hacer una transferencia");
				esTrans(lblBarra, panel, btnGenerarRegistro);
			}
		});
		
		
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
	
    private void notifyVentanaPrincipal() {
        if (principal != null) {
        	principal.updateData();
        	}
        }
	
	public void esGasto(JLabel label, JPanel panel, JButton btnGenerarRegistro)
    {
		ImageIcon imageGastB = new ImageIcon(new ImageIcon(VentanaLogIn.class.getResource("/Imagenes/GastoBar.png")).getImage().getScaledInstance(370, 35, Image.SCALE_DEFAULT));
		label.setIcon(imageGastB);
		panel.setBackground(new Color(176, 0, 0));
		btnGenerarRegistro.setBackground(new Color(176, 0, 0));
    }
	
	public void esIngreso(JLabel label, JPanel panel, JButton btnGenerarRegistro)
    {
		ImageIcon imageIngB2 = new ImageIcon(new ImageIcon(VentanaLogIn.class.getResource("/Imagenes/IngresoBar.png")).getImage().getScaledInstance(370, 35, Image.SCALE_DEFAULT));
		label.setIcon(imageIngB2);
		panel.setBackground(new Color(0, 128, 64));
		btnGenerarRegistro.setBackground(new Color(0, 128, 64));
    }
	
	public void esTrans(JLabel label, JPanel panel, JButton btnGenerarRegistro)
    {
		ImageIcon imageTransB = new ImageIcon(new ImageIcon(VentanaLogIn.class.getResource("/Imagenes/TransferenciaBar.png")).getImage().getScaledInstance(370, 35, Image.SCALE_DEFAULT));
		label.setIcon(imageTransB);
		panel.setBackground(new Color(218, 165, 32));
		btnGenerarRegistro.setBackground(new Color(218, 165, 32));
    }
}
