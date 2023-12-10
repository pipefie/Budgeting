package Ventanas;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JInternalFrame;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import javax.swing.JTextArea;

public class VentanaMovimientos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static Logger logger;

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
	public VentanaMovimientos(String Operacion) {
		
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
		
		JButton btnGenerarRegistro = new JButton("Generar Registro");
		btnGenerarRegistro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				logger.log( Level.FINE, "El usuario ha realizado una operacion");
				dispose();
			}
		});
		btnGenerarRegistro.setForeground(new Color(255, 255, 255));
		btnGenerarRegistro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGenerarRegistro.setBackground(new Color(255, 128, 0));
		btnGenerarRegistro.setBounds(275, 462, 339, 37);
		internalFrame.getContentPane().add(btnGenerarRegistro);
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
		}
		

		panel.add(lblBarra);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(new Color(0, 0, 0));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setBounds(317, 122, 269, 30);
		panel.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Cuenta:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(317, 104, 101, 14);
		panel.add(lblNewLabel);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(317, 190, 173, 30);
		panel.add(spinner);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setForeground(Color.WHITE);
		lblCantidad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCantidad.setBounds(317, 172, 101, 14);
		panel.add(lblCantidad);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setForeground(Color.BLACK);
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_1.setBackground(Color.WHITE);
		comboBox_1.setBounds(501, 190, 85, 30);
		panel.add(comboBox_1);
		
		JLabel lblCurrencia = new JLabel("Currencia:");
		lblCurrencia.setForeground(Color.WHITE);
		lblCurrencia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCurrencia.setBounds(501, 172, 85, 14);
		panel.add(lblCurrencia);
		
		JLabel lblNewLabel_1 = new JLabel("Categoría:");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(189, 269, 101, 14);
		internalFrame.getContentPane().add(lblNewLabel_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setForeground(Color.BLACK);
		comboBox_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_2.setBackground(Color.WHITE);
		comboBox_2.setBounds(189, 287, 269, 30);
		internalFrame.getContentPane().add(comboBox_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("Fecha:");
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(482, 269, 101, 14);
		internalFrame.getContentPane().add(lblNewLabel_1_1);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(482, 287, 212, 30);
		internalFrame.getContentPane().add(dateChooser);
		
		
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(new Color(211, 211, 211));
		textArea.setBounds(189, 351, 505, 100);
		internalFrame.getContentPane().add(textArea);
		
		JLabel lblNewLabel_1_2 = new JLabel("Descripción:");
		lblNewLabel_1_2.setForeground(Color.BLACK);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(189, 332, 101, 14);
		internalFrame.getContentPane().add(lblNewLabel_1_2);
		
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
