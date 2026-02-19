/****************
MIDN Sophia Urrea
m286582
Week.java
****************/
import si211.*;//DrBrown.explode(...String pat)
import java.util.*;
import java.io.*;

/**
 *creates and fills a matrix for a schedule
 */
public class Week{
    private String[] week;
    
    /**
     *constructor for empty matrix
     */
    public Week(){
        week = new String[]{" ", "M", "T", "W", "R", "F",
        "1", " ", " ", " ", " ", " ",
        "2", " ", " ", " ", " ", " ",
        "3", " ", " ", " ", " ", " ",
        "4", " ", " ", " ", " ", " ",
        "5", " ", " ", " ", " ", " ",
        "6", " ", " ", " ", " ", " "};
        
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Week schedule = new Week();//blank matrix
        schedule.printWeek();//print blank matrix
        String command = in.next();
        String[] days;//expanded array from Dr Brown

        /**
         *command while loop
         */
        while(!command.equals("quit"))
        {
            days = DrBrown.explode(command);//convert command to array
            int len = days.length;//length of array
            for(int i = 0; i < len; i++){
                int j = schedule.addWeek(days[i]);//finds appropriate index for class period
                schedule.addClass(j);//converts index to "x"
            }
            schedule.printWeek();//prints new matrix
            command = in.next();
        }
    }

    /**
     *finds appropriate index for class period
     */
    public int addWeek(String day){
        int i = 0;
        int j = 0;
        if(day.indexOf('M') != -1)//Monday = col 1
            i = 1;
        if(day.indexOf('T') != -1)//Tuesday = col 2
            i = 2;
        if(day.indexOf('W') != -1)//Wednesday = col 3
            i = 3;
        if(day.indexOf('R') != -1)//Thursday = col 4
            i = 4;
        if(day.indexOf('F') != -1)//Friday = col 5
            i = 5;
        j = day.charAt(1) - '0';//converts period from string to int
        return i+(6*j);//index = cols + #rows*6
    }

    /**
     *prints current matrix
     */
    public void printWeek(){
        for(int i = 0; i < 42; i++){
            System.out.print(this.week[i]);
            if((i+1)%6 == 0)//end of week starts new line
                System.out.println();
            else   
                System.out.print(" ");
        }
    }

    /**
     *returns true if period is booked
     */
    public boolean checkWeek(String command){
        String days[] = DrBrown.explode(command);//converts string to array
        int len = days.length;//length of array
        for(int i = 0; i < len; i++){//goes through array checking if the period is booked
            int j = addWeek(days[i]);//finds index of class period
            if(week[j].equals("x"))//checks if booked
                return true;//return true if booked
        }
        return false;//returns false if available
    }

    /**
     *converts class period to "x"
     */
    public void addClass(int j){
        week[j] = "x";
    }
}