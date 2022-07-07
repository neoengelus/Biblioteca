package clases;

import java.util.Scanner;

public class Usuario {
	private String nombre;
	private String apellido;
	private String mail;
	private String nombreUsuario; //nick que se elije en el momento del registro
	private String password; //contrase�a generada al momento del registro
	private int tipoUsuario; //1: Admin, 2:Socio, 3:Visitante, 4:Baja/Suspendido
	private int idUsuario;
	private int dni;
	
	//Constructores
	public Usuario() {
		
	}
	
	public Usuario(String nom, String ape, String mail, String nick, String pass, int tipo, int id, int dni) {
		this.nombre = nom;
		this.apellido = ape;
		this.mail = mail;
		this.nombreUsuario = nick;
		this.password = pass;
		this.tipoUsuario = tipo;
		this.idUsuario = id;
		this.dni = dni;
	}
	
	public Usuario(String nom, String ape, String mail, String nick, String pass, int tipo, int dni) {
		this.nombre = nom;
		this.apellido = ape;
		this.mail = mail;
		this.nombreUsuario = nick;
		this.password = pass;
		this.tipoUsuario = tipo;
		this.dni = dni;
	}
	
	public Usuario(Usuario u) {
		this.nombre = u.nombre;
		this.apellido = u.apellido;
		this.mail = u.mail;
		this.nombreUsuario = u.nombreUsuario;
		this.password = u.password;
		this.tipoUsuario = u.tipoUsuario;
		this.idUsuario = u.idUsuario;
		this.dni = u.dni;
	}
	
	//Metodos set y get
	public void setNombre(String n) {
		this.nombre = n;
	}
	
	public void setApellido(String a) {
		this.apellido = a;
	}
	
	public void setMail(String m) {
		this.mail = m;
	}
	
	public void setIdUsuario(int id) {
		this.idUsuario = id;
	}
	
	public void setNombreUsuario(String n) {
		this.nombreUsuario = n;
	}
	
	public void setPassword(String p) {
		this.password = p;
	}
	
	public void setTipoUsuario(int t) {
		this.tipoUsuario = t;
	}
	
	public void setDni(int d) {
		this.dni = d;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getApellido() {
		return this.apellido;
	}
	
	public String getMail() {
		return this.mail;
	}
	
	public int getIdUsuario() {
		return this.idUsuario;
	}
	
	public String getNombreUsuario() {
		return this.nombreUsuario;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public int getTipoUsuario() {
		return this.tipoUsuario;
	}
	
	public int getDni() {
		return this.dni;
	}
	
	//Metodos propios
	
	public void mostrarDatos() {
		System.out.println("Los datos son: ");
		System.out.println("Nombre y Apellido: " +this.nombre +" " +this.apellido);
		System.out.println("DNI: "+this.dni);
		System.out.println("email: "+this.mail);
		System.out.println("Nombre de Usuario: " +this.nombreUsuario);
		System.out.println("Usuario de tipo: " +determinarTipoUsuario(this.tipoUsuario));
	}

	public String determinarTipoUsuario(int t) {
		if (t == 1) return "Administrador";
		else if (t == 2) return "Usuario Registrado";
		else if (t == 4) return "Usuario de Baja / Suspendido";
		else return "Invitado";
	}

	public void cargarUsuario() {
		try (Scanner teclado = new Scanner(System.in)) {
			System.out.println("Ingrese Nombre");
			this.nombre = teclado.nextLine();
			System.out.println("Ingrese Apellido");
			this.apellido = teclado.nextLine();
			System.out.println("Ingrese correo electr�nico (e-mail)");
			this.mail = teclado.nextLine();
			System.out.println("Ingrese el nombre de usuario a mostrar (nickname)");
			this.nombreUsuario = teclado.nextLine();
			System.out.println("Ingrese una contrase�a (recuerde que es su responsabilidad el cuidado de la misma)");
			this.password = teclado.nextLine();
			System.out.println("Ingrese DNI");
			this.dni = teclado.nextInt();
			System.out.println("Ingrese el tipo de Usuario: \n 1) Administrador \n 2) Socio \n 4) De baja / suspendido");
			this.tipoUsuario = teclado.nextInt();
		}
	}
}
