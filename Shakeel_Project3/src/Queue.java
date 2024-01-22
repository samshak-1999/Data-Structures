
/**
 * @author Sam Shakeel
 *
 */
public class Queue {
	private States head;
	private States tail;
	
	public Queue() {
		this.head = null;
		this.tail = null;
	}
	
	/**
	 * @param s
	 */
	public void insertFront(States s) {
		States newNode = s;
		if(isEmpty()) {
			tail = newNode;
		}
		else {
			head.previous = newNode;
		}
		newNode.next = head;
		head = newNode;
	}
	
	/**
	 * @param s
	 */
	public void insertEnd(States s) {
		States newNode = s;
		if(isEmpty()){
			head = newNode;
		}
		else {
			tail.next = newNode;
			newNode.previous = tail;
		}
		tail = newNode;
	}
	
	/**
	 * @return
	 */
	public States removeFront() {
		if(head == null) {
			throw new RuntimeException("Deque is empty");
		}
		States front = head;
		if(head.next == null) {
			tail = null;
		}
		else {
			head.next.previous = null;
		}
		head = head.next;
		
		return front;
	}
	
	/**
	 * @return
	 */
	public States removeBack() {
		
		if(tail == null) {
			throw new RuntimeException("Deque is empty");
		}
		States back = tail;
		if(head.next == null) {
			head = null;
		}
		else {
			tail.previous.next = null;
		}
		tail = tail.previous;
		
		return back;
	}
	
	/**
	 * @param minimum
	 * @param maximum
	 * @return
	 */
	public boolean statesDelete(float minimum, float maximum) {
		boolean result = false;
		States current = head;
		
		while(current != null) {
			float DR = current.getDR();
			if(minimum <= DR && DR <= maximum) {
				if(head == null || tail == null) {
					return result;
				}
				if(head == current) {
					head = current.next;
				}
				if(current.next != null) {
					current.next.previous = current.previous;
				}
				if(current.previous != null) {
					current.previous.next = current.next;
				}
			}
			current = current.next;
		}
		return result;
	}
	
	/**
	 * Prints the Queue
	 */
	public void printQ() {
		States current = head;
		while(current != null) {
			System.out.println(current);
			current = current.next;
		}
	}
	
	/**
	 * @return
	 */
	public boolean isEmpty() {
		return head == null;
	}
	
	/**
	 * @return
	 */
	public boolean isFull() {
		return false;
	}
}
