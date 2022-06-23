public class Libro {
	private String nombre;
	private String autor;
	private String descripcion;
	private int anioPub;
	private int cantPag;
	
	//constructores 
	
	public Libro() {
		
	}
	
	public Libro(String nom, String aut, String desc, int pub, int pag) {
		this.nombre = nom;
		this.autor = aut;
		this.descripcion = desc;
		this.anioPub = pub;
		this.cantPag = pag;
	}
	
	public Libro(Libro l) {
		this.nombre = l.nombre;
		this.autor = l.autor;
		this.descripcion = l.descripcion;
		this.anioPub = l.anioPub;
		this.cantPag = l.cantPag;
	}
	
	//metodos set y get
	
	public void setNombre(String n) {
		this.nombre = n;
	}
	
	public void setAutor(String a) {
		this.autor = a;
	}
	
	public void setDescripcion(String d) {
		this.descripcion = d;
	}
	
	public void setAnio(int a) {
		this.anioPub = a;
	}
	
	public void setPag(int p) {
		this.cantPag = p;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public int getAnio() {
		return anioPub;
	}
	
	public int getPag() {
		return cantPag;
	}
	
	// metodos propios
	
	public void mostrarDatos() {
		System.out.println("Los datos de los libros son: ");
		System.out.println("Nombre: " +this.nombre);
		System.out.println("Autor: " +this.autor);
		System.out.println("Descripcion: " +this.descripcion);
		System.out.println("Año de publicación: " +this.anioPub);
		System.out.println("Cantidad de páginas: " +this.cantPag);
	}
}
