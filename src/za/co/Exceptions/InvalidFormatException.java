package za.co.Exceptions;

// A Class that represents use-defined expception. RuntimeException is unchecked
public class InvalidFormatException extends RuntimeException 
{ 
    private final static long serialVersionUID = 104;
    public InvalidFormatException(String s) 
    { 
        // Call constructor of parent Exception 
        super(s); 
    } 
} 