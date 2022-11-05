package models;
import java.util.ArrayList;
import java.util.Date;

public abstract class ConsumerUser extends User {

	private String id;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	private ArrayList<Playlist> playlists;
	public ArrayList<Playlist> getPlaylists() {
		return playlists;
	}

	public void setPlaylists(ArrayList<Playlist> playlists) {
		this.playlists = playlists;
	}
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
	}

	public Date datePurchase() {
		// TODO - implement ConsumerUser.datePurchase
		throw new UnsupportedOperationException();
	}

	public String consumerResume() {
		// TODO - implement ConsumerUser.consumerResume
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param Song
	 */
	public abstract boolean addSong(int Song);

	public abstract String calculateMostGenre();

	public abstract String calculateMostArtist();

	public abstract String calculateMostCreator();

	public abstract String deployPurchases();

	public int getPlayedTime() {
		return this.playedTime;
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