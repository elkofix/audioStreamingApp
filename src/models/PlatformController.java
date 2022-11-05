package models;

import java.util.ArrayList;

public class PlatformController {

	private String name;
	private String nit;
	private ArrayList<User> users;
	private ArrayList<Audio> audios;

	/**
	 * 
	 * @param name
	 * @param nit
	 */
	public PlatformController(String name, String nit) {
		
		this.name = name;
		this.nit = nit;
		users = new ArrayList<User>();
		users.add(new Premium("1", "k"));
		users.add(new ContentCreator("a", "a"));
		audios = new ArrayList<Audio>();
	}

	/**
	 * 
	 * @param User
	 */
	public String addUser(User user) {
		String id = giveUserId(user);
		String msj = "No se agrego el usuario";
		User anyUser = searchUser(id);
		if(anyUser == null){
			if(users.add(user)){
				msj = "Sea agrego el usuario";
			}
		}else{
			msj = "Ya existe un usuario con ese identificador";
		}
		
		return msj;
	}

	public User createUser(String id, String nickname, String name, String imgURL, int typeUser1, int typeUser2){
		User anyUser = null;
		if(typeUser1 == 1){
			if(typeUser2 == 1){
				anyUser = new Standard(id, nickname);
			}else{
				anyUser = new Premium(id, nickname);
			}
		}

		if(typeUser1 == 2){
			if(typeUser2 == 1){
				anyUser = new Artist(name, imgURL);
			}else{
				anyUser = new ContentCreator(name, imgURL);
			}
		}
		return anyUser;
	}

	public Audio createAudio(String name, String imgURL, int duration, String album, double price, String description, int genre,int audioType){
		Audio anyAudio = null;
		if(audioType==1){
			anyAudio = new Song(name, imgURL, duration, album, price, giveSongGenre(genre));
		}else{
			anyAudio = new PodCast(name, imgURL, duration, description, givePodcastCategory(genre));
		}
		return anyAudio;
	}

	/**
	 * 
	 * @param Audio
	 */
	public String addAudio(Audio audio, String userId) {
		String msj = "No se agrego el audio";
		User anyUser = searchUser(userId);
		if(anyUser!=null){
			if(anyUser instanceof Artist && audio instanceof Song){
				((Artist)(anyUser)).addSong(((Song)(audio)));
				audios.add(audio);
				msj = "Se agrego la cancion";
			}else if(anyUser instanceof ContentCreator && audio instanceof PodCast){
				((ContentCreator)(anyUser)).addPodcast(((PodCast)(audio)));
				audios.add(audio);
				msj = "Se agrego el podcast";
			}else{
				msj = "Este usuario no puede agregar este audio";
			}
		}
		return msj;
	}
	
	/**
	 * 
	 * @param name
	 */
	public User searchUser(String id){
		User anyUser = null;
		Boolean isFound = false;
		String userName;
		String userId;
			for (int i = 0; i < users.size() && !isFound; i++) {
				if(users.get(i) instanceof Artist || users.get(i) instanceof ContentCreator){
				userName = ((ProducerUser)(users.get(i))).getName();
					if(id.equals(userName)){
						anyUser = users.get(i);
						isFound = true;
					}

				}
				if(users.get(i) instanceof ConsumerUser){
						userId = ((ConsumerUser)(users.get(i))).getId();
						if(id.equals(userId)){
							anyUser = users.get(i);
							isFound = true;
						}
				}
			}
			
		return anyUser;
	}
	public String showUsers(){
		String msj = "";
		for (int i = 0; i < users.size(); i++) {
			if(users.get(i) instanceof ConsumerUser){
				msj+=((ConsumerUser)(users.get(i))).getId();
			}
			
		}
		return msj;
	}
	public String[] deployUserOptions(String id){
		String[] msj = new String[]{"Audios disponibles: \n \n", null};
		User anyUser = searchUser(id);
		ConsumerUser anyUserC = null;
		if(anyUser != null){
			if(anyUser instanceof Premium  || anyUser instanceof Standard){
				anyUserC = (ConsumerUser)anyUser;
				msj[0] += anyUserC.deployPurchases() + "\n";
				msj[0]+= deployPodcast();
		
			}else{
				msj[1] = "Este usuario es no es de tipo consumidor";
			} 
		}
		return msj;
		
	}

	public String deployPodcast(){
		String msj = "Podcast disponbibles: \n";
		int counter = 0;
		for (int i = 0; i < audios.size(); i++) {
			if(audios.get(i) instanceof PodCast){
				msj+= "-"+audios.get(i).getName()+"\n";
				counter++;
			}
			
		}
		if(counter == 0){
			msj = "No hay podcast disponibles por el momento \n";
		}
		return msj;
	}

	public Audio searcAudio(String audioName){
		Audio anyAudio = null;
		boolean isFound = false;
		for (int i = 0; i < audios.size() && !isFound; i++) {
			if(audios.get(i).getName().equals(audioName)){
				anyAudio = audios.get(i);
				isFound = true;
			}
		}
		return anyAudio;
	}

	public boolean createPlaylist(String name, String userId, String audioName){
		ConsumerUser anyUser = (ConsumerUser)searchUser(userId);
		Playlist newPlaylist = new Playlist(name);
		Audio anyAudio = searcAudio(audioName);
		boolean isCreated = false;
		if(anyAudio!=null){
			int i = users.indexOf(anyUser);
			newPlaylist.addAudio(anyAudio);
			anyUser.addPlaylist(newPlaylist);
			users.set(i, anyUser);
			isCreated = true;
		}
		

		return isCreated;
	}
	
	/**
	 * 
	 * @param listId
	 * @param consumerId
	 */
	public Playlist searchPlaylistFromConsumer(String name, ConsumerUser anyUser) {
		Playlist anyPlaylist = null;
		Boolean isFound = false;
		if(anyUser!= null){
				for (int i = 0; i < anyUser.getPlaylists().size() && !isFound; i++) {
					if(anyUser.getPlaylists().get(i).getName().equals(name)){
						anyPlaylist = anyUser.getPlaylists().get(i);
						isFound = true;
					}
				}
		}
		return anyPlaylist;
	}

	/**
	 * 
	 * @param Playlist
	 * @param audioName
	 * @param action
	 */
	public String editPlaylist(String playlistName, String audioName, int action, String UserName) {
		String msj = "Lol";
		User anyUser = searchUser(UserName);
		ConsumerUser anyUserC = parseUser(anyUser);
		Audio newAudio = searcAudio(audioName);
		if(anyUserC!= null){
			Playlist anyPlaylist = searchPlaylistFromConsumer(playlistName, anyUserC);
			if(anyPlaylist != null){
				if(newAudio!=null && newAudio instanceof PodCast){
					if(action == 1){
						if(anyPlaylist.getAudios().contains(newAudio)){
							msj = "Este podcast ya pertenece a la playlist";
						}else{
							anyPlaylist.getAudios().add(newAudio);
							anyUserC.getPlaylists().remove(anyPlaylist);
								anyUserC.addPlaylist(anyPlaylist);
								users.remove(anyUser);
								users.add(anyUserC);
								msj = "Se agrego el podcast";
						}
						
					}
					if(action == 2){
						if(anyPlaylist.getAudios().contains(newAudio)){
							anyPlaylist.getAudios().remove(newAudio);
							anyUserC.getPlaylists().remove(anyPlaylist);
								anyUserC.addPlaylist(anyPlaylist);
								users.remove(anyUser);
								users.add(anyUserC);
								msj = "Se elimino el podcast";
						}else{
							msj = "Esta playlist no tiene este audio";
						}
					}
				}else{
					msj = "No se encontro el audio";
				}
				if(newAudio!=null && newAudio instanceof Song){
					if(searchSongFromUser((Song)newAudio, anyUserC)){
						if(action == 1){
							if(anyPlaylist.getAudios().contains(newAudio)){
								msj = "Esta playlist no tiene ese audio";
							}else{
								anyPlaylist.getAudios().add(newAudio);
								anyUserC.getPlaylists().remove(anyPlaylist);
								anyUserC.addPlaylist(anyPlaylist);
								users.remove(anyUser);
								users.add(anyUserC);
							}
							
						}
						if(action == 2){
							if(anyPlaylist.getAudios().contains(newAudio)){
								anyPlaylist.getAudios().remove(newAudio);
								anyUserC.getPlaylists().remove(anyPlaylist);
								anyUserC.addPlaylist(anyPlaylist);
								users.remove(anyUser);
								users.add(anyUserC);
								msj = "Se elimino la cancion";
							}
						}	
					}else{
					  msj= "No has comprado esta cancion";	
					}
				}else{
				
				}
			}else{
				msj = "No se encontro la playlist";
			}

		}else{
			msj = "No se encontro al usuario";
		}
		
		return msj;
	}

	/**
	 * 
	 * @param listId
	 * @param consumerId
	 */
	public String showPlaylistSharecode(int listId, int consumerId) {
		// TODO - implement PlatformController.showPlaylistSharecode
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param audioName
	 * @param userId
	 */
	public boolean searchSongFromUser(Song anySong, ConsumerUser anyUser) {
		Boolean isFound = false;
		if(anyUser instanceof Premium){
			for (int i = 0; i < ((Premium)(anyUser)).getPurchases().size() && !isFound; i++) {
				if(((Premium)(anyUser)).getPurchases().get(i).getSong().equals(anySong)){
					isFound = true;
				}
			}
			
		}
		if(anyUser instanceof Standard){
			for (int i = 0; i < ((Standard)(anyUser)).getPurchases().size() && !isFound; i++) {
				if(((Standard)(anyUser)).getPurchases().get(i).getSong().equals(anySong)){
					isFound = true;
				}
			}
		}
		return isFound;
	}

	/**
	 * 
	 * @param Audio
	 */
	public String playAudio(int Audio) {
		// TODO - implement PlatformController.playAudio
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param songName
	 * @param userId
	 */
	public String buySong(int songName, int userId) {
		// TODO - implement PlatformController.buySong
		throw new UnsupportedOperationException();
	}

	public String generateAudioReport() {
		// TODO - implement PlatformController.generateAudioReport
		throw new UnsupportedOperationException();
	}

	public String getMaxGenre() {
		// TODO - implement PlatformController.getMaxGenre
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param userId
	 */
	public String getMaxGenre(int userId) {
		// TODO - implement PlatformController.getMaxGenre
		throw new UnsupportedOperationException();
	}

	public String getMaxCategory() {
		// TODO - implement PlatformController.getMaxCategory
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param userId
	 */
	public String getMaxCategort(int userId) {
		// TODO - implement PlatformController.getMaxCategort
		throw new UnsupportedOperationException();
	}

	public String getTop5ArtistnCreator() {
		// TODO - implement PlatformController.getTop5ArtistnCreator
		throw new UnsupportedOperationException();
	}

	public String getTop10SongnPodcast() {
		// TODO - implement PlatformController.getTop10SongnPodcast
		throw new UnsupportedOperationException();
	}

	public String getGenreSales() {
		// TODO - implement PlatformController.getGenreSales
		throw new UnsupportedOperationException();
	}

	public String getBestSeller() {
		// TODO - implement PlatformController.getBestSeller
		throw new UnsupportedOperationException();
	}
	public String giveUserId(User user){
		String id = null;
		if(user != null){
			if(user instanceof Artist || user instanceof ContentCreator){
				id = ((ProducerUser)(user)).getName();
			}
			if(user instanceof Premium || user instanceof Standard){
				id = ((ConsumerUser)(user)).getId();
			}
		}

		return id;
	}
	public ConsumerUser parseUser(User anyUser){
		ConsumerUser anyUserC = null;
		if(anyUser instanceof Premium || anyUser instanceof Standard){
			anyUserC = (ConsumerUser)anyUser;
		}
		return anyUserC;
	}
	
	public Genre giveSongGenre(int option){
		Genre givenGenre = null;
		switch(option){
			case 1:
				givenGenre = Genre.ROCK;
			break;
			case 2:
				givenGenre = Genre.POP;
			break;
			case 3:
				givenGenre = Genre.TRAP;
			break;
			case 4:
				givenGenre = Genre.HOUSE;
			break;
			default:

			break;
			
		}
		return givenGenre;
	}

	public Category givePodcastCategory(int option){
		Category givenCategory = null;
		switch(option){
			case 1:
				givenCategory = Category.POLITICS;
			break;
			case 2:
				givenCategory = Category.ENTERTAINMENT;
			break;
			case 3:
				givenCategory = Category.VIDEOGAMES;
			break;
			case 4:
				givenCategory = Category.TREND;
			break;
			default:

			break;
			
		}
		return givenCategory;
	
	}

}