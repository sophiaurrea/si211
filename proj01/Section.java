/****************
MIDN Sophia Urrea
m286582
Section.java
****************/
import java.util.*;
import java.io.*;
import si211.*;

/**
 *create a class to represent a section
 */
public class Section{
    private String course;
    private int section;
    private String periods;
    private String classroom;

    /**
     *creates a linked list of sections for each course in file
     */
    public static Queue readIn(String fname){
        /**
         *open filename taking in from args
         */
        Scanner sc = null;
        try { sc = new Scanner(new FileReader(fname)); } 
        catch(IOException e) { e.printStackTrace(); System.exit(1); }
        
        /**
         *fill linked list
         */
        Queue Q = new Queue();
        int i = 0;
        while(sc.hasNext()){//until file is empty
            Section S = new Section();
            S.course = sc.next();
            S.section = sc.nextInt(); 
            S.periods = sc.next();
            S.classroom = sc.next();
            Q.enqueue(S);//add to back of linked list
        }
        
        return Q;
    }

    /**
     *prints section as string if it matches target course
     */
    public void printSection(String word){
        if(course.equals(word))
            //output must seperate items by a single space
            printShow();
    }
    
    /**
     *prints section as string
     */
    public void printShow(){
        System.out.println(course + " " + section + " " + periods + " " + classroom);
    }

    /**
     *returns section if it matches course and section
     */
    public Section returnSection(String word, int section){
        if(course.equals(word)){
            if(this.section == section)
                return this;
        }
        return null;
    }

    /**
     *adds section to current matrix
     */
    public void matrixData(Week matrix){
        String[] days = DrBrown.explode(periods);//turns periods into array
        int len = days.length;
        for(int i = 0; i < len; i++){
            int j = matrix.addWeek(days[i]);
            matrix.addClass(j);//adds class into matrix
        }
    }

    /**
     *returns true if current course is same as target course
     */
    public boolean match(Section Q, String course){
        String name;
        if(course.equals("any"))
            name = Q.course;//target course is current course in list of all classes
        else    
            name = course;//target course is already defined
        return this.course.equals(name);
    }

    /**
     *returns true if period is booked and prints the course if it fits
     */
    public boolean checkFit(Week matrix, String course){
        if(this.course.equals(course) || course.equals("any")){
            
            if(matrix.checkWeek(this.periods))
                return true;
            else
                System.out.println(this.course + " " + this.section + " " + this.periods + " " + this.classroom);
        }
        return false;
    }

    /**
     * returns course
     */
    public String getCourse(){
        return course;
    }
}