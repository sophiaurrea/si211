import si211.*;//DrBrown.explode(...String pat)
import java.util.*;
import java.io.*;

public class Week{
    private String[] week;
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
        Week schedule = new Week();
        schedule.printWeek();
        String command = in.next();
        String[] days;
        while(!command.equals("quit"))
        {
            days = DrBrown.explode(command);
            int len = days.length;
            for(int i = 0; i < len; i++){
                schedule.addWeek(days[i]);
            }
            schedule.printWeek();
            command = in.next();
        }
    }

    public int addWeek(String day){
        int i = 0;
        int j = 0;
        if(day.indexOf('M') != -1){
            i = 1;
        }
        if(day.indexOf('T') != -1){
            i = 2;
        }
        if(day.indexOf('W') != -1){
            i = 3;
        }
        if(day.indexOf('R') != -1){
            i = 4;
        }
        if(day.indexOf('F') != -1){
            i = 5;
        }
        j = day.charAt(1) - '0';
        return i+(6*j);
    }

    public void printWeek(){
        for(int i = 0; i < 42; i++){
            System.out.print(this.week[i]);
            if((i+1)%6 == 0)
                System.out.println();
            else   
                System.out.print(" ");
        }
    }

    public boolean checkWeek(String periods){
        String command = periods;
        String days[] = DrBrown.explode(command);
        int len = days.length;
        for(int i = 0; i < len; i++){
            int j = addWeek(days[i]);
            if(week[j].equals("X"))
                return true;
        }
        return false;
    }

    public void addClass(int j){
        week[j] = "X";
    }
}