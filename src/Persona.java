public class Persona {
	private String nombre;
	private String apellido;
	private String domicilio;
	private int dni;
	private int edad;
	
	//constructores
	public Persona() {
		
	}
	
	public Persona(String n, String a, String d, int i, int e) {
		this.nombre = n;
		this.apellido = a;
		this.domicilio = d;
		this.dni = i;
		this.edad = e;
	}
	
	public Persona(Persona p) {
		this.nombre = p.nombre;
		this.apellido = p.apellido;
		this.domicilio = p.apellido;
		this.dni = p.dni;
		this.edad = p.edad;
	}
	
	//métodos set y get	
	public void setNombre(String n) {
		this.nombre = n;
	}
	
	public void setApellido(String a) {
		this.apellido = a;
	}
	
	public void setDomicilio(String d) {
		this.domicilio = d;
	}
	
	public void setDni(int dni) {
		this.dni = dni;
	}
	
	public void setEdad(int e) {
		this.edad = e;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public String getDomicilio() {
		return domicilio;
	}
	
	public int getDni() {
		return dni;
	}
	
	public int getEdad() {
		return edad;
	}
	
	//metodos propios 
	public void mostrarDatos() {
		System.out.println("Los datos son: ");
		System.out.println("Nombre y Apellido: " +this.nombre +" " +this.apellido);
		System.out.println("Domicilio: " +this.domicilio);
		System.out.println("DNI Nº: " +this.dni);
		System.out.println("Edad: " +this.edad);
	}
}
