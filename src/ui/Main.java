package ui;
import models.PlatformController;
import java.util.Scanner;
/** Represents the User interface.
 * @author Alejandro Cordoba
 * @version 1.0
 * @since 1.0
*/
public class Main {
	
	Scanner sc;
	PlatformController control;

	/**
	 * Constructor of the Main class
	 */
	public Main() {
		sc = new Scanner(System.in);
		control = new PlatformController("NeoSound", "78964646536");
	}
	/**
 	* Our main method.
 	* @param args The command line arguments.
 	**/
	public static void main(String[] args) {
		Main main = new Main();
		int option = 0;
		do{
			option = main.getOptionShowMenu();
			main.executeOption(option);

		}while (option!=0);	
	}


	/**Shows the menu and gets the option
	 * @return option selected
	 */
	public int getOptionShowMenu(){
		int option = 0; 
		System.out.println("<<<<< Welcome to Store >>>>>");
		System.out.println(
				"1. Registrar usuario\n" +
				"2. Registrar audio \n" +
				"3. Crear lista de reproduccion \n" +
				"4. Editar lista de reproduccion\n" +
				"5. Compartir lista de reproduccion\n" +
				"6. Reproducir una cancion\n" +
				"7. Comprar una cancion\n" +
				"8. Generar reporte\n" +
				"0. Exit. ");
		option =  validateIntegerInput();
		return option; 
	}

	/**Excutes the selected option
	 * @param option selected option
	 */
	public void executeOption(int option){

		switch(option){
			case 1: 
				registerUser();
				break; 

			case 2: 
				registerAudio();
				break; 

			case 3: 
				registerPlaylist();
				break; 
			case 4:
				editPlaylist();
				break;
			case 5:
				sharePlaylist();
			break;
			case 6:
				playAudio();
			break;
			case 7:
				buySong();
			break;
			case 8:
				showPlatformResume();
			break;
			case 0: 
				System.out.println("Exit program.");
				break; 

			default: 
				System.out.println("Invalid Option");
				break; 
		}
	}

	/**Validates an integere input
	 * @return -1 if not an integer, else the integer itself
	 */
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
	
	/**
	 * Ask the data for register a user and sends it to the controller
	 */
	public void registerUser() {
		System.out.println("??Que tipo de usuario desea registrar?\n"+
		"1. Consumidor \n"+
		"2. Productor");
		String user = null;
		String id = null;
		String nickname = null;
		String imgURL = null;
		String name = null;
		String which = sc.nextLine().trim();
		if(which.equals("1")){
			System.out.println("Quieres registrar como  (1) Usuario Standard o (2) Usuario premium ");
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
				name = sc.nextLine().trim();	
				if(name.isEmpty()){
					System.out.println("El nombre no puede estar vacio");
				}else{
					System.out.println("La URL de la imagen que lo representa");
					imgURL = sc.nextLine().trim();
					if(imgURL.isEmpty()){
						System.out.println("la URL no puede estar vacia");
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

	/**
	 * Ask the data for registering an audio an sends it to the controller
	 */
	public void registerAudio() {
		String msj  = null;
		String name = null;
		String imgURL = null;
		int duration = 0;
		String album = null;
		Double price = 0.0;
		int genre = 0;
		String description = null;
		System.out.println("Inserte el nombre del productor al cual agregar el audio");
		String creatorName = sc.nextLine().trim();
		System.out.println("??Que tipo de audio deseas registrar? \n"+
		"1. Cancion \n"+
		"2. PodCast");
		String audioType = sc.nextLine().trim();
		if(audioType.equals("1") || audioType.equals("2")){	
			System.out.println("Inserte el nombre del audio");
			name = sc.nextLine().trim();
				if(control.searcAudio(name)==null){ 
				System.out.println("Inserte el el URL de la imagen");
				imgURL = sc.nextLine().trim();
				System.out.println("Inserte la duracion del audio en segundos");
				duration = sc.nextInt();
				sc.nextLine();
				
				if(audioType.equals("1")){
					System.out.println("Inserte el nombre del album");
					album = sc.nextLine();
					System.out.println("Inserte el precio de venta de la cancion");
					price = sc.nextDouble();
					System.out.println("Escoja el genero de la cancion \n"+
					"1. Rock \n"+
					"2. Pop \n"+
					"3. Trap \n"+
					"4. Houes");
					genre = sc.nextInt();
				}else if(audioType.equals("2")){
					System.out.println("Escoja la categoria de la cancion \n"+
					"1. Politica\n"+
					"2. Entretenimiento \n"+
					"3. Videojuegos \n"+
					"4. Moda");
					genre = sc.nextInt();
					sc.nextLine();
					System.out.println("Inserte la descripcion del podcast");
					description = sc.nextLine();
				}
				msj = control.addAudio(control.createAudio(name, imgURL, duration, album, price, description, genre, Integer.parseInt(audioType), creatorName), creatorName);
				System.out.println(msj);
			}else{
				System.out.println("Ya existe un audio con ese nombre");
			}
		}else{
			System.out.println("Opcion invalida");
		}
	}
	
	/**
	 * Asks the data for registering a playlist and sends it to the controller
	 */
	public void registerPlaylist() {
		String id = null;
		String playlistName = null;
		System.out.println("Inserte el identificador del usuario");
		id = sc.nextLine();
		if(control.deployUserOptions(id)[0]!=null){ 
			if(control.deployUserOptions(id)[1]==null){
				System.out.println("Inserte un nombre para la playlist");
				playlistName = sc.nextLine();
				if(control.searchPlaylistFromConsumer(playlistName, control.searchUser(id))==null){;
					if(control.createPlaylist(playlistName, id)){
						System.out.println("Se creo la playlist");
					}else{
						System.out.println("No se creo la playlist");
					}
				}else{
					System.out.println("Ya tienes una playlist creada con ese nombre");
				}
			}else{
				System.out.println(control.deployUserOptions(id)[1]);
			}
		}else{
			System.out.println("No se encontro al usuario");
		}
		
	}

	/**
	 * Ask the data for editing a playlist and sends it to the controller
	 */
	public void editPlaylist() {
		String id = null;
		String which = null;
		String playlistName = null;
		String audioName = null;
		String which2 = null;
		System.out.println("Inserte el identificador de usuario");
		id = sc.nextLine();
		if(control.deployUserOptions(id)[0]!=null){
			if(control.deployUserOptions(id)[1]==null){	
				System.out.println(control.deployUserPlaylists(id)[0]);
				System.out.println("Inserte el nombre de la playlist");
				playlistName = sc.nextLine();
				if(control.deployPlaylistAudio(playlistName, id)!=null){
					do{ 
						System.out.println("??Quieres agregar o eliminar un audio? \n"+
						"1. Agregar \n"+
						"2. Eliminar");
						which = sc.nextLine();
						if(which.equals("1") || which.equals("2")){
							System.out.println(control.deployPlaylistAudio(playlistName, id));
							if(which.equals("1")){
								System.out.println(control.deployUserOptions(id)[0]);
							}
							System.out.println("Inserte el nombre del audio");
							audioName = sc.nextLine();
							System.out.println(control.editPlaylist(playlistName, audioName, Integer.parseInt(which), id));
							System.out.println("Edicion Concluida");
						}else{
							System.out.println("Opcion invalida");
						}
						System.out.println("??Deseas hacer otro cambio? \n"+
						"1. Si \n"+
						"2. No");
						which2 = sc.nextLine().trim();
					}while(!which2.equals("2"));
				}else{
					System.out.println("No se encontro la playlist");
				}
			}else{
				System.out.println("No tienes Playlist creadas");
			}
		}else{
			System.out.println("No se encontro al usuario");
		}
		
		
		

	}
	
	/**
	 * Asks the data for sharing a playlist and sends it to the controller
	 */
	public void sharePlaylist() {
		String id = null;
		String playlistName = null;
		System.out.println("Inserte el identificador del usuario");
		id = sc.nextLine();
		if(control.deployUserPlaylists(id)[0]!=null){
			if(control.deployUserPlaylists(id)[1]!=null){
				System.out.println(control.deployUserPlaylists(id)[0]);	
				System.out.println("Inserte un nombre de la playlist");
				playlistName = sc.nextLine();
				if(control.deployPlaylistAudio(playlistName, id)!=null){
					if(control.deployPlaylistAudio(playlistName, id).equals("No hay audios en esta playlist")){
						System.out.println("No hay audios en esta playlist");
					}else{
						System.out.println(control.showPlaylistSharecode(playlistName, id));
					}
				}else{
					System.out.println("No se encontro la playlist");
				}
			}else{
				System.out.println("No tienes playlist creadas");
			}
		}else{
			System.out.println("No se encontro al usuario");
		}
		
	}

	
	
	/**
	 * Asks the data for playing an audio an simulates it being played
	 */
	public void playAudio() {
		String id = null;
		Boolean isOwned = false;
		int songsPlayed = 0;
		String audioName = null;
		String which = "";
		Boolean isSong = false;
		Boolean isPremium = false;
		System.out.println("Inserte el identificador del usuario");
		id = sc.nextLine();
		if(control.deployUserOptions(id)[0]!=null){ 
			if(control.deployUserOptions(id)[1]==null){ 
				do{
				System.out.println(control.deployUserOptions(id)[0]);
				System.out.println("Inserte el nombre del audio que desea reproducir");
				audioName = sc.nextLine();	
				if(control.searcAudio(audioName)!=null){
					isPremium = control.isPremium(control.searchUser(id));
					isSong = control.isSong((control.searcAudio(audioName)));
					if(control.isSong(control.searcAudio(audioName))){
						isOwned = control.searchSongFromUser(control.searcAudio(audioName), control.searchUser(id));	
					}
					if(!isSong || isOwned){
						int seconds = control.searcAudio(audioName).getDuration();
						int minutes = 0;
						int showSeconds = 0;
						Boolean playAd = true;
						String option = "1";
						Boolean isFound = false;
						int playedTime = 0;
						for (int i = 0; i <= seconds && !isFound; i++) {
							if(!isPremium && !isSong && playAd){
								System.out.println("Anuncio publicitario, en unos segundos empezara la producci??n \n"+
								"Pasate a premium, y disfruta de tus audios sin interrupciones");
								try {
									Thread.sleep(5*1000);
								} catch (Exception e) {
									System.out.println(e);
								}
								playAd = false;
							}
							if(!isPremium && isSong){
								songsPlayed++;
							}
							if(songsPlayed%2==0 && !isPremium && songsPlayed>1 && playAd){
								System.out.println("Anuncio publicitario, en unos segundos empezra la producci??n \n"+
								"Disfruta tus canciones sin interrupciones, Unete a premiun");
								try {
									Thread.sleep(5*1000);
								} catch (Exception e) {
									System.out.println(e);
								}
									playAd = false;
							}
									
							System.out.println("Reproduciendo "+audioName);
							if(minutes<10 && showSeconds<10){System.out.println("0"+minutes+":0"+showSeconds);}
							if(minutes<10 && showSeconds>=10){System.out.println("0"+minutes+":"+showSeconds);}
							if(minutes>=10 && showSeconds<10){System.out.println(""+minutes+":0"+showSeconds);}
							if(minutes>=10 && showSeconds>=10){System.out.println(""+minutes+":"+showSeconds);}
									
							showSeconds++;
							if(showSeconds>=60){
								minutes++;
								showSeconds = 0;
							}
									
								
							try {
								Thread.sleep(1*1000);
							} catch (Exception e) {
								System.out.println(e);
							}
							System.out.print("\033[H\033[2J");
							System.out.flush();
							if((showSeconds%15)==0){
								if(i<seconds-1){ 
									System.out.println("Sigues ahi?");
									System.out.println("Presiona enter para seguir reproduciendo u otra tecla para salir del audio");
									option = sc.nextLine();
									if(!option.equals("")){
										isFound = true;
									}
								}
							}
							if(i>=seconds){
								isFound = true;
							}
							playedTime = i;
						}
						control.updateAudio(control.searcAudio(audioName), playedTime);
						control.playAudio(id, control.searcAudio(audioName), playedTime);
						System.out.println("Fin de la reproduccion");				
																		
					}else{
						System.out.println("No has comprado esta cancion");
					}
				}else{
					System.out.println("No se encontro el audio");
				}
				System.out.println("Deseas reproducir otro audio? \n"+
				"1. Si \n"+
				"2. No");
				which = sc.nextLine();
		}while(!which.equals("2"));	
			}else{
				System.out.println(control.deployUserOptions(id)[1]);
			}
		}else{
			System.out.println("No se encontro al usuario");
		}
		
						
		
	}
	
	/**
	 * Asks the data for buying a song and sends it to the controller
	 */
	public void buySong() {
		String id  = null;
		String songName = null;
		System.out.println("Inserte el identificador del usuario");
		id = sc.nextLine();
		if(control.deploySongs()!=null){
			if(control.searchUser(id)!=null){
				System.out.println(control.deploySongs());
				System.out.println("Inserte el nombre la cancion");
				songName = sc.nextLine();
				System.out.println(control.buySong(songName, id));
			}else{
				System.out.println("No se encontro al usuario");
			}
		}else{
			System.out.println("Aun no hay canciones creadas en el servicio, Intenta mas tarde");
		}
	}

	/**
	 * Asks the data for displaying users resume and displays it with all the general platform stadistics
	 */
	public void showPlatformResume(){
		String id = null;
		System.out.println("Inserte el id del usuario");
		id = sc.nextLine();
		System.out.println(control.generateAudioReport(id));
			
	}

	
}