package models;

import java.util.ArrayList;

public class Standard extends ConsumerUser {

	public static final int MAX_SONGS = 100;
	private ArrayList<Purchase> purchases;
	/**
	 * 
	 * @param id
	 * @param nickname
	 */
	public Standard(String id, String nickname) {
		super(id, nickname);
		purchases = new ArrayList<Purchase>(MAX_SONGS);
	}

	public String calculateMostCreator() {
		// TODO - implement Standard.calculateMostCreator
		throw new UnsupportedOperationException();
	}

	public String calculateMostArtist() {
		// TODO - implement Standard.calculateMostArtist
		throw new UnsupportedOperationException();
	}

	public String calculateMostGenre() {
		// TODO - implement Standard.calculateMostGenre
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param songName
	 */
	public Song searchSong(int songName) {
		// TODO - implement Purchase.searchSong
		throw new UnsupportedOperationException();
	}
	/**
	 * 
	 * @param Song
	 */
	public boolean addSong(int Song) {
		// TODO - implement Standard.addSong
		throw new UnsupportedOperationException();
	}

}