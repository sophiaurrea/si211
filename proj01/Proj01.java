/****************
MIDN Sophia Urrea
m286582
Proj01.java
****************/
import java.util.*;
import java.io.*;
import si211.*;

public class Proj01{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Queue S = Section.readIn(args[0]);//fills linked list from file
        Schedule classes = new Schedule();//empty schedule with blank matrix

        /**
         *command while loop
         */
        System.out.print("> ");
        String command = in.next();
        while(!command.equals("quit")){
            if(command.equals("sections")){
                String course = in.next();//takes in target course
                S.searchSection(course);//searches list of all classes for course

            }else if(command.equals("add")){
                String course = in.next();//takes in target course
                int section = in.nextInt();//takes in target section
                classes.add(S, course, section);//adds course and section to current schedule
                classes.makeWeek();//updates matrix

            }else if(command.equals("show")){
                classes.show();//prints current schedule without matrix

            }else if(command.equals("week")){
                classes.print();//prints current matrix without schedule

            }else if(command.equals("fit")){
                String course = in.next();//takes in target course
                if(classes.fit(S, course)){//if course doesnt fit in schedule
                    System.out.println("No room!");
                }

            }else{
                System.out.println("Unknown command: " + command);//unkown command
            }

            System.out.print("> ");
            command = in.next();
        }
    }
}