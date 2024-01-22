public class States {

	String state_Name;
	String state_Capital;
	String state_Region;
	int state_HouseSeats;
	int state_Population;
	float state_CovidCases;
	float state_CovidDeaths;
	int state_MedianIncome;
	float state_ViolentCrime;
	float state_Cfr;
	public States next;
	public States previous;

	/**
	 * 
	 */
	public States() {
		super();
	}
	/*
	 * Overloaded Constructor that will create an object in the main class.
	 */

	public States(String state_Name, String state_Capital, String state_Region, int state_HouseSeats,
			int state_Population, float state_CovidCases, float state_CovidDeaths, int state_MedianIncome,
			float state_ViolentCrime) {

		this.state_Name = state_Name;
		this.state_Capital = state_Capital;
		this.state_Region = state_Region;
		this.state_HouseSeats = state_HouseSeats;
		this.state_Population = state_Population;
		this.state_CovidCases = state_CovidCases;
		this.state_CovidDeaths = state_CovidDeaths;
		this.state_MedianIncome = state_MedianIncome;
		this.state_ViolentCrime = state_ViolentCrime;

	}

	/*
	 * Getter and setter methods for all the required fields
	 */

	/**
	 * @return
	 */
	public String getName() {
		return state_Name;
	}

	/**
	 * @param name
	 */
	public void setName(String name) {
		this.state_Name = name;
	}

	/**
	 * @return
	 */
	public String getCapital() {
		return state_Capital;
	}

	/**
	 * @param capital
	 */
	public void setCapital(String capital) {
		this.state_Capital = capital;
	}

	/**
	 * @return
	 */
	public String getRegion() {
		return state_Region;
	}

	/**
	 * @param region
	 */
	public void setRegion(String region) {
		this.state_Region = region;
	}

	/**
	 * @return
	 */
	public int getHouseSeats() {
		return state_HouseSeats;
	}

	/**
	 * @param seats
	 */
	public void setHouseSeats(int seats) {
		this.state_HouseSeats = seats;
	}

	/**
	 * @return
	 */
	public int getPopulation() {
		return state_Population;
	}

	/**
	 * @param pop
	 */
	public void setPopulation(int pop) {
		this.state_Population = pop;
	}

	/**
	 * @return
	 */
	public float getCases() {
		return state_CovidCases;
	}

	/**
	 * @param cases
	 */
	public void setCases(float cases) {
		this.state_CovidCases = cases;
	}

	/**
	 * @return
	 */
	public float getDeaths() {
		return state_CovidDeaths;
	}

	/**
	 * @param deaths
	 */
	public void setDeaths(float deaths) {
		this.state_CovidDeaths = deaths;
	}

	/**
	 * @return
	 */
	public int getMedianIncome() {
		return state_MedianIncome;
	}

	/**
	 * @param median
	 */
	public void setMedianIncome(int median) {
		this.state_MedianIncome = median;
	}

	/**
	 * @return
	 */
	public float getViolentCrime() {
		return state_ViolentCrime;
	}

	/**
	 * @param crime
	 */
	public void setViolentCrime(float crime) {
		this.state_ViolentCrime = crime;
	}

	/**
	 * @return
	 */
	public float getDR() {
		return ((this.state_CovidDeaths / this.state_Population) * 100000);
	}

	/**
	 * Prints States
	 */
	public void println() {

		System.out.printf("%-17s  %-10d\t %6.2f\t\t %-10.6f %10.2f\t  %8.2f \n", this.state_Name,
				this.state_MedianIncome, this.state_ViolentCrime, (this.state_CovidDeaths / this.state_CovidCases),
				((this.state_CovidCases) / (this.state_Population) * 100000),
				((this.state_CovidDeaths / this.state_Population) * 100000));
	}
	public String toString() {
		String str = String.format("%-17s  %-10d\t %6.2f\t\t %-10.6f %10.2f\t  %8.2f \n", this.state_Name,
				this.state_MedianIncome, this.state_ViolentCrime, (this.state_CovidDeaths / this.state_CovidCases),
				((this.state_CovidCases) / (this.state_Population) * 100000),
				((this.state_CovidDeaths / this.state_Population) * 100000));
		return str; 
	} 
}