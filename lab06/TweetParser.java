//MIDN Sophia Urrea m286582
//MIDN Nick Hogan m282850
import java.util.*;
import java.io.*;
import si211.*;

public class TweetParser extends TweetQueue{

    public TweetParser() {
        super();
    }
    
    public TweetParser(Scanner sc) {
        while (sc.hasNextLine()) {
            super.enqueue(Tweet.read(sc));
        }
    }

    public void dump() {
        TweetQueue.Iter list = iterator();

        while (list.hasNext()) {
            System.out.println(list.next().toString());
        }
    }    

    public int tweetCount() {
        TweetQueue.Iter list = iterator();
        int i = 0;

        while (list.hasNext()) {
            i++;
            list.next();
        }

        return i;
    }

    public static void main(String[] args) {
        Scanner sc = null;
        try { sc = new Scanner(new FileReader(args[0])); } 
        catch(IOException e) { e.printStackTrace(); System.exit(1); }

        TweetParser test = new TweetParser(sc);
        System.out.println(test.tweetCount() + " tweets");
        System.out.println("Test Dump");
        test.dump();
    }
}