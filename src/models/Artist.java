package models;

import java.util.ArrayList;

public class Artist extends ProducerUser {
	ArrayList<Song> songs;
	/**
	 * 
	 * @param name
	 * @param imgURL
	 */
	public Artist(String name, String imgURL) {
		super(name, imgURL);
		songs = new ArrayList<Song>();
	}

}