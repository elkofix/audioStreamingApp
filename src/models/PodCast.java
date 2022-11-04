package models;
public class PodCast extends Audio {

	private String description;
	private Category category;

	/**
	 * 
	 * @param name
	 * @param imgURL
	 * @param duration
	 * @param description
	 */
	public PodCast(String name, String imgURL, int duration, String description, Category category) {
		super(name, imgURL, duration);
		this.description = description;
		this.category = category;
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