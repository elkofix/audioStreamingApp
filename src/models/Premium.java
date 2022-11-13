package models;

import java.util.ArrayList;

public class Premium extends ConsumerUser {
	
	/**
	 * 
	 * @param id
	 * @param nickname
	 */


	public Premium(String id, String nickname) {
		super(id, nickname);
	}

	public String calculateMostCreator() {
		// TODO - implement Premium.calculateMostCreator
		throw new UnsupportedOperationException();
	}

	public String calculateMostArtist() {
		// TODO - implement Premium.calculateMostArtist
		throw new UnsupportedOperationException();
	}

	public boolean addSong(Song Song) {
		return getPurchases().add(new Purchase(Song));
	}

}