package models;
import java.util.Date;
public abstract class ConsumerUser extends User {

	private String id;
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

	public Playlist getPlaylist() {
		// TODO - implement ConsumerUser.getPlaylist
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param Playlist
	 */
	public boolean addPlaylist(int Playlist) {
		// TODO - implement ConsumerUser.addPlaylist
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param Playlist
	 */
	public void setPlaylist(int Playlist) {
		// TODO - implement ConsumerUser.setPlaylist
		throw new UnsupportedOperationException();
	}

}