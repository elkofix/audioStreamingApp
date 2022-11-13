package models;

public class CategoryPlays implements Comparable<CategoryPlays>{
    private Category category;
    public Category getCategory() {
        return category;
    }
    private int timesPlayed;
    public int getTimesPlayed() {
        return timesPlayed;
    }
    public CategoryPlays(Category category){
        this.category = category;
        timesPlayed = 0;
    }
    public void updatePlays(){
        timesPlayed++;
    }

    public int compareTo(CategoryPlays b){
        return this.timesPlayed-b.getTimesPlayed(); 
    }
}
