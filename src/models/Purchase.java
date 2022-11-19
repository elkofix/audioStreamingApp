package models;

import java.util.Date;
/** Represents a Purchase.
 * @author Alejandro Cordoba
 * @version 1.0
 * @since 1.0
*/
public class Purchase {

	private Date purchaseDate;
	private Song song;

	
	/**Constructor of the Purchase Class
	 * @param newSong obj song bought
	 */
	public Purchase(Song newSong) {
		purchaseDate = new Date();
		this.song = newSong;
	}

	/**Gets the bought song
	 * @return Obj song
	 */
	public Song getSong() {
		return song;
	}


	/**Gets the date when the song was bought
	 * @return purchase date
	 */
	public Date getPurchaseDate() {
		return purchaseDate;
	}


	

}