import java.util.*;

public class MyException extends Exception{
    private char badChar;

    public MyException(String message, char badChar){
        super(message);
        this.badChar = badChar;
    }

    public char getBadChar(){
        return badChar;
    }
}