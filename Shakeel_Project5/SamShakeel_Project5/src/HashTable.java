public class HashTable {
	private LinkedList[] hashArray; //array of lists
	private int arraySize;
	
	/**
	 * @param size
	 * Constructor
	 */
	public HashTable(int size) {
		arraySize = size;
		hashArray = new LinkedList[arraySize];
		for(int i = 0; i < arraySize; i++) {
			hashArray[i] = new LinkedList();
		}
	}
	
	/**
	 * Displays each cell
	 */
	public void displayTable() {
		System.out.println("Hash Table");
		
		for(int i = 0; i < arraySize; i++) {
			System.out.print(i + ".");
			hashArray[i].displayList();
		}
	}
	
	/**
	 * @param state
	 * Hash function
	 * Calculates Hash Value
	 * @return
	 */
	public int hashFunc(String state) {  //Finds the Key Value of String
		int value = 0;
		int hash = 0;
		
		for(int i = 0; i < state.length(); i++) {
			hash = (int) state.charAt(i);  //get char code
			value = value + hash;
		}
		
		return value % arraySize; // mod
	}
	
	/**
	 * @param state
	 * @param population
	 * @param deaths
	 * Insert a state
	 */
	public void insert(String state, long population, long deaths) {
		Node node = new Node(state,population,deaths);
		int hashValue = hashFunc(state); //hash the key
		hashArray[hashValue].insert(node); //insert at Hashval
	}
	
	/**
	 * @param state
	 * @return
	 * Find and return the Death Rate of a given state
	 */
	public double find(String state) {
		int hashValue = hashFunc(state);
		Node node = hashArray[hashValue].find(state);
		if(node != null) {
			return ((double) node.deaths/node.population * 100000);
		}
		else {
			return -1;
		}
	}
	
	/**
	 * @param state
	 * Deletes a state
	 */
	public void delete(String state) {
		int hashValue = hashFunc(state);
		hashArray[hashValue].delete(state);
	}
	
	/**
	 * Prints the empty and collisions
	 */
	public void printCount(){
		int empty = 0;
		int coll = 0;
		
		for(int i = 0; i < arraySize; i++) {
			Node node = hashArray[i].first;
				if(node == null) {
					empty++;
				}
				else {
					if(node.nextNode != null) {
						coll++;
					}
				}
		}
		System.out.println("Empty cells = " + empty + " and Collisions Cells = " + coll);
	}
}
	

