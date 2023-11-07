package Clases;

public class Actividad {
	private Acciones accion;
	private String concepto;
	
	public Actividad(Acciones accion, String concepto) {
		super();
		this.accion = accion;
		this.concepto = concepto;
	}

	public Acciones getAccion() {
		return accion;
	}

	public void setAccion(Acciones accion) {
		this.accion = accion;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}
	
}
