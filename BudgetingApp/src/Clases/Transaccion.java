package Clases;

import java.util.Currency;
import java.util.Date;
import java.math.BigDecimal;
import java.time.*;

public class Transaccion {
	private Cuenta cuentaOrigen;
	private BigDecimal cantidadTransaccion;
	private Currency currencyTransaccion;
	private CategoryofTransaction categoryofTransaction;
	private String comentarios;
	private Date fechaHora;
	public Transaccion() {
		super();
		// TODO Auto-generated constructor stub
	}
	//constructor para transaccion con ambas cuentas en la app
	public Transaccion(Cuenta cuentaOrigen,  BigDecimal cantidadTransaccion,  
			Currency currencyTransaccion, String comentarios, Date fechaHora, CategoryofTransaction categoryofTransaction) {
		super();
		this.cuentaOrigen = cuentaOrigen;
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
	public BigDecimal getCantidadTransaccion() {
		return cantidadTransaccion;
	}
	public void setCantidadTransaccion(BigDecimal cantidadTransaccion) {
		this.cantidadTransaccion = cantidadTransaccion;
	}
	public Currency getCurrencyTransaccion() {
		return currencyTransaccion;
	}
	public void setCurrencyTransaccion(Currency currencyTransaccion) {
		this.currencyTransaccion = currencyTransaccion;
	}
	public CategoryofTransaction getCategoryofTransaction() {
		return categoryofTransaction;
	}
	public void setCategoryofTransaction(CategoryofTransaction categoryofTransaction) {
		this.categoryofTransaction = categoryofTransaction;
	}
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	public Date getFechaHora() {
		return fechaHora;
	}
	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}
	@Override
	public String toString() {
		return "Transaccion [cuentaOrigen=" + cuentaOrigen + ", cantidadTransaccion=" + cantidadTransaccion
				+ ", currencyTransaccion=" + currencyTransaccion + ", categoryofTransaction=" + categoryofTransaction
				+ ", comentarios=" + comentarios + ", fechaHora=" + fechaHora + "]";
	}


}
