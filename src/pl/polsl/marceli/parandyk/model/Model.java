package pl.polsl.marceli.parandyk.model;

import pl.polsl.marceli.parandyk.exceptions.EmptyListException;
import pl.polsl.marceli.parandyk.exceptions.WrongFormatOfDataException;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import static java.lang.Math.round;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


/**
 * Class containing data given by user, fields containg variables of requested
 * values and calcualtion methods needed to obtain them.
 * @author Marceli Parandyk
 * @version 2.0
 */
public class Model {
    
    /**
     * Constructor which is declaring list to store data
     */
    public Model() {
        this.data = new ArrayList();
    }
    
    /**
     * List of double storing data given by user.
     */
    private ArrayList data;
    
    /**
     * Size of list.
     */
    private int size;
    
    /**
     *  Value of average.
     */
    private double avg;
    
    /**
     * Value of standard deviation.
     */
    private double std;
    
    /**
     * Value of median.
     */
    private double md;
    
    /**
     * Checking whether list is empty.
     * @return information of list state
     */
    public boolean isEmpty() {
        return data.isEmpty();
    }
    
    /**
     * Adding values to list given by user using scanner.
     * To stop adding data just press in keyboard some character. Method read
     * it as end.
     * If data already exists, method expands list with new data.
     * @param s String containing data.
     * @throws WrongFormatOfDataException when user give text
     */
    public void setData(String s) throws WrongFormatOfDataException{
        
        s=s.replace(';', ' ');

        Scanner scanner = new Scanner(s);
        
        while(scanner.hasNext()){
            if(!scanner.hasNextDouble()){
                throw new WrongFormatOfDataException("Wrong format of data!");
            }else{
                data.add(scanner.nextDouble());
            }

        setSize();

        }    
    }
    
    
    /**
     * Setting value of size.
     */
    private void setSize() {
        
        this.size = this.data.size();
        
    }
    
    /**
     * Getting list od data.
     * @return list of data provided by user.
     */
    public ArrayList getData() {
        return data;
    }
    
    /**
     * Average of given data
     */
    private void average(){
        
        for(Object o : this.data){
            avg += (double)o;
        }
        
        avg=avg/((double) size);
 
    }

    /**
     * Getting average
     * @return average
     * @throws EmptyListException when data is empty
     */
    public double getAvg() throws EmptyListException{
        if(data.isEmpty()){
            throw new EmptyListException("Empty list");
        }
        else{
            return avg;
        }
    }
    
    /**
     * Standatd deviation of given data
     */
    
    private void standardDeviation(){
     
        for(Object o : data){
            
            std += pow(((double)o-avg), 2);
        }
        
        std = round(sqrt(std/((double) size))*1000.0)/1000.0;
   
    }
    
    /**
     * Getting standard deviation.
     * @return standard deviation 
     */
    public double getStd() {
        return std;
    }
    
    /**
     * Median of given data
     */
    private void median() {
        
        if(size % 2 != 0){
            md = (double)data.get((size-1)/2);
        } else if(((int) size == 2)){
            md = ((double)data.get(0)+(double)data.get(1))/2;
        }
        else { md = ((double)data.get(size/2)+(double)data.get((size/2)+1))/2; }
        
    }

    /**
     * Getting median.
     * @return median 
     */
    public double getMd() {
        return md;
    }
    
    /**
     * Ascending sort of data and calculating results based on data.
     * @throws IndexOutOfBoundsException when list of data is empty
     */
    public void calculate() throws IndexOutOfBoundsException{
        
        Collections.sort(data);
        average();        
        standardDeviation();
        median();

            
            
        
    }
    
    
    
}
