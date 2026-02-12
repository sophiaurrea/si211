import java.util.*;
import java.io.*;

public class Proj01{
    public static void main(String[] args)
    {
        //printSection("sections11.txt", "SI211");
        Scanner in = new Scanner(System.in);

        //create array
        Queue S = Section.readIn(args[0]);

        //take command until quit
        System.out.print("> ");
        String command = in.next();
        while(!command.equals("quit"))
        {
            //error message for wrong input
            if(!command.equals("sections")){
                System.out.println("Unknown command: " + command);
            }else{
                String course = in.next();
                for(int i = 0; i < 11; i++)
                    S[i].printSection(course);
            }
            System.out.print("> ");
            command = in.next();
        }
    }
}