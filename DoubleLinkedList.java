package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import practice.SingleLinkedList.Node;

public class DoubleLinkedList {
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
	public void addNodeAtLast(int data) {
		Node newnode=new Node(data);
		Node temp;
		if(head==null) {
			head=newnode;
			tail=head;
			head.next=null;
			head.prev=null;
		}
		else {
			temp=head;
			while(temp.next!=null) {
				temp=temp.next;
			}
			temp.next=newnode;
			newnode.prev=temp;
			tail=newnode;
			
		}
		
	}
	public void addNodeAtBeginning(int data) {
		Node newnode=new Node(data);
		Node temp;
		if(head==null) {
			head=newnode;
			tail=head;
		}
		else {
//			temp=head;
			newnode.next=head;
			head.prev=newnode;
			head=newnode;
		}
	}
	public void addNodeAfterANode(int data,int inputData) {
		Node newnode=new Node(inputData);
		Node temp,temp1,temp2;
		int found=0;
		if(head==null) {
			System.out.println("No data entered");
			return;
		}
		else {
			temp=head;
			while(temp!=null) {
				if(temp.data==data) {
					temp1=temp.next;
					temp.next=newnode;
					newnode.prev=temp;
					newnode.next=temp1;
					temp1.prev=newnode;
					found=1;
					break;
				}
				temp=temp.next;
				
			}
		}
	}
	public void printReverse() {
		Node current=tail;
		System.out.println("Display Backwords");
		while(current!=null) {
			System.out.println("Data "+current.data);
			current=current.prev;
		}
	}
	public void display() {
		Node current=head;
		System.out.println("Display Forward");
		while(current!=null) {
			System.out.println("Data "+current.data);
			current=current.next;
		}
	}
	public void deleteNodeBegginning() {
		if(head==null) {
			System.out.println("List Empty");
			return;
		}
		else {
//			temp=head;
			head=head.next;
			head.prev=null;
		}
	}
	public void deleteNodeEnd() {
		if(head==null) {
			System.out.println("List Empty");
			return;
		}
		else {
			tail=tail.prev;
			tail.next=null;
		}
	}
	public void deleteNode(int data) {
		Node prev1,current,temp;
		if(head==null) {
			System.out.println("List Empty");
			return;
		}
		else {
			prev1=head;
			current=head;
			while(current!=null) {
				if(current.data==data) {
					temp=current.next;
					prev1.next=temp;
					temp.prev=current.prev;
				}
				prev1=current;
				current=current.next;
			}
		}
	}
	public void reverse() {
		Node temp=null;
		Node current=head;
		while(current!=null) {
			temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
		}
		if (temp != null) {
            head = temp.prev;
        }
	}
	public static void main(String[] args) throws  IOException {
		// TODO Auto-generated method stub
		BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));
		
		DoubleLinkedList dlt=new DoubleLinkedList();
		System.out.println("Enter Data at last");
		for(int i=0;i<5;i++) {
			int data=Integer.parseInt(buf.readLine());
			//slt.addNodeAtBegin(data);
//			dlt.addNodeAtLast(data);
//			dlt.addNodeAtBeginning(data);
			dlt.addNodeAtLast(data);;
		}
//		System.out.println("Enter Data to be searched");
//		int data1=Integer.parseInt(buf.readLine());
//		System.out.println("Enter Data to be deleted");
//		int data=Integer.parseInt(buf.readLine());
////		dlt.addNodeAfterANode(data1, data);
//		dlt.deleteNodeEnd();
//		dlt.deleteNode(data);
//		dlt.printReverse();
		dlt.reverse();
		dlt.display();
	}

}
