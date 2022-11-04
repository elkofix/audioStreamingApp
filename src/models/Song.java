package models;
public class Song extends Audio {

	private String album;
	private double price;
	private int timesSold;

	/**
	 * 
	 * @param name
	 * @param imgURL
	 * @param duration
	 * @param album
	 * @param price
	 */
	public Song(String name, String imgURL, int duration, String album, Double price) {
		super(name, imgURL, duration);
		this.album = album;
		this.price = price;
	}

	public String getAlbum() {
		return this.album;
	}

	/**
	 * 
	 * @param album
	 */
	public void setAlbum(String album) {
		this.album = album;
	}

	public double getPrice() {
		return this.price;
	}

	/**
	 * 
	 * @param price
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	public int getTimesSold() {
		return this.timesSold;
	}

	/**
	 * 
	 * @param timesSold
	 */
	public void setTimesSold(int timesSold) {
		this.timesSold = timesSold;
	}

	public Genre getGenre() {
		// TODO - implement Song.getGenre
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param Genre
	 */
	public void setGenre(int Genre) {
		// TODO - implement Song.setGenre
		throw new UnsupportedOperationException();
	}

}