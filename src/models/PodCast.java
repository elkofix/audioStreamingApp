package models;
/** Represents a Podcast.
 * @author Alejandro Cordoba
 * @version 1.1
 * @since 1.0
*/
public class PodCast extends Audio {

	private String description;
	private Category category;

	/**
	 * Constructor of the Podcast class
	 * @param name name of the podcast
	 * @param imgURL URL of the image tha represents the podcast
	 * @param duration duration of the podcast in seconds
	 * @param description description of the podcast
	 * @param category category of the podcast
	 * @param author name of the author
	 */
	public PodCast(String name, String imgURL, int duration, String description, Category category, String author) {
		super(name, imgURL, duration, author);
		this.description = description;
		this.category = category;
	}

	/**Gets the description of the podcast
	 * @return description of the podcast
	 */
	public String getDescription() {
		return this.description;
	}

	
	/**Gets the category of the podcast
	 * @return category of the podcast
	 */
	public Category getCategory() {
		return category;
	}


	/**
	 * Sets the description of the podcast to a new one 
	 * @param description new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}