public class vacationDestination {

	/**************** ATTRIBUTES *******************************************
	 ***********************************************************************/
	private String cityName;
	private int distance;
	private double moneySpent;
	private int date; //YYYYMMDD
	private boolean enjoyed;
	
	/**************** CONSTRUCTORS *****************************************
	 ***********************************************************************/
	public vacationDestination() {
	}
	
	public vacationDestination(String cityName, int distance, double moneySpent, int date, boolean enjoyed) {	//constructor
        this.cityName = cityName;			
		this.distance = distance;
		this.moneySpent = moneySpent;
		if (String.valueOf(date).length() != 8) {
			throw new IllegalArgumentException("vacationDestination: date has to be 8 digits long");	//EXCEPTION
		}	
		else {
			this.date = date;
		}
		this.enjoyed = enjoyed;
    }
	
	/***************** SETTERS / MUTATORS **********************************
	 ***********************************************************************/
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public void setMoneySpent(double moneySpent) {
		this.moneySpent = moneySpent;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public void setEnjoyed(boolean enjoyed) {
		this.enjoyed = enjoyed;
	}
    
	/**************** GETTERS / ACCESSORS **********************************
	 ***********************************************************************/
	public String getCityName() {
		return cityName;
	}
	public int getDistance() {
		return distance;
	}
	public double getMoneySpent() {
		return moneySpent;
	}
	public int getDate() {
		return date;
	}
	public boolean getEnjoyed() {
		return enjoyed;
	}	
	
	/**
	 * Converts an integer date YYYYMMDD to a MM/DD/YYYY format as a string
	 *
	 * @return string version of given integer date
	*/
	
	private String dateToString(int date) {	
		String a = Integer.toString(date);
		return a.substring(4,6) + "/" + a.substring(6,8) + "/" + a.substring(0,4);
	}
	
	/**
	 * Prints relevent information contained in the Class.
	 *
	 *	EXAMPLE print():
	 *	Destination: Tucson on 9/1/2015
	 *	Distance from home: 400 miles
	 *	Total expenses: 1050.99
	 *	This vacation was great!
	 *
	 * @see vacationDestination#dateToString()
	*/

	public void print() {
		System.out.println("Destination: " + cityName + " on " + dateToString(date));
		System.out.println("Distance from home: " + distance + " miles");
		System.out.println("Total expenses: " + moneySpent);
		System.out.println((enjoyed) ? "This vacation was great!" : "This vacation was not so great...");
    }

}
