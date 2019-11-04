package za.co.Exceptions;

// A Class that represents use-defined expception 
public class TypeNotFoundException extends Exception 
{ 
    private final static long serialVersionUID = 103;
    public TypeNotFoundException(String s) 
    { 
        // Call constructor of parent Exception 
        super(s); 
    } 
} 