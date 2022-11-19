package models;
/** Counter of the time each genre is played.
 * @author Alejandro Cordoba
 * @version 1.0
 * @since 1.0
*/
public class GenrePlays implements Comparable<GenrePlays>{
    private Genre genre;
    private int timesPlayed;

    /**Constructor of the GenrePlays Class
     * @param genre song genre
     */
    public GenrePlays(Genre genre){
        this.genre = genre;
        timesPlayed = 0;
    }

    /**
     * Adds one to the times played of this genre
     */
    public void updatePlays(){
        this.timesPlayed++;
    }

    /* (non-Javadoc)
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    public int compareTo(GenrePlays b){
        return this.timesPlayed-b.getTimesPlayed(); 
    }

    /**Gets the genre of the counter
     * @return genre
     */
    public Genre getGenre() {
        return genre;
    }

    /**Gets the times this genres was played
     * @return times played
     */
    public int getTimesPlayed() {
        return timesPlayed;
    }
    /**Sets the times this genre was played to a new one
     * @param timesPlayed new times played
     */
    public void setTimesPlayed(int timesPlayed) {
        this.timesPlayed = timesPlayed;
    }

}
