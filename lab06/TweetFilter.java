//MIDN Sophia Urrea m286582
//MIDN Nick Hogan m282850
import java.util.*;
import java.io.*;
import si211.*;

public class TweetFilter extends TweetParser{

    public TweetFilter() {
        super();
    }

    public TweetFilter(Scanner sc) {
        super(sc);
    }

    public TweetFilter filter(String s) {
        TweetFilter result = new TweetFilter();
        TweetQueue.Iter list = iterator();

        while(list.hasNext()) {
            Tweet t = list.next();
            if (t.getText().indexOf(s) != -1) {
                result.enqueue(t);
            }
        }

        return result;
    }

    public TweetFilter copy()
    {
        TweetFilter result = new TweetFilter();
        TweetQueue.Iter list = iterator();

        while(list.hasNext()) {
            Tweet t = list.next();
            result.enqueue(t);
        }

        return result;
    }

    public TweetFilter notFilter(String s) {
        TweetFilter result = new TweetFilter();
        TweetQueue.Iter list = iterator();

        while(list.hasNext()) {
            Tweet t = list.next();
            if (t.getText().indexOf(s) == -1) {
                result.enqueue(t);
            }
        }

        return result;
    }
}
