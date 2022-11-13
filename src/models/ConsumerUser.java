package models;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public abstract class ConsumerUser extends User {

	private String id;
	private ArrayList<Playlist> playlists;
	private ArrayList<Purchase> purchases;
	private ArrayList<GenrePlays> genrePlays;
	private ArrayList<CategoryPlays> categoryPlays;
	private String nickname;
	private int playedTime;

	/**
	 * 
	 * @param id
	 * @param nickname
	 */
	public ConsumerUser(String id, String nickname) {
		super();
		this.id = id;
		this.nickname = nickname;
		playedTime = 0;
		playlists = new ArrayList<Playlist>();
		purchases = new ArrayList<Purchase>();
		genrePlays = new ArrayList<GenrePlays>();
		genrePlays.add(new GenrePlays(Genre.ROCK));
		genrePlays.add(new GenrePlays(Genre.TRAP));
		genrePlays.add(new GenrePlays(Genre.POP));
		genrePlays.add(new GenrePlays(Genre.HOUSE));
		categoryPlays = new ArrayList<CategoryPlays>();
		categoryPlays.add(new CategoryPlays(Category.ENTERTAINMENT));
		categoryPlays.add(new CategoryPlays(Category.POLITICS));
		categoryPlays.add(new CategoryPlays(Category.TREND));
		categoryPlays.add(new CategoryPlays(Category.VIDEOGAMES));

	}

	public ArrayList<Purchase> getPurchases() {
		return purchases;
	}

	public void setPurchases(ArrayList<Purchase> purchases) {
		this.purchases = purchases;
	}

		/**
	 * 
	 * @param songName
	 */
	public Song searchSong(String songName) {
		Song anySong = null;
		for (int i = 0; i < purchases.size(); i++) {
			if(purchases.get(i).getSong().getName().equals(songName)){
				anySong = purchases.get(i).getSong();
			}
		}
		return anySong;
	}

	/**
	 * 
	 * @param Song
	 */


	public String deployPurchases(){
		String msj = "Tus canciones: \n";
		int counter = 0;
		for (int i = 0; i < purchases.size() ; i++) {
			msj += "-"+purchases.get(i).getSong().getName()+"\n";
			counter++;
		}
		if(counter == 0){
			msj = "No has comprado canciones aun \n";
		}
		return msj;
	}


	public Date datePurchase() {
		// TODO - implement ConsumerUser.datePurchase
		throw new UnsupportedOperationException();
	}

	public String consumerResume() {
		return calculateMostGenre() +'\n' ;
	}
	public boolean updateGenrePlays(Genre genre){
		boolean isFound = false;
		for (int i = 0; i < genrePlays.size() && !isFound; i++) {
			if(genrePlays.get(i).getGenre() == genre){
				genrePlays.get(i).updatePlays();
				isFound = true;
			}
		}
		return isFound;
	}
	public boolean updateCategoryPlays(Category category){
		boolean isFound = false;
		for (int i = 0; i < categoryPlays.size() && !isFound; i++) {
			if(categoryPlays.get(i).getCategory() == category){
				categoryPlays.get(i).updatePlays();
				isFound = true;
			}
		}
		return isFound;
	}

	/**
	 * 
	 * @param Song
	 */
	public abstract boolean addSong(Song Song);

	public String calculateMostGenre(){
		Collections.sort(genrePlays, Collections.reverseOrder());
		return "El genero mas escuchado es: "+genrePlays.get(0).getGenre()+" Reproducciones: "+genrePlays.get(0).getTimesPlayed();
	}
	public String calculateMostCategory(){
		Collections.sort(categoryPlays, Collections.reverseOrder());
		return "La categoria mas escuchada es: "+categoryPlays.get(0).getCategory()+" Reproducciones: "+categoryPlays.get(0).getTimesPlayed();
	}

	public abstract String calculateMostArtist();

	public abstract String calculateMostCreator();


	public int getPlayedTime() {
		return this.playedTime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public ArrayList<Playlist> getPlaylists() {
		return playlists;
	}

	public void setPlaylists(ArrayList<Playlist> playlists) {
		this.playlists = playlists;
	}

	/**
	 * 
	 * @param playedTime
	 */
	public void setPlayedTime(int playedTime) {
		this.playedTime = playedTime;
	}

	public String getNickname() {
		return this.nickname;
	}

	/**
	 * 
	 * @param nickname
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


	/**
	 * 
	 * @param playlist
	 */
	public boolean addPlaylist(Playlist playlist) {
		return playlists.add(playlist);
	}

	/**
	 * 
	 * @param Playlist
	 */

}