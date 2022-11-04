package models;

import java.util.Date;
public class Purchase {

	private Date purchaseDate;
	private Song song;

	public Purchase(Song newSong) {
		purchaseDate = new Date();
		this.song = newSong;
	}

	

}