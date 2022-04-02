package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Node1{
	String data;
	Node1 next;
	public Node1(String data) {
		this.data=data;
		this.next=null;
	}
}


class PriorityQueue {
	Node1 head=null;
	Node1 tail=null;
	public void add(String data) {
		Node1 newnode=new Node1(data);
		Node1 temp=null;
		int len=getLength(data);
		
		if(isEmpty()) {
			head=newnode;
		}
		else if(getLength(head.data)>len) {
			temp=head.next;
			newnode.next=head;
			head=newnode;
			
		}
		else {
			Node1 current=head.next;
			Node1 prev=head;
			boolean found=false;

			while(current!=null) {
				if(getLength(current.data)<len) {
					current=current.next;
					prev=prev.next;
				}
				else {
					prev.next=newnode;
					newnode.next=current;
					found=true;
					break;
				}
			
			}
			if(!found) {
				prev.next=newnode;
			}
			
		}
	}
	public boolean isEmpty() {
		if(head==null)
			return true;
		else
			return false;
	}
	public int getLength(String str) {
		return str.length();
	
	}
	public void display() {
		Node1 current=head;
		while(current!=null) {
			System.out.println(current.data);
			current=current.next;
		}
	
	}
	public void remove() {
		Node1 current=head;
		Node1 prev=head;
		while(current.next!=null) {
			prev=current;
			current=current.next;
		}
		prev.next=null;
	}
	public String poll() {
		Node1 temp=head;
		head=head.next;
		return temp.data;
	}
	public String peek() {
		return head.data;
	}
	public void getQueue() {
		Node1 current=head;
		while(current!=null) {
			System.out.println(""+current.data+"");
			current=current.next;
		}
	}
	public boolean contains(String str) {
		Node1 current=head;
		boolean found=false;
		while(current!=null) {
			if(current.data.equals(str)) {
				found=true;
				break;
			}
			current=current.next;
		}
		return found;
	}
	public void clear() {
		head=null;
	}
	public int getLocation(String str) {
		int c=0;
		boolean found=false;
		Node1 current=head;
		while(current!=null) {
			if(current.data.equals(str)) {
				found=true;
				break;
			}
			c++;
			current=current.next;
		}
		if(found)
			return c;
		else
			return -1;
	}
	public String getValue(int index) {
		Node1 current=head;
		String value=null;
		int c=0;
		while(current!=null) {
			if(c==index) {
				value=current.data;
				break;
			}
			c++;
			current=current.next;
		}
		return value;
	}
}
public class PriorityQueueImplementation{
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		PriorityQueue pq=new PriorityQueue();
		while (true) {
		     
		     System.out.println("enter 1 to enter data into PriorityQueue: ");
		     System.out.println("enter 2 to remove element from PriorityQueue: ");
		     System.out.println("enter 3 to peek element from PriorityQueue: ");
		     System.out.println("enter 4 to see all the elements in the PriorityQueue: ");
		     System.out.println("enter 5 to get the nth element in the PriorityQueue: ");
		     System.out.println("enter 6 to check if the element if present or not");
		     System.out.println("enter 7 to get the location of the given element: ");
		     System.out.println("enter 8 to clear the PriorityQueue: ");
		     
		     int ch = Integer.parseInt (br.readLine ());
		     
		     switch (ch) {
		          
		          case 1:
		               String value =br.readLine ();
		               pq.add (value);
		          break;
		          
		          case 2:
		              	pq.remove();
		          break;
		          
		          case 3:
		               System.out.println(pq.peek ());;
		          break;
		          
		          case 4:
		               pq.getQueue ();
		          break;
		          
		          case 5:
		               System.out.println("enter the location where you want to get the element: ");
		               int n = Integer.parseInt (br.readLine ());
		               String v = pq.getValue(n);
		               System.out.println(v);
		          break;
		          
		          case 6:
		               System.out.println("enter the target which you want to search for: ");
		               if (pq.contains (br.readLine ())) {
		                    System.out.println("Yes");
		               } else {
		                    System.out.println("Not present");
		               }
		               
		          break;
		          
		          case 7:
		        	  String data =br.readLine ();
		        	  System.out.println(data+": "+pq.getLocation(data));
		          break;
		          
		          case 8:
		               pq.clear ();
		               break;
		               
		          default: break;
		          
		     }
		}


