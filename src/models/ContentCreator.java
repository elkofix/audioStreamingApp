package models;

import java.util.ArrayList;

public class ContentCreator extends ProducerUser {
	private ArrayList<PodCast> podcasts;
	/**
	 * 
	 * @param name
	 * @param imgURL
	 */
	public ContentCreator(String name, String imgURL) {
		super(name, imgURL);
		podcasts = new ArrayList<PodCast>();
	}

	public boolean addPodcast(PodCast newPodCast){
		return podcasts.add(newPodCast);
	}

}