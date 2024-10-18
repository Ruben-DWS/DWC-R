package servicio;


import java.util.Scanner;





public class MenuImplementacion implements MenuInterfaz {
	
	

	
	
	public byte recogerOpcion(Scanner scanner) {
		
		System.out.println("Indica la opcion deseada: ");
		
		return scanner.nextByte();
	}
	
	public void menuYseleccion() {
		
	
		System.out.println("--------------------MENU--------------------");
		System.out.println("Bienvenido a Road Owners eliga la opcion que desee: ");
		System.out.println("0. Salir");
		System.out.println("1. Menu Usuario");
		System.out.println("2. Menu Club");
		System.out.println("--------------------------------------------");
		
	}
	
	
	
	public void menuUsuario() {
		
		System.out.println("-----------Bienvenido a Menu Usuario----------");
		System.out.println("0- Salir");
		System.out.println("1- Registrar Usuario");
		System.out.println("2- Editar Usuario");
		System.out.println("3- Eliminar Usuario");
		System.out.println("-----------------------------------------------");
		
	}
	
	
	
	
	public byte menuEdicionUsuario(Scanner scanner) {
		
			System.out.println("Eliga que campo editar: ");
			System.out.println("0- Salir");
			System.out.println("1- Nombre");
			System.out.println("2- Apellido");
			System.out.println("3- DNI");
			System.out.println("4- Telefono");
			System.out.println("5- Email");
			return scanner.nextByte();
			
	}
	
	

	public void menuClub() {
		
		System.out.println("-----------Bienvenido a Menu Club----------");
		System.out.println("0- Salir");
		System.out.println("1- Registrar Club");
		System.out.println("2- Editar Club");
		System.out.println("3- Eliminar Club");
		System.out.println("-----------------------------------------------");
		
	}
	
	
	
	
}
