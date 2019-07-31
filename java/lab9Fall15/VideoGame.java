public class VideoGame {

	/**************** ATTRIBUTES *******************************************
	/* Here go your attributes, i.e., the information that is contained in 
	 * your new "type" 
	 * We can also see these new types as "blue-prints" of "things" we are 
	 * going to build 
	 * Expected attributes are:
	 * a.	A name: of type string
	 * b.	A price: of type double
	 * c.	A number of items sold: of type int
	 * d.	A type of game: of type string
	 ***********************************************************************/
	private String name;
	private double price;
	private int numberSold;
	private String typeOfGame;
	
	/**************** CONSTRUCTORS *****************************************
	 * note that the signatures are different from those we are used to 
	 ***********************************************************************/
	/* default constructor: provided to you. You should not touch the next two lines of code */
	public VideoGame() {
	}
	
	// your code goes here...
	public VideoGame(String name, double price, int numberSold, String typeOfGame) {
		this.name = name;
		this.price = price;
		this.numberSold = numberSold;
		this.typeOfGame = typeOfGame;
	}
	
	/***************** SETTERS / MUTATORS **********************************
	 * Methods that allow to set or modify the values of the attributes
	 * One method per attribute
	 * Note that the methods are not static (to be explained -- much -- later)
	 ***********************************************************************/
	/* one per attribute: we provide you with two, you have to provide the others */
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setNumberSold(int numberSold) {
		this.numberSold = numberSold;
	}
	public void setTypeOfGame(String typeOfGame) {
		this.typeOfGame = typeOfGame;
	}
	
	/**************** GETTERS / ACCESSORS **********************************
	 * Methods that allow to access the values of the attributes
	 * One method per attribute
	 * Note that the methods are not static (to be explained -- much -- later)
	 ***********************************************************************/
	/* one per attribute: we provide you with the one, you have to provide the others */
	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
	public int getNumberSold() {
		return numberSold;
	}
	public String getTypeOfGame() {
		return typeOfGame;
	}
	
	/***********************************************************************
	 * Other methods, depending on needs 
	 * Here we are asking you to design a method that prints the information
	 * about any video game
	 ***********************************************************************/
	public void Print() {
		System.out.println("Video Game " + name + " is a " + typeOfGame + " game. Its price is S" + price + ", and so far, " + numberSold + " items have been sold.");
	}
	
}
