package models;

public class Audio implements Comparable<Audio>{

	private String name;
	private String author;
	public String getAuthor() {
		return author;
	}

	private String imgURL;
	private int duration;
	private int timesPlayed;

	/**
	 * 
	 * @param name
	 * @param imgURL
	 * @param duration
	 */
	public Audio(String name, String imgURL, int duration, String author) {
		this.author = author;
		this.name = name;
		this.imgURL = imgURL;
		this.duration = duration;
	}
	public int compareTo(Audio b){
		return this.timesPlayed- b.getTimesPlayed();
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


}