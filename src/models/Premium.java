package models;
/** Represents a Premiun User type.
 * @author Alejandro Cordoba
 * @version 1.0
 * @since 1.0
*/
public class Premium extends ConsumerUser {
	
	/**
	 * Constructor of Premium class
	 * @param id user id
	 * @param nickname nickname of the user
	 */
	public Premium(String id, String nickname) {
		super(id, nickname);
	}

	/**Adds a song to the purchase list
	 *@param song song to be added
	 *@return true if added, else false
	 */
	public boolean addSong(Song song) {
		return getPurchases().add(new Purchase(song));
	}

}