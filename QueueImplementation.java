//package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Node<E>{
	E data;
	Node<E> next;
	public Node(E data) {
		this.data=data;
		this.next=null;
	}
}
class Queue<E>{
	Node<E> head=null;
	Node<E> tail=null;
	int size=0;
	public void add(E data) {
		Node<E> newnode=new Node<>(data);
		if(head==null) {
			head=newnode;
			tail=newnode;
			size++;
		}
		else {
			tail.next=newnode;
			tail=newnode;
			size++;
		}
	}
	public void remove() {
		Node<E> temp;
		if(isEmpty()) {
			return;
		}
		else {
			head=head.next;
			size--;
		}
	}
	public E poll() {
		E temp;
		if(isEmpty()) {
			return null;
		}
		else {
			temp=head.data;
			head=head.next;
			return temp;
		}
	}
	public boolean isEmpty() {
		if(head==null)
			return true;
		else
			return false;
	}
	public int size() {
		return this.size;
	}
	public void display() {
		Node<E> current=head;
		while(current!=null) {
			System.out.println(current.data);
			current=current.next;
		}
	}
	public E peek() {
		E temp;
		if(isEmpty())
			return null;
		else
		{
			temp=head.data;
			return temp;
		}
	} 
	
}
public class QueueImplementation {

	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		Queue<Integer> q=new Queue<>();
		for(int i=0;i<5;i++) {
			q.add(Integer.parseInt(br.readLine()));
		}
		q.display();
	}
		

	}
