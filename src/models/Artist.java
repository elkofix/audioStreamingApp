package models;

import java.util.ArrayList;
/** Represents an artist user.
 * @author Alejandro Cordoba
 * @version 1.1
 * @since 1.0
*/
public class Artist extends ProducerUser {
	ArrayList<Song> songs;

	/**
	 * Conostructor of Artist class
	 * @param name name of the artist
	 * @param imgURL url tha represent the artist
	 */
	public Artist(String name, String imgURL) {
		super(name, imgURL);
		songs = new ArrayList<Song>();
	}

	/**Gets the list of songs from the Artist
	 * @return list of songs of the Artist
	 */
	public ArrayList<Song> getSongs() {
		return songs;
	}

	
	/**Adds a song to the list
	 * @param newSong song to be added
	 * @return true if added, else false
	 */
	public boolean addSong(Song newSong){
		return songs.add(newSong);
	}

}