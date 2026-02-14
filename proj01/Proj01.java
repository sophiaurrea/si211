import java.util.*;
import java.io.*;

public class Proj01{
    public static void main(String[] args)
    {
        //printSection("sections11.txt", "SI211");
        Scanner in = new Scanner(System.in);

        //create linked list
        Queue S = Section.readIn(args[0]);
        Schedule classes = new Schedule();
        Week matrix = new Week();

        //take command until quit
        System.out.print("> ");
        String command = in.next();
        while(!command.equals("quit"))
        {
            //error message for wrong input
            //if(!command.equals("sections")){
                //System.out.println("Unknown command: " + command);
            //}else if{
            if(command.equals("sections")){
                String course = in.next();
                Queue Q = S;
                Q.searchSection(course);
            }else if(command.equals("add")){
                String course = in.next();
                int section = in.nextInt();
                classes.add(S, course, section);
            }else if(command.equals("show")){
                classes.show();
            }else if(command.equals("week")){
                classes.makeWeek(matrix);
            }else if(command.equals("fit")){
                String course = in.next();
                if(course.equals("any")){
                    System.out.println("hold");
                }else{
                    if(classes.fit(S, matrix, course)){//doesnt fit
                        System.out.println("Doesnt fit!");
                    }
                }
            }else{
                System.out.println("Unknown command: " + command);
            }
            System.out.print("> ");
            command = in.next();
        }
    }
}