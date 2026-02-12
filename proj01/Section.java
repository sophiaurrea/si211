import java.util.*;
import java.io.*;

public class Section{
    //create a class to represent a section
    private String course;
    private int section;
    private String periods;
    private String classroom;

    public static Queue[] readIn(String fname)
    {
        //open filename taking in from args
        Scanner sc = null;
        try { sc = new Scanner(new FileReader(fname)); } 
        catch(IOException e) { e.printStackTrace(); System.exit(1); }
        
        //fill array
        Queue Q = new Queue();
        int i = 0;
        while(sc.hasNext())
        {
            Section S = new Section();
            S.course = sc.next();
            S.section = sc.nextInt(); 
            S.periods = sc.next();
            S.classroom = sc.next();
            Q.enqueue(S);
        }
        
        return Q;
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