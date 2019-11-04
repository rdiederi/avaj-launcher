package za.co.Exceptions;

// A Class that represents use-defined expception 
public class InvalidCoordinateException extends Exception 
{ 
    private final static long serialVersionUID = 102;
    public InvalidCoordinateException(String s) 
    { 
        // Call constructor of parent Exception 
        super(s); 
    } 
} 