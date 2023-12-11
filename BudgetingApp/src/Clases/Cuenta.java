package Clases;

import java.math.BigDecimal;
import java.util.Currency;

public class Cuenta {
	private String idcuenta;
	private String nombreCuenta; //nuevo
	private Currency currency; //nuevo
	private String idusuario; 
	private TipoCuenta tipocuenta;
	private BigDecimal dinero;
	
	public Cuenta() {}

	public Cuenta(String usuario, TipoCuenta tipocuenta, BigDecimal dinero) {
		super();
		this.idusuario = usuario;
		this.tipocuenta = tipocuenta;
		this.dinero = dinero;
	}



	public TipoCuenta getTipocuenta() {
		return tipocuenta;
	}

	public void setTipocuenta(TipoCuenta tipocuenta) {
		this.tipocuenta = tipocuenta;
	}

	public BigDecimal getDinero() {
		return dinero;
	}

	public void setDinero(BigDecimal dinero2) {
		this.dinero = dinero2;
	}

	public String getNombreCuenta() {
		return nombreCuenta;
	}

	public void setNombreCuenta(String nombreCuenta) {
		this.nombreCuenta = nombreCuenta;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	@Override
	public String toString() {
		return getNombreCuenta();
	}
	
	//metodos para añadir y restar del dinero de la cuenta
	
	public synchronized void aniadirDinero (BigDecimal monto) {
		
		dinero.add(monto) ;
		
	}
	
	public synchronized void quitarDinero (BigDecimal monto) {
		
		if(dinero.compareTo(dinero) < 0) {
			return;
		}
		else {
			dinero.subtract(monto);
		}
	}

	public String getIdcuenta() {
		return idcuenta;
	}

	public void setIdcuenta(String idcuenta) {
		this.idcuenta = idcuenta;
	}

	public String getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(String idusuario) {
		this.idusuario = idusuario;
	}
	
	public int IDtipoCuenta (TipoCuenta tipoCuenta) {
		switch (tipoCuenta) {
		case Corriente:
			return 1;
		case Ahorro :
			return 2;
		case Facturas:
			return 3;
		case Prestamo:
			return 4;
		}
		return 0;
	}
}
