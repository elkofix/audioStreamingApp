package models;
/** Represents an Audio from the platform.
 * @author Alejandro Cordoba
 * @version 1.0
 * @since 1.0
*/
public class Audio implements Comparable<Audio>{

	private String name;
	private String author;
	private String imgURL;
	private int duration;
	private int timesPlayed;

	/**
	 * Constructor of Audio Class
	 * @param name name of the audio
	 * @param imgURL URL that represents the audio
	 * @param duration duration in seconds of the audio
	 * @param author Author of the audio
	 */
	public Audio(String name, String imgURL, int duration, String author) {
		this.author = author;
		this.name = name;
		this.imgURL = imgURL;
		this.duration = duration;
	}
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Audio b){
		return this.timesPlayed- b.getTimesPlayed();
	}
	/**Gets the name of the audio
	 * @return name of the audio
	 */
	public String getName() {
		return this.name;
	}
	
	/**Gets the author name of the audio
	 * @return Author name of the audio
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * Sets the name of the audio to a new one
	 * @param name new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**Gets the img URL that represents the Audio
	 * @return img URL that represents the Audio
	 */
	public String getImgURL() {
		return this.imgURL;
	}

	/**
	 * Sets the img URL that represents the Audio to a new pone
	 * @param imgURL New URL
	 */
	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}

	/**Gets the duration of the Audio
	 * @return duration fo the audio
	 */
	public int getDuration() {
		return this.duration;
	}

	/**
	 * Sets the duration of the Audio to a new one
	 * @param duration new duration
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}

	/**Gets the times one audio was played
	 * @return time this audio was played
	 */
	public int getTimesPlayed() {
		return this.timesPlayed;
	}

	/**
	 * Sets the times the audio was played to a new one
	 * @param timesPlayed new times audio was played
	 */
	public void setTimesPlayed(int timesPlayed) {
		this.timesPlayed = timesPlayed;
	}


}