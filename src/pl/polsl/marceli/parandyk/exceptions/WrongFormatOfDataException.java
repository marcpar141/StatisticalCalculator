package pl.polsl.marceli.parandyk.exceptions;

/**
 * Class storing WrongFormatOfDataException
 * @author Marceli Parandyk
 * @version 2.0
 */
public class WrongFormatOfDataException extends Exception{
    
    /**
     * Constructor launching exception
     * @param message message shown for user
     */
    public WrongFormatOfDataException(String message){
        super(message);
    }
    
    
    
}
