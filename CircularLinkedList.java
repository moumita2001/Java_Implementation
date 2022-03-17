package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//import practice.SingleLinkedList.Node;

public class CircularLinkedList {
	public class Node{
		int data;
		Node next;
		public Node(int data) {
			this.data=data;
			this.next=null;
		}
	}
	public Node head=null;
	public Node tail=null;
	public void insertAtEnd(int data) {
		Node newnode=new Node(data);
		Node current=head,temp=null;
		if(head==null) {
			head=newnode;
			head.next=head;
			tail=head;
		}
		else {
				temp=tail.next;
				newnode.next=temp;
				tail.next=newnode;
				tail=newnode;
			}
		}
	public void insertAtBegin(int data) {
		Node newnode=new Node(data);
		Node current=head,temp=null;
		if(head==null) {
			head=newnode;
			head.next=head;
			tail=head;
		}
		else {
			tail.next=newnode;
			newnode.next=head;
			head=newnode;
		}
	}
	public void insertAfterANode(int data,int inputData) {
		Node newnode=new Node(inputData);
		Node current=head,temp=null;
		if(head==null) {
			System.out.println("no data");
			return;
		}
		if(tail.data==data) {
			insertAtEnd(inputData);
		}
		else {
			while(current!=tail) {
				if(current.data==data) {
					temp=current.next;
					newnode.next=temp;
					current.next=newnode;
				}
				current=current.next;
			}
		}
	}
	public void deleteBegin() {
		Node current=head;
		if(head==null) {
			System.out.println("No data");
			return;
		}
		else {
			tail.next=head.next;
			head=head.next;
		}
	}
	public void display() {
		Node current=head;
		System.out.println("Data "+current.data);
		current=current.next;
		while(current!=head) {
			System.out.println("Data "+current.data);
			current=current.next;
		}
	}
	public void deleteEnd() {
		Node current=head,prev=head;
		if(head==null) {
			System.out.println("No data");
			return;
		}
		else {
			
			while(current!=tail) {
				prev=current;
				current=current.next;
			}
			prev.next=tail.next;
			tail=prev;
			
		}
	}
	
	public static void main(String[] args) throws  IOException {
		// TODO Auto-generated method stub
BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));
		
		CircularLinkedList clt=new CircularLinkedList();
		System.out.println("Enter Data at last");
		for(int i=0;i<5;i++) {
			int data=Integer.parseInt(buf.readLine());
//			clt.insertAtBegin(data);
			clt.insertAtEnd(data);
		}
//		System.out.println("Enter Data to be searched");
//		int data1=Integer.parseInt(buf.readLine());
//		System.out.println("Enter Data to be deleted");
//		int data=Integer.parseInt(buf.readLine());
//		clt.insertAfterANode(data1, data);
//		clt.deleteBegin();
		clt.deleteEnd();
		clt.display();

	}

}
