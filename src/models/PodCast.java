package models;
public class PodCast extends Audio {

	private String description;
	private Category category;

	public Category getCategory() {
		return category;
	}

	/**
	 * 
	 * @param name
	 * @param imgURL
	 * @param duration
	 * @param description
	 */
	public PodCast(String name, String imgURL, int duration, String description, Category category, String author) {
		super(name, imgURL, duration, author);
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