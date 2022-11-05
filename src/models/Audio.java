package models;

import java.security.PublicKey;

public class Audio {

	private String name;
	private String imgURL;
	private int duration;
	private int timesPlayed;

	/**
	 * 
	 * @param name
	 * @param imgURL
	 * @param duration
	 */
	public Audio(String name, String imgURL, int duration) {
		this.name = name;
		this.imgURL = imgURL;
		this.duration = duration;
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

	public String getImgURL() {
		return this.imgURL;
	}

	/**
	 * 
	 * @param imgURL
	 */
	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}

	public int getDuration() {
		return this.duration;
	}

	/**
	 * 
	 * @param duration
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getTimesPlayed() {
		return this.timesPlayed;
	}

	/**
	 * 
	 * @param timesPlayed
	 */
	public void setTimesPlayed(int timesPlayed) {
		this.timesPlayed = timesPlayed;
	}

	public void play() {
		// TODO - implement Audio.play
		throw new UnsupportedOperationException();
	}

	public void stop() {
		// TODO - implement Audio.stop
		throw new UnsupportedOperationException();
	}

}