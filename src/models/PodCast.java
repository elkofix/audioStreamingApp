package models;
public class PodCast extends Audio {

	private String description;

	/**
	 * 
	 * @param name
	 * @param imgURL
	 * @param duration
	 * @param description
	 */
	public PodCast(String name, String imgURL, int duration, String description) {
		super(name, imgURL, duration);
		this.description = description;
	}

	public String getDescription() {
		return this.description;
	}

	/**
	 * 
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}