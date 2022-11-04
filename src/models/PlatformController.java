package models;

import java.util.ArrayList;

public class PlatformController {

	private String name;
	private String nit;
	private ArrayList<User> users;

	/**
	 * 
	 * @param name
	 * @param nit
	 */
	public PlatformController(String name, String nit) {
		this.name = name;
		this.nit = nit;
		users = new ArrayList<User>();
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
				msj = "Se agrego la cancion";
			}else if(anyUser instanceof ContentCreator && audio instanceof PodCast){
				((ContentCreator)(anyUser)).addPodcast(((PodCast)(audio)));
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
		String userName;
		String userId;
			for (int i = 0; i < users.size(); i++) {
				if(users.get(i) instanceof Artist || users.get(i) instanceof ContentCreator){
				userName = ((ProducerUser)(users.get(i))).getName();
					if(id.equals(userName)){
						anyUser = users.get(i);
					}

				}
				if(users.get(i) instanceof Premium || users.get(i) instanceof Standard){
						userId = ((ConsumerUser)(users.get(i))).getId();
						if(id.equals(userId)){
							anyUser = users.get(i);
						}
				}
			}
			
		return anyUser;
	}

	/**
	 * 
	 * @param listId
	 * @param consumerId
	 */
	public Playlist searchPlaylistFromConsumer(int listId, int consumerId) {
		// TODO - implement PlatformController.searchPlaylistFromConsumer
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param Playlist
	 * @param audioName
	 * @param action
	 */
	public boolean editPlaylist(int Playlist, int audioName, int action) {
		// TODO - implement PlatformController.editPlaylist
		throw new UnsupportedOperationException();
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
	public Audio searchAudioFromUser(int audioName, int userId) {
		// TODO - implement PlatformController.searchAudioFromUser
		throw new UnsupportedOperationException();
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