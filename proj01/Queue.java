import java.util.*;
import java.io.*;

public class Queue{
   private Node head = null;
   private Node tail = null;

   private static class Node {
    public Section data;
    public Node next;
    public Node(String d, Node n) { 
        data = d; 
        next = n;
    }
   } 

    public void matchCourse(String course)
    {
        while(next != null)
        {
            data.printSection(course);    
        }
    }

   /**
   * adds s to the back of the queue
   */
  public void enqueue(Section s) {
    if(head == null){
        head = new Node(s, null);
        tail = head;
    }else{
        Node temp = tail;
        temp.next = new Node(s, null);
        tail = temp.next;
    }
  }
  /**
   * removes and returns string from the front of the queue
   */
  public String dequeue() { 
    String s = head.data;
    head = head.next;
    return s;
  }

  /**
   * returns true if the queue is empty
   */
  public boolean empty() {
    return head == null;
  }

  public static void main(String[] args)
  {
    Queue test = new Queue();
    System.out.println(test.empty());
    test.enqueue("hello");
    test.enqueue("world");
    System.out.println(test.head.data + test.head.next.data);
    System.out.println(test.empty());
    System.out.println(test.dequeue());
    System.out.println(test.head.data);

  }
}