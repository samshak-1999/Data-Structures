public class BinaryTree {
	
	private Node root;  // first node of tree
	private Node min;  // min
	private Node max; // max
	
	/**
	 * 
	 */
	public BinaryTree() { // constructor
		root = null; // no nodes in tree yet
	}
	
	/**
	 * @param name
	 * @param DR
	 */
	public void insert(String name, double DR) {  // make new node
		Node newNode = new Node(name, DR);
		
		if(root == null) {
			root = newNode;
		}
		else {
			Node current = root;
			Node parent;
			
			while(true) {
				parent = current;
					if(current.state_Name.compareTo(name) > 0) {
						current = current.leftChild;
							if(current == null) {
								parent.leftChild = newNode;
								return;
							}
					}
							
					else {
						current = current.rightChild;
					}	
								if(current == null) {
									parent.rightChild = newNode;
								return;
								}
			}
		}
	}
	
	/**
	 * @param name
	 * @return
	 */
	public double find(String name) { // find node with given key
		Node current = root;
		
		while(!current.state_Name.equals(name))  {
			if(current.state_Name.compareTo(name) > 0) {
				current = current.leftChild;
			}
			else
			{
				current = current.rightChild;
			}
			if(current == null) {
				return -1;
			}
		}
		return current.state_DR;
		
	} // end find
	
	/**
	 * @param name
	 */
	public void delete(String name) { // delete node with given key
		Node current = root;
		Node parent = root;
		boolean isLeftChild = true;
		
		while(!current.state_Name.equals(name)) {
			parent = current;
			if(current.state_Name.compareTo(name) > 0) {
				isLeftChild = true;
				current = current.leftChild;
			}
			else {
				isLeftChild = false;
				current = current.rightChild;
			}
			
			
			if(current == null) {
				System.out.println("State " + name + " not found");
				return;
			}
		}//end while
		
		//if no children simply delete it
		if(current.leftChild == null && current.rightChild == null) {
			if(current == root) {
				root = null;
			}
			else if(isLeftChild) {
				parent.leftChild = null;
			}
			else {
				parent.rightChild = null;
			}
		}
		else if(current.rightChild == null) {
			if(current == root) {
				root = current.leftChild;
			}
			else if(isLeftChild) {
				parent.leftChild = current.leftChild;
			}
			else {
				parent.rightChild = current.leftChild;
			}
		}
		else if(current.leftChild == null) {
			if(current == root) {
				root = current.rightChild;
			}
			else if(isLeftChild) {
				parent.leftChild = current.rightChild;
			}
			else {
				parent.rightChild = current.rightChild;
			}
			
		}
		else {
			Node successor = getSuccessor(current);
			
			if(current == root) {
				root = successor;
			}
			else if(isLeftChild) {
				parent.leftChild = successor;
			}
			else {
				parent.rightChild = successor;
			}
			successor.leftChild = current.leftChild;
		}
		
		System.out.println(name + " deleted");
	} // end delete 
	
	
	private Node getSuccessor(Node delNode){ // get successor of node to delete (current)
		Node successorParent = delNode;
		Node successor = delNode;
		Node current = delNode.rightChild;
		while(current != null) {
			successorParent = successor;
			successor = current;
			current = current.leftChild;
		}
		if(successor != delNode.rightChild) {
			successorParent.leftChild = successor.rightChild;
			successor.rightChild = delNode.rightChild;
		}
		
		return successor;
	} 
	
	/**
	 * @param localRoot
	 * PreOrder format
	 */
	public void preOrder(Node localRoot) {
		if(localRoot != null) {
			localRoot.printNode();
			preOrder(localRoot.leftChild);
			preOrder(localRoot.rightChild);
		}
	}
	
	/**
	 * @param localRoot
	 * InOrder format
	 */
	public void inOrder(Node localRoot) {
		if(localRoot != null) {
			inOrder(localRoot.leftChild);
			localRoot.printNode();
			inOrder(localRoot.rightChild);
		}
	}
	
	/**
	 * @param localRoot
	 * postOrder format
	 */
	public void postOrder(Node localRoot) {
		if(localRoot != null) {
			postOrder(localRoot.leftChild);
			postOrder(localRoot.rightChild);
			localRoot.printNode();
		}
	}
	
	/**
	 *  Print In Order
	 */
	public void printInOrder() {
		inOrder(root);
		System.out.println();
	}
	
	/**
	 *  Print pre Order
	 */
	public void printPreOrder() {
		preOrder(root);
		System.out.println();
	}
	
	/**
	 * Print Post Order
	 */
	public void printPostOrder() {
		postOrder(root);
		System.out.println();
	}
	
	/**
	 * Print the Min DR Value
	 */
	public void printMin() {
		min = root;
		findMin(root);
		min.printNode();
	}
	
	
	/**
	 * @param localRoot
	 * Find the Min Level DR
	 */
	public void findMin(Node localRoot) {
		if(localRoot != null) {
			findMin(localRoot.leftChild);
			findMin(localRoot.rightChild);
			if(localRoot.state_DR < min.state_DR) {
				min = localRoot;
			}
		}
	}
	
	/**
	 * Prints the Max value DR
	 */
	public void printMax() {
		max = root;
		findMax(root);
		max.printNode();
	}
	
	/**
	 * @param localRoot
	 * Find the Max Value DR
	 */
	public void findMax(Node localRoot) {
		if(localRoot != null) {
			findMax(localRoot.leftChild);
			findMax(localRoot.rightChild);
			if(localRoot.state_DR > max.state_DR) {
				max = localRoot;
			}
		}
	}
}
