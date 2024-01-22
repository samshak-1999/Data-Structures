	public class LinkedList{
		Node first; //ref to the first item
		Node last; // ref to the last item
		
		/**
		 * Constructor
		 */
		public LinkedList() {
			first = null;
			last = null;
		}
		
		/**
		 * @param state
		 * Insert node in order
		 */
		public void insert(Node state) { 
			if(first == null) {
				first = state; 
			}
			else {
				last.nextNode = state;
			}
			last = state;
		}
		
		/**
		 * @param state
		 * Find the Node with the same String (Name)
		 * @return
		 */
		public Node find(String state) { //find node
			Node current = first; // hash the node
			
			while(current != null) { 
				if(current.name.equals(state)) {
				return current; //return node
			}
				current = current.nextNode;
			}
			
			return null;
		}
		
		/**
		 * @param state
		 * Deletes the node with the matching state name
		 */
		public void delete(String state) { //delete a node
			Node previous = null;
			Node current = first;
			
			while(current != null && state.equals(current.name) != true) {
				previous = current;
				current = current.nextNode;
			}
			
			if(previous == null) {
				first = first.nextNode;
			}
			else {
				previous.nextNode = current.nextNode;
			}
		}
		
		/**
		 * Displays the entire list
		 */
		public void displayList() {	
			Node current = first;
			
			if(current == null) {
				System.out.println("Empty");
			}
			
			while(current != null) {
				current.printNode();
				current = current.nextNode;
				System.out.print("   ");
			}
			System.out.println();
		}	
	}