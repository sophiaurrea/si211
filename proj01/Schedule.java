import java.util.*;
import java.io.*;

public class Schedule{
    private Queue schedule;

    public Schedule(){
        this.schedule = new Queue();
    }

    public void add(Queue Q, String course, int section){
        Section S = Q.matchCourse(course, section);
        if(S == null){
            System.out.println("Error! Section not found!");
        }else{
            this.schedule.enqueue(S);
        }
    }

    public void show(){
        Queue current = this.schedule;
        current.showSection();
    }

    public void makeWeek(Week matrix){
        schedule.makeMatrix(matrix);
    }

    public boolean fit(Queue Q, Week matrix, String course){
        return schedule.check(Q, matrix, course);
    }
}
