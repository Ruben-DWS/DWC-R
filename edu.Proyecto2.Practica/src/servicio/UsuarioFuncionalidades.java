package servicio;

import java.util.List;
import java.util.Scanner;
import controladore.Inicio;
import controladore.UsuarioControlado;
import dto.Usuario;


/**
 * @author RGV
 * 
 * 10/10/2024
 * 
 * Funciones de Usuario
 * **/


public class UsuarioFuncionalidades implements InterfazUsuario{
	
	
	ConexionInterfaz cpi = new ConexionFuncionalidades();
	
	InterfazConsulta ic = new ConsultaFuncionalidade();
	
	MenuInterfaz menu = new MenuImplementacion();
	
	Scanner sc = new Scanner(System.in);
	
	UsuarioControlado us = new UsuarioControlado();
	
	List<Usuario> listausuario = Inicio.listausuario;
	
	public void newUsuario(){
		
		
		
		System.out.println("Nombre de usuario: ");
		String nombre = sc.next();
		System.out.println("Nombre guardado correctamente");
		
		System.out.println("Apellido de Usuario: ");
		String apellido = sc.next();
		System.out.println("Apellido guardado correctamente");
		
		System.out.println("DNI de Usuario: ");
		String dni = sc.next();
		System.out.println("DNI guardado correctamente");
		
		System.out.println("Telefono de Usuario: ");
		int telefono = sc.nextInt();
		System.out.println("Telefono guardado correctamente");
		
		System.out.println("Email de Usuario: ");
		String email = sc.next();
		System.out.println("Email guardado correctamente");
		
		long id = ic.cargaIDUsuario(cpi.generaConexion());
		
		Usuario usuario = new Usuario(id, nombre, apellido, dni, telefono, email);
		
		listausuario.add(usuario);	
		
		ic.insertarnewUsuario(cpi.generaConexion(), usuario);
		
		System.out.println("[INFO] - Usuario añadido correctamente");
		
		
		
		
		
	
	}
	

	
	
	
	
	public void editUsuario() {
	    System.out.println("Introduzca DNI del usuario a Editar:");
	    String dni = sc.next(); // Leer el DNI del usuario a editar

	    // Cargar el usuario por DNI
	    Usuario user = ic.cargarUsuarioPorDNI(cpi.generaConexion(), dni);

	    if (user != null) { // Verificar si el usuario fue encontrado
	        byte opcion = menu.menuEdicionUsuario(sc); // Mostrar menú de opciones de edición

	        switch (opcion) {
	            case 0:
	                break; // Salir del menú

	            case 1:
	                System.out.println("Introduzca nuevo nombre: ");
	                user.setNombre(sc.next());
	                System.out.println("[INFO] - Nombre cambiado correctamente");
	                break;

	            case 2:
	                System.out.println("Introduzca nuevo apellido: ");
	                user.setApellidos(sc.next());
	                System.out.println("[INFO] - Apellido cambiado correctamente");
	                break;

	            case 3:
	                System.out.println("Introduzca nuevo DNI: ");
	                user.setDni(sc.next());
	                System.out.println("[INFO] - DNI cambiado correctamente");
	                break;

	            case 4:
	                System.out.println("Introduzca nuevo Telefono: ");
	                user.setTelefono(sc.nextInt()); // Asegúrate de que el tipo de dato sea correcto
	                System.out.println("[INFO] - Telefono cambiado correctamente");
	                break;

	            case 5:
	                System.out.println("Introduzca nuevo Email: ");
	                user.setEmail(sc.next());
	                System.out.println("[INFO] - Email cambiado correctamente");
	                break;

	            default:
	                System.out.println("[ERROR] - Opción no válida");
	                break;
	        }
	        ic.actualizarUser(cpi.generaConexion(),user);
	    } else {
	        System.out.println("No existe usuario con dicho DNI");
	    }
	}
	
	
	
	public void eliminarUsuario() {
	
		System.out.println("Introduzca DNI del usuario a eliminar: ");
		String dni = sc.next();
		ic.eliminarUsuarioPorDNI(cpi.generaConexion(), dni);
	
	
	}
}
