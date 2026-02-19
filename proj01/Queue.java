/****************
MIDN Sophia Urrea
m286582
Queue.java
****************/
import java.util.*;
import java.io.*;

/**
 *Queue class used in previous lab for linked lists 
 */
public class Queue{
	private Node head = null;//top of linked list
	private Node tail = null;//bottom of linked list

	/**
	 * constructor for a node with section data
	 */
	private static class Node{
    	public Section data;
    	public Node next;
    	public Node(Section d, Node n) { 
        	data = d; 
        	next = n;
		}
    } 
	/**
	 * returns the section that matches the target course and section
	 */
    public Section matchCourse(String word, int section){
    	Node current = this.head;

    	while(current != null){
        	Section S = current.data.returnSection(word, section);
        	if(S != null)
          		return S;
        	current = current.next; 
        }

      	return null;
    }

	/**
	 * Searches linked list for target course
	 */
    public void searchSection(String word){   
        Node current = this.head;
        //list all sections available for that course
        while(current != null){
            current.data.printSection(word);
            current = current.next;
        }
    }

	/**
	 * prints entire linked list
	 */
    public void showSection(){   
        Node current = this.head;
        while(current != null){
            current.data.printShow();
            current = current.next;
        }
    }

    /**
    * adds s to the back of the queue
    */
    public void enqueue(Section s){
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
  	public Section dequeue(){ 
    	Section s = head.data;
    	head = head.next;
	    return s;
  	}

  	/**
   	* returns true if the queue is empty
   	*/
  	public boolean empty(){
	    return head == null;
  	}


	/**
	 * calls makeMatrix with every section from schedule
	 */
  	public void makeMatrix(Week matrix){
    	Node current = this.head;
    	while(current != null){
      		current.data.matrixData(matrix);
      		current = current.next;
    	}
  	}

	/**
	 * checks if target course fits in matrix
	 */
	public boolean check(Queue Q, Week matrix, String course){
    	boolean found = false;
    	Node temp = Q.head;
		Node current = this.head;

    	while(temp != null){
			while(current != null){
				if(!current.data.match(temp.data, course)){
					if(current.data.checkFit(matrix, course));
				}
				current = current.next;
			}
			temp = temp.next;
		}

    	return found;
  	}
}