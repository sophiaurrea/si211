import java.util.*;
import java.io.*;

public class Section{
    //create a class to represent a section
    private String course;
    private int section;
    private String periods;
    private String classroom;

    public static Section[] readIn(String fname)
    {
        //open filename taking in from args
        Scanner sc = null;
        try { sc = new Scanner(new FileReader(fname)); } 
        catch(IOException e) { e.printStackTrace(); System.exit(1); }
        
        //fill array
        Section[] S = new Section[11];
        for(int i = 0; i < 11; i++)
        {
            S[i] = new Section();
            S[i].course = sc.next();
            S[i].section = sc.nextInt(); 
            S[i].periods = sc.next();
            S[i].classroom = sc.next();
        }
        
        return S;
    }

    public void printSection(String word)
    {   
        //list all sections available for that course
        if(course.equals(word))
            //output must seperate items by a single space
            System.out.println(course + " " + section + " " + periods + " " + classroom);
    }
    //test functions
    public static void main(String[] args)
    {
        //printSection("sections11.txt", "SI211");
    }
}