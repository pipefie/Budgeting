package Clases;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
				String correo1 = resultado.getString("correo");
				System.out.println(id + correo1);
				ArrayList<String> lista = new ArrayList<>();
				lista.add(id);
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
    
    
    public ArrayList<String> cargacuentas(String id) {
    	Connection conn = null;
    	
    	try {
    		conn = DriverManager.getConnection(url, username, password);
      
        	String consulta = "SELECT * FROM cuentas WHERE idUsuario ='" +id+"'";
        	java.sql.Statement estado =  conn.createStatement();
			ResultSet resultado = estado.executeQuery(consulta);
			while(resultado.next()) {
				String idCuenta = resultado.getString("id");
				String dinero = resultado.getString("dinero");
				String tipodinero = resultado.getString("idmoneda");
				String tipocuenta = resultado.getString("tipocuenta");
				System.out.println(idCuenta + dinero +tipodinero );
				ArrayList<String> lista = new ArrayList<>();
				lista.add(id);
				lista.add(idCuenta);
				lista.add(dinero);
				lista.add(tipocuenta);
				lista.add(tipodinero);
				return lista;
			}
			System.out.println(resultado);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }
}