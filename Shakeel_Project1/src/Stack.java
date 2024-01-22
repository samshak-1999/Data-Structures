
public class Stack {
	


	private States[] s;
	private int top;
	private int maxSize;
	
	public Stack(int size) {
		top = -1;
		maxSize = size;
		s = new States[51];
	}
	
	public void push(States state) {
		if(isFull()) {
			System.out.println("Full Stack");
		}
		else {
			s[++top] = state;
		}
	}
	
	public States pop() {
		if(isEmpty()) {
			System.out.println("Empty Stack");
			return null;
		}
		else {
			System.out.println("Stack Popped");
			System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
			return s[top--];
		}
	}
	
	public States peek() {
		return s[top];
	}
	
	public boolean isEmpty() {
		return (top == -1);
	}
	
	public boolean isFull() {
		return(top == maxSize -1);
	}
	
	public void printS() {
		System.out.println("Content of Stack");
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
		
		for(int i = top ; i > 0; i--) {
			System.out.printf("%-17s  %-10d\t %6.2f\t\t %-10.6f %10.2f\t  %8.2f \n", s[i].getName(), s[i].getMedianIncome(), s[i].getViolentCrime() ,(s[i].getDeaths()/s[i].getCases()), ((s[i].getCases()/s[i].getPopulation()) * 100000), (s[i].getDeaths()/s[i].getPopulation() * 100000));
		}
		
		
	}

}
