package models;

public class GenrePlays implements Comparable<GenrePlays>{
    private Genre genre;
    public Genre getGenre() {
        return genre;
    }
    private int timesPlayed;

    public int compareTo(GenrePlays b){
        return this.timesPlayed-b.getTimesPlayed(); 
    }
    public int getTimesPlayed() {
        return timesPlayed;
    }
    public void setTimesPlayed(int timesPlayed) {
        this.timesPlayed = timesPlayed;
    }
    public GenrePlays(Genre genre){
        this.genre = genre;
        timesPlayed = 0;
    }
    public void updatePlays(){
        this.timesPlayed++;
    }
}
