package models;
import java.util.ArrayList;
import java.util.Collections;
/** Represents a Consumer User tyoe.
 * @author Alejandro Cordoba
 * @version 1.0
 * @since 1.0
*/
public abstract class ConsumerUser extends User {

	private String id;
	private ArrayList<Playlist> playlists;
	private ArrayList<Purchase> purchases;
	private ArrayList<GenrePlays> genrePlays;
	private ArrayList<CategoryPlays> categoryPlays;
	private String nickname;
	private int playedTime;

	/**
	 * Constructor of the ConsumerUser class
	 * @param id id of the user
	 * @param nickname nickname of the user
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

	/**Adds a song to the list of purchases
	 * @param Song song to be added 
	 * @return true if added, else false
	 */
	public abstract boolean addSong(Song Song);

	/**
	 * Search a song in the purchase list
	 * @param songName name of the song
	 * @return Obj song found, else null
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

	/**Deploys the String representation of purchase song
	 * @return purchase resume
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
	
	/**Updates the times a song genre after is played
	 * @param genre genre to update
	 * @return true if updated, else false
	 */
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
	/**Updates the times a podcast category after is played
	 * @param category category to update
	 * @return true if updated, else false
	 */
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

	/**Calculates the most reproduced genre
	 * @return Message with the most reproduced genre
	 */
	public String calculateMostGenre(){
		Collections.sort(genrePlays, Collections.reverseOrder());
		return "El genero mas escuchado es: "+genrePlays.get(0).getGenre()+" Reproducciones: "+genrePlays.get(0).getTimesPlayed();
	}
	/**Calculate the most reproduced category
	 * @return Message with the most reproduced category
	 */
	public String calculateMostCategory(){
		Collections.sort(categoryPlays, Collections.reverseOrder());
		return "La categoria mas escuchada es: "+categoryPlays.get(0).getCategory()+" Reproducciones: "+categoryPlays.get(0).getTimesPlayed();
	}
	

	/**
	 * adds a playlist to the list
	 * @param playlist new playlist
	 * @return true if added, else false
	 */
	public boolean addPlaylist(Playlist playlist) {
		return playlists.add(playlist);
	}

	
	/**Gets the list of purchases
	 * @return list of purchases
	 */
	public ArrayList<Purchase> getPurchases() {
		return purchases;
	}

	/**Sets the list of purchases to a new one
	 * @param purchases new list of purchases
	 */
	public void setPurchases(ArrayList<Purchase> purchases) {
		this.purchases = purchases;
	}


	/**Gets the accumulated time a user has played audios
	 * @return accumulated time
	 */
	public int getPlayedTime() {
		return this.playedTime;
	}

	/**
	 * Sets the accumlated time played to a new one
	 * @param playedTime new time played
	 */
	public void setPlayedTime(int playedTime) {
		this.playedTime = playedTime;
	}

	/**Gets the id of the user 
	 * @return id of the user
	 */
	public String getId() {
		return id;
	}

	/**Sets the id of the user to a new one
	 * @param id new id
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**Gets the list of playlists
	 * @return list of playlists
	 */
	public ArrayList<Playlist> getPlaylists() {
		return playlists;
	}

	/**Sets the lsit of playlists to a new one
	 * @param playlists new list of playlist
	 */
	public void setPlaylists(ArrayList<Playlist> playlists) {
		this.playlists = playlists;
	}



	/**Gets the nickname of the user
	 * @return nickname of the user
	 */
	public String getNickname() {
		return this.nickname;
	}

	/**
	 * Sets the nickname of the user to a new one
	 * @param nickname new nickname
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

}