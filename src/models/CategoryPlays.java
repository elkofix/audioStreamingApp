package models;
/** Counter of the time each category is played.
 * @author Alejandro Cordoba
 * @version 1.0
 * @since 1.0
*/
public class CategoryPlays implements Comparable<CategoryPlays>{
    private Category category;
    private int timesPlayed;
    /**Constructor of CategoryPlays class
     * @param category category counted
     */
    public CategoryPlays(Category category){
        this.category = category;
        timesPlayed = 0;
    }
    /**Gets the category
     * @return category
     */
    public Category getCategory() {
        return category;
    }

    /**Gets the times the category was played
     * @return times played
     */
    public int getTimesPlayed() {
        return timesPlayed;
    }

    /**
     * Adds one to the times played
     */
    public void updatePlays(){
        timesPlayed++;
    }

    /* (non-Javadoc)
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    public int compareTo(CategoryPlays b){
        return this.timesPlayed-b.getTimesPlayed(); 
    }
}
