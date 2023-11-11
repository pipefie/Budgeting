package Clases;

import java.util.Currency;
import java.time.*;

public class Transaccion {
	private Cuenta cuentaOrigen;
	private Cuenta cuentaDestino;
	private String destino; //en caso que la transaccion no sea a una cuenta posteriormente guardada en la app sino a otra entidad o lo que sea 
	private Acciones accion;
	private long cantidadTransaccion;
	private Currency currencyTransaccion;
	private String comentarios;
	private LocalDateTime fechaHora;
	public Transaccion() {
		super();
		// TODO Auto-generated constructor stub
	}
	//constructor para transaccion con ambas cuentas en la app
	public Transaccion(Cuenta cuentaOrigen, Cuenta cuentaDestino, long cantidadTransaccion,  
			Currency currencyTransaccion, String comentarios, LocalDateTime fechaHora) {
		super();
		this.cuentaOrigen = cuentaOrigen;
		this.cuentaDestino = cuentaDestino;
		this.cantidadTransaccion = cantidadTransaccion;
		this.currencyTransaccion = currencyTransaccion;
		this.comentarios = comentarios;
		this.fechaHora = fechaHora;
	}
	//constructor para transaccion con destino diferente
	public Transaccion(Cuenta cuentaOrigen, String destino, long cantidadTransaccion,
			Currency currencyTransaccion, String comentarios, LocalDateTime fechaHora) {
		super();
		this.cuentaOrigen = cuentaOrigen;
		this.destino = destino;
		this.cantidadTransaccion = cantidadTransaccion;
		this.currencyTransaccion = currencyTransaccion;
		this.comentarios = comentarios;
		this.fechaHora = fechaHora;
	}

	public Cuenta getCuentaOrigen() {
		return cuentaOrigen;
	}
	public void setCuentaOrigen(Cuenta cuentaOrigen) {
		this.cuentaOrigen = cuentaOrigen;
	}
	public Cuenta getCuentaDestino() {
		return cuentaDestino;
	}
	public void setCuentaDestino(Cuenta cuentaDestino) {
		this.cuentaDestino = cuentaDestino;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public long getCantidadTransaccion() {
		return cantidadTransaccion;
	}
	public void setCantidadTransaccion(long cantidadTransaccion) {
		this.cantidadTransaccion = cantidadTransaccion;
	}
	public Currency getCurrencyTransaccion() {
		return currencyTransaccion;
	}
	public void setCurrencyTransaccion(Currency currencyTransaccion) {
		this.currencyTransaccion = currencyTransaccion;
	}
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	public LocalDateTime getFechaHora() {
		return fechaHora;
	}
	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}
	public Acciones getAccion() {
		return accion;
	}
	public void setAccion(Acciones accion) {
		this.accion = accion;
	}
	
	@Override
	public String toString() {
		return "Transaccion: " + accion + ", cantidad: " + cantidadTransaccion
				+ ", moneda: " + currencyTransaccion + ", Fecha/hora" + fechaHora;
	}
	

}
