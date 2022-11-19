package models;
import java.util.ArrayList;
/** Represents a Playlist of Audios.
 * @author Alejandro Cordoba
 * @version 1.1
 * @since 1.0
*/
public class Playlist {

	private String name;
	private String id;
	private ArrayList<Audio> audios;
	private int[][] matrix;


	/**
	 * Constructor of the Playlist Class 
	 * @param name name of the Playlist
	 */
	public Playlist(String name) {
		this.name = name;
		audios = new ArrayList<Audio>();
		matrix = new int[6][6];
		generateCode();
	}
	/**Generates a message with the audios contained by this playlist
	 * @return message with playlist's audios or exception if no audios are found
	 */
	public String audiosResume(){
		String msj = "Audios en esta playlist: \n";
		int counter = 0;
		for (int i = 0; i < audios.size(); i++) {
			msj += "-"+audios.get(i).getName()+"\n";
			counter++;
		}
		if(counter == 0){
			msj = "No hay audios en esta playlist";
		}
		return msj;
	}
	/**
	 * Search an audio in the playlist
	 * @param name name of the audio
	 * @return audio obj or null if isn't found
	 */
	public Audio searchAudio(String name) {
		Audio anyAudio = null;
		boolean isFound = false;
		for (int i = 0; i < audios.size() && !isFound; i++) {
			if(audios.get(i).getName().equals(name)){
				anyAudio = audios.get(i);
				isFound = true;
			}
		}
		return anyAudio;
	}

	/**Generates a code depending of the audios contained in the playlist
	 * @return generated code
	 */
	public boolean generateCode() {
		String code = "";
		boolean isGenerated = false;
		int[] audiosSummary = countAudioByType();
		initMatrix();
		if(audiosSummary[0]>0 && audiosSummary[1]==0){
			code = tRoute();	
			isGenerated = true;
		}
		if(audiosSummary[0]==0 && audiosSummary[1]>0){
			code = nRoute();
			isGenerated = true;	
		}
		if(audiosSummary[0]>0 && audiosSummary[1]>0){
			code = anyRoute();
			isGenerated = true;
		}
		
		setId(code);
		return isGenerated;
	}
	/**Counts how many audios of each type are there in the playlists
	 * @return two integers, first count of podcast, second count of
	 */
	public int[] countAudioByType(){
		
		int podcastCount = 0;
		int songCount = 0;
		for (int i = 0; i < audios.size(); i++) {
			if(audios.get(i) instanceof Song){
				songCount++;
			}
			if(audios.get(i) instanceof PodCast){
				podcastCount++;
			}
		}
		int[] podSong = new int[]{podcastCount, songCount};
		return podSong;
	}
	/**Genreates a code travesing the matrix in a N form 
	 * @return generated code
	 */
	public String nRoute(){
		String nCode = "";
		for (int i = matrix.length-1; i >= 0; i--) {
			nCode += ""+matrix[i][0];
		}
		for (int i = 1; i < matrix.length-1; i++) {
			nCode += ""+matrix[i][i];
		}
		for (int i = matrix.length-1; i >= 0; i--) {
			nCode += ""+matrix[i][matrix.length-1];
		}
		return nCode;
		
	}
	
	/**Generates a code travesing the matrix in a T form
	 * @return generated code
	 */
	public String tRoute(){
		String tCode = "";
		for (int i = 0; i < (matrix.length/3); i++) {
			tCode += ""+matrix[0][i];
		}
		for (int i = 0; i < matrix[0].length ; i++) {
			tCode += ""+matrix[i][(matrix.length/2)-1];
		}
		for (int i = matrix.length-1; i >= 0 ; i--) {
			tCode += ""+matrix[i][matrix.length/2];

		}
		for (int i = matrix.length-(matrix.length/3); i < matrix.length; i++) {
			tCode += ""+matrix[0][i];
		}



		return tCode;
	}

	/**Genrates a code travesing the matrix in a oscillating form	
	 * @return generated code
	 */
	public String anyRoute(){
		String anyCode = "";
		for (int i = matrix.length-1; i >= 0; i--) {
			for (int j = matrix[0].length-1; j >=0 ; j--) {
				if(	( ((i+j)%2) != 0 )  && ( (i+j)>1 ) ){
					anyCode += matrix[i][j];
				}
			}
		}

		return anyCode;
	}

	/**
	 * Inits the matrix with random numbers between 0 to 9
	 */
	public void initMatrix(){
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				this.matrix[i][j] = (int)((Math.random()*10));
			}
		}
	}
	/**
	 * Adds a new audio to the Audios list
	 * @param newAudio audio to be added
	 * @return true if added, else false
	 */
	public boolean addAudio(Audio newAudio) {
		return audios.add(newAudio);
	}

	/**
	 * Gets the matrix that is bases the share code
	 * @return matrix
	 */
	public int[][] getMatrix() {
		return matrix;
	}

	/**Gets the list of audios
	 * @return list of audios
	 */
	public ArrayList<Audio> getAudios() {
		return audios;
	}

	/**Sets the list of audios to a new one
	 * @param audios new list
	 */
	public void setAudios(ArrayList<Audio> audios) {
		this.audios = audios;
	}

	/**Gets tha name of the playlist
	 * @return name of the playlist
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Sets the name of the playlist to a new one
	 * @param name new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**Get the share id of the playlist
	 * @return share id of the playlist
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * Sets the share id of the playlist to a new one
	 * @param id new shareid
	 */
	public void setId(String id) {
		this.id = id;
	}


}