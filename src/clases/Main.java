package clases;
import java.sql.*;
import java.util.Scanner;

public class Main {
	
	static String nombre;
	static String password;
	
	public static void main(String[] args) {
		opciones(Menu());
		}

	//Funciones 
	public static int Menu() {
		int opcion;
		Scanner teclado = new Scanner(System.in);
		System.out.println("+------------------------------------------------------------------+");
		System.out.println("|                  Biblioteca 2.0                                  |");
		System.out.println("+------------------------------------------------------------------+");
		System.out.println("|                                                                  |");
		System.out.println("| (1) Ingresar al sistema con su usuario                           |");
		System.out.println("| (2) Ingresar al sistema como invitado                            |");
		System.out.println("| (3) Crear nuevo usuario                                          |");
		System.out.println("| (4) Salir                                                        |");
		System.out.println("|                                                                  |");
		System.out.println("+------------------------------------------------------------------+");
		System.out.printf("| Ingrese su opci�n: ");
		opcion = teclado.nextInt();
		return (opcion);

	}
	public static void opciones(int op) {
		
		String user;
		String pass;
		Scanner teclado = new Scanner(System.in);
		switch(op) {
		case 1: 
			System.out.println("+------------------------------------------------------------------+");
			System.out.println("|                          LOGIN                                   |");
			System.out.println("+------------------------------------------------------------------+");
			System.out.println("|                                                                  |");
			System.out.println("|                                                                  |");
			System.out.printf("     USUARIO: ");
			user = teclado.nextLine();
			nombre = user;
			System.out.printf("     CONTRASE�A: ");
			pass = teclado.next();
			password = pass;
			Login logueo = new Login();
			if (logueo.login(user, pass) == 1) {
				System.out.println("+------------------------------------------------------------------+");
				System.out.println("|                       Login exitoso                              |");
				System.out.println("+------------------------------------------------------------------+");
				System.out.println("|                  Bienvenido/a nuevamente                         |");
				System.out.println("+------------------------------------------------------------------+");
				try { Thread.sleep(1500); 
				  } catch(InterruptedException ex) 
				  { Thread.currentThread().interrupt(); }
				Consulta tipoU =new Consulta();
				menuUsuario(tipoU.determinarTUsuario(user));
				
				
			}else {
				System.out.println("+------------------------------------------------------------------+");
				System.out.println("|          ERROR! Usuario o Contrase�a incorrectos                 |");
				System.out.println("+------------------------------------------------------------------+");
				try { Thread.sleep(2500); 
				  } catch(InterruptedException ex) 
				  { Thread.currentThread().interrupt(); }
				System.out.println("|        Desea intentarlo nuevamente...?                           |");
				System.out.println("| (1) SI                                                           |");
				System.out.println("| (2) NO (volver al menu anterior)                                 |");
				System.out.printf("|  Ingrese su opci�n: ");
				if (teclado.nextInt() == 1)
					opciones(1);
				else opciones(Menu());
			}
			
			break;
			
		case 2: 
			
			 try {
					Conexion conn = new Conexion();
					Connection con = null;
					Statement stm = null;

					con = conn.conectar();
					stm = con.createStatement();
					String sql;
					sql = "SELECT L.id_Libro AS ID, L.titulo AS Titulo, L.descripcion AS Descripcion, L.paginas AS Paginas, A.nombre AS Autor  FROM libro as L INNER JOIN autor as A ON L.id_Autor = A.id_Autor;";
					ResultSet rs = stm.executeQuery(sql);
						  
					System.out.printf("+---+-----------------------------------------+----------------------------------------------------------------------------------------+-----+------------------------------+\n");
					System.out.printf("|%-3s|%-41s|%-88s|%5s|%30s|\n","ID", "Nombre", "Descripcion", "Pag.", "Autor");
					System.out.printf("+---+-----------------------------------------+----------------------------------------------------------------------------------------+-----+------------------------------+\n");
					  
					while (rs.next()) {
							int id = rs.getInt("ID");
							String titulo = rs.getString("Titulo");
							String desc = rs.getString("Descripcion");
							int pag = rs.getInt("Paginas");
							String autor = rs.getString ("Autor");
							System.out.printf("|%-3s|%-41s|%-88s|%5s|%30s|\n", id, titulo, desc, pag, autor);
					
							}
					System.out.printf("+---+-----------------------------------------+----------------------------------------------------------------------------------------+-----+------------------------------+\n");
					  
					} catch (Exception e) {
						System.out.println("error!!");
						System.out.println(e);
					}
				
			System.out.printf("Presione una tecla + 'Enter' para volver al menu anterior");
			teclado.next();
			opciones(Menu());
			
			break;
		
		case 3: 
			
			//Usuario newUser = new Usuario();
			//newUser.cargarUsuario(2);
			//String nick = newUser.getNombreUsuario();
			//System.out.println(nick);
			
			System.out.println("+------------------------------------------------------------------+");
			System.out.println("|                         NUEVO USUARIO                            |");
			System.out.println("+------------------------------------------------------------------+");
			System.out.println("|                                                                  |");
			System.out.println("|                                                                  |");
			System.out.printf("   Ingrese nombre de Usuario: ");
			String nick = teclado.nextLine();
			System.out.printf("   Ingrese contrase�a: ");
			pass = teclado.nextLine();
			System.out.printf("   Ingrese su Nombre: ");
			String name = teclado.nextLine();
			System.out.printf("   Ingrese su Apellido: ");
			String surname = teclado.nextLine();
			System.out.printf("   Ingrese su DNI: ");
			int dni = teclado.nextInt();
			System.out.printf("   Ingrese su  direcci�n de correo electronico: ");
			String email = teclado.next();
			int userType = 2;
			int state = 1;
			
			Consulta existe = new Consulta();
			int resultado = existe.existeUsuario(nick);
			if (resultado == 0) {
				Usuario newUser = new Usuario(name, surname, email, nick, pass, userType, state, dni);
				existe.insertarUsuario(newUser);
				
				System.out.println("+------------------------------------------------------------------+");
				System.out.println("                  Bienvenido/a "+nick+"");
				System.out.println("+------------------------------------------------------------------+");
				try { Thread.sleep(1500); 
				  } catch(InterruptedException ex) 
				  { Thread.currentThread().interrupt(); }
				menuUsuario(2);
				
			}
			else {
				System.out.println("+------------------------------------------------------------------+");
				System.out.println("|          ERROR! El nombre de usuario ya existe                   |");
				System.out.println("+------------------------------------------------------------------+");
				System.out.println("|        Desea intentarlo nuevamente...?                           |");
				System.out.println("| (1) SI                                                           |");
				System.out.println("| (2) NO (volver al menu anterior)                                 |");
				System.out.printf("|  Ingrese su opci�n: ");
				int opc = teclado.nextInt();
				if ( opc == 1)
					opciones(3);
				else opciones(Menu());
				
			}
				
			
		break;
		
		case 4:
			System.out.println("+------------------------------------------------------------------+");
			System.out.println("|                         HASTA LUEGO!!                            |");
			System.out.println("+------------------------------------------------------------------+");
			try { Thread.sleep(1500); 
			  } catch(InterruptedException ex) 
			  { Thread.currentThread().interrupt(); }
			break;
		
		default: 		
			System.out.println("+------------------------------------------------------------------+");
			System.out.println("|          OPCION NO DISPONIBLE, INTENTE NUEVAMENTE                |");
			System.out.println("+------------------------------------------------------------------+");
			try { Thread.sleep(1500); 
			  } catch(InterruptedException ex) 
			  { Thread.currentThread().interrupt(); }
			opciones(Menu());
			break;
		
		}
		//teclado.close();
		
	}
	
	public static void menuUsuario(int tipo) {
		int opcion;
		Scanner teclado = new Scanner(System.in);
		
		switch(tipo) {
		case 1:
			System.out.println("+------------------------------------------------------------------+");
			System.out.println("|                  Administradores - Biblioteca 2.0                |");
			System.out.println("+------------------------------------------------------------------+");
			System.out.println("|                                                                  |");
			System.out.println("| (1) Crear, Ver, Actualizar o Borrar un usuario administrador     |");
			System.out.println("| (2) Acciones con cuotas de Socios                                |");
			System.out.println("| (3) Ver registro de multas de un Socio                           |");
			System.out.println("| (4) Ver libros descargados por un Socio                          |");
			System.out.println("| (5) Crear, Actualizar o Borrar un Libro                          |");
			System.out.println("| (6) Buscar un libro                                              |");
			System.out.println("| (7) Salir                                                        |");
			System.out.println("|                                                                  |");
			System.out.println("+------------------------------------------------------------------+");
			System.out.printf("| Ingrese su opci�n: ");
			opcion = teclado.nextInt();
			if (opcion == 8) {
				try { Thread.sleep(1000); 
				  } catch(InterruptedException ex) 
				  { Thread.currentThread().interrupt(); }
				opciones(Menu());
			}
				
			else accionesAdmin(opcion);
						
			break;
		case 2:
			System.out.println("+------------------------------------------------------------------+");
			System.out.println("|                  Usuarios - Biblioteca 2.0                       |");
			System.out.println("+------------------------------------------------------------------+");
			System.out.println("|                                                                  |");
			System.out.println("| (1) Ver libros disponibles                                       |");
			System.out.println("| (2) Buscar un libro                                              |");
			System.out.println("| (3) Ver estado de cuotas                                         |");
			System.out.println("| (4) Ver historico de descargas                                   |");
			System.out.println("| (5) Darse de baja                                                |");
			System.out.println("| (6) Salir                                                        |");
			System.out.println("|                                                                  |");
			System.out.println("+------------------------------------------------------------------+");
			System.out.printf("| Ingrese su opci�n: ");
			opcion = teclado.nextInt();
			if (opcion == 6)
				opciones(Menu());
			else accionesUser(opcion);
			break;
		case 4:
			System.out.println("+------------------------------------------------------------------+");
			System.out.println("| ERROR!! Usuario de baja o suspendido. Contacte un administrador  |");
			System.out.println("+------------------------------------------------------------------+");
			try { Thread.sleep(1500); 
			  } catch(InterruptedException ex) 
			  { Thread.currentThread().interrupt(); }
			opciones(Menu());
			break;
		default:
			System.out.println("+------------------------------------------------------------------+");
			System.out.println("|         ERROR!! Regresando al men� anterior...                   |");
			System.out.println("+------------------------------------------------------------------+");
			try { Thread.sleep(1500); 
			  } catch(InterruptedException ex) 
			  { Thread.currentThread().interrupt(); }
			opciones(Menu());
			break;
		}
	}
	
	public static void accionesAdmin(int op) {
		Scanner teclado = new Scanner(System.in);
		int opcion;
		String respuesta;
		
		switch(op) {
		case 1:
			System.out.println("+------------------------------------------------------------------+");
			System.out.println("|                  Administradores - Biblioteca 2.0                |");
			System.out.println("+------------------------------------------------------------------+");
			System.out.println("|                                                                  |");
			System.out.println("| (1) Crear un nuevo usuario administrador                         |");
			System.out.println("| (2) Ver datos de un Administrador                                |");
			System.out.println("| (3) Actualizar datos de un Administrador                         |");
			System.out.println("| (4) Borrar un usuario Administrador                              |");
			System.out.println("| (5) Salir                                                        |");
			System.out.println("|                                                                  |");
			System.out.println("+------------------------------------------------------------------+");
			System.out.printf("| Ingrese su opci�n: ");
			opcion = teclado.nextInt();
			crudUsuarios(opcion, 1);
			
			break;
		case 2:
			System.out.println("+------------------------------------------------------------------+");
			System.out.println("|                  Administradores - Biblioteca 2.0                |");
			System.out.println("+------------------------------------------------------------------+");
			System.out.println("|                                                                  |");
			System.out.println("| (1) Ver cuotas impagas                                           |");
			System.out.println("| (2) Registrar cuota pagada                                       |");
			System.out.println("| (3) Actualizar datos de un Administrador                         |");
			System.out.println("| (4) Borrar un usuario Administrador                              |");
			System.out.println("| (5) Salir                                                        |");
			System.out.println("|                                                                  |");
			System.out.println("+------------------------------------------------------------------+");
			System.out.printf("| Ingrese su opci�n: ");
			opcion = teclado.nextInt();
			
			
			break;
		case 3:
			
			break;
		case 4:
			System.out.println("+------------------------------------------------------------------+");
			System.out.println("|                  Administradores - Biblioteca 2.0                |");
			System.out.println("+------------------------------------------------------------------+");
			System.out.println("|                                                                  |");
			System.out.print("| Ingrese el nombre del usuario: ");
			respuesta = teclado.nextLine();
			Consulta consul = new Consulta();
			if (consul.existeUsuario(respuesta) == 0) {
				System.out.println("+------------------------------------------------------------------+");
				System.out.println("|                  El usuario ingresado no existe                  |");
				System.out.println("+------------------------------------------------------------------+");
				accionesAdmin(4);
			} else {
				int idUsuario = consul.buscarIdUsuario(respuesta);
				consul.historialDescargas(idUsuario);
			}
				
			break;
		case 5:
			
			break;
		case 6:
			
			break;
		default:
			System.out.println("+------------------------------------------------------------------+");
			System.out.println("|          REGRESANDO AL MENU ANTERIOR...                          |");
			System.out.println("+------------------------------------------------------------------+");
			try { Thread.sleep(1500); 
			  } catch(InterruptedException ex) 
			  { Thread.currentThread().interrupt(); }
			menuUsuario(1);
			break;
		
		}
		
		
	}
	public static void accionesUser(int op) {
		Scanner teclado = new Scanner(System.in);
		int opcion;
		Consulta consul = new Consulta();
		int idUsuario = consul.buscarIdUsuario(nombre);
		switch(op) {
		case 1:
			consul.mostrarLibros(2);
			System.out.println("+------------------------------------------------------------------+");
			System.out.println("|        Desea realizar otra consulta...?                          |");
			System.out.println("+------------------------------------------------------------------+");
			System.out.println("| (1) SI                                                           |");
			System.out.println("| (2) NO (sale del sistema)                                        |");
			System.out.println("+------------------------------------------------------------------+");
			System.out.print("|  Ingrese su opci�n:                                               ");
			opcion = teclado.nextInt();
			if (opcion == 1) {
				menuUsuario(2);
			} else
				Menu();
			break;
		case 2:
			System.out.println("+------------------------------------------------------------------+");
			System.out.println("|                   B�squeda de Libros                             |");
			System.out.println("+------------------------------------------------------------------+");
			System.out.println("| (1) Buscar por nombre de libro                                   |");
			System.out.println("| (2) Buscar por ID de libro                                       |");
			System.out.println("| (3) Volver al men� anterior                                      |");
			System.out.println("+------------------------------------------------------------------+");
			System.out.print("|   Ingrese su opci�n:                                              ");
			opcion = teclado.nextInt();
			if (opcion == 1) {
				System.out.print(" |  Ingrese el nombre del libro:                                    ");
				Scanner nombre = new Scanner(System.in);
				String nombreLibro = teclado.nextLine();
				Libro libroBuscado = consul.buscarLibro(nombreLibro);
				libroBuscado.mostrarDatos();
				} else if (opcion == 2) {
					System.out.print("|  Ingrese el ID del libro:                                        ");
					int idLibro = teclado.nextInt();
					Libro libroBuscado = consul.buscarLibro(idLibro);
					libroBuscado.mostrarDatos();
				} else {
					accionesUser(2);
				}
			break;
		case 3:
			System.out.println("+------------------------------------------------------------------+");
			System.out.println("|                   Historial de Cuotas                            |");
			System.out.println("+------------------------------------------------------------------+");
			consul.historialCuotas(idUsuario);
			System.out.println("+------------------------------------------------------------------+");
			System.out.println("|        Desea realizar otra consulta...?                          |");
			System.out.println("+------------------------------------------------------------------+");
			System.out.println("| (1) SI                                                           |");
			System.out.println("| (2) NO (sale del sistema)                                        |");
			System.out.println("+------------------------------------------------------------------+");
			System.out.print("|  Ingrese su opci�n:                                               ");
			opcion = teclado.nextInt();
			if (opcion == 1) {
				menuUsuario(2);
			} else
				Menu();
			break;
		case 4:
			System.out.println("+------------------------------------------------------------------+");
			System.out.println("|                Historial de Descargas                            |");
			System.out.println("+------------------------------------------------------------------+");
			consul.historialDescargas(idUsuario);
			System.out.println("+------------------------------------------------------------------+");
			System.out.println("|        Desea realizar otra consulta...?                          |");
			System.out.println("+------------------------------------------------------------------+");
			System.out.println("| (1) SI                                                           |");
			System.out.println("| (2) NO (sale del sistema)                                        |");
			System.out.println("+------------------------------------------------------------------+");
			System.out.print("|  Ingrese su opci�n:                                               ");
			opcion = teclado.nextInt();
			if (opcion == 1) {
				menuUsuario(2);
			} else
				Menu();
			break;
		case 5:
			System.out.println("+------------------------------------------------------------------+");
			System.out.println("|                Baja de Usuario                                   |");
			System.out.println("+------------------------------------------------------------------+");
			consul.bajaUsuario(idUsuario);
			System.out.println("+------------------------------------------------------------------+");
			System.out.println("|        Desea realizar otra consulta...?                          |");
			System.out.println("+------------------------------------------------------------------+");
			System.out.println("| (1) SI                                                           |");
			System.out.println("| (2) NO (sale del sistema)                                        |");
			System.out.println("+------------------------------------------------------------------+");
			System.out.print("|  Ingrese su opci�n:                                               ");
			opcion = teclado.nextInt();
			if (opcion == 1) {
				menuUsuario(2);
			} else
				Menu();
			break;
		default:
			System.out.println("+------------------------------------------------------------------+");
			System.out.println("|          REGRESANDO AL MENU ANTERIOR...                          |");
			System.out.println("+------------------------------------------------------------------+");
			try { Thread.sleep(1500); 
			  } catch(InterruptedException ex) 
			  { Thread.currentThread().interrupt(); }
			menuUsuario(2);
			break;
		}
	}

	public static void crudUsuarios(int op, int tipo) {
		Scanner teclado = new Scanner(System.in);
		Usuario user = new Usuario();
		Consulta consul = new Consulta();
	
		if (tipo == 1) {
			switch(op) {
			case 1:
				System.out.println("+------------------------------------------------------------------+");
				System.out.println("|                         NUEVO ADMINISTRADOR                      |");
				System.out.println("+------------------------------------------------------------------+");
				System.out.println("|                                                                  |");
				System.out.println("|                                                                  |");
				System.out.printf("   Ingrese nombre de Usuario: ");
				String nick = teclado.nextLine();
				System.out.printf("   Ingrese contrase�a: ");
				String pass = teclado.nextLine();
				System.out.printf("   Ingrese Nombre: ");
				String name = teclado.nextLine();
				System.out.printf("   Ingrese Apellido: ");
				String surname = teclado.nextLine();
				System.out.printf("   Ingrese DNI: ");
				int dni = teclado.nextInt();
				System.out.printf("   Ingrese direcci�n de correo electronico: ");
				String email = teclado.next();
				int userType = 1;
				int state = 1;
				Consulta existe = new Consulta();
				int resultado = existe.existeUsuario(nick);
				if (resultado == 0) {
					Usuario newUser = new Usuario(name, surname, email, nick, pass, userType, state, dni);
					existe.insertarUsuario(newUser);
					System.out.println("+------------------------------------------------------------------+");			
				}
				accionesAdmin(1);
				break;
			case 2:
				System.out.println("+------------------------------------------------------------------+");
				System.out.println("|                  Administradores - Biblioteca 2.0                |");
				System.out.println("+------------------------------------------------------------------+");
				System.out.println("|                                                                  |");
				System.out.printf("|  Ingrese el nombre de USUARIO a buscar: ");
				user = consul.buscarUsuario(teclado.next());
				if (user == null || user.getTipoUsuario() != 1) {
					System.out.println("+------------------------------------------------------------------+");
					System.out.println("|    NOMBRE DE USUARIO ADMINISTRADOR ERR�NEO O INEXISTENTE         |");
					System.out.println("|    Regresando al menu anterior...                                |");
					System.out.println("+------------------------------------------------------------------+");
					try { Thread.sleep(2500); 
					  } catch(InterruptedException ex) 
					  { Thread.currentThread().interrupt(); }
					accionesAdmin(1);
				} else {
					user.mostrarDatos();
					System.out.println("|  TOME NOTA Y PRESIONE UNA TECLA + 'ENTER' PARA CONTINUAR         |");
					System.out.println("+------------------------------------------------------------------+");
					String a = teclado.next();
					accionesAdmin(1);
					
				}
				
				break;
			case 3:
				System.out.println("+------------------------------------------------------------------+");
				System.out.println("|                  Administradores - Biblioteca 2.0                |");
				System.out.println("+------------------------------------------------------------------+");
				System.out.println("|                                                                  |");
				System.out.printf("|  Ingrese el nombre de USUARIO a MODIFICAR: ");
				user = consul.buscarUsuario(teclado.next());
				if (user == null || user.getTipoUsuario() != 1) {
					System.out.println("+------------------------------------------------------------------+");
					System.out.println("|    NOMBRE DE USUARIO ADMINISTRADOR ERR�NEO O INEXISTENTE         |");
					System.out.println("|    Regresando al menu anterior...                                |");
					System.out.println("+------------------------------------------------------------------+");
					try { Thread.sleep(2500); 
					  } catch(InterruptedException ex) 
					  { Thread.currentThread().interrupt(); }
					accionesAdmin(1);
				} else {
					user.cargarUsuario(1);
					consul.actualizarUsuario(user, user.getIdUsuario());
					System.out.println("+------------------------------------------------------------------+");
					System.out.println("|          REGRESANDO AL MENU ANTERIOR...                          |");
					System.out.println("+------------------------------------------------------------------+");
					try { Thread.sleep(1500); 
					  } catch(InterruptedException ex) 
					  { Thread.currentThread().interrupt(); }
					accionesAdmin(1);
				}
				
				break;
			case 4:
				
				break;
			default:
				System.out.println("+------------------------------------------------------------------+");
				System.out.println("|          REGRESANDO AL MENU ANTERIOR...                          |");
				System.out.println("+------------------------------------------------------------------+");
				try { Thread.sleep(1500); 
				  } catch(InterruptedException ex) 
				  { Thread.currentThread().interrupt(); }
				menuUsuario(1);
				break;
			}
		}else {	
		
		}
	}
}