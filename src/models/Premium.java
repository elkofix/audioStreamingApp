package models;

import java.util.ArrayList;

public class Premium extends ConsumerUser {
	
	/**
	 * 
	 * @param id
	 * @param nickname
	 */

	 private ArrayList<Purchase> purchases;
	public ArrayList<Purchase> getPurchases() {
		return purchases;
	}

	public void setPurchases(ArrayList<Purchase> purchases) {
		this.purchases = purchases;
	}

	public Premium(String id, String nickname) {
		super(id, nickname);
		purchases = new ArrayList<Purchase>();
	}

	public String calculateMostCreator() {
		// TODO - implement Premium.calculateMostCreator
		throw new UnsupportedOperationException();
	}

	public String calculateMostArtist() {
		// TODO - implement Premium.calculateMostArtist
		throw new UnsupportedOperationException();
	}

	public String calculateMostGenre() {
		// TODO - implement Premium.calculateMostGenre
		throw new UnsupportedOperationException();
	}
	/**
	 * 
	 * @param songName
	 */
	public Song searchSong(int songName) {
		// TODO - implement Purchase.searchSong
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param Song
	 */
	public boolean addSong(int Song) {
		// TODO - implement Premium.addSong
		throw new UnsupportedOperationException();
	}

	public String deployPurchases(){
		String msj = "Tus canciones: \n";
		int counter = 0;
		for (int i = 0; i < purchases.size() ; i++) {
			msj += "-"+purchases.get(i).getSong().getName()+"\n";
			counter++;
		}
		if(counter == 0){
			msj = "No has comprado canciones aun \n";
		}
		return msj;
	}

}