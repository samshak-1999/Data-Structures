
public class PriorityQ {

	private States[] s;
	private int nItems;
	private int maxSize;

	public PriorityQ(int size) {

		maxSize = size;
		s = new States[maxSize];
		nItems = 0;

	}

	public void insert(States state) {

		if (isFull()) {
			System.out.println("Queue is Full");
		} else {
			s[nItems++] = state;
		}

	}

	public States remove() {
		if (isEmpty()) {
			System.out.println("Queue is Empty");
			return s[0];
		} else {
			System.out.println("Queue Dequeued");
			System.out.println(
					"---------------------------------------------------------------------------------------------------------------------------------------------------");
			return s[--nItems];
		}
	}

	public void printQ() {

		System.out.println("Content of Queue");
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------------------------------------");

		// System.out.printf("%-17s %-10d\t %6.2f\t\t %-10.6f %10.2f\t %8.2f \n",
		// s[i].getName(), s[i].getMedianIncome(), s[i].getViolentCrime()
		// ,(s[i].getDeaths()/s[i].getCases()), ((s[i].getCases()/s[i].getPopulation())
		// * 100000), (s[i].getDeaths()/s[i].getPopulation() * 100000));
		System.out.println("State\t\t   MHI \t\t  VCR \t\t  CFR\t      Case Rate\t    Death Rate");
		System.out.println("--------------------------------------------------------------------------------------");

		for (int i = nItems-1; i > 0; i--) {
			System.out.printf("%-17s  %-10d\t %6.2f\t\t %-10.6f %10.2f\t  %8.2f \n", s[i].getName(),
					s[i].getMedianIncome(), s[i].getViolentCrime(), (s[i].getDeaths() / s[i].getCases()),
					((s[i].getCases() / s[i].getPopulation()) * 100000),
					(s[i].getDeaths() / s[i].getPopulation() * 100000));
		}

	}

	public void bubbleSort() {
		int n = s.length;
		States nameState;

		System.out.println("State\t\t   MHI \t\t  VCR \t\t  CFR\t      Case Rate\t    Death Rate");
		System.out.println("--------------------------------------------------------------------------------------");

		for (int i = 0; i < n; i++)
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

	public boolean isEmpty() {
		return (nItems == 0);
	}

	public boolean isFull() {
		return (nItems == maxSize);
	}

}
