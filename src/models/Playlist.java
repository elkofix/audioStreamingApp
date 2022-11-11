package models;

import java.util.ArrayList;

public class Playlist {

	private String name;
	private String id;
	private ArrayList<Audio> audios;
	private int[][] matrix;
	public int[][] getMatrix() {
		return matrix;
	}

	public ArrayList<Audio> getAudios() {
		return audios;
	}

	public void setAudios(ArrayList<Audio> audios) {
		this.audios = audios;
	}

	/**
	 * 
	 * @param name
	 */
	public Playlist(String name) {
		this.name = name;
		audios = new ArrayList<Audio>();
		matrix = new int[6][6];
		generateCode();
	}
	
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

	public void initMatrix(){
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				this.matrix[i][j] = (int)((Math.random()*9));
			}
		}
	}
	/**
	 * 
	 * @param newAudio
	 */
	public boolean addAudio(Audio newAudio) {
		return audios.add(newAudio);
	}

	public String getName() {
		return this.name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return this.id;
	}

	/**
	 * 
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}
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
	 * 
	 * @param name
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

}