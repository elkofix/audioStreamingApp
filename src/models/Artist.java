package models;

import java.util.ArrayList;

public class Artist extends ProducerUser {
	ArrayList<Song> songs;
	public ArrayList<Song> getSongs() {
		return songs;
	}

	/**
	 * 
	 * @param name
	 * @param imgURL
	 */
	public Artist(String name, String imgURL) {
		super(name, imgURL);
		songs = new ArrayList<Song>();
	}
	
	public boolean addSong(Song newSong){
		return songs.add(newSong);
	}

}