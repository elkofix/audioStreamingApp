package models;
import java.util.Date;


public abstract class User {

	private Date linkDate;

	public User() {
		this.linkDate = new Date();
	}

	public String getId() {
		// TODO - implement User.getId
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param id
	 */
	public void setId(String id) {
		// TODO - implement User.setId
		throw new UnsupportedOperationException();
	}

	public Date getLinkDate() {
		return this.linkDate;
	}

	/**
	 * 
	 * @param linkDate
	 */
	public void setLinkDate(Date linkDate) {
		this.linkDate = linkDate;
	}

	

}