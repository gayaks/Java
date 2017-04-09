import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;


public class BinarySearchTree {
	public static Node root;
	
	public BinarySearchTree() {
		root = null;
	}
	
	
	private void insert(int data) {
		Node newNode = new Node(data);
		
		if (root == null) { 
			root = newNode;
			return;
		}
		
		// current to parent to maintain child-parent relationship
		Node current = root;
		Node parent = null;
		
		while(true) {
			parent = current;
			
			if (data > current.data) {
				current = current.right;
				if (current == null) {
					parent.right = newNode;
					return;
				}
			} else {
				current = current.left;
				if (current == null) {
					parent.left = newNode;
					return;
				}
			}				
		}				
	}
	
	/**
	 *
	 * @param root root element of the node
	 * @param rpre preorder flag - recursive mode
	 * @param rpost post order flag - recursive mode
	 * @param rin inorder flag - recursive mode
	 * @param iterative inorder - iterative
	 * @param ipre preorder - iterative
	 * @param ipost postorder - iterative
	 */
	private void display(Node root,boolean rpre,boolean rpost,boolean rin,boolean iterative,boolean ipre,
			boolean ipost) {
		if (root == null) {
			System.out.println("BST is empty!!");			
		}
		
		if (iterative) {
			// inroder stack implmentation
			System.out.println("Displaying inorder - stack implementation");
			displayIterative(root);
		}
		
		if (rin) {
			System.out.println("printing in recursive inorder");
			displayInRecursive(root);
		}
		
		if (rpre) {
			System.out.println("printing in recursive preorder");
			displayPreRecursive(root);
		}
	}
	
	private void displayIterative(Node root) {
		Node current = root;
		Stack<Node> nodes = new Stack<Node>();
		int count = 0;
		
		// track the path 
		while (current != null) {
			nodes.push(current);
			current = current.left;			
		}
		
		while (nodes.size() > 0) {
			Node node = nodes.pop();
			System.out.println(node.data);
			count++;
			
			
			// Traverse the right subtree
			if (node.right != null) {
				node = node.right;
				
				while(node != null) {
					nodes.push(node);
					node = node.left;
				}
				//System.out.println(node.data);
			}
		}
		System.out.println("Number of nodes : " + count);
	}
	
	private void displayInRecursive(Node root) {
		
		if (root != null) {
			displayInRecursive(root.left);
			System.out.println(root.data);
			displayInRecursive(root.right);
		}
	}
	
	private void displayPreRecursive(Node root) {
		
		if (root != null) {
			displayInRecursive(root.left);			
			displayInRecursive(root.right);
			System.out.println(root.data);
		}
	}
	
	// The right most of the right subtree will be maximum element in the tree
	private void maxElement(Node root) {
		if (root!= null) {
			Node current = root;
			
			while(current.right != null) {
				current = current.right;
			}
			System.out.println("Maximum elememt : " + current.data);
		}		
	}
	
	private int height(Node root) {
		if (root != null) {
			// compute height of left subtree and right subtree
			// maximum of left subtree or right subtree
			return 1+ max(height(root.left),height(root.right));
		}
		return 0;
	}
	
	private int depthOfTree(Node node) {
		return 0;
	}
	
	private int max(int left, int right) {
		return left > right ? left : right;
	}
	
	// The left most of the left subtree will be the minimum element in the tree
	private void minElement(Node root) {
		if (root != null) {
			Node current = root;
			
			while(current.left != null) {
				current = current.left;
			}
			
			System.out.println("Minimum elelment : " + current.data);
		}
	}
	
	private int countNodes(Node root) {
		if (root != null) {
			return 1+countNodes(root.left)+countNodes(root.right);
		} else {
			return 0;
		}
	}
	
	private Node findById(int id) {
		if (root != null) {
			Node cur = root;
			while (cur != null) {
				if (id == cur.data) 
					return cur;
				else if (id > cur.data)
					cur = cur.right;
				else
					cur = cur.left;
			}
			return null;
		}
		return null;
	}
	
	private int diffBtwNodes(Node n1, Node n2) {
		if (n1 != null && n2 != null) {
			n1 = findById(n1.data);
			n2 = findById(n2.data);
			return n1.data > n2.data ? (n1.data - n2.data) : (n2.data - n1.data);
		}
		return 0;
	}
	
	
	
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		//bst.insert(4);
		//bst.insert(6);bst.insert(1);bst.insert(5);bst.insert(2);bst.insert(7);bst.insert(8);bst.insert(9);
		int input[] = {4,6,1,5,2,7,8,9};
		for (int i = 0; i < input.length; i++) {
			bst.insert(input[i]);
		}
		bst.display(root,false,false,false,true,false,false);
		bst.maxElement(root);
		bst.minElement(root);
		System.out.println("Height of the tree : " + bst.height(root));
		System.out.println("No of nodes: " + bst.countNodes(root));
		
		Node node = bst.findById(2);
		if (node != null)
			System.out.println("Node found!");
		else
			System.out.println("Node not found!!");
		
		// Difference between 2 nodes
		Node n1 = bst.findById(9);
		Node n2 = bst.findById(2);
		int diff = bst.diffBtwNodes(n1, n2);
		if (diff > 0)
			System.out.println("Difference between nodes : " + diff); 
		else
			System.out.println("Please provide valid inputs");
		// recurisve inorder 
		//bst.display(root,false,false,true,false,false,false);
		//bst.display(root,true,false,false,false,false,false);
	}

}

class Node {
	int data;
	Node left;
	Node right;
	
	public Node(int data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
}