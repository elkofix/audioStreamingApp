package models;
public class ProducerUser extends User {

	private String name;
	private String imgURL;
	private int plays;
	private int playTime;

	/**
	 * 
	 * @param name
	 * @param imgURL
	 */
	public ProducerUser(int name, int imgURL) {
		// TODO - implement ProducerUser.ProducerUser
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param Audio
	 */
	public boolean addAudio(int Audio) {
		// TODO - implement ProducerUser.addAudio
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

	public int getPlays() {
		return this.plays;
	}

	/**
	 * 
	 * @param plays
	 */
	public void setPlays(int plays) {
		this.plays = plays;
	}

	public int getPlayTime() {
		return this.playTime;
	}

	/**
	 * 
	 * @param playTime
	 */
	public void setPlayTime(int playTime) {
		this.playTime = playTime;
	}

}