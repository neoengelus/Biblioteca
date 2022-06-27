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
		return this.nombre;
	}
	
	public String getAutor() {
		return this.autor;
	}
	
	public String getDescripcion() {
		return this.descripcion;
	}
	
	public int getAnio() {
		return this.anioPub;
	}
	
	public int getPag() {
		return this.cantPag;
	}
	
	// metodos propios
	
	public void mostrarDatos() {
		System.out.println("Los datos de los libros son: ");
		System.out.println("Nombre: " +this.nombre);
		System.out.println("Autor: " +this.autor);
		System.out.println("Descripcion: " +this.descripcion);
		System.out.println("A�o de publicaci�n: " +this.anioPub);
		System.out.println("Cantidad de p�ginas: " +this.cantPag);
	}
	
	public void listarLibros() {
		//muestra una lista de todos los libros de la biblioteca
		//realiza una consulta en SQL y devuelve la totalidad del cat�logo de libros independientemente de su estado 
		//SELECT * FROM Libros
		//Consultas.listarLibros();
	}
	
	public void listarLibros(int idLibro) {
		//muestra una lista espec�fica de los libros indicados 
		//consulta SQL que devuelve los libros indicados mediante su id
		//Consultas.listarlibros();
	}
	
	public void listarLibros(String nombre) {
		//muestra la lista de libros por autor
		//consulta SQL que devuelve los libros del autor indicado
		//Consultas.listarLibros();
	}
	
	public boolean estadoLibro(int nroEjemplar, int idLibro) {
		//devuelve true si el libro se encuentra prestado caso contrario false
		//teniendo en cuenta que el nro de ejemplar es un entero y se va incrementando y 
		//puede haber m�s de un ejemplar del mismo tipo, Por ej Algebra de Boole ejemplar 1, Algebra de Boole ejemplar 2 
		//por eso mismo se usa el idLibro para determinar espec�ficamente que libro es ya que este es �nico de cada libro
		//sin importar si hay m�s de un ejemplar del mismo
		//Consulta SQL con los valores mencionados anteriormente
		//Consultas.estadoLibro();
		return true;
	}
}
