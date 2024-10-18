package controladore;

import java.util.Scanner;

import servicio.InterfazUsuario;
import servicio.MenuImplementacion;
import servicio.MenuInterfaz;
import servicio.UsuarioFuncionalidades;

public class UsuarioControlado {

	public void menuGestionUsuario(Scanner scanner) {
	
		MenuInterfaz mu = new MenuImplementacion();
		boolean esCerrado = false;
		InterfazUsuario us = new UsuarioFuncionalidades();
		
		
		do {			
			mu.menuUsuario();
			byte opcion =  mu.recogerOpcion(scanner);
			switch (opcion) {
			case 0:
				System.out.println("Saliendo del Menu Usuario...");
				esCerrado = true;
				break;
			case 1:
				System.out.println("Entrando a menu Registrar...");
				us.newUsuario();
				break;
			case 2:
				System.out.println("Entrando a menu Edicion...");
				us.editUsuario();
				break;
			case 3:
				System.out.println("Entrando a Eliminacion...");
				us.eliminarUsuario();
				break;
			default:
				break;
			}
			
			
			
		} while (!esCerrado);
	
	
	
	
	}
	
	
	
}
