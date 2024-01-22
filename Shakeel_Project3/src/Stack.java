/**
 * @author Sam Shakeel
 *
 */
class Stack {

	private class Link {

		States data; 
		Link next;

		/**
		 * @param data
		 */
		Link(States data){
			this.data=data;
		}
	}

		Link top = null;
		Link end = null;
	
	
	/**
	 * Constructor
	 */
	public Stack()
	{
		this.top = null;
	}

	
	/**
	 * @param s
	 * Pushes the object onto the Stack
	 */
	public void push(States s) 
	{
		Link temp = new Link(s);

		if (top==null) {
			top=end=temp;
			end.next=null;
		}
		else{
			temp.next=top;
			top=temp;
		}
	}


	/**
	 * @return
	 */
	public boolean isEmpty()
	{
		return top == null;
	}

	/**
	 * Removes the objects from the stack
	 */
	public void pop() 
	{
	
		if (top == null) {
			System.out.print("\nStack Underflow");
			return;
		}
		else{

			if(top!=end){
				top=top.next;
			}
			else{
				top=end=null;
			}
		}
	}

	/**
	 * print the stack elements
	 */
	public void print()
	{
		if (top == null) {
			System.out.printf("\nStack Underflow");
			
		}
		else {
			print(top);
			System.out.println();
		}
	}
	
	/**
	 * @param state
	 */
	private void print(Link state){
		if(state==null){
			return;
		}
		System.out.printf("%-17s  %-10d\t %6.2f\t\t %-10.6f %10.2f\t  %8.2f \n", state.data.getName(),
				state.data.getMedianIncome(), state.data.getViolentCrime(),
				(state.data.state_CovidDeaths / state.data.state_CovidCases),
				((state.data.state_CovidCases) / (state.data.state_Population) * 100000),
				((state.data.state_CovidDeaths / state.data.state_Population) * 100000));
		System.out.println();
		print(state.next);
	}
}
