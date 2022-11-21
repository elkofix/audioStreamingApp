package models;

import java.util.ArrayList;
/** Represents a Standard type user.
 * @author Alejandro Cordoba
 * @version 1.0
 * @since 1.0
*/
public class Standard extends ConsumerUser {

	/**
	 *Max number of songs a standard user can buy
	 */
	public static final int MAX_SONGS = 100;
	public static final int MAX_PLAYLSIT = 20;

	/**
	 * Constructor of the Standard Class
	 * @param id id of the user
	 * @param nickname nickname of the user
	 */
	public Standard(String id, String nickname) {
		super(id, nickname);
		setPurchases(new ArrayList<Purchase>(MAX_SONGS)); 
	}

	/**
	 * Adds a song to the purchase list - max songs is 100
	 * @param Song song to be added
	 * @return True if added, else false because max capacity is reached
	 */
	public boolean addSong(Song Song) {
		boolean isAdded = false;
		if(getPurchases().size()<100){
			isAdded = getPurchases().add(new Purchase(Song));
		}
		return isAdded;
	}
	@Override
	public boolean addPlaylist(Playlist playlist) {
		if(getPlaylists().size()<MAX_PLAYLSIT){
			ArrayList<Playlist> play = getPlaylists();
			play.add(playlist);
			setPlaylists(play);
			return true;
		}else{
			return false;
		}
		
	}

}