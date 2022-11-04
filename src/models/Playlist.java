package models;

import java.util.ArrayList;

public class Playlist {

	private String name;
	private String id;
	private ArrayList<Audio> audios;

	/**
	 * 
	 * @param name
	 */
	public Playlist(String name) {
		this.name = name;
		audios = new ArrayList<Audio>();
		id = generateCode();
	}

	public String generateCode() {
		// TODO - implement Playlist.generateCode
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param Audio
	 */
	public boolean addAudio(int Audio) {
		// TODO - implement Playlist.addAudio
		throw new UnsupportedOperationException();
	}

	public String getName() {
		return this.name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return this.id;
	}

	/**
	 * 
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 
	 * @param name
	 */
	public boolean searchAudio(int name) {
		// TODO - implement Playlist.searchAudio
		throw new UnsupportedOperationException();
	}

}