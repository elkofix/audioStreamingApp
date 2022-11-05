package models;

import java.util.ArrayList;

public class Playlist {

	private String name;
	private String id;
	private ArrayList<Audio> audios;

	public ArrayList<Audio> getAudios() {
		return audios;
	}

	public void setAudios(ArrayList<Audio> audios) {
		this.audios = audios;
	}

	/**
	 * 
	 * @param name
	 */
	public Playlist(String name) {
		this.name = name;
		audios = new ArrayList<Audio>();
		//id = generateCode();
	}

	public String generateCode() {
		// TODO - implement Playlist.generateCode
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param newAudio
	 */
	public boolean addAudio(Audio newAudio) {
		return audios.add(newAudio);
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
	public Audio searchAudio(String name) {
		Audio anyAudio = null;
		boolean isFound = false;
		for (int i = 0; i < audios.size() && !isFound; i++) {
			if(audios.get(i).getName().equals(name)){
				anyAudio = audios.get(i);
				isFound = true;
			}
		}
		return anyAudio;
	}

}