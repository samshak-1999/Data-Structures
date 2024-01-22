/*
 * COP 3530: Project 1 - Array Searches and Sorts
 * <p>
 * This class will split the Csv file and use the get/set methods of the state class to store values in the States objects
 * 
 * @author <Sam Shakeel>
 * @version <09/17/2021>
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String input = "";
		String line = "";
		System.out.println("Data Structures Sorting");
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
		Stack s1 = new Stack(51);
		PriorityQ pq = new PriorityQ(51);
		
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
		selectionSort(s);
		for(int i = 1; i < s.length; i++) {
		pq.insert(s[i]);
		}

		while (true) {

			System.out.println("1. Print a States report");
			System.out.println("2. Sort by Name");
			System.out.println("3. Sort by Case Fatality Rate");
			System.out.println("4. Sort by Median Household Income");
			System.out.println("5. Find and print a given State");
			System.out.println("6. Print the Spearman's rho matrix");
			System.out.println("7. Quit");
			System.out.printf("Enter your choice: ");
			int entry = Integer.parseInt(in.nextLine());

			if (entry == 1) {
				// printStates(s);
			/*	System.out.println("State\t\t   MHI \t\t  VCR \t\t  CFR\t      Case Rate\t    Death Rate");
				System.out.println(
						"--------------------------------------------------------------------------------------");
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

				} 
				for (int i = 1; i < s.length; i++) {
					s[i].println();
				} */

				s1.printS();
				System.out.println(
						"--------------------------------------------------------------------------------------");
			} else if (entry == 2) {
				bubbleSort(s);
				System.out.println(
						"--------------------------------------------------------------------------------------");
			} else if (entry == 3) {
				pq.printQ();
				
				System.out.println(
						"--------------------------------------------------------------------------------------");
			} else if (entry == 4) {
				insertionSort(s);
				System.out.println(
						"--------------------------------------------------------------------------------------");
			} else if (entry == 5) {
				System.out.printf("Enter the State Name: ");
				String namesearch = in.nextLine();
				System.out.println("You entered: " + namesearch);

				for (int i = 1; i < s.length; i++) {
					if (s[i].getName().equals(namesearch)) {
						System.out.println("State\t\t   MHI \t\t  VCR \t\t  CFR\t      Case Rate\t    Death Rate");
						System.out.println(
								"--------------------------------------------------------------------------------------");
						System.out.printf("%-17s  %-10d\t %6.2f\t\t %-10.6f %10.2f\t  %8.2f \n", s[i].getName(),
								s[i].getMedianIncome(), s[i].getViolentCrime(), (s[i].getDeaths() / s[i].getCases()),
								((s[i].getCases() / s[i].getPopulation()) * 100000),
								(s[i].getDeaths() / s[i].getPopulation() * 100000));
					}
				}

				namesearch = "";

				System.out.println(
						"--------------------------------------------------------------------------------------");
			} else if (entry == 6) {
				System.out.println("-----------------------------------------");
				System.out.println("|            |     MHI      |   VCR     |");
				System.out.println("-----------------------------------------");
				System.out.println("| Case Rate  |      X       |     X     |");
				System.out.println("-----------------------------------------");
				System.out.println("| Death Rate |      X       |     X     |");
				System.out.println("-----------------------------------------");

			} else if (entry == 7) {
				System.out.println("You have exited the program.");
				System.out.println(
						"--------------------------------------------------------------------------------------");
				break;
			} else {
				System.out.println("Invalid choice, Enter again");
			}
		}

		in.close();

	}

	/*
	 * This method print states in the default sort as they were provided in the Csv
	 * file.
	 * 
	 *
	 * @param s
	 */
	public static void printStates(States[] s) {
		for (int i = 1; i < s.length; i++) {
			System.out.printf("%-17s  %-10d\t %6.2f\t\t %-10.6f %10.2f\t  %8.2f \n", s[i].getName(),
					s[i].getMedianIncome(), s[i].getViolentCrime(), (s[i].getDeaths() / s[i].getCases()),
					((s[i].getCases() / s[i].getPopulation()) * 100000),
					(s[i].getDeaths() / s[i].getPopulation() * 100000));
		}
	}

	/*
	 * This method sorts the objects by CFR using selection sort by ascending order
	 * and prints the output.
	 */

	/**
	 * @param s
	 */
	public static void selectionSort(States[] s) {
		int n = s.length;
		System.out.println("State\t\t   MHI \t\t  VCR \t\t  CFR\t      Case Rate\t    Death Rate");
		System.out.println("--------------------------------------------------------------------------------------");
		for (int p = 1; p < n; p++) {
			int small = p;
			for (int w = p + 1; w < n; w++) {
				if (s[w].getCfr() < s[small].getCfr()) {
					small = w;
				}
			}
			if (small != p) {
				States temp = s[small];
				s[small] = s[p];
				s[p] = temp;
			}
		}
		
	}	
	/*	for (int i = 1; i < n; i++) {
			System.out.printf("%-17s  %-10d\t %6.2f\t\t %-10.6f %10.2f\t  %8.2f \n", s[i].getName(),
					s[i].getMedianIncome(), s[i].getViolentCrime(), (s[i].getDeaths() / s[i].getCases()),
					((s[i].getCases() / s[i].getPopulation()) * 100000),
					(s[i].getDeaths() / s[i].getPopulation() * 100000));
		}*/
		

	/*
	 * This method sorts the objects by name using bubble sort then outputs the
	 * objects in Alphabetical order
	 */

	/**
	 * @param s
	 */
	public static void bubbleSort(States[] s) {
		int n = s.length;
		States nameState;

		System.out.println("State\t\t   MHI \t\t  VCR \t\t  CFR\t      Case Rate\t    Death Rate");
		System.out.println("--------------------------------------------------------------------------------------");

		for (int i = 1; i < n; i++)
			for (int j = 1; j < n - i; j++) {

				if (s[j].getName().compareTo(s[j + 1].getName()) > 0) {
					nameState = s[j];
					s[j] = s[j + 1];
					s[j + 1] = nameState;

				}
			}
		for (int i = 1; i < n; i++) {
			System.out.printf("%-17s  %-10d\t %6.2f\t\t %-10.6f %10.2f\t  %8.2f \n", s[i].getName(),
					s[i].getMedianIncome(), s[i].getViolentCrime(), (s[i].getDeaths() / s[i].getCases()),
					((s[i].getCases() / s[i].getPopulation()) * 100000),
					(s[i].getDeaths() / s[i].getPopulation() * 100000));
		}
	}
	/*
	 * This method Sorts the objects by Median Household income using the insertion
	 * Sort technique and then outputs the value.
	 */

	/**
	 * @param s
	 */
	public static void insertionSort(States[] s) {
		int w;
		System.out.println("State\t\t   MHI \t\t  VCR \t\t  CFR\t      Case Rate\t    Death Rate");
		System.out.println("--------------------------------------------------------------------------------------");
		for (int i = 1; i < s.length; i++) {
			w = s[i].getMedianIncome();

			int j = i - 1;

			while ((j > 0) && (s[j].getMedianIncome() > w)) {
				s[j + 1].setMedianIncome(s[j].getMedianIncome());
				j--;
			}

			s[j + 1].setMedianIncome(w);
		}
		for (int i = 1; i < s.length; i++) {
			System.out.printf("%-17s  %-10d\t %6.2f\t\t %-10.6f %10.2f\t  %8.2f \n", s[i].getName(),
					s[i].getMedianIncome(), s[i].getViolentCrime(), (s[i].getDeaths() / s[i].getCases()),
					((s[i].getCases() / s[i].getPopulation()) * 100000),
					(s[i].getDeaths() / s[i].getPopulation() * 100000));
			
		}

	}

}
