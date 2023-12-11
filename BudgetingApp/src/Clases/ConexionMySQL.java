package Clases;
import java.lang.reflect.Array;
import java.util.*;
import java.util.Date;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;

import javax.swing.JOptionPane;

import com.mysql.cj.xdevapi.Statement;

public class ConexionMySQL {

    // Librería de MySQL
    public String driver = "com.mysql.cj.jdbc.Driver";

    // Nombre de la base de datos
    public String database = "budgeting";

    // Host
    public String hostname = "localhost";

    // Puerto
    public String port = "3306";

    // Ruta de nuestra base de datos (desactivamos el uso de SSL con "?useSSL=false")
    public String url = "jdbc:mysql://" + hostname + "/" + database + "?useSSL=false";

    // Nombre de usuario
    public String username = "root";

    // Clave de usuario
    public String password = "";

    public Connection conectarMySQL() {
        Connection conn = null;

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
            JOptionPane.showMessageDialog(null, "conectado");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "desconectado");
            }

        return conn;
    }
    public ArrayList<String> inicioSesion(String correo,String passwd) {
    	Connection conn = null;
    	
    	try {
    		conn = DriverManager.getConnection(url, username, password);
      
        	String consulta = "SELECT * FROM usuarios WHERE correo ='" +correo+"' AND contrasena = '"+passwd+"'";
        	java.sql.Statement estado =  conn.createStatement();
			ResultSet resultado = estado.executeQuery(consulta);
			while(resultado.next()) {
				String id = resultado.getString("id");
				String nombre = resultado.getString("nombre");
				String apellidos = resultado.getString("apellidos");
				String correo1 = resultado.getString("correo");

				ArrayList<String> lista = new ArrayList<>();
				lista.add(id);
				lista.add(nombre);
				lista.add(apellidos);
				lista.add(correo1);
				return lista;
				
			}
			System.out.println(resultado);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }
    
    
    public ArrayList<Cuenta> cargacuentas(String id) {
    	Connection conn = null;
    	
    	try {
    		conn = DriverManager.getConnection(url, username, password);
      
//        	String consulta = "SELECT cuentas.id,cuentas.dinero,tipocuenta.nombre,tipomoneda.nombre as nombremoneda FROM cuentas,tipocuenta,tipomoneda WHERE cuentas.idUsuario="+id+" and tipocuenta.id = cuentas.tipoCuenta and tipomoneda.id = cuentas.idmoneda;";
    		
    		String consulta = "SELECT cuentas.id, cuentas.nombreCuenta, cuentas.pais ,cuentas.dinero,tipocuenta.nombre AS tipoCuenta, tipomoneda.nombre as divisa \r\n"
    				+ "FROM cuentas,tipocuenta,tipomoneda \r\n"
    				+ "WHERE cuentas.idUsuario="+id+" and tipocuenta.id = cuentas.tipoCuenta and tipomoneda.id = cuentas.idmoneda;";
        	java.sql.Statement estado =  conn.createStatement();
			ResultSet resultado = estado.executeQuery(consulta);
		
			ArrayList<Cuenta> lista = new ArrayList<>();
			while(resultado.next()) {
				String idCuenta = resultado.getString("id");
				String nomCuenta = resultado.getString("nombreCuenta");
				String paisCuenta = resultado.getString("pais");
				BigDecimal dinero = resultado.getBigDecimal("dinero");
				String tipodinero = resultado.getString("divisa");
				String tipocuenta = resultado.getString("tipoCuenta");
				System.out.println(idCuenta + dinero +tipodinero );
				ArrayList<Cuenta> datos = new ArrayList<>();
				Cuenta  cuenta= new Cuenta();
				cuenta.setIdcuenta(idCuenta);
				cuenta.setIdusuario(id);
				cuenta.setDinero(dinero);
				cuenta.setTipocuenta(TipoCuenta.valueOf(tipocuenta));
				cuenta.setCurrency(Currency.getInstance(tipodinero));
				cuenta.setNombreCuenta(nomCuenta);
				cuenta.setPais(paisCuenta);
				lista.add(cuenta);
			}
			return lista;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    } 
    public ArrayList<ArrayList<String>> cargartipocuentas() {
    	Connection conn = null;
    	
    	try {
    		conn = DriverManager.getConnection(url, username, password);
      
        	String consulta = "SELECT * FROM tipocuenta ";
        	java.sql.Statement estado =  conn.createStatement();
			ResultSet resultado = estado.executeQuery(consulta);
			ArrayList<ArrayList<String>> lista = new ArrayList<>();
			while(resultado.next()) {
				ArrayList<String> datos = new ArrayList<>();
				String id = resultado.getString("id");
				String nombre = resultado.getString("nombre");
				datos.add(id);
				datos.add(nombre);
				lista.add(datos);
			}
			return lista;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    } 
   
	public ArrayList<String> registro(String correo,String contrasena,String nombre,String apellidos) {
	    	
	    	String insertTableSQL = "INSERT INTO usuarios"
	                + "(correo,contrasena,nombre,apellidos) VALUES"
	                + "(?,?,?,?)";
	    	Connection conn;
	        try {
	        	conn = DriverManager.getConnection(url, username, password);
	        	PreparedStatement preparedStatement = conn.prepareStatement(insertTableSQL);
	        	preparedStatement.setString(1, correo);
	            preparedStatement.setString(2, contrasena);
	            preparedStatement.setString(3, nombre);
	            preparedStatement.setString(4, apellidos);
	
	            // execute insert SQL stetement
	            preparedStatement.executeUpdate();
	            System.out.println("Se inserto correctamente");
	            return this.inicioSesion(correo, contrasena);
	
	        } catch (SQLException e) {
	        	
	           
	
	        }
			return null;   
	}

	public void creacuenta(String idusuario,int tipocuenta, int tipomoneda, BigDecimal dinero) {
	    	
			Integer IDUsuario = Integer.parseInt(idusuario);
	    	String insertTableSQL = "INSERT INTO cuentas"
	                + "(idUsuario,tipocuenta,dinero,idmoneda) VALUES"
	                + "(?,?,?,?)";
	    	Connection conn;
	        try {
	        	conn = DriverManager.getConnection(url, username, password);
	        	PreparedStatement preparedStatement = conn.prepareStatement(insertTableSQL);
	        	preparedStatement.setInt(1, IDUsuario);
	            preparedStatement.setInt(2, tipocuenta);
	            preparedStatement.setBigDecimal(3, dinero);
	            preparedStatement.setInt(4, tipomoneda );
	
	            // execute insert SQL stetement
	            preparedStatement.executeUpdate();
	            
	            
	
	        } catch (SQLException e) {
	        	
	           e.printStackTrace();
	
	        }
			
	    }
	
	public void subirMovimiento (int idaccion, int idcuenta, double dinero, Date fecha) {
		
    	String insertTableSQL = "INSERT INTO movimientos"
                + "(idaccion,idcuenta,dinero, fecha) VALUES"
                + "(?,?,?,?)";
    	Connection conn;
        try {
        	conn = DriverManager.getConnection(url, username, password);
        	PreparedStatement preparedStatement = conn.prepareStatement(insertTableSQL);
        	preparedStatement.setInt(1, idaccion);
            preparedStatement.setInt(2, idcuenta);
            preparedStatement.setDouble(3, dinero);
            java.sql.Date dateMov = new java.sql.Date(fecha.getTime());
            preparedStatement.setDate(4, dateMov);

            // execute insert SQL stetement
            preparedStatement.executeUpdate();
            
            

        } catch (SQLException e) {
        	
           e.printStackTrace();

        }
		
	}
	
	/*
	 * Función que devuelve un mapa de todas las transacciones de un usuario (userId)
	 * que tiene por clave el id de la cuenta desde las que se ham hecho dichos movimientos 
	 * y como valor tiene un ArrayList con todos los "mapas" de transacciones que tiene por clave - valor,
	 * cada atributo de información relevante
	 */
	
	public Map<Integer, List<Map<String, Object>>> consultarMovimientos (int userId) {
		
	
		
		Connection conn;
		Map<Integer, List<Map<String, Object>>> accountMovements = new HashMap<>();
		
		try {
			conn = DriverManager.getConnection(url, username, password);
		      
        	String query = "SELECT usuarios.nombre, usuarios.apellidos, usuarios.correo, cuentas.id AS idCuenta, cuentas.nombreCuenta as NombreCuenta,cuentas.tipoCuenta, tipocuenta.nombre as TipoCuenta,cuentas.dinero AS saldoCuenta,"
        			+ "    movimientos.id AS idMovimiento,"
        			+ "    movimientos.dinero AS montoMovimiento,"
        			+ "    acciones.id AS idAccion,"
        			+ "    acciones.nombre AS nombreAccion,"
        			+ "    movimientos.fecha"
        			+ "FROM usuarios"
        			+ "JOIN cuentas ON usuarios.id = cuentas.idUsuario"
        			+ "JOIN tipocuenta on tipocuenta.id = cuentas.tipoCuenta"
        			+ "JOIN movimientos ON cuentas.id = movimientos.idcuenta"
        			+ "JOIN acciones ON movimientos.idaccion = acciones.id"
        			+ "WHERE usuarios.id = " + userId
        			+ "order by movimientos.fecha;"; 
        	
        	PreparedStatement preparedStatement = conn.prepareStatement(query);
        	preparedStatement.setInt(1, userId);

            ResultSet resultSet = preparedStatement.executeQuery();
            	
            while (resultSet.next()) {

            	 Map<String, Object> movementInfo = new HashMap<>();
                 movementInfo.put("nombre", resultSet.getString("nombre"));
                 movementInfo.put("apellidos", resultSet.getString("apellidos"));
                 movementInfo.put("correo", resultSet.getString("correo"));
                 movementInfo.put("idCuenta", resultSet.getInt("idCuenta"));
                 movementInfo.put("NombreCuenta", resultSet.getString("NombreCuenta"));
                 movementInfo.put("tipoCuenta", resultSet.getInt("tipoCuenta"));
                 movementInfo.put("TipoCuenta", resultSet.getString("TipoCuenta"));
                 movementInfo.put("saldoCuenta", resultSet.getDouble("saldoCuenta"));
                 movementInfo.put("idMovimiento", resultSet.getInt("idMovimiento"));
                 movementInfo.put("montoMovimiento", resultSet.getDouble("montoMovimiento"));
                 movementInfo.put("idAccion", resultSet.getInt("idAccion"));
                 movementInfo.put("nombreAccion", resultSet.getString("nombreAccion"));
                 movementInfo.put("fecha", resultSet.getDate("fecha"));

                 int accountId = resultSet.getInt("idCuenta");
                 accountMovements.computeIfAbsent(accountId, k -> new ArrayList<>()).add(movementInfo);
                    	
               	}
                    	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			e.getCause();
		}
		
		return accountMovements;
	}
}


