package pl.polsl.marceli.parandyk.controller;

import pl.polsl.marceli.parandyk.exceptions.EmptyListException;
import pl.polsl.marceli.parandyk.exceptions.WrongFormatOfDataException;
import pl.polsl.marceli.parandyk.model.Model;
import pl.polsl.marceli.parandyk.view.View;

/**
 * Class containing all needed methods required to operate calculator.
 * @author Marceli Parandyk
 * @version 2.0
 */
public class Controller {
    
    /**
     * Constructor gathering all classes needed to valid operate of calculator.
     * @param view view containing methods to inform user.
     * @param model model containing methods and field to manipulate and store data
     */
    public Controller(View view, Model model) {
        this.view=view;
        this.model = model;
    }
    
    /**
     * Field responsible for storing class of View type which is neccesary 
     * for contact with user.
     */
    private View view;
    
    /**
     * Field responsible for storing class of Model type which calculate 
     * requested values manipulate data provided by user.
     */
    private Model model;
    
    /**
     * Process of adding data to list.
     * @param s String containing data.
     */
    public void addData(String s) {
        try{
            model.setData(s); 
        }
        catch(WrongFormatOfDataException ex){
            System.out.println(ex.getMessage());
            System.exit(0);
        }
        
    }
    
    /**
     * Process of printing all data provided by user.
     */
    public void seeData(){
        if(!model.isEmpty()) {
        view.viewData(model.getData());
        } else view.noData();
    }
    
    
    /**
     * Process of calculating results.
     */ 
    public void startCalculating(){
        try{
            model.calculate();
        }
        catch(IndexOutOfBoundsException ex){
            System.out.println(ex.getMessage());
            System.exit(0);
        }
        finally{
            System.out.println("Finished calculating");
        }
    }
    
    /**
     * Process of presenting results to user.
     */
    public void getResults() {
        try{
            view.printResults(model.getAvg(),
                model.getStd(), 
                model.getMd());
        }catch(EmptyListException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    /**
     * Method informing user about incorrect input. 
     */
    public void printIncorrectInputMessage(){
        view.IncorrectInputMessage();
    }
       
}
