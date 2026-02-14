import java.util.*;
import java.io.*;

public class Queue{
   private Node head = null;
   private Node tail = null;

   private static class Node {
    public Section data;
    public Node next;
    public Node(Section d, Node n) { 
        data = d; 
        next = n;
    }
   } 

    public Section matchCourse(String word, int section)
    {
      Node current = this.head;

      while(current != null)
      {
        Section S = current.data.returnSection(word, section);
        if(S != null)
          return S;
        current = current.next; 
      }

      return null;
    }

    public void searchSection(String word)
    {   
        Node current = this.head;
        //list all sections available for that course
        while(current != null){
            current.data.printSection(word);
            current = current.next;
        }
    }

    public void showSection()
    {   
        Node current = this.head;
        //list all sections available for that course
        while(current != null){
            current.data.printShow();
            current = current.next;
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
  public Section dequeue() { 
    Section s = head.data;
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
    /*
    Queue test = new Queue();
    System.out.println(test.empty());
    test.enqueue("hello");
    test.enqueue("world");
    System.out.println(test.head.data + test.head.next.data);
    System.out.println(test.empty());
    System.out.println(test.dequeue());
    System.out.println(test.head.data);
    */
  }

  public void makeMatrix(Week matrix){
    Node current = this.head;
    while(current != null){
      current.data.matrixData(matrix);
      current = current.next;
    }
  }

  public boolean check(Queue Q, Week matrix, String course){
    boolean found = false;
    Node current = null;
    Node temp = Q.head;
    while(temp != null){
      current = this.head;
      // found = false;
      while(current != null){
        if(current.data.match(temp.data, course)){
          found = true;
          break;
        }
        current = current.next;
      }
      if(found && course.equals("any")){
        Section hold = temp.data;
        while(hold.match(temp.data, course))
          temp = temp.next;
      }else
        temp = temp.next;
    }

    current = Q.head;
    while(current != null){
      current.data.checkFit(matrix, course);
      current = current.next;
    }
    return found;
  }
}