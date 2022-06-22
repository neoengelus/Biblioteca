import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
	
		Conexion conn = new Conexion();
		Socio soc = new Socio();
		
		cargarDatos(soc);
		conn.conectar();
		soc.mostrarDatos();
		

	}
	
	public static void cargarDatos(Socio per) {
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
		System.out.println("Es socio? 1 para Sí 2 para No");
		per.setMembresia(teclado.nextInt());
		System.out.println("Está al día? 1 para Sí 2 para No");
		per.setCuenta(teclado.nextInt());
	}

}