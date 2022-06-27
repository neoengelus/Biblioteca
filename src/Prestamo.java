import java.util.Date;

public class Prestamo {
	private int nroPrestamo;
	private Date inicio;
	private Date fin;
	
	//constructores
	public Prestamo() {
		
	}
	
	public Prestamo(int n, Date i, Date f) {
		this.nroPrestamo = n;
		this.inicio = i;
		this.fin = f;
	}
	
	public Prestamo(Prestamo p) {
		this.inicio = p.inicio;
		this.fin = p.fin;
		this.nroPrestamo = p.nroPrestamo;
	}
	
	//metodos set y get
	
	public void setNroPrestamo(int n) {
		this.nroPrestamo = n;
	}
	
	public void setInicio(Date i) {
		this.inicio = i;
	}
	
	public void setFin(Date f) {
		this.fin = f;
	}
	
	public int getNroPrestamo() {
		return this.nroPrestamo;
	}
	
	public Date getInicio() {
		return this.inicio;
	}
	
	public Date getFin() {
		return this.fin;
	}
	
	public boolean controlPrestamo(int idSocio) {
		//devuelve true si el usuario tiene m�s de un pr�stamo en el d�a caso contrario devuelve false
		//consulta en SQL con idSocio para traer la cantidad de pr�stamos
		//Consultas.prestamosDiarios(idSocio);
		return true;
	}
}