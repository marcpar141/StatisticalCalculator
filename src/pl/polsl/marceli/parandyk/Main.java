package pl.polsl.marceli.parandyk;

import pl.polsl.marceli.parandyk.view.View;
import pl.polsl.marceli.parandyk.model.Model;
import pl.polsl.marceli.parandyk.controller.Controller;

/**
 * This is a console operation which generate basic statistical components 
 * like standard deviation, average and median.
 * 
 * @author Marceli Parandyk
 * @version 2.0
 */
public class Main {
    
    
    /**
     * Main method of application
     * @param args first and only argument consist of data which calculator 
     * generate requested results. They have to be doubles seperated by 
     * semicolon.
     */
    public static void main(String[] args) {
        
        View view = new View();
        Model model = new Model();
        Controller controller = new Controller(view, model);
        
        if(args.length==1){
            controller.addData(args[0]);
            controller.seeData();
            controller.startCalculating();
            controller.getResults();
        
        }else{
            controller.printIncorrectInputMessage();
            
        }

    }
    
}
