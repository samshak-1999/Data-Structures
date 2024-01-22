
public class Node {
	String state_Name;  // data item(Key)
	double state_DR; 	// data item
	Node leftChild;  // this node’s left child
	Node rightChild; // this node’s right child
	
	public Node(String state, double DR) {
		state_Name = state;
		state_DR = DR;
	}
	
	public void printNode() { //Prints Node
		System.out.printf("%-17s %-10.2f\n",state_Name, state_DR);
	}
}
