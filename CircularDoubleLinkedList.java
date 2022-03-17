package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import practice.CircularLinkedList.Node;

//import practice.DoubleLinkedList.Node;

public class CircularDoubleLinkedList {
	class Node{
		Node prev;
		Node next;
		int data;
		public Node(int data) {
			this.data=data;
			this.prev=null;
			this.next=null;
		}
	}
	public Node head=null;
	public Node tail=null;
	public void insertEnd(int data) {
		Node newnode=new Node(data);
		
		if(head==null) {
			head=newnode;
			head.next=head;
			tail=head;
		}
		else {
			newnode.next=tail.next;
			tail.next=newnode;
			newnode.prev=tail;
			head.prev=newnode;
			tail=newnode;
		}
	}
	public void insertBegin(int data) {
		Node newnode=new Node(data);
		Node temp=null;
		if(head==null) {
			head=newnode;
			head.next=head;
			tail=head;
		}
		else {
			temp=tail.next;
			newnode.next=head;
			newnode.prev=tail;
			tail.next=newnode;
			head.prev=newnode;
			head=newnode;
		}
	}
	public void deleteBegin() {
		Node temp;
		if(head.next==null) {
			head=null;
			return;
		}
		else {
			temp=head.next;
			tail.next=temp;
			temp.prev=tail;
			head=head.next;
		}
	}
	public void deleteEnd() {
		Node temp;
		if(head.next==null) {
			head=null;
			return;
		}
		else {
			temp=tail.prev;
			temp.next=tail.next;
			head.prev=temp;
			tail=temp;
		}
	}
	public void diplay() {
		Node current=head;
		System.out.println("Data "+current.data);
		current=current.next;
		while(current!=head) {
			System.out.println("Data "+current.data);
			current=current.next;
		}
	}
	
	public static void main(String[] args) throws  IOException {
		// TODO Auto-generated method stub
		BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));
		
		CircularDoubleLinkedList cdlt=new CircularDoubleLinkedList();
		System.out.println("Enter Data at last");
		for(int i=0;i<5;i++) {
			int data=Integer.parseInt(buf.readLine());
			//slt.addNodeAtBegin(data);
//			dlt.addNodeAtLast(data);
//			dlt.addNodeAtBeginning(data);
			cdlt.insertEnd(data);
//			cdlt.insertBegin(data);
			
		}
		cdlt.deleteEnd();
		cdlt.diplay();
	}

}
