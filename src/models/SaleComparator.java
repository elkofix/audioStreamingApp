package models;
import java.util.Comparator;
public class SaleComparator implements Comparator<Song>{
    public int compare(Song a, Song b){
        a.updateSales();
        b.updateSales();
        return (int)(b.getTotalSales()-a.getTotalSales());
    }
}
