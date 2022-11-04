package models;
public class Song extends Audio {

	private String album;
	private double price;
	private int timesSold;
	private Genre genre;

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	/**
	 * 
	 * @param name
	 * @param imgURL
	 * @param duration
	 * @param album
	 * @param price
	 */
	public Song(String name, String imgURL, int duration, String album, Double price, Genre genre) {
		super(name, imgURL, duration);
		this.album = album;
		this.price = price;
		this.genre = genre;
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



}