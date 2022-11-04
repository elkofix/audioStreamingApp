package models;
public class PlatformController {

	private String name;
	private String nit;

	/**
	 * 
	 * @param name
	 * @param nit
	 */
	public PlatformController(String name, String nit) {
		this.name = name;
		this.nit = nit;
	}

	/**
	 * 
	 * @param User
	 */
	public String addUser(int User) {
		// TODO - implement PlatformController.addUser
		throw new UnsupportedOperationException();
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
	public ProducerUser searchProducer(int name) {
		// TODO - implement PlatformController.searchProducer
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param id
	 */
	public ConsumerUser searchConsumer(int id) {
		// TODO - implement PlatformController.searchConsumer
		throw new UnsupportedOperationException();
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