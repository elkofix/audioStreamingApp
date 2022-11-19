package models;
import java.util.Comparator;
/** Comparator of songs by sales
 * @author Alejandro Cordoba
 * @version 1.0
 * @since 1.0
*/
public class SaleComparator implements Comparator<Song>{
    /* (non-Javadoc)
     * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
     */
    public int compare(Song a, Song b){
        a.updateSales();
        b.updateSales();
        return (int)(b.getTotalSales()-a.getTotalSales());
    }
}
