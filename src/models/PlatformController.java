package models;

import java.util.ArrayList;
import java.util.Collections;


public class PlatformController{

	private String name;
	private String nit;
	private ArrayList<User> users;
	private ArrayList<Audio> audios;


	/**
	 * Constructor of the platform controller
	 * @param name name of the platform
	 * @param nit enterprise nit
	 */
	public PlatformController(String name, String nit) {
		
		this.name = name;
		this.nit = nit;
		users = new ArrayList<User>();
		audios = new ArrayList<Audio>();
		users.add(new Premium("1", "k"));
		users.add(new ContentCreator("a", "a"));
		users.add(new Artist("b", "a"));
		addAudio(createAudio("Wanna be yours", "xd", 150, null, 100.0, null, 1, 1, "b") , "b");
		addAudio(createAudio("Wisdom", "xd", 200, null, 200.0, null, 1, 1,"b" ), "b");
		addAudio(createAudio("Vibras", "xd", 100, null, 100.0, null, 1, 1,"b"), "b");
		addAudio(createAudio("Rises the moon", "xd", 122, null, 800.0, null, 1, 1,"b"), "b");	
		addAudio(createAudio("Titi me pregunto", "xd", 1, null, 100.0, null, 1, 1,"b"), "b");
		addAudio(createAudio("Problems", "xd", 120, null, 150.0, null, 1, 1,"b"), "b");
		addAudio(createAudio("Vos tan", "xd", 182, null, 20.0, null, 1, 2,"a"), "a");
		addAudio(createAudio("Sky podcast", "xd", 120, null, 50.0, null, 1, 2,"a"), "a");
		addAudio(createAudio("Dos nombres comunes", "xd", 100, null, 80.0, null, 1, 2,"a"), "a");
		addAudio(createAudio("Con nombre de podcasst", "xd", 401, null, 90.0, null, 1, 2,"a"), "a");	
		
	}
	/**Updates and audio in Producer and Platform list when it's played
	 * @param anyAudio audio to be updated
	 * @param playTime the seconds the audio was played
	 * @return true if is updated, else false
	 */
	public boolean updateAudio(Audio anyAudio, int playTime){
		audios.remove(anyAudio);
		ProducerUser anyUser = ((ProducerUser)(searchUser(anyAudio.getAuthor())));
		anyUser.setPlayTime(anyUser.getPlayTime()+playTime);
		anyUser.setPlays(anyUser.getPlays()+1);
		anyAudio.setTimesPlayed(anyAudio.getTimesPlayed()+1);
		if(anyUser instanceof ContentCreator){
			((ContentCreator)(anyUser)).getPodcasts().remove(anyAudio);
			((ContentCreator)(anyUser)).getPodcasts().add((PodCast)anyAudio);
		}
		if(anyUser instanceof Artist){
			((Artist)(anyUser)).getSongs().remove(anyAudio);
			((Artist)(anyUser)).getSongs().add((Song)anyAudio);
		}
		users.remove(anyUser);
		users.add(anyUser);
		return audios.add(anyAudio);
	}
	/**
	 * Adds a user to Platform's list
	 * @param User user object to be added
	 * @return Confirmation message if added, else error message
	 */
	public String addUser(User user) {
		String id = giveUserId(user);
		String msj = "No se agrego el usuario";
		User anyUser = searchUser(id);
		if(anyUser == null){
			if(users.add(user)){
				msj = "Sea agrego el usuario";
			}
		}else{
			msj = "Ya existe un usuario con ese identificador";
		}
		
		return msj;
	}

	/** Creates a user depending on the type 
	 * @param id id for the user
	 * @param nickname nickname if the user is consumer
	 * @param name name if the user is producer
	 * @param imgURL Url of the image that represents them if producer
	 * @param typeUser1 type of user, 1 being consumer, 2 being Producer
	 * @param typeUser2 subtype of user, 1 being Artist for producer or Standard for Consumer, 2 being Content creator for producer or Premium for Consumer
	 * @return User created
	 */
	public User createUser(String id, String nickname, String name, String imgURL, int typeUser1, int typeUser2){
		User anyUser = null;
		if(typeUser1 == 1){
			if(typeUser2 == 1){
				anyUser = new Standard(id, nickname);
			}else{
				anyUser = new Premium(id, nickname);
			}
		}

		if(typeUser1 == 2){
			if(typeUser2 == 1){
				anyUser = new Artist(name, imgURL);
			}else{
				anyUser = new ContentCreator(name, imgURL);
			}
		}
		return anyUser;
	}

	/**Creates and audio depending on the type
	 * @param name name of the audio
	 * @param imgURL url that represents the audio
	 * @param duration duration in seconds of the audio
	 * @param album name of the album if song
	 * @param price price of the audio if song
	 * @param description description of the audio if podcast
	 * @param genre option selected for genre if song or category if podcast
	 * @param audioType audio type, 1 being song, 2 being podcast
	 * @param author author of the audio
	 * @return Audio created
	 */
	public Audio createAudio(String name, String imgURL, int duration, String album, double price, String description, int genre,int audioType, String author){
		Audio anyAudio = null;
		if(audioType==1){
			anyAudio = new Song(name, imgURL, duration, album, price, giveSongGenre(genre), author);
		}else{
			anyAudio = new PodCast(name, imgURL, duration, description, givePodcastCategory(genre), author);
		}
		return anyAudio;
	}

	/**
	 * Adds and audio to a producer user list
	 * @param Audio Audio to be added
	 * @param userId id of the producer user - it's mandatory to be a producer, else and exception message is thrown
	 * @return Confirmation message
	 */
	public String addAudio(Audio audio, String userId) {
		String msj = "No se agrego el audio";
		User anyUser = searchUser(userId);
			if(anyUser!=null){
				if(anyUser instanceof Artist && audio instanceof Song){
					((Artist)(anyUser)).addSong(((Song)(audio)));
					audios.add(audio);
					msj = "Se agrego la cancion";
				}else if(anyUser instanceof ContentCreator && audio instanceof PodCast){
					((ContentCreator)(anyUser)).addPodcast(((PodCast)(audio)));
					audios.add(audio);
					msj = "Se agrego el podcast";
				}else{
					msj = "Este usuario no puede agregar este audio";
				}
			}
		return msj;
	}
	
	/**
	 * Search a user by its id and return the object
	 * @param id id of the user to be search
	 * @return Object of the user, null if isn't found
	 */
	public User searchUser(String id){
		User anyUser = null;
		Boolean isFound = false;
		String userName;
		String userId;
			for (int i = 0; i < users.size() && !isFound; i++) {
				if(users.get(i) instanceof Artist || users.get(i) instanceof ContentCreator){
				userName = ((ProducerUser)(users.get(i))).getName();
					if(id.equals(userName)){
						anyUser = users.get(i);
						isFound = true;
					}

				}
				if(users.get(i) instanceof ConsumerUser){
						userId = ((ConsumerUser)(users.get(i))).getId();
						if(id.equals(userId)){
							anyUser = users.get(i);
							isFound = true;
						}
				}
			}
			
		return anyUser;
	}

	/**Deploys a message with purchased songs and available podcast from a give user 
	 * @param id id of the user 
	 * @return two strings, first contains the audios and second is null. First is null if user isn't found, second is an exception if the user is not consumer 
	 */
	public String[] deployUserOptions(String id){
		String[] msj = new String[]{"Audios disponibles: \n \n", null};
		User anyUser = searchUser(id);
		ConsumerUser anyUserC = null;
		if(anyUser != null){
			if(anyUser instanceof Premium  || anyUser instanceof Standard){
				anyUserC = (ConsumerUser)anyUser;
				msj[0] += anyUserC.deployPurchases() + "\n";
				msj[0]+= deployPodcast();
		
			}else{
				msj[1] = "Este usuario es no es de tipo consumidor";
			} 
		}else{
			msj[0]= null;
		}
		return msj;
		
	}
	/**Checks if an audio is an instance of Song
	 * @param anyAudio audio to be checked
	 * @return true if song, else false
	 */
	public boolean isSong(Audio anyAudio){
		return anyAudio instanceof Song;
	}
	/**Deploys sthe podcast available in the platforom
	 * @return message with the podcast or an exception if no podcasts are found
	 */
	public String deployPodcast(){
		String msj = "Podcast disponbibles: \n";
		int counter = 0;
		for (int i = 0; i < audios.size(); i++) {
			if(audios.get(i) instanceof PodCast){
				msj+= "-"+audios.get(i).getName()+"\n";
				counter++;
			}
			
		}
		if(counter == 0){
			msj = "No hay podcast disponibles por el momento \n";
		}
		return msj;
	}

	/**Searches an audio by its name
	 * @param audioName name of the audio
	 * @return audio object found or null if is not found
	 */
	public Audio searcAudio(String audioName){
		Audio anyAudio = null;
		boolean isFound = false;
		for (int i = 0; i < audios.size() && !isFound; i++) {
			if(audios.get(i).getName().equals(audioName)){
				anyAudio = audios.get(i);
				isFound = true;
			}
		}
		return anyAudio;
	}

	/**Creates a playlist with a audio and adds it to a given user
	 * @param name name of the playlist
	 * @param userId ID of the user
	 * @param audioName name of the audio
	 * @return true if is the audio is 
	 */
	public boolean createPlaylist(String name, String userId){
		ConsumerUser anyUser = (ConsumerUser)searchUser(userId);
		Playlist newPlaylist = new Playlist(name);
		int i = users.indexOf(anyUser);
		boolean isCreated = anyUser.addPlaylist(newPlaylist);
		users.set(i, anyUser);
	
		return isCreated;
	}

	
	/**
	 * 
	 * @param listId
	 * @param consumerId
	 */
	public String showPlaylistSharecode(String listId, String consumerId) {
		ConsumerUser anyConsumerUser  =(ConsumerUser)searchUser(consumerId);
		Playlist anyPlaylist = null;
		String msj = "";
		if(anyConsumerUser!=null){
			anyPlaylist = searchPlaylistFromConsumer(listId, anyConsumerUser);
		}else{
			msj = "No se encontro al usuario";
		}
		
		if(anyPlaylist!=null){
			int[][] matrix = anyPlaylist.getMatrix();
			msj = "ID de Playlist: "+anyPlaylist.getId()+"\n";
			msj+= "\n Matriz de ID \n"+ printMatrix(matrix);
		}else{
			msj = "No se encontro la playlist";	
		}
		return msj;
	}

	public String printMatrix(int[][] matrix){
		String msj = "";
		for (int i = 0; i < matrix.length; i++) {
			msj+= "------------------------ \n";
			for (int j = 0; j < matrix.length; j++) {
				if(j==0){
					msj +=	" "+matrix[i][j];	
				}else if(j==matrix.length-1){
					msj +=	" - "+matrix[i][j]+" - \n";
				}else{
					msj += " - "+matrix[i][j];
				}
			}
		}
		return msj; 
	
	}
	
	/**
	 * 
	 * @param listId
	 * @param consumerId
	 */
	public Playlist searchPlaylistFromConsumer(String name, User anyUserC) {
		ConsumerUser anyUser = (ConsumerUser)anyUserC;
		Playlist anyPlaylist = null;
		Boolean isFound = false;
		if(anyUser!= null){
				for (int i = 0; i < anyUser.getPlaylists().size() && !isFound; i++) {
					if(anyUser.getPlaylists().get(i).getName().equals(name)){
						anyPlaylist = anyUser.getPlaylists().get(i);
						isFound = true;
					}
				}
		}
		return anyPlaylist;
	}

	/**
	 * Adds or removes and audio to a given playlist
	 * @param Playlist Playlist to be edited
	 * @param audioName audio to be added or removed
	 * @param action action to be executed, 1 being adding the audio, 2 being remove the audio
	 * @return a message if the action is completed or an alert for any exception
	 */
	public String editPlaylist(String playlistName, String audioName, int action, String UserName) {
		String msj = "Lol";
		User anyUser = searchUser(UserName);
		ConsumerUser anyUserC = parseUser(anyUser);
		Audio newAudio = searcAudio(audioName);
		boolean isDone = false;
		if(anyUserC!= null){
			Playlist anyPlaylist = searchPlaylistFromConsumer(playlistName, anyUserC);
			if(anyPlaylist != null){
				if(newAudio!=null && newAudio instanceof PodCast && !isDone){
					if(action == 1){
						if(anyPlaylist.getAudios().contains(newAudio)){
							msj = "Este podcast ya pertenece a la playlist";
						}else{
							anyPlaylist.getAudios().add(newAudio);
							anyUserC.getPlaylists().remove(anyPlaylist);
							anyPlaylist.generateCode();
								anyUserC.addPlaylist(anyPlaylist);
								users.remove(anyUser);
								users.add(anyUserC);
								msj = "Se agrego el podcast";
								isDone = true;
						}
						
					}
					if(action == 2){
						if(anyPlaylist.getAudios().contains(newAudio)){
							anyPlaylist.getAudios().remove(newAudio);
							anyUserC.getPlaylists().remove(anyPlaylist);
							anyPlaylist.generateCode();
								anyUserC.addPlaylist(anyPlaylist);
								users.remove(anyUser);
								users.add(anyUserC);
								msj = "Se elimino el podcast";
								isDone = true;
						}else{
							msj = "Esta playlist no tiene este audio";
						}
					}
				}else{
					msj = "No se encontro el audio";
				}
				if(newAudio!=null && newAudio instanceof Song && !isDone){
					if(searchSongFromUser((Song)newAudio, anyUserC)){
						if(action == 1){
							if(anyPlaylist.getAudios().contains(newAudio)){
								msj = "Esta playlist ya tiene esta cancion";
							}else{
								anyPlaylist.getAudios().add(newAudio);
								anyUserC.getPlaylists().remove(anyPlaylist);
								anyPlaylist.generateCode();
								anyUserC.addPlaylist(anyPlaylist);
								users.remove(anyUser);
								users.add(anyUserC);
								msj = "Se agrego la cancion";
								isDone = true;
							}
							
						}
						if(action == 2){
							if(anyPlaylist.getAudios().contains(newAudio)){
								anyPlaylist.getAudios().remove(newAudio);
								anyUserC.getPlaylists().remove(anyPlaylist);
								anyPlaylist.generateCode();
								anyUserC.addPlaylist(anyPlaylist);
								users.remove(anyUser);
								users.add(anyUserC);
								msj = "Se elimino la cancion";
								isDone = true;
							}
						}	
					}else{
					  msj= "No has comprado esta cancion";	
					}
				}else{
					msj = "No se encontro el audio";
				}
			}else{
				msj = "No se encontro la playlist";
			}

		}else{
			msj = "No se encontro al usuario";
		}
		
		return msj;
	}


	/**
	 * 
	 * @param audioName
	 * @param userId
	 */
	public boolean searchSongFromUser(Audio anySong, User anyUser) {

		Boolean isFound = false;
		if(anyUser instanceof Premium){
				if(((Premium)(anyUser)).searchSong(anySong.getName())!=null){
					isFound = true;
				}
		}
		if(anyUser instanceof Standard){
			if(((Standard)(anyUser)).searchSong(anySong.getName())!=null){
				isFound = true;
			}
		}
		return isFound;
	}

	public String[] deployUserPlaylists(String id){
		String[] msj = new String[]{null, "Teni play"};
		int counter = 0;
		ConsumerUser anyUser = (ConsumerUser)searchUser(id);
		if(anyUser!=null){
			msj[0] = "Tus Playlist: \n";
			for (int i = 0; i < anyUser.getPlaylists().size(); i++) {
				msj[0] += "- "+anyUser.getPlaylists().get(i).getName()+"\n";
				counter++;
			}
		}
		if(counter==0){
			msj[1] = null;
		}

		
		return msj;
	}

	public String deployPlaylistAudio(String playName, String userId){
		String msj = null;
		Playlist anPlaylist = searchPlaylistFromConsumer(playName, (ConsumerUser)searchUser(userId));
		if(anPlaylist!=null){
			msj = anPlaylist.audiosResume();
		}
		return msj;
	}
	public boolean isPremium(User anyUser){
		return anyUser instanceof Premium;
	}

	/**
	 * 
	 * @param Audio
	 */
	public String deploySongs(){
		String msj = "Canciones del sistema: \n";
		int counter = 0;
		for (int i = 0; i < audios.size(); i++) {
			if(audios.get(i) instanceof Song){
				msj += "-"+audios.get(i).getName()+"\n";
				counter++;
			}
		}
		if(counter == 0){
			msj = null;
		}
		return msj;
	}
	/**
	 * 
	 * @param songName
	 * @param userId
	 */
	public String buySong(String songName, String userId) {
		String msj = "";
		User anyUser = searchUser(userId);
		if(anyUser instanceof ConsumerUser){
			Audio anyAudio = searcAudio(songName);
			if(anyAudio instanceof Song){	
				if(!searchSongFromUser(anyAudio, anyUser)){
					if(anyUser instanceof Premium){
						if(((Premium)(anyUser)).addSong((Song)anyAudio)){
							msj = "Compra exitosa";
							((Song)anyAudio).setTimesSold(((Song)anyAudio).getTimesSold()+1);
						}else{
							msj = "No se pudo comprar la cancion";
						}
					}
					if(anyUser instanceof Standard){
						if(((Standard)(anyUser)).addSong((Song)anyAudio)){
							msj = "Compra exitosa";
							((Song)anyAudio).setTimesSold(((Song)anyAudio).getTimesSold()+1);
							
						}else{
							msj = "No tienes espacio para mas canciones";
						}
						
					}
				}else{
					msj = "Ya has comprado esta cancion";
				}
			}else{
				msj = "No se encontro la cancion";
			}
		}else{
			msj = "Este usuario no es de tipo consumidor";
		}
		return msj;
	}

	public String generateAudioReport(String userId) {
		int[] audioPlays = getAudioPlays();
		return "Informes de datos: \n\n"+
		"Reproducciones de canciones: "+audioPlays[1]+"\n"+
		"Reproducciones de Podcast: "+audioPlays[0]+"\n\n"+
		getMaxGenre(userId)+"\n"+
		getMaxCategory(userId)+"\n\n"+
		getTop5ArtistnCreator()+"\n\n"+
		getTop10SongnPodcast()+"\n\n"+
		getGenreSales()+"\n\n"+
		getBestSeller();
	}
	public int[] getAudioPlays(){
		int totalPlaysSong = 0;
		int totalPlaysPodcast = 0;
		for (int i = 0; i < audios.size(); i++) {
			if(audios.get(i) instanceof PodCast){
				totalPlaysPodcast += audios.get(i).getTimesPlayed();
			}
			if(audios.get(i) instanceof Song){
				totalPlaysSong += audios.get(i).getTimesPlayed();
			}
		}
		return new int[]{totalPlaysPodcast, totalPlaysSong};
	}

	public String getMaxGenre(String userId) {
		String msj= "";
		User anyUser = searchUser(userId);
		if(anyUser instanceof ConsumerUser){
			msj  =((ConsumerUser)(anyUser)).calculateMostGenre();
		}else{
			msj = "Este usuario no es de tipo consumidor o no existe";
		}
		return msj;
	}
	public boolean playAudio(String userId, Audio audio){
		ConsumerUser anyUser= (ConsumerUser)searchUser(userId);
		Boolean isUpdate = false;
		if(audio instanceof Song){
			anyUser.updateGenrePlays(((Song)audio).getGenre());
			isUpdate = true;
		}
		if(audio instanceof PodCast){
			anyUser.updateCategoryPlays(((PodCast)(audio)).getCategory());
			isUpdate = true;
		}
		return isUpdate;
	}

	public String getMaxCategory(String userId) {
		String msj= "";
		User anyUser = searchUser(userId);
		if(anyUser instanceof ConsumerUser){
			msj  =((ConsumerUser)(anyUser)).calculateMostCategory();
		}else{
			msj = "Este usuario no es de tipo consumidor";
		}
		return msj;
	}

	public String getTop5ArtistnCreator() {
		ArrayList<ProducerUser> creators = new ArrayList<ProducerUser>();
		ArrayList<ProducerUser> artists = new ArrayList<ProducerUser>();
		for (int i = 0; i < users.size(); i++) {
			if(users.get(i) instanceof ContentCreator){
				creators.add((ProducerUser)users.get(i));
			}
			if(users.get(i) instanceof Artist){
				artists.add((ProducerUser)users.get(i));
			}
		}
		if(creators.size()>1){
			Collections.sort(creators, Collections.reverseOrder());
		}
		if(artists.size()>1){
			Collections.sort(artists, Collections.reverseOrder());
		}
		String msj = "Top 5 Creadores de contenido \n\n";
			if(creators.size()>1){
				for (int i = 0; i <= 5 && i<creators.size(); i++) {
					msj += i+1+":"+creators.get(i).getName()+ " Reproducciones: "+creators.get(i).getPlays() + "\n";
				}
			}else if (creators.size()==1){
				msj += 1+":"+creators.get(0).getName()+ " Reproducciones: "+creators.get(0).getPlays() + "\n";
			}else{
				msj = "No hay creadores \n";
			}
			String msj2 = "\n Top 5 artistas \n\n";
			if(artists.size()>1){ 
				for (int i = 0; i <= 5 && i<creators.size(); i++) {
					msj2 += i+1+":"+artists.get(i).getName()+ " Reproducciones: "+artists.get(i).getPlays() + "\n";
				}
			}else if(artists.size()==1){
				msj2 += 1+":"+artists.get(0).getName()+ " Reproducciones: "+artists.get(0).getPlays() + "\n";
			}else{
				msj2 = "No hay artistas \n";
			}
		return msj+msj2;
	}

	public String getTop10SongnPodcast() {
		ArrayList<Audio> songs= new ArrayList<Audio>();
		ArrayList<Audio> podcast = new ArrayList<Audio>();
		for (int i = 0; i < audios.size(); i++) {
			if(audios.get(i) instanceof Song){
				songs.add(audios.get(i));
			}
			if(audios.get(i) instanceof PodCast){
				podcast.add(audios.get(i));
			}
		}
		Collections.sort(songs, Collections.reverseOrder());
		Collections.sort(podcast, Collections.reverseOrder());
		String msj = "Top 10 Canciones \n\n";
		for (int i = 0; i <= 10 && i<songs.size(); i++) {
			msj += i+1+": "+songs.get(i).getName()+" Genero: "+((Song)songs.get(i)).getGenre() +" Reproducciones: "+songs.get(i).getTimesPlayed() + "\n";
			
		}

		String msj2 = "\n Top 10 Podcast \n\n";
		for (int i = 0; i <= 10 && i<podcast.size(); i++) {
			msj2 += i+1+": "+podcast.get(i).getName()+" Categoria: "+((PodCast)podcast.get(i)).getCategory() + " Reproducciones: "+podcast.get(i).getTimesPlayed() + "\n";
		}
		return msj+msj2;
	}

	public String getGenreSales() {
		String msj = "Ventas por genero \n";
		int[] rockSales = new int[]{0, 0};
		int[] popSales = new int[]{0, 0};
		int[] trapSales = new int[]{0, 0};
		int[] houseSales = new int[]{0, 0};
		
		Song anySong = null;
		for (int i = 0; i < audios.size(); i++) {
			if(audios.get(i) instanceof Song){
				anySong = (Song)audios.get(i);
				anySong.updateSales();
				if(anySong.getGenre()==Genre.HOUSE){
					houseSales[0] += anySong.getTimesSold();
					houseSales[1] += anySong.getTotalSales();
				}
				if(anySong.getGenre()==Genre.TRAP){
					trapSales[0] += anySong.getTimesSold();
					trapSales[1] += anySong.getTotalSales();
				}
				if(anySong.getGenre()==Genre.POP){
					popSales[0] += anySong.getTimesSold();
					popSales[1] += anySong.getTotalSales();
				}
				if(anySong.getGenre()==Genre.ROCK){
					rockSales[0] += anySong.getTimesSold();
					rockSales[1] += anySong.getTotalSales();
				}
			} 
		}
		int[][] genres = new int[][]{rockSales, popSales, trapSales, houseSales};
		String[] genresName = new String[]{"Rock", "Pop", "Trap", "House"};
		for (int i = 0; i < genres.length; i++) {
			msj +=  genresName[i]+"\n";
			for (int j = 0; j < genres[0].length; j++) {
				msj+= "Ventas: "+genres[i][j]+"\n"+
				"Valor de ventas: "+genres[i][j+1]+"\n\n";
				j=2;
			}
		}
		return msj;
	}

	public String getBestSeller() {
		String msj =  "";
		ArrayList<Song> songs= new ArrayList<Song>();
		for (int i = 0; i < audios.size(); i++) {
			if(audios.get(i) instanceof Song){
				songs.add((Song)audios.get(i));
			}
		}
		Collections.sort(songs, new SaleComparator());
		if(songs.size()!=0){
			msj = "La cancion mas vendida es: "+songs.get(0).getName()+ " Total ventas: "+songs.get(0).getTimesSold()+ " Valor de venta: "+songs.get(0).getTotalSales();
		}else{
			msj = "No hay canciones";
		}
		return msj;

	}
	public String giveUserId(User user){
		String id = null;
		if(user != null){
			if(user instanceof Artist || user instanceof ContentCreator){
				id = ((ProducerUser)(user)).getName();
			}
			if(user instanceof Premium || user instanceof Standard){
				id = ((ConsumerUser)(user)).getId();
			}
		}

		return id;
	}
	public ConsumerUser parseUser(User anyUser){
		ConsumerUser anyUserC = null;
		if(anyUser instanceof Premium || anyUser instanceof Standard){
			anyUserC = (ConsumerUser)anyUser;
		}
		return anyUserC;
	}
	
	public Genre giveSongGenre(int option){
		Genre givenGenre = null;
		switch(option){
			case 1:
				givenGenre = Genre.ROCK;
			break;
			case 2:
				givenGenre = Genre.POP;
			break;
			case 3:
				givenGenre = Genre.TRAP;
			break;
			case 4:
				givenGenre = Genre.HOUSE;
			break;
			default:

			break;
			
		}
		return givenGenre;
	}

	public Category givePodcastCategory(int option){
		Category givenCategory = null;
		switch(option){
			case 1:
				givenCategory = Category.POLITICS;
			break;
			case 2:
				givenCategory = Category.ENTERTAINMENT;
			break;
			case 3:
				givenCategory = Category.VIDEOGAMES;
			break;
			case 4:
				givenCategory = Category.TREND;
			break;
			default:

			break;
			
		}
		return givenCategory;
	
	}

}