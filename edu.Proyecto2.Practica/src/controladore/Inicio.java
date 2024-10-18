package controladore;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import dto.Club;
import dto.Usuario;
import servicio.MenuImplementacion;
import servicio.MenuInterfaz;
/**
 * @author Ruben
 * 16/10/2024
 * Se actualiza estructura de proyecto
 * */


public class Inicio {

	 public static List<Usuario> listausuario = new ArrayList<Usuario>();
	
	 public static List<Club> listaClub = new ArrayList<Club>();

	 
	 
	public static void main(String[] args) {
		
		
	
		
		MenuInterfaz mi = new MenuImplementacion();
		
		Scanner sc = new Scanner(System.in);
		ClubControlado cl = new ClubControlado();
		UsuarioControlado us = new UsuarioControlado();
			
		boolean esCerrado = false;
		
			
		
		
		
		
		
		
		
		
		do {
			mi.menuYseleccion();
			byte opcion = mi.recogerOpcion(sc);
			switch (opcion) {
			case 0:
				System.out.println("La aplicacion se va a Cerrar");
				esCerrado = true;
				break;
			case 1: 
				System.out.println("Entrando al menu Usuario...");
				us.menuGestionUsuario(sc);
				break;
			case 2: 
				System.out.println("Entrando al menu Club...");
				cl.menuGestionClub(sc);
			default:
				break;
			}
				
		} while (!esCerrado);
		
		 
		 
		 
	 
	
	
	}

}
