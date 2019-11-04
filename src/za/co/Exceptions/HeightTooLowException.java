package za.co.Exceptions;

// A Class that represents use-defined expception 
public class HeightTooLowException extends Exception 
{ 
    private final static long serialVersionUID = 101;
    public HeightTooLowException(String s) 
    { 
        // Call constructor of parent Exception 
        super(s); 
    } 
} 