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
	public PodCast(int name, int imgURL, int duration, int description) {
		super(name, imgURL, duration);
		// TODO - implement PodCast.PodCast
		throw new UnsupportedOperationException();
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