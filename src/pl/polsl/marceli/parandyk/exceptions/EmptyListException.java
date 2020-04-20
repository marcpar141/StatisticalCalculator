package pl.polsl.marceli.parandyk.exceptions;

/**
 *  Class cointaining empty list extension
 * @version 2.0
 * @author Marceli Parandyk
 */
public class EmptyListException extends Exception{

    /**
     * Constructor launching exception
     * @param message message shown for user 
     */
    public EmptyListException(String message) {
        super(message);
    }
    
    
    
}
