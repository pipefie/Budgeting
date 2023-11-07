package Clases;

public class Cuenta {
	private Usuario usuario;
	private TipoCuenta tipocuenta;
	private long dinero;
	
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
	
	
}
