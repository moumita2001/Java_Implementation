package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SingleLinkedList {
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
	
	public void addNodeAtLast(int data) {
		Node newnode=new Node(data);
		if(head==null) {
			head=newnode;
			tail=newnode;
			
		}
		else {
			tail.next=newnode;
			tail=newnode;
		}
	}
	public void deleteNodeAtLast() {
		Node current=head;
		Node prev=head;
		if(head==null) {
			System.out.println("Linked List Empty");
			return;
		}
		if(head.next==null) {
			head=null;
			return;
		}
		do {
			prev=current;
			current=current.next;
		}while(current.next!=null);
		prev.next=null;
		
	}
	public void deleteNodeAtBegginning() {
		if(head==null) {
			System.out.println("Linked List Empty");
			return;
		}
		Node temp=head.next;
		head=head.next;
		
	}
	public void deleteAfterANode(int data) {
		Node current=head;
		Node prev=current;
		int found=0;
		while(current.next!=null) {
			
			if(current.data==data) {
				prev.next=current.next;
				found=1;
				return;
			}
			prev=current;
			current=current.next;
		}
	}
	public void addAfteraNode(int data1,int inputData) {
		Node newnode=new Node(inputData);
		Node current=head,temp;
		int found=0;
		if(head==null) {
			System.out.println("No data to be entered after");
			return;
		}
		else {
			
			while(current!=null) {
				if(current.data==data1) {
					temp=current.next;
					current.next=newnode;
					newnode.next=temp;
					found=1;break;
				}
				current=current.next;
			}
		}
		if(current==null) {
			System.out.println("Data not found");
			return;
		}
	}
	public void addNodeAtBegin(int data) {
		 Node temp=null;
		Node newnode=new Node(data);
		if(head==null) {
			head=newnode;
			tail=newnode;
		}
		else {
			temp=head;
			head=newnode;
			head.next=temp;
			
		}
	}
	public void display() {
		Node current=head;
		while(current!=null) {
			System.out.println("Data "+current.data);
			current=current.next;
		}
	}
	public static void main(String[] args) throws  IOException {
		// TODO Auto-generated method stub
		BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));
		
		SingleLinkedList slt=new SingleLinkedList();
		System.out.println("Enter Data at last");
		for(int i=0;i<5;i++) {
			int data=Integer.parseInt(buf.readLine());
			//slt.addNodeAtBegin(data);
			slt.addNodeAtLast(data);
		}
//		System.out.println("Enter Data to be searched");
//		int data1=Integer.parseInt(buf.readLine());
		System.out.println("Enter Data to be deleted");
		int data=Integer.parseInt(buf.readLine());
//		slt.addAfteraNode(data1, inputData);
//		slt.deleteNodeAtLast();
//		slt.deleteNodeAtBegginning();
		slt.deleteAfterANode(6);
		slt.display();
		
		
	}

}
