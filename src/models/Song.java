package models;
/** Represents a song.
 * @author Alejandro Cordoba
 * @version 1.0
 * @since 1.0
*/
public class Song extends Audio{

	private String album;
	private double price;
	private int timesSold;
	private Genre genre;
	private double totalSales;

	/**
	 * Constructor of the Song Class
	 * @param name name of the song
	 * @param imgURL URL that represents the song
	 * @param duration duration in seconds of the song
	 * @param album album that the song belongs to
	 * @param price price of the song
	 * @param genre genre of the song
	 * @param author author of the song
	 */
	public Song(String name, String imgURL, int duration, String album, Double price, Genre genre, String author) {
		super(name, imgURL, duration, author);
		this.album = album;
		this.price = price;
		this.genre = genre;
		this.totalSales = 0;
	}

	
	/**Gets the total sales of the song
	 * @return total sales of the song
	 */
	public double getTotalSales() {
		return totalSales;
	}

	/**Gets the genre of the song
	 * @return genre of the song
	 */
	public Genre getGenre() {
		return genre;
	}

	/**Sets the genre of the song to a new one
	 * @param genre new genre
	 */
	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	/**Gets the album the song belongs to 
	 * @return album 
	 */
	public String getAlbum() {
		return this.album;
	}

	/**
	 * Updates total sales after a new sale
	 */
	public void updateSales(){
		this.totalSales = price*timesSold;
	}

	/**
	 * Sets the album the song belongs to, to a new one
	 * @param album new album
	 */
	public void setAlbum(String album) {
		this.album = album;
	}

	/**Gets the price of the song
	 * @return price of the song
	 */
	public double getPrice() {
		return this.price;
	}

	/**
	 * Sets the price of the song to a new one
	 * @param price new price
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**Gets the times the song was sold
	 * @return time the song was sold
	 */
	public int getTimesSold() {
		return this.timesSold;
	}

	/**
	 * Sets the times the song was sold to a new one
	 * @param timesSold new times
	 */
	public void setTimesSold(int timesSold) {
		this.timesSold = timesSold;
	}

}