
/**
 * Class Provided by the instructor to add
 *
 */
class Node{
		String name;
		long population;
		long deaths;
		Node nextNode;
		
		public Node(String name, long population, long deaths) {
			this.name = name;
			this.population = population;
			this.deaths = deaths;
		}
		
		public void printNode() {
			System.out.printf("%-30s %-20.2f\n", name, (double) deaths/population * 100000);
		}
	}