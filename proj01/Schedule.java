/****************
MIDN Sophia Urrea
m286582
Schedule.java
****************/
import java.util.*;
import java.io.*;

/**
 *new class for a linked list schedule and cooresponding matrix
 */
public class Schedule{
    private Queue schedule;
    private Week matrix;

    /**
     *constructor blank schedule and blank matrix
     */
    public Schedule(){
        this.schedule = new Queue();
        this.matrix = new Week();
    }

    /**
     *adds class to current schedule
     */
    public void add(Queue Q, String course, int section){
        Section S = Q.matchCourse(course, section);//returns target class from list of all classes
        if(S == null){//error if not found
            System.out.println("Error! Section not found!");
        }else{//adds to back of schedule linked list
            this.schedule.enqueue(S);
        }
    }
    /**
     *calls showSection with schedule
     */
    public void show(){
        schedule.showSection();
    }
    /**
     *calls makeMatrix with schedule and matrix
     */
    public void makeWeek(){
        schedule.makeMatrix(matrix);
    }

    /**
     *calls check for fit with schedule and matrix
     */
    public boolean fit(Queue Q, String course){
        return schedule.check(Q, matrix, course);
    }
    
    /**
     *calls printWeek with matrix
     */
    public void print(){
        matrix.printWeek();
    }
}
