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
		this.inicio = i; //registra el pr�stamo del libro falta hacer el update en la BD se hace con otro m�todo
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
	
	//m�todos propios
	
	public boolean controlPrestamo(int idSocio) {
		//devuelve true si el usuario tiene m�s de un pr�stamo en el d�a caso contrario devuelve false
		//consulta en SQL con idSocio para traer la cantidad de pr�stamos
		//Consultas.prestamosDiarios(idSocio);
		return true;
	}
	
	public void registarPrestamo(int idSocio, int idLibro, int idEjemplar) {
		//registra el pr�stamo en la BD se debe ejecutar despu�s de setear el pr�stamo
		//Consulta SQL con los 3 ids de par�metro y el valor de this.Inicio y this.Fin
		//Consultas.registrarPrestamo();
	}
	
	public void historicoPrestamo(int idSocio) {
		//devuelve el historial de prestamos de un socio en particular
		//Consulta SQL SELECT * FROM prestamos WHERE idSocio
		//Consultas.historicoPrestamo();
	}
	
	public boolean controlDevolucion(int idSocio, int idPrestamo) {
		//devuelve true si el libro fue devuelto en tiempo y forma caso contrario false
		//if (this.fin == prestamo.devolucion)
		//Consultas.fechaDevolcion();
		return true;
	}
}