package ui;
import models.PlatformController;
import java.util.Scanner;

public class Main {
	
	Scanner sc;
	PlatformController control;

	public Main() {
		sc = new Scanner(System.in);
		control = new PlatformController("NeoSound", "78964646536");
	}
	public static void main(String[] args) {
		Main main = new Main();
		int option = 0;
		do{
			option = main.getOptionShowMenu();
			main.executeOption(option);

		}while (option!=0);	
	}

	
	public int getOptionShowMenu(){
		int option = 0; 
		System.out.println("<<<<< Welcome to Store >>>>>");
		System.out.println(
				"1. Registrar usuario\n" +
				"2. Registrar audio \n" +
				"3. Crear lista de reproduccion \n" +
				"4. Editar lista de reproduccion\n" +
				"0. Exit. ");
		option =  validateIntegerInput();
		return option; 
	}

	public void executeOption(int option){

		switch(option){
			case 1: 
				registerUser();
				break; 

			case 2: 
		
				break; 

			case 3: 
		
				
				break; 
			case 4:

				break;

			case 0: 
				System.out.println("Exit program.");
				break; 

			default: 
				System.out.println("Invalid Option");
				break; 
		}
	}

	public int validateIntegerInput(){
		int option = 0; 

		if(sc.hasNextInt()){
			option = sc.nextInt(); 
			sc.nextLine();
		}
		else{
			// clear sc. 
			sc.nextLine(); 
			option = -1; 
		}

		return option; 
	}

	public void registerUser() {
		System.out.println("¿Que tipo de usuario desea registrar?\n"+
		"1. Consumidor \n"+
		"2. Productor");
		String user = null;
		String id = null;
		String nickname = null;
		String imgURL = null;
		String name = null;
		String which = sc.nextLine().trim();
		if(which.equals("1")){
			System.out.println("Quieres registrar como (1) Usuario premium o (2) Usuario Standard");
			user = sc.nextLine().trim();
			if(user.equals("1") || user.equals("2")){
				System.out.println("Inserte el numero de documento del usuario");
				id = sc.nextLine().trim();
				if(id.isEmpty()){
					System.out.println("El id no puede estar vacio");
				}else{
					System.out.println("Inserte el nickname del usuario");
					nickname = sc.nextLine().trim();
					if(nickname.isEmpty()){
						System.out.println("El nickname no puede estar vacios");
					}else{
						String msj =control.addUser(control.createUser(id, nickname, name, imgURL, Integer.parseInt(which), Integer.parseInt(user)));
						System.out.println(msj);
					}
				}
			}else{
				System.out.println("Opcion invalida");
			}

		}else if(which.equals("2")){
			System.out.println("Quieres registrar como (1) Artista o (2) Creador de contenido");
			user = sc.nextLine().trim();
			if(user.equals("1") || user.equals("2")){
				System.out.println("Inserte el nombre del usuario");
				id = sc.nextLine();	
				if(id.isEmpty()){
					System.out.println("El nombre no puede estar vacio");
				}else{
					System.out.println("La URL de la imagen que lo representa");
					nickname = sc.nextLine().trim();
					if(nickname.isEmpty()){
						System.out.println("la URl no puede estar vacia");
					}else{
						String msj =control.addUser(control.createUser(id, nickname, name, imgURL, Integer.parseInt(which), Integer.parseInt(user)));
						System.out.println(msj);
					}
				}
			}
		}else{
			System.out.println("Opcion invalida");
		}
	}

	public void registerAudio() {
		// TODO - implement Main.registerAudio
		throw new UnsupportedOperationException();
	}

	public void registerPlaylist() {
		// TODO - implement Main.registerPlaylist
		throw new UnsupportedOperationException();
	}

	public void editPlaylist() {
		// TODO - implement Main.editPlaylist
		throw new UnsupportedOperationException();
	}

	public void sharePlaylist() {
		// TODO - implement Main.sharePlaylist
		throw new UnsupportedOperationException();
	}

	public void playAudio() {
		// TODO - implement Main.playAudio
		throw new UnsupportedOperationException();
	}

	public void buySong() {
		// TODO - implement Main.buySong
		throw new UnsupportedOperationException();
	}


}