package models;

import java.util.ArrayList;

public class Standard extends ConsumerUser {

	public static final int MAX_SONGS = 100;


	/**
	 * 
	 * @param id
	 * @param nickname
	 */
	public Standard(String id, String nickname) {
		super(id, nickname);
		setPurchases(new ArrayList<Purchase>(MAX_SONGS)); 
	}

	public String calculateMostCreator() {
		// TODO - implement Standard.calculateMostCreator
		throw new UnsupportedOperationException();
	}

	public String calculateMostArtist() {
		// TODO - implement Standard.calculateMostArtist
		throw new UnsupportedOperationException();
	}


	/**
	 * 
	 * @param Song
	 */
	public boolean addSong(Song Song) {
		boolean isAdded = false;
		if(getPurchases().size()<100){
			isAdded = getPurchases().add(new Purchase(Song));
		}
		return isAdded;
	}

}