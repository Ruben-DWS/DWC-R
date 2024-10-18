package controladore;

import java.util.Scanner;

import servicio.ClubFuncionalidade;
import servicio.InterfazClub;
import servicio.MenuImplementacion;
import servicio.MenuInterfaz;


public class ClubControlado {

	public void menuGestionClub(Scanner scanner) {
		
		MenuInterfaz mu = new MenuImplementacion();
		boolean esCerrado = false;
		InterfazClub cl = new ClubFuncionalidade();
		
		
		do {			
			mu.menuClub();
			byte opcion =  mu.recogerOpcion(scanner);
			switch (opcion) {
			case 0:
				System.out.println("Saliendo del Menu Club...");
				esCerrado = true;
				break;
			case 1:
				System.out.println("Entrando a menu Registrar...");
				cl.crearClub();
				break;
			case 2:
				System.out.println("Entrando a menu Edicion...");
				
				break;
			case 3:
				System.out.println("Entrando a Eliminacion...");
				
				break;
			default:
				break;
			}
			
			
			
		} while (!esCerrado);
	
	
	
	
	}
	
	
}
