/*
 * COP 3530: Project 5 - Hashtable
 * 
 * @author <Sam Shakeel>
 * @version <12/10/2021>
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Project5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		HashTable h = new HashTable(101);
		
		
		String input = "";
		String line = "";
		System.out.println("COP 3530 Project 5");
		System.out.println();
		System.out.println("Hash Tables ");
		System.out.println();
		Scanner in = new Scanner(System.in);
		System.out.printf("Enter the file name: ");
		input = in.nextLine();
		System.out.println();
		System.out.println(
				"----------------------------");
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
			h.insert(s[i].getName(), (long) s[i].getPopulation(), (long) s[i].getDeaths());
		}
		
		
		while(true) {
			
			System.out.println("1. Print hash table  ");
			System.out.println("2. Delete a state of given name ");
			System.out.println("3. Insert a state of its name, population, and COVID deaths  ");
			System.out.println("4. Search and print a state and its DR for a given name ");
			System.out.println("5. Print numbers of empty and collided cells ");
			System.out.println("6. Exit ");
			
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
				h.displayTable();
			}
			else if(entry == 2) {
			
				String stateName;
				System.out.print("Enter State Name to delete: ");
				stateName = in.nextLine();
				
				if(h.find(stateName) != -1) {
					h.delete(stateName);
					System.out.println(stateName + " has been deleted from hash table");
				}
				else {
				System.out.println(stateName + " is not a state");
				}
			}
			else if(entry == 3) {
				String s_Name;
				long s_Pop, s_Death;
				
				System.out.print("Enter state name: ");
				s_Name = in.next();
				System.out.print("Enter state population: ");
				s_Pop = in.nextLong();
				System.out.print("Enter state COVID deaths: ");
				s_Death = in.nextLong();
				
				h.insert(s_Name, s_Pop, s_Death);
				
				System.out.println(s_Name + " has been inserted to hash table.");
			}
			else if(entry == 4) {
				
				String stateName;
				System.out.print("Enter State Name to search: ");
				stateName = in.nextLine();
				
				if(h.find(stateName) != -1) {
					System.out.printf("%s has been found with the DR of %.2f\n", stateName, h.find(stateName));
				}
				else {
					System.out.println(stateName + " not found.");
				}
			}
			else if(entry == 5) {
				h.printCount();
			}
			else if(entry == 6) {
				System.out.println("Have a good day! ");
				break;
			}

			else {
				System.out.println("Invalid choice, enter 1-6 ");
			}
			
		}
		
		in.close(); //end
}
}
