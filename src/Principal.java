import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
	
		Conexion conn = new Conexion();
		Socio soc = new Socio();
		Libro lib = new Libro();
		
		cargarDatosSocio(soc);
		cargarDatosLibro(lib);
		conn.conectar();
		soc.mostrarDatos();
		lib.mostrarDatos();

	}
	
	public static void cargarDatosSocio(Socio per) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Ingrese el nombre");
		per.setNombre(teclado.next());
		System.out.println("Ingrese el apellido");
		per.setApellido(teclado.next());
		System.out.println("Ingrese el domicilio");
		per.setDomicilio(teclado.next());
		teclado.nextLine();
		System.out.println("Ingrese el DNI");
		per.setDni(teclado.nextInt());
		System.out.println("Ingrese la edad");
		per.setEdad(teclado.nextInt());
		System.out.println("Es socio? 1 para S� 2 para No");
		per.setMembresia(teclado.nextInt());
		System.out.println("Est� al d�a? 1 para S� 2 para No");
		per.setCuenta(teclado.nextInt());
	}
	
	public static void cargarDatosLibro(Libro lib) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Ingrese el nombre del libro");
		lib.setNombre(teclado.next());
		System.out.println("Ingrese el autor del libro");
		lib.setAutor(teclado.next());
		System.out.println("Ingrese la descripci�n del libro");
		lib.setDescripcion(teclado.next());
		teclado.nextLine();
		System.out.println("Ingrese el a�o de publicaci�n del libro");
		lib.setAnio(teclado.nextInt());
		System.out.println("Ingrese la cantidad de p�ginas del libro");
		lib.setPag(teclado.nextInt());		
	}

}