/*
 * COP 3530: Project 3 - Linked Lists
 * Main class that will call the States Object class, The Stack Class using double ended linked lists, The Queue class using Doubly Linked lists
 * 
 * @author <Sam Shakeel>
 * @version <10/22/2021>
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue PQ = new Queue();
		Stack stack = new Stack();
		
		String input = "";
		String line = "";
		System.out.println("COP 3530 Project 3");
		System.out.println();

		Scanner in = new Scanner(System.in);
		System.out.printf("Enter the file name: ");
		input = in.nextLine();
		System.out.println();
		System.out.println("Stack Contents: ");
		System.out.println();
		System.out.println("State\t\t   MHI \t\t  VCR \t\t  CFR\t      Case Rate\t    Death Rate");
		System.out.println(
				"--------------------------------------------------------------------------------------");
		String filename = "src/" + input;
		
		String[] name = new String[51];
		String[] capital = new String[51];
		String[] region = new String[51];
		String[] seats = new String[51];
		String[] pop = new String[51];
		String[] cases = new String[51];
		String[] deaths = new String[51];
		String[] income = new String[51];
		String[] crime = new String[51];
		States[] s = new States[51]; 
		String[] name1 = new String[51];
		String[] capital1 = new String[51];
		String[] region1 = new String[51];
		String[] seats1 = new String[51];
		String[] pop1 = new String[51];
		String[] cases1 = new String[51];
		String[] deaths1 = new String[51];
		String[] income1 = new String[51];
		String[] crime1 = new String[51];

	
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));

			int x1 = 0;
			while ((line = br.readLine()) != null) {

				String[] strs = line.split(",");

				for (int i = 0 ; i < strs.length; i++) {
					name[i] = strs[0];
					capital[i] = strs[1];
					region[i] = strs[2];
					seats[i] = strs[3];
					pop[i] = strs[4];
					cases[i] = strs[5];
					deaths[i] = strs[6];
					income[i] = strs[7];
					crime[i] = strs[8];
				}

			
				name1[x1] = name[0];
				capital1[x1] = capital[0];
				region1[x1] = region[0];
				seats1[x1] = seats[0];
				pop1[x1] = pop[0];
				cases1[x1] = cases[0];
				deaths1[x1] = deaths[0];
				income1[x1] = income[0];
				crime1[x1] = crime[0];

				x1++;
				
			}
			
	
		
			br.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (int i = 1, j = 1; i < s.length; i++, j++) {
			s[i] = new States();
			s[i].setName(name1[j]);
			s[i].setCapital(capital1[j]);
			s[i].setRegion(region1[j]);
			s[i].setHouseSeats(Integer.parseInt(seats1[j]));
			s[i].setPopulation(Integer.parseInt(pop1[j]));
			s[i].setCases(Float.parseFloat(cases1[j]));
			s[i].setDeaths(Integer.parseInt(deaths1[j]));
			s[i].setMedianIncome(Integer.parseInt(income1[j]));
			s[i].setViolentCrime(Float.parseFloat(crime1[j]));
			
			
		}
		
		// FAIR, GOOD, VGOOD states (Death rate)
		
		for(int i = 1; i<s.length; i++) {
			if(s[i].getDR() > 70 && s[i].getDR() < 250) {
				stack.push(s[i]);
			}
		}
		stack.print();
		
		
		selectionSort(s);
		for(int i = 1; i < s.length; i++) {
			PQ.insertFront(s[i]);
		}
		
		
		System.out.println("Priority Queue Contents: ");
		System.out.println("State\t\t   MHI \t\t  VCR \t\t  CFR\t      Case Rate\t    Death Rate");
		System.out.println(
				"--------------------------------------------------------------------------------------");
		PQ.printQ();
		
		
		while(true) {
			
			System.out.println("1. Enter a DR interval for deletions");
			System.out.println("2. Print priority queue");
			System.out.println("3. Exit");
			
			System.out.printf("Enter your choice: ");
			int entry;
			
			try {
				entry = in.nextInt();
				System.out.println(
						"--------------------------------------------------------------------------------------");
			}
			catch (InputMismatchException ie) {
				entry = 0;
			}
			in.nextLine();
			
			
			if(entry == 1) {
				int num1, num2;
				
				System.out.println("Enter DR intervals ");
				while(true) {
			
				try {
					System.out.print("Enter 1st interval: ");
					num1 = in.nextInt();
					System.out.print("Enter 2nd interval: ");
					num2 = in.nextInt();
					
					
					if(num2 > num1) {
						System.out.println();
						System.out.printf("States of priority queue with DRs in [%d,%d] are deleted\n", num1, num2);
						PQ.statesDelete(num1, num2);
						System.out.println();
						break;
					}
					else {
						System.out.println("Invalid interval, 1st number must be bigger than the 2nd number");
					}
					
				}
				catch(InputMismatchException ex){
					System.out.println("Invalid input, try again");
					in.next();
				}
				
				
				}
			}
			else if(entry == 2) {
				System.out.println("State\t\t   MHI \t\t  VCR \t\t  CFR\t      Case Rate\t    Death Rate");
				System.out.println(
						"--------------------------------------------------------------------------------------");
				PQ.printQ();
				
			}
			else if(entry == 3) {
				System.out.println("Have a good day! ");
				break;
			}
			else {
				System.out.println("Invalid choice, enter 1-3 ");
			}
			
		}
		
		in.close();
	
	}

	/**This method sorts the objects by Death Rate
	 * @param s
	 */
	public static void selectionSort(States[] s) {
		int n = s.length;
		for (int p = 1; p < n; p++) {
			int max = p;
			for (int w = p + 1; w < n; w++) {
				if (s[w].getDR() > s[max].getDR()) {
					max = w;
				}
			}
			if (max != p) {
				States temp = s[max];
				s[max] = s[p];
				s[p] = temp;
			}
		}
		
	}
}
