package clases;

public class Main {

	public static void main(String[] args) {
		/*
		System.out.println("Sistema de gestión de biblioteca \nElija una opción:");
		System.out.println("1.- Para ingresar como usuario");
		System.out.println("2.- Para ingresar como visitante");
		System.out.println("3.- Para registrarse");
		*/
		Consulta conn = new Consulta();
		Usuario usuario = new Usuario();
		Libro libro = new Libro();
		
		//conn.mostrarLibros(2);
		/*libro = conn.buscarLibro(3);
		libro.mostrarDatos();*/
		/*usuario.cargarUsuario();
		conn.insertarUsuario(usuario);
		usuario.mostrarDatos();*/
		/*usuario.cargarUsuario();
		conn.actualizarUsuario(usuario, 2);
		usuario.mostrarDatos();*/
		//conn.mostrarUsuarios(1);
		/*usuario =conn.buscarUsuario("neo");
		usuario.mostrarDatos();*/
		//conn.borrarUsuario(2);
		//System.out.println(conn.validarUsuario("neo", "admin"));
		//conn.registrarDescarga("neo", "El señor de los anillos");
		//conn.historialDescargas(1);
		conn.historialCuotas(1);
	}

}
