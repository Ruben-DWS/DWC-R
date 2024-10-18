package servicio;

import java.util.List;
import java.util.Scanner;

import controladore.Inicio;
import dto.Club;

/**
 * @author Ruben
 * 16/10/2024
 * Se realiza por completo funcionalidades Club
 * */


public class ClubFuncionalidade implements InterfazClub{
	
	MenuInterfaz menu = new MenuImplementacion();
	InterfazConsulta ic = new ConsultaFuncionalidade();
	Scanner sc = new Scanner(System.in);
	ConexionInterfaz cn = new ConexionFuncionalidades();
	
	List<Club> listadoClub = Inicio.listaClub;	
	public void crearClub() {
		
		System.out.println("Introduzca Nombre del Club: ");
		String nombre = sc.nextLine();
		System.out.println("Nombre del Club guardado correctamente...");
		
		System.out.println("Introduzca Colores del Club: ");
		String colore = sc.nextLine();
		System.out.println("Colores del Club guardado correctamente...");
		
		System.out.println("Introduzca Alias del Club: ");
		String alia = sc.nextLine();
		System.out.println("Alias del Club guardado correctamente...");
		
		long id = ic.cargaIDClub(cn.generaConexion());
		
		Club club = new Club(id, nombre, colore, alia);
		
		listadoClub.add(club);
		
		ic.insertarnewClub(cn.generaConexion(), club);
		
		System.out.println("[INFO] - Club Resgistrado correctamente");
		
		
	}

	
	

	
	

	
	
	
	
	

}
