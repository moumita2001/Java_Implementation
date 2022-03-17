package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
 class Node <E>{
	E data;
	Node<E> next;
	public Node(E data) {
		this.data=data;
		this.next=null;
	}
}
class Stack<E>{
	int size=0;
	Node<E> head=null;
	public void push(E data) {
		Node<E> newnode=new Node<>(data);
		if(isEmpty()) {
			head=newnode;
			size++;
		}
		else {
			newnode.next=head;
			head=newnode;
			size++;
		}
	}
	public E pop() {
		E temp;
		if(isEmpty()) {
			return null;
		}
		temp=head.data;
		head=head.next;
		size--;
		return temp;
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
	public boolean isEmpty() {
		if(head==null)
			return true;
		else
			return false;
	}
	public int search(E data) {
		Node<E> current=head;
		int index=-1,temp=-1;
		while(current!=null) {
			if(current.data==data) {
				temp=index;
				break;
			}
			index++;
			current=current.next;
		}
		return temp;
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
}
public class StackImplementation{
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		Stack<Integer> st=new Stack<>();
//		char ch='y';
		for(int i=0;i<5;i++) {
			st.push(Integer.parseInt(br.readLine()));
//			System.out.println("Do you want to enter more");
//			ch=(char)br.read();
		}
		st.display();
	}
}
