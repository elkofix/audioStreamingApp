package models;
/** Represents a Producer user type.
 * @author Alejandro Cordoba
 * @version 1.0
 * @since 1.0
*/
public class ProducerUser extends User implements Comparable<ProducerUser>{

	private String name;
	private String imgURL;
	private int plays;
	private int playTime;

	/**
	 * Constructor of ProducerUser Class
	 * @param name name of the producer
	 * @param imgURL URL of the image that represents the user
	 */
	public ProducerUser(String name, String imgURL) {
		super();
		this.name = name;
		this.imgURL = imgURL;
		plays = 0;
		playTime = 0;
	}
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(ProducerUser b){
		return this.plays - b.getPlays();
	}

	/**Gets the name of the User
	 * @return name of the user
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Sets the name of the user to a new one
	 * @param name new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**Gets the Url of the image that represents the user
	 * @return URL of the image
	 */
	public String getImgURL() {
		return this.imgURL;
	}

	/**
	 * Sets the URL of the image that represents the user to a new one
	 * @param imgURL new URL
	 */
	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}

	/**Gets the accumulated plays this Producers has
	 * @return accumulated plays
	 */
	public int getPlays() {
		return this.plays;
	}

	/**
	 * Sets the accumulated play to a new number
	 * @param plays new plays
	 */
	public void setPlays(int plays) {
		this.plays = plays;
	}

	/**Gets the accumulated played time this producer has
	 * @return played time
	 */
	public int getPlayTime() {
		return this.playTime;
	}

	/**
	 * Sets the accumulated played time to a new one
	 * @param playTime new played time
	 */
	public void setPlayTime(int playTime) {
		this.playTime = playTime;
	}

}