/*
 * COP 3530: Project 2 - Stacks and Priority Queues
 * <p>
 * The States class will use the values from the Csv file and use the get/set methods of the state class to store values in the States objects
 * The stack will be created using the stack class and will store objects in the Last in First Out 
 * The PriorityQ Class will hold the sorted array by Death Rate, the lower the Death Rate the higher the priority
 * @author <Sam Shakeel>
 * @version <10/07/2021>
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("COP 3530 Project 2");
		System.out.println("Instructor: Xudong Liu");
		System.out.println();
		
		
		String input = "";
		String line = "";
		System.out.println("Stacks and Priority Queues");
		System.out.println();

		Scanner in = new Scanner(System.in);
		System.out.printf("Enter the name of the file: ");
		input = in.nextLine();

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

		String[] name1 = new String[51];
		String[] capital1 = new String[51];
		String[] region1 = new String[51];
		String[] seats1 = new String[51];
		String[] pop1 = new String[51];
		String[] cases1 = new String[51];
		String[] deaths1 = new String[51];
		String[] income1 = new String[51];
		String[] crime1 = new String[51];

		States[] s = new States[51]; 
		Stack s1 = new Stack(52);
		PriorityQ pq = new PriorityQ(52);
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));

			int x1 = 0;
			while ((line = br.readLine()) != null) {

				String[] strs = line.split(",");

				for (int i = 0; i < strs.length; i++) {
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
			s[i].setCases(Float.parseFloat(cases1[i]));
			s[i].setDeaths(Integer.parseInt(deaths1[j]));
			s[i].setMedianIncome(Integer.parseInt(income1[j]));
			s[i].setViolentCrime(Float.parseFloat(crime1[j]));
			s1.push(s[i]);
		}
		
		System.out.println();
		System.out.println("Stack created of 50 states. ");
		
		selectionSort(s);
		for(int i = 1; i < s.length; i++) {
		pq.insert(s[i]);
		}
		
		System.out.println("Priority queue created of 50 states.");
		System.out.println();
		
		int val = 50;
		int val1 = 50;
		String value = "";

		while (true) {

			System.out.println("1. Print Stack");
			System.out.println("2. Pop a state object from stack");
			System.out.println("3. Push a state object onto Stack");
			System.out.println("4. Print Priority Queue");
			System.out.println("5. Remove a state object from Priority Queue");
			System.out.println("6. Insert a state object into Priority Queue");
			System.out.println("7. Quit");
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
			if (entry == 1) {
				s1.printS();
				System.out.println(
						"--------------------------------------------------------------------------------------");
			} else if (entry == 2) {
				s1.pop();
				val--;
			} else if (entry == 3) {
			
				s[val] = new States();
				System.out.print("Enter State: ");
				value = in.nextLine();
				s[val].setName(value);
				System.out.print("Enter Capital: ");
				value = in.nextLine();
				s[val].setCapital(value);
				System.out.print("Enter Region: ");
				value = in.nextLine();
				s[val].setRegion(value);
				System.out.print("Enter House Seats: ");
				value = in.nextLine();
				s[val].setHouseSeats(Integer.parseInt(value));
				System.out.print("Enter Population: ");
				value = in.nextLine();
				s[val].setPopulation(Integer.parseInt(value));
				System.out.print("Enter COVID CASES: ");
				value = in.nextLine();
				s[val].setCases(Float.parseFloat(value));
				System.out.print("Enter COVID Deaths: ");
				value = in.nextLine();
				s[val].setDeaths(Integer.parseInt(value));
				System.out.print("Enter Median Household Income: ");
				value = in.nextLine();
				s[val].setMedianIncome(Integer.parseInt(value));
				System.out.print("Enter Violent Cases: ");
				value = in.nextLine();
				s[val].setViolentCrime(Float.parseFloat(value));
				s1.push(s[val]);
				val++;
				System.out.println(
						"--------------------------------------------------------------------------------------");
				System.out.println("One state is pushed onto stack.");
				System.out.println(
						"--------------------------------------------------------------------------------------");
			} else if (entry == 4) {
				pq.printQ();
				System.out.println(
						"--------------------------------------------------------------------------------------");
			} else if (entry == 5) {
				pq.remove();
				val1--;
			} else if (entry == 6) {
				s[val1] = new States();
				System.out.print("Enter State: ");
				value = in.nextLine();
				s[val1].setName(value);
				System.out.print("Enter Capital: ");
				value = in.nextLine();
				s[val1].setCapital(value);
				System.out.print("Enter Region: ");
				value = in.nextLine();
				s[val1].setRegion(value);
				System.out.print("Enter House Seats: ");
				value = in.nextLine();
				s[val1].setHouseSeats(Integer.parseInt(value));
				System.out.print("Enter Population: ");
				value = in.nextLine();
				s[val1].setPopulation(Integer.parseInt(value));
				System.out.print("Enter COVID CASES: ");
				value = in.nextLine();
				s[val1].setCases(Float.parseFloat(value));
				System.out.print("Enter COVID Deaths: ");
				value = in.nextLine();
				s[val1].setDeaths(Integer.parseInt(value));
				System.out.print("Enter Median Household Income: ");
				value = in.nextLine();
				s[val1].setMedianIncome(Integer.parseInt(value));
				System.out.print("Enter Violent Cases: ");
				value = in.nextLine();
				s[val1].setViolentCrime(Float.parseFloat(value));
				pq.insert(s[val1]);
				val1++;
				System.out.println("One State is inserted onto priority queue.");
				System.out.println(
						"--------------------------------------------------------------------------------------");

			} else if (entry == 7) {
				System.out.println("Have a good day!");
				System.out.println(
						"--------------------------------------------------------------------------------------");
				break;
			} 
			else {
				System.out.println(
						"--------------------------------------------------------------------------------------");
				System.out.println("Invalid choice, Enter again");
				System.out.println(
						"--------------------------------------------------------------------------------------");
			}
			
		}

		in.close();

	}

	/*
	 * @param s
	 */
	public static void printStates(States[] s) {
		System.out.println("State\t\t   MHI \t\t  VCR \t\t  CFR\t      Case Rate\t    Death Rate");
		for (int i = 1; i < s.length; i++) {
			System.out.printf("%-17s  %-10d\t %6.2f\t\t %-10.6f %10.2f\t  %8.2f \n", s[i].getName(),
					s[i].getMedianIncome(), s[i].getViolentCrime(), (s[i].getDeaths() / s[i].getCases()),
					((s[i].getCases() / s[i].getPopulation()) * 100000),
					(s[i].getDeaths() / s[i].getPopulation() * 100000));
		}
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
