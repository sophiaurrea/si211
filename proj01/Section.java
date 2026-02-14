import java.util.*;
import java.io.*;
import si211.*;

public class Section{
    //create a class to represent a section
    private String course;
    private int section;
    private String periods;
    private String classroom;

    public static Queue readIn(String fname)
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

    public void printSection(String word){
        if(course.equals(word))
            //output must seperate items by a single space
            System.out.println(course + " " + section + " " + periods + " " + classroom);
    }
    
    public void printShow(){
        System.out.println(course + " " + section + " " + periods + " " + classroom);
    }

    public Section returnSection(String word, int section){
        if(course.equals(word))
        {
            if(this.section == section)
                return this;
        }
        return null;
    }

    //test functions
    public static void main(String[] args)
    {
        //printSection("sections11.txt", "SI211");
    }

    public void matrixData(Week matrix){
        String command = periods;
        String[] days = DrBrown.explode(command);
        int len = days.length;
        for(int i = 0; i < len; i++){
            int j = matrix.addWeek(days[i]);
            matrix.addClass(j);
        }
    }

    public boolean match(Section Q, String course){
        String name;
        if(course.equals("any"))
            name = Q.course;
        else    
            name = course;
        return this.course.equals(name);
    }

    public boolean checkFit(Week matrix, String course){
        if(this.course.equals(course) || course.equals("any")){
            if(matrix.checkWeek(this.periods))
                return true;
            System.out.println(this.course + " " + this.section + " " + this.periods + " " + this.classroom);
        }
        return false;
    }
}