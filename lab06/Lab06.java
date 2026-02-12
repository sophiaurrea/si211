//MIDN Sophia Urrea m286582
//MIDN Nick Hogan m282850

import java.util.*;
import java.io.*;
import si211.*;

public class Lab06{
    public static void main(String[] args){
        //must print a prompt (including # of tweets) 
        if(args.length == 0){
            System.out.println("usage: java Lab06 <filename>");
            return;
        }
        
        Scanner sc = null;
        try { sc = new Scanner(new FileReader(args[0])); } 
        catch(IOException e) { e.printStackTrace(); System.exit(1); }

        TweetFilter tweets = new TweetFilter(sc);
        TweetFilter filtered = tweets.copy();
        System.out.println(tweets.tweetCount() + " tweets");
        System.out.print("> ");
        Scanner cmd = new Scanner(System.in);
        String input = cmd.next();

        while(!(input.equals("quit")))
        {
            if(input.equals("dump")){
                filtered.dump();
            }else if(input.equals("filter")){
                String s = cmd.next();
                filtered = filtered.filter(s);
            }else if(input.equals("filter!")){
                String s = cmd.next();
                filtered = filtered.notFilter(s);
            }else if(input.equals("reset")){
                filtered = tweets.copy();
            }
            System.out.println(filtered.tweetCount() + " tweets");
            System.out.print("> ");
            input = cmd.next();
        }
        //The user can give the "dump" commands over and over again and should see all the data each time.
        //The input file (given as a command-line argument) can only be read once by the program, and if no argument is given, the program must print a nice usage message and exit. Similarly, if the file can't be opened for some reason, an error message should be printed.
        //You must use the Tweet and TweetQueue classes. You should not use any linked-list (or array) code other than TweetQueue. You can build off of it, of course.

    }
}