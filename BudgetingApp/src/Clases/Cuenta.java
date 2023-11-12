package Clases;

import java.util.Currency;

public class Cuenta {
	private String nombreCuenta; //nuevo
	private String pais; //nuevo
	private Currency currency; //nuevo
	private Usuario usuario; //me parece que deberíamos quitar usuario de aquí
	private TipoCuenta tipocuenta;
	private long dinero;
	
	public Cuenta() {}

	public Cuenta(Usuario usuario, TipoCuenta tipocuenta, long dinero) {
		super();
		this.usuario = usuario;
		this.tipocuenta = tipocuenta;
		this.dinero = dinero;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public TipoCuenta getTipocuenta() {
		return tipocuenta;
	}

	public void setTipocuenta(TipoCuenta tipocuenta) {
		this.tipocuenta = tipocuenta;
	}

	public long getDinero() {
		return dinero;
	}

	public void setDinero(long dinero) {
		this.dinero = dinero;
	}

	public String getNombreCuenta() {
		return nombreCuenta;
	}

	public void setNombreCuenta(String nombreCuenta) {
		this.nombreCuenta = nombreCuenta;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	@Override
	public String toString() {
		return "Cuenta: " + nombreCuenta + ", dinero: " + dinero +" "+ currency;
	}
	
	//metodos para añadir y restar del dinero de la cuenta
	
	public synchronized void aniadirDinero (long monto) {
		
		dinero += monto;
		
	}
	
	public synchronized void quitarDinero (long monto) {
		
		if(dinero < monto) {
			return;
		}
		else {
			dinero -= monto;
		}
	}
	
}
