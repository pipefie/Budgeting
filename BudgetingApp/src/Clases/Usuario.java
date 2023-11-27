package Clases;

import java.util.ArrayList;

public class Usuario {
	private String id;
	private String nombre;
	private String apellidos;
	private String correo;
	private String contrasena;
	private ArrayList<Cuenta> cuentasUsuario; //nuevo
	
	public Usuario() {}
	
	public Usuario(String nombre, String apellidos, String correo, String contrasena) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.correo = correo;
		this.contrasena = contrasena;
	}
	
	public Usuario(String nombre, String apellidos, String correo, String contrasena,
			ArrayList<Cuenta> cuentasUsuario) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.correo = correo;
		this.contrasena = contrasena;
		this.cuentasUsuario = cuentasUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public ArrayList<Cuenta> getCuentasUsuario() {
		return cuentasUsuario;
	}

	public void setCuentasUsuario(ArrayList<Cuenta> cuentasUsuario) {
		this.cuentasUsuario = cuentasUsuario;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
}
