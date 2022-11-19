package models;
import java.util.Date;
/** Represents a User.
 * @author Alejandro Cordoba
 * @version 1.0
 * @since 1.0
*/

public abstract class User {

	private Date linkDate;

	/**
	 * Constructor of the User Class
	 */
	public User() {
		this.linkDate = new Date();
	}

		
	/**Gets the link date of the user
	 * @return link date
	 */
	public Date getLinkDate() {
		return this.linkDate;
	}

	/**
	 * Sets the link date of the user to a new one
	 * @param linkDate new link date
	 */
	public void setLinkDate(Date linkDate) {
		this.linkDate = linkDate;
	}

	

}