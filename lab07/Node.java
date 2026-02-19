import java.util.*;

public class Node
{
    private Thing data;
    private Node next;
    
    public Node(Thing data, Node next){
        this.data = data;
        this.next = next;
    }

    public void printNode(){
        for(Node T = this; T != null; T = T.next)
            T.data.printThing();
    }

    public void move(int i){
        // move each thing
      for(Node T = this; T != null; T = T.next)
      {
	    T.data.maybeTurn(i);
	    T.data.step();
      } 
    }
}