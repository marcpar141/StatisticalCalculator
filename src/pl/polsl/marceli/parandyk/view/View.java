package pl.polsl.marceli.parandyk.view;

import java.util.ArrayList;
import java.util.List;
/**
 * Class containing methods responsible for informing user of current states
 * and printing results of calculations
 * @author Marceli
 * @version 2.0
 */
public class View {
    
    /**
     * Printing information about lack of data in model.
     */
    public void noData() {
        System.out.println("No data.");
    }
    
    /**
     * Printing all data which model contain.
     * @param list Data given by user
     */
    public void viewData(ArrayList list){
        
        System.out.println("Data: ");
        
        for(Object o : list){
            System.out.print((double)o+", ");
        }
        
        System.out.println("");
    }
    
    /**
     * Printing results based on given data.
     * @param avg Value of average
     * @param std Value of Standard deviation
     * @param md  Value of Median
     */
    
    public void printResults(double avg, double std, double md) {
        
        System.out.println("Results:");
        System.out.println("Average: "+ avg);
        System.out.println("Standard deviation: "+ std);
        System.out.println("Median: "+ md);
    }
    
    /**
     * Printing information about incorrect input.
     */
    public void IncorrectInputMessage(){
        System.out.println("Incorrect input");
        System.out.println("Provide valid data!");
    }
    
}
