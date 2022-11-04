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
	public String addUser(User User) {
		String msj = "No se agrego el usuario";
		if(users.add(User)){
			msj = "Sea agrego el usuario";
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

	/**
	 * 
	 * @param Audio
	 */
	public String addAudio(int Audio) {
		// TODO - implement PlatformController.addAudio
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param name
	 */
	public User searchUser(String id){
		User anyUser = null;
			for (int i = 0; i < users.size(); i++) {
				if(users.get(i) instanceof ProducerUser){

				}
				if(users.get(i) instanceof ConsumerUser){
					
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

}