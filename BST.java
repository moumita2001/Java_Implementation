

class Node2{
	int data;
	Node2 left,right;
	public Node2(int data) {
		this.data=data;
		this.left=null;
		this.right=null;
	}
}
class BinarySearchTree{

	Node2 root=null;
	public void insert(int data) {
		root=insertion(root,data);
	}
	public Node2 insertion(Node2 root,int data)
	{
		
		if(root==null) {
			Node2 newnode=new Node2(data);
			root=newnode;
			System.out.println("Inserted:"+data);
			
			return root;
		}
	
			if(data>root.data) {
			root.right=	insertion(root.right,data);
			}
			else {
			root.left=	insertion(root.left,data);
			}
			return root;
		
	}
	public boolean isEmpty() {
		if(root==null) 
			return true;
		else
			return false;
	}
	public void displayPreOrder() {
		preorder(root);
	}
	public void preorder(Node2 root) {
		if(root==null) {
			return;
		}
			System.out.print(" "+root.data);
			preorder(root.left);
			preorder(root.right);
		
	}
	public void displayPostOrder() {
		postorder(root);
	}
	public void postorder(Node2 root) {
		if(root==null) {
			return;
		}
			
			
			postorder(root.left);
			postorder(root.right);
			System.out.print(" "+root.data);
		
	}
	public void displayInorder() {
		inorder(root);
	}
	public void inorder(Node2 root) {
		if(root==null) {
			return;
		}
			
			
			inorder(root.left);
			System.out.print(" "+root.data);
			inorder(root.right);
		}
	
	public int height() {
		int h=heightTree(root);
		return h;
	}
	public int heightTree(Node2 root) {
		if(root==null) {
			return -1;
		}
		return 1+Math.max(heightTree(root.left), heightTree(root.right));
	}
//	
	
}
public class BST {

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		 	tree.insert(50);
	        tree.insert(30);
	        tree.insert(20);
	        tree.insert(40);
	        tree.insert(70);
	        tree.insert(60);
	        tree.insert(80);
	        System.out.println("PreOrder Tranversal");
	        tree.displayPreOrder();
	        System.out.println();
	        System.out.println("PostOrder Tranversal");
	        tree.displayPostOrder();
	        System.out.println();
	        System.out.println(tree.height());
	}

}
