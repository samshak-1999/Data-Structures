
/**
 * @author Sam Shakeel
 *	
 */
public class Stack {
	


	private States[] s;
	private int top;
	private int maxSize;
	
	/**
	 * @param size
	 */
	public Stack(int size) {
		top = -1;
		maxSize = size;
		s = new States[51];
	}
	
	/**
	 * @param state
	 */
	public void push(States state) {
		if(isFull()) {
			System.out.println("Full Stack");
		}
		else {
			s[++top] = state;
		}
	}
	
	/**
	 * @return
	 */
	public States pop() {
		if(isEmpty()) {
			System.out.println("Empty Stack");
			return null;
		}
		else {
			System.out.println("One state is popped from stack.");
			System.out.println(
					"--------------------------------------------------------------------------------------");	
			return s[top--];
		}
	}
	
	/**
	 * @return
	 */
	public States peek() {
		return s[top];
	}
	
	/**
	 * @return
	 */
	public boolean isEmpty() {
		return (top == -1);
	}
	
	/**
	 * @return
	 */
	public boolean isFull() {
		return(top == maxSize -1);
	}
	
	/**
	 * Prints the Stack
	 */
	public void printS() {
		
		System.out.println("State\t\t   MHI \t\t  VCR \t\t  CFR\t      Case Rate\t    Death Rate");
		System.out.println(
				"--------------------------------------------------------------------------------------");		
		for(int i = top ; i > 0; i--) {
			System.out.printf("%-17s  %-10d\t %6.2f\t\t %-10.6f %10.2f\t  %8.2f \n", s[i].getName(), s[i].getMedianIncome(), s[i].getViolentCrime() ,(s[i].getDeaths()/s[i].getCases()), ((s[i].getCases()/s[i].getPopulation()) * 100000), (s[i].getDeaths()/s[i].getPopulation() * 100000));
		}
		
		
	}

}
