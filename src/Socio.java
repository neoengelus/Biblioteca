public class Socio extends Persona{
	
	private boolean membresia; //true es socio
	private boolean cuenta; //true est� al d�a
	
	//constructor
	public Socio(){
		
	}
	
	public Socio(String n, String a, String d, int i, int e, boolean m, boolean c) {
		super(n,a,d,i,e);
		this.membresia = m;
		this.cuenta = c;
	}
	
	public Socio(Socio s) {
		super(s.getNombre(),s.getApellido(),s.getDomicilio(),s.getDni(),s.getEdad());
		this.cuenta = s.cuenta;
		this.membresia = s.membresia;
	}
	
	//metodos set y get 
	
	public void setMembresia(int n) {
		if (n == 1) this.membresia = true;
		else this.membresia = false;
	}
	
	public void setCuenta(int n) {
		if (n == 1) this.cuenta = true;
		else this.cuenta = false;
	}
	
	public boolean getMembresia() {
		return this.membresia;
	}
	
	public boolean getCuenta() {
		return this.cuenta;
	}
	
	//m�todos propios
	public void mostrarDatos() {
		super.mostrarDatos();
		if (this.membresia) { 
			System.out.println("Es socio"); 
			if (this.cuenta) System.out.println("El usuario est� al d�a");
			else System.out.println("El usuario se encuentra en mora");
			}
		else System.out.println("No es socio");
	}
	

	public boolean controlCuenta(int idSocio) {
		//devuelve true si el usuario est� al d�a caso contrario false
		//consulta en SQL cin el idSocio para traer el estado de cuenta
		//Consultas.Cuenta(idSocio)
		return true;
	}
	
	public boolean controSocio(int idSocio) {
		//devuelve true si el usuario es socio caso contrario false
		//consulta en SQL con el idSocio para traer si es socio o no de la biblioteca
		//Consultas.Membresia(idSocio)
		return true;
	}
}
