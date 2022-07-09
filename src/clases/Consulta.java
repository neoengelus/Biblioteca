package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;

public class Consulta {
	Conexion conn = new Conexion();
	Connection usarConexion = null;
	Statement stm = null;
	ResultSet rs = null;
	PreparedStatement ps;

	//constructores
	public Consulta() {
		
	}
	
	//métodos propios
	
	////////////////////////////////////////METODOS PARA LOS LIBROS/////////////////////////////////////////////////////
	
	public void mostrarLibros(int tipoUsuario) {
		//muestra todo el catálogo disponible según el tipo de usuario que consulta
		try {
			usarConexion = conn.conectar(); 
			String consulta = "SELECT * FROM libro";
			stm = usarConexion.createStatement();
			rs = stm.executeQuery(consulta); 
			ArrayList<Libro> listaLibro = new ArrayList<Libro>();
			
			while (rs.next()) {
				Libro libro = new Libro();
				libro.setIdLibro(rs.getInt(1));
				libro.setTitulo(rs.getString(2));
				libro.SetDescripcion(rs.getString(3));
				libro.setLinkDescarga(rs.getString(4));
				libro.setCantPaginas(rs.getInt(5));
				//libro.setAutor(buscarAutor(rs.getInt(6)));
				listaLibro.add(libro);
		} 
			if (tipoUsuario == 1 || tipoUsuario == 2) {
			//System.out.println("ID | Nombre | Descripcion | Cantidad de Páginas | Autor | Link Descarga");
			System.out.printf("|%-20s|%-20s|%-20s,|%-20s|%-20s|%-20s\n","ID", "Nombre", "Descripcion", "Cantidad de Paginas", "Autor", "Link Descarga \n");
			for (int i=0; i < listaLibro.size(); i++) {
				Libro libro = new Libro();
				libro = listaLibro.get(i);
				System.out.printf("|%-20s|%-20s|%-20s|%-20s|%-20s|\n", libro.getIdLibro(),libro.getTitulo(),libro.getDescripcion(),libro.getCantPaginas(),libro.getLinkDescarga());
				}
			} 
		else if (tipoUsuario == 3) {
			System.out.printf("|%-20s|%-20s|%-20s|%-20s|%-20s\n", "ID", "Nombre", "Descripcion", "Cantidad de Paginas", "Autor \n");
			for (int i=0; i < listaLibro.size(); i++) {
				Libro libro = new Libro();
				libro = listaLibro.get(i);
				System.out.printf("|%-20s|%-20s|%-20s|%-20s\n", libro.getIdLibro(),libro.getTitulo(),libro.getDescripcion(),libro.getCantPaginas());
				}
			
		} 
		else if (tipoUsuario == 4) {
			System.out.println("Usuario de baja o suspendido");
		}
			}catch (Exception e) {
			System.out.println("Ocurrio un error inesperado, intente de nuevo" +e);
		}
	}
	
	public Libro buscarLibro(String titulo) {
		//devuelve los datos del libro que se busca en base al título ingresado en caso de no encontrarlo devuelve null
		Libro nuevoLibro = new Libro();
		try {
			usarConexion = conn.conectar(); 
			String consulta = "SELECT * FROM libro WHERE titulo='"+titulo+"'";
			stm = usarConexion.createStatement();
			rs = stm.executeQuery(consulta); 
			if (rs.next()) {
				nuevoLibro.setIdLibro(rs.getInt(1));
				nuevoLibro.setTitulo(rs.getString(2));
				nuevoLibro.SetDescripcion(rs.getString(3));
				nuevoLibro.setLinkDescarga(rs.getString(4));
				nuevoLibro.setCantPaginas(rs.getInt(5));
				nuevoLibro.setAutor(buscarAutor(rs.getInt(6)));
				} else nuevoLibro = null;
		} catch (Exception e) {
			System.out.println("Ocurrio un error inesperado" +" " +e);
		} 
		return nuevoLibro;
	}
	
	public Libro buscarLibro(int id) {
		//devuelve los datos del libro que se busca en base del id del libro en caso de no encontrarlo devuelve null
		Libro nuevoLibro = new Libro();
		try {
			usarConexion = conn.conectar(); 
			String consulta = "SELECT * FROM libro WHERE id_libro='"+id+"'";
			stm = usarConexion.createStatement();
			rs = stm.executeQuery(consulta); 
			if (rs.next()) {
				nuevoLibro.setIdLibro(rs.getInt(1));
				nuevoLibro.setTitulo(rs.getString(2));
				nuevoLibro.SetDescripcion(rs.getString(3));
				nuevoLibro.setLinkDescarga(rs.getString(4));
				nuevoLibro.setCantPaginas(rs.getInt(5));
				nuevoLibro.setAutor(buscarAutor(rs.getInt(6)));
				} else nuevoLibro = null;
		} catch (Exception e) {
			System.out.println("Ocurrio un error inesperado" + " " + e);
		} 
		return nuevoLibro;
	}
	
	public String buscarAutor(int idAutor) {
		//devuelve el nombre del autor en caso de no encontrarlo devuelve null
		String autor = new String();
		try {
			usarConexion = conn.conectar(); 
			String consulta = "SELECT nombre FROM autor WHERE id_Autor ='"+idAutor+"'";
			stm = usarConexion.createStatement();
			rs = stm.executeQuery(consulta); 
			if (rs.next()) {
				autor = rs.getString(1);
				}
			else autor = null;
			} catch (Exception e) {
				System.out.println("Ocurrio un error inesperado" + " " +e);
		}
		return autor;
	}
	////////////////////////////////////////METODOS PARA LOS USUARIO/////////////////////////////////////////////////////
	public void insertarUsuario(Usuario user) {
		//actualiza la BD con la información proporcionada
		try {
			usarConexion = conn.conectar(); 
			String consulta = "INSERT INTO usuario (nombreUsuario, contraseña, tipoUsuario, nombre, apellido, dni, email) VALUES (?,?,?,?,?,?,?)";
			ps = usarConexion.prepareStatement(consulta);
			ps.setObject(1, user.getNombreUsuario());
			ps.setObject(2, user.getPassword());
			ps.setObject(3, user.getTipoUsuario());
			ps.setObject(4, user.getNombre());
			ps.setObject(5, user.getApellido());
			ps.setObject(6,user.getDni());
			ps.setObject(7, user.getMail());
			ps.executeUpdate();
			System.out.println("Se agregó correctamente al usuario: "+user.getNombreUsuario());
		}catch (Exception e) {
			System.out.println("Ocurrio un error inesperado"+ " "+e);
		}
	}

	public int buscarIdUsuario(String usuario) {
		//busca el id de usuario en base al nombre del mismo y devuelve su id en caso de no encontrar devuelve -1
		int id=-1;
		try {
			usarConexion = conn.conectar();
			String consulta ="SELECT id_Usuario FROM usuario WHERE nombreUsuario='" +usuario +"'";
			stm = usarConexion.createStatement();
			rs = stm.executeQuery(consulta); 
			if (rs.next()) {
				id = rs.getInt(1);
			}
		}catch (Exception e) {
			System.out.println("Ocurrio un error inesperado"+ " "+e);
		}
		return id;
	}
	
	public void mostrarUsuarios(int tipoUsuario) {
		//muestra los usuarios almacenados según el tipo especificado en tipoUsuario Si el valor está fuera del rango [1...4] muestra la totalidad de los usuarios
		String consulta = new String();
		
		if (tipoUsuario == 1 || tipoUsuario == 2 || tipoUsuario ==3 || tipoUsuario ==4 ) {
			consulta = "SELECT * FROM usuario WHERE tipoUsuario=" +tipoUsuario;
		} else {
			consulta = "SELECT * FROM usuario";
		}
		try {
			usarConexion = conn.conectar();
			
			stm = usarConexion.createStatement();
			rs = stm.executeQuery(consulta); 
			ArrayList<Usuario> listaUsuario = new ArrayList<Usuario>(); 
			
			while (rs.next()) {	
				Usuario user = new Usuario();
				user.setIdUsuario(rs.getInt(1));
				user.setNombreUsuario(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setTipoUsuario(rs.getInt(4));
				user.setNombre(rs.getString(5));
				user.setApellido(rs.getString(6));
				user.setDni(rs.getInt(7));
				user.setMail(rs.getString(8));
				listaUsuario.add(user);
			}
			System.out.println("Los usuarios son:");
			System.out.printf("|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s\n" ,"ID", "Nombre de Usuario", "Password", "Tipo de Usuario","Nombre","Apellido","DNI","email\n");
			for (int i=0; i < listaUsuario.size(); i++) {
				Usuario user = new Usuario();
				user = listaUsuario.get(i);
				System.out.printf("|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s\n" ,user.getIdUsuario(),user.getNombreUsuario(),user.getPassword(),user.getTipoUsuario(),user.getNombre(),user.getApellido(),user.getDni(),user.getMail(),"\n");
			}
		}catch (Exception e) {
			System.out.println("Ocurrio un error inesperado"+ " "+e);
		}
	}
	
	public Usuario buscarUsuario(String nombre) {
		//devuelve el usuario buscado en base al nombreUsuario en caso de no encontrar devuelve null
		Usuario nuevoUsuario = new Usuario();
		
		try {
			usarConexion = conn.conectar(); 
			String consulta = "SELECT * FROM usuario WHERE nombreUsuario='"+nombre+"'";
			stm = usarConexion.createStatement();
			rs = stm.executeQuery(consulta); 
			if (rs.next()) {
				nuevoUsuario.setIdUsuario(rs.getInt(1));
				nuevoUsuario.setNombreUsuario(rs.getString(2));
				nuevoUsuario.setPassword(rs.getString(3));
				nuevoUsuario.setTipoUsuario(rs.getInt(4));
				nuevoUsuario.setNombre(rs.getString(5));
				nuevoUsuario.setApellido(rs.getString(6));
				nuevoUsuario.setDni(rs.getInt(7));
				nuevoUsuario.setMail(rs.getString(8));
				} else nuevoUsuario = null;
		}catch (Exception e) {
			System.out.println("Ocurrio un error inesperado"+ " "+e);
		}		
		return nuevoUsuario;
	}
	
	public Usuario buscarUsuario(int id) {
		//devuelve el usuario buscado en base al id_Usuario en caso de no encontrar devuelve null
		Usuario nuevoUsuario = new Usuario();
		
		try {
			usarConexion = conn.conectar(); 
			String consulta = "SELECT * FROM usuario WHERE id_Usuario="+id;
			stm = usarConexion.createStatement();
			rs = stm.executeQuery(consulta); 
			if (rs.next()) {
				nuevoUsuario.setIdUsuario(rs.getInt(1));
				nuevoUsuario.setNombreUsuario(rs.getString(2));
				nuevoUsuario.setPassword(rs.getString(3));
				nuevoUsuario.setTipoUsuario(rs.getInt(4));
				nuevoUsuario.setNombre(rs.getString(5));
				nuevoUsuario.setApellido(rs.getString(6));
				nuevoUsuario.setDni(rs.getInt(7));
				nuevoUsuario.setMail(rs.getString(8));
				} else nuevoUsuario = null;
		}catch (Exception e) {
			System.out.println("Ocurrio un error inesperado"+ " "+e);
		}		
		return nuevoUsuario;
	}
	
	public void actualizarUsuario(Usuario user, int id) {
		//actualiza los datos del usuario en base a su id con los datos de user
		try {
			usarConexion = conn.conectar();
			String consulta ="UPDATE usuario SET nombreUsuario=?, contraseña=?, tipoUsuario=?, nombre=?, apellido=?, dni=?, email=? WHERE id_Usuario=?";
			ps = usarConexion.prepareStatement(consulta);
			ps.setObject(1, user.getNombreUsuario());
			ps.setObject(2, user.getPassword());
			ps.setObject(3, user.getTipoUsuario());
			ps.setObject(4, user.getNombre());
			ps.setObject(5, user.getApellido());
			ps.setObject(6, user.getDni());
			ps.setObject(7, user.getMail());
			ps.setObject(8, id);
			ps.executeUpdate();
			System.out.println("Se actualizó correctamente al usuario: "+user.getNombreUsuario());
		}catch (Exception e) {
			System.out.println("Ocurrio un error inesperado"+ " "+e);
		}
	}
	
	public void borrarUsuario(int id) {
		//elimina el usuario cuya id sea conincidente
		try {
			String consulta = "DELETE FROM usuario WHERE Id_Usuario="+id;
			usarConexion = conn.conectar();
			ps = usarConexion.prepareStatement(consulta);
			ps.executeUpdate();
			System.out.println("Se eliminó al usuario");
		}catch (Exception e) {
			System.out.println("Ocurrio un error inesperado"+ " "+e);
		}
	}
	
	public boolean validarUsuario(String nombreUsuario, String password) {
		//valida las credenciales ingresadas y devuelve true en caso de exíto sino false
		boolean validar=false;
			try {
				String consulta = "SELECT * FROM usuario WHERE nombreUsuario='" +nombreUsuario +"'"+ "and contraseña="+ "'" +password +"'";
				usarConexion = conn.conectar();
				stm = usarConexion.createStatement();
				rs = stm.executeQuery(consulta);
				if (rs.next()) {
					validar=true;
				}
			}catch (Exception e) {
				System.out.println("Ocurrio un error inesperado"+ " "+e);
			}
		return validar;
	}
	
	public void registrarDescarga(String nombreUsuario, String nombreLibro) {
		//registra la descarga del libro en la BD
		Usuario user = buscarUsuario(nombreUsuario);
		Libro book = buscarLibro(nombreLibro);
		
		try {
			String consulta = "INSERT INTO descarga (fechaDescarga, id_Usuario, id_Libro) VALUES (NOW(),?,?)";
			ps = usarConexion.prepareStatement(consulta);
			ps.setObject(1,user.getIdUsuario());
			ps.setObject(2, book.getIdLibro());
			ps.executeUpdate();
			System.out.println("Se registró la descarga");
		}catch (Exception e) {
			System.out.println("Ocurrio un error inesperado"+ " "+e);
		}
	}
	
	public void registrarDescarga(int idUsuario, int idLibro) {
		//registra la descarga del libro en la BD
		
		try {
			String consulta = "INSERT INTO descarga (fechaDescarga, id_Usuario, id_Libro) VALUES (NOW(),?,?)";
			ps = usarConexion.prepareStatement(consulta);
			ps.setObject(1,idUsuario);
			ps.setObject(2,idLibro);
			ps.executeUpdate();
			System.out.println("Se registró la descarga");
		}catch (Exception e) {
			System.out.println("Ocurrio un error inesperado"+ " "+e);
		}
	}
	
	public void controlDescargas(int idUsuario) {
		/*debe controlar las cantidades de descargas antes de registrarlas 
	 	No se permite la descarga de un libro si:
			ha descargado 2 libros en un mismo dia
			ha descargado más de 20 libros en el mes
			ha descargado más de 2 vece el mismo libro en 6 meses
		Si se cumplen las condiciones llama a registrarDescarga, caso contrario muestra mensaje de error 
	 */
	}
	
	public boolean controlDescargasDiarias(int idUsuario) {
		//devuelve true en caso de que se hallan superado las 2 descargas diarias permitidas caso contrario devuelve false
		boolean ctrl = false;
		try {
			String consulta="SELECT fechaDescarga FROM descarga WHERE id_Usuario=" +idUsuario + " AND fechaDescarga=CURDATE()";
			usarConexion = conn.conectar();
			stm = usarConexion.createStatement();
			rs = stm.executeQuery(consulta);
			ArrayList<Date> listaFecha = new ArrayList<Date>();
			while (rs.next()) {
				listaFecha.add(rs.getDate(1));
			}
			//vamos a controlar las dos descargas diarias 
			int cont = 0; //contador de control
			for (int i = 0; i < listaFecha.size(); i++) {
				Date hoy = new Date(System.currentTimeMillis());//devuelve el tiempo a hoy en milisegundos
				Date fecha = listaFecha.get(i);//asigana la fecha obtenida en la consulta en milisegundos
				int cantMiliSeg = 1000*60*60*24; //cantidad de milisegundos en un día
				long restaFechas = ((hoy.getTime() - fecha.getTime()) / cantMiliSeg);//Se restas las dos fechas y se divide el resultado entre el 
																				//número de milisegundos que tiene un día
				if ( restaFechas == 0) {
					cont++;
					}
				}
			if (cont >= 2) {
				System.out.println("Alcanzado el límite de 2 descargas diarias");
				ctrl = true;
				}
		}catch (Exception e) {
			System.out.println("Ocurrio un error inesperado"+ " "+e);
		}
		return ctrl;
	}
	
	public boolean controlDescargasMensuales(int idUsuario) {
		//devuelve true en caso de que se halla superado el límite de 20 libros mensuales caso contrario devuelve false
		boolean ctrl = false;
		int cont = 0;
		try {
			String consulta ="SELECT * FROM descarga WHERE YEAR(fechaDescarga) = YEAR(CURDATE()) AND MONTH (fechaDescarga) = MONTH (CURDATE()) AND id_Usuario =" +idUsuario;
			usarConexion = conn.conectar();
			stm = usarConexion.createStatement();
			rs = stm.executeQuery(consulta);
			while (rs.next()) {
				cont++;
			}
			if (cont >= 20) {
				System.out.println("Se superaron las 20 descargas mensuales");
				ctrl = true;
			}
		}catch (Exception e) {
			System.out.println("Ocurrio un error inesperado"+ " "+e);
		}
		return ctrl;
	}
	
	public boolean controlDescargasSemestrales(int idUsuario, int idLibro) {
		//devuelve true en caso de que se halla superado el máximo de 2 descargas de un mismo libro en los últimos 6 meses
		boolean ctrl = false;
		try {
		String consulta	="SELECT fechaDescarga FROM descarga WHERE id_Usuario =" +idUsuario +" AND id_Libro=" +idLibro;
		usarConexion = conn.conectar();
		stm = usarConexion.createStatement();
		rs = stm.executeQuery(consulta);
		ArrayList<Date> listaFecha = new ArrayList<Date>();
		while (rs.next()) {
			listaFecha.add(rs.getDate(1));
		}
		int mes1 = listaFecha.get(0).getMonth();
		int mes2 = listaFecha.get(1).getMonth();
		System.out.println(mes1 - mes2);
		if (mes1 - mes2 == 0) {
			System.out.println("Se descargó dos veces el mismo libro en 6 meses");
			ctrl = true;
		}
		}catch (Exception e) {
			System.out.println("Ocurrio un error inesperado"+ " "+e);
		}
		return ctrl;
	}
	
	public void historialDescargas(int idUsuario) {
		//muestra el historial de descargas en base al idUsuario
		try {
			String consulta ="SELECT * FROM descarga WHERE id_Usuario=" +idUsuario;
			usarConexion = conn.conectar();
			stm = usarConexion.createStatement();
			rs = stm.executeQuery(consulta);
			System.out.printf("|%-20s|%-20s|%-20s|%-20s\n","ID Descarga", "Fecha", "Usuario", "Libro");
			
			if (rs.next()) {
				System.out.printf("|%-20s|%-20s",rs.getString(1), rs.getString(2));
				int id=rs.getInt(4);
				Usuario usuario = buscarUsuario(idUsuario);
				Libro libro = buscarLibro(id);
				System.out.printf("|%-20s|%-20s",usuario.getNombreUsuario(), libro.getTitulo());
			}
			else {
				System.out.println("No se econtró historial");
			}
		}catch (Exception e) {
			System.out.println("Ocurrio un error inesperado"+ " "+e);
		}
	}
	
	public void historialCuotas(int idUsuario) {
		//muestra el historial de las cuotas en base al idUsuario
		try {
			String consulta="SELECT * FROM cuota WHERE id_Usuario=" +idUsuario;
			usarConexion = conn.conectar();
			stm = usarConexion.createStatement();
			rs = stm.executeQuery(consulta);
			
			System.out.printf("|%-20s|%-20s|%-20s|%-20s|%-20s|%-20s\n","ID Cuota", "Estado", "Monto", "Fecha","Usuario","Nombre Usuario");
			if (rs.next()) {
				System.out.printf("|%-20s|%-20d|%-20d|%-20s",rs.getString(1), rs.getInt(2),rs.getInt(3),rs.getDate(5));
				Usuario usuario = buscarUsuario(idUsuario);
				System.out.printf("|%-20s|%-20s", usuario.getNombre() +" " + usuario.getApellido(), usuario.getNombreUsuario());
			}else {
				System.out.println("No se econtró historial");
			}
		}catch (Exception e) {
			System.out.println("Ocurrio un error inesperado"+ " "+e);
		}
	}
	
	public boolean determinarEstadoCuota(int idUsuario) {
		//funcion que determina si un usuario está al día o no con las cuotas, true=al día, false=mora
		boolean estado=false;
		try {
			String consulta ="SELECT * FROM cuota WHERE fecha=NOW()";
			usarConexion = conn.conectar();
			stm = usarConexion.createStatement();
			rs = stm.executeQuery(consulta);
			if (rs.next()) {
				estado = true;
			}
		}catch (Exception e) {
			System.out.println("Ocurrio un error inesperado"+ " "+e);
		}
		return estado;
	}
	
	public void registrarCuota(int idUsuario, int monto, int estado) {
		//registra el pago de la cuota en la BD
		try {
			String consulta = "INSERT INTO cuota (estado, monto, id_Usuario, fecha) VALUES (?,?,?,NOW())";
			usarConexion = conn.conectar();
			ps = usarConexion.prepareStatement(consulta);
			ps.setObject(1, estado);
			ps.setObject(2, monto);
			ps.setObject(3, idUsuario);
			ps.executeUpdate();
			Usuario user = buscarUsuario(idUsuario);
			System.out.println("Se registró correctamente la cuota del usuario: " + user.getNombre() + " " +user.getApellido());
		}catch (Exception e) {
			System.out.println("Ocurrio un error inesperado"+ " "+e);
		}
	}
}
