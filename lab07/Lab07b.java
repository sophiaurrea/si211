import java.util.*;

public class Lab07b
{
    public static Random rand = new Random(System.currentTimeMillis());

    public static void main(String args[]){
        int N = 200;
        if(args.length != 0) 
            N = Integer.parseInt(args[0]);
        
        Node L = null;
        int count = 0;
        while(true)
        {
            int i = rand.nextInt(3);

            // every N rounds add another typeA and typeB Thing
            if (count % N == 0)
            {
                Thing tA = new Thing(45, 50, 'r');
                Node nA = new Node(tA, L);
                L = nA;

                ThingB tB = new ThingB(55, 50, 'b');
                Node nB = new Node(tB, L);
                L = nB;
            }

            //print out each thing
            L.printNode();
            System.out.println("done");
            System.out.flush();        
            L.move(i);
            count++;
        }  
    }  
}

