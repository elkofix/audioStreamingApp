package models;
import java.util.ArrayList;
/** Represents a Content Creator.
 * @author Alejandro Cordoba
 * @version 1.0
 * @since 1.0
*/
public class ContentCreator extends ProducerUser {
	private ArrayList<PodCast> podcasts;


	/**
	 * Constructor of ContentCreator Class
	 * @param name name of the contect creator
	 * @param imgURL URL of the image that represents the creator
	 */
	public ContentCreator(String name, String imgURL) {
		super(name, imgURL);
		podcasts = new ArrayList<PodCast>();
	}

	/**Adds a podcast to podcasts list
	 * @param newPodCast podacast to be added
	 * @return true if added, else false
	 */
	public boolean addPodcast(PodCast newPodCast){
		return podcasts.add(newPodCast);
	}

	/**Gets the list of podcasts 
	 * @return list of podcasts
	 */
	public ArrayList<PodCast> getPodcasts() {
		return podcasts;
	}

	/**Sets the list of podcasts to a new one
	 * @param podcasts new list
	 */
	public void setPodcasts(ArrayList<PodCast> podcasts) {
		this.podcasts = podcasts;
	}

}