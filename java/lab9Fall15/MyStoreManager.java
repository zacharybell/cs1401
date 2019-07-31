import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MyStoreManager {
	
	/**********************************************************************************
	 * ReadFromFile: 
	 * This method takes the name of a file as parameter: the given file contains 
	 * information about video games. 
	 * It reads the information and fills an array of videogames with this information. 
	 * It returns the array of video games. 
	 ***********************************************************************************/
	public static VideoGame[] readFromFile(String filename) throws IOException {
		
		Scanner sc = new Scanner(new BufferedReader(new FileReader(filename)));
		
		int counter = 0;
		
		String name = new String();
		double price;
		int numberSold;
		String typeOfGame = new String();
		
		while (sc.hasNextLine()) {
			sc.nextLine();
			++counter;
		}
		
		sc.close();
		
		sc = new Scanner(new BufferedReader(new FileReader(filename)));
		
		VideoGame[] games = new VideoGame[counter / 4];
		
		for (int i = 0; i < (counter / 4); ++i) {
			games[i] = new VideoGame();
			
			games[i].setName(sc.nextLine());
			games[i].setPrice(Double.valueOf(sc.nextLine()));
			games[i].setNumberSold(Integer.valueOf(sc.nextLine()));
			games[i].setTypeOfGame(sc.nextLine());
		}
		
		sc.close();
		
		return games;
	
	}
	
	/**********************************************************************************
	 * SortBySold: 
	 * This method takes an array of video games as an input and sorts it by the number 
	 * of items sold of each video game. 
	 * Use the same selection sort algorithm as you implemented in lab8 
	 * – just modify it slightly.
	 ***********************************************************************************/
	public static void sortBySold(VideoGame[] myVideoGames) {
		
		VideoGame temp = new VideoGame();
		
		for (int i = 0; i < myVideoGames.length; ++i) {
			
			for (int j = i + 1; j < myVideoGames.length; ++j) {
				if (myVideoGames[j].getNumberSold() > myVideoGames[i].getNumberSold()) {
					temp = myVideoGames[i];
					myVideoGames[i] = myVideoGames[j];
					myVideoGames[j] = temp;
				}
			}
		
		}
	
	}
	
	/**********************************************************************************
	 * SortByPrice: 
	 * This method takes an array of video games as an input and sorts it by the price 
	 * of each video game. 
	 * Use the same selection sort algorithm as you implemented in lab8 
	 * – just modify it slightly.
	 ***********************************************************************************/
	public static void sortByPrice(VideoGame[] myVideoGames) {
		
		VideoGame temp = new VideoGame();
		
		for (int i = 0; i < myVideoGames.length; ++i) {
			
			for (int j = i + 1; j < myVideoGames.length; ++j) {
				if (myVideoGames[j].getPrice() > myVideoGames[i].getPrice()) {
					temp = myVideoGames[i];
					myVideoGames[i] = myVideoGames[j];
					myVideoGames[j] = temp;
				}
			}
		
		}
	}

	/**********************************************************************************
	 * SortByType: 
	 * This method takes an array of video games as an input and sorts it by the type 
	 * of each video game. 
	 * Use the same selection sort algorithm as you implemented in lab8 
	 * – just modify it slightly.
	 ***********************************************************************************/
	public static void sortByType(VideoGame[] myVideoGames) {

	for (int i = 0; i < myVideoGames.length; ++i) {
			
			VideoGame temp = new VideoGame();
			
			for (int j = i + 1; j < myVideoGames.length; ++j) {
				if (myVideoGames[j].getTypeOfGame().compareTo(myVideoGames[i].getTypeOfGame()) < 0) {
					temp = myVideoGames[i];
					myVideoGames[i] = myVideoGames[j];
					myVideoGames[j] = temp;
				}
			}
		
		}
	}

	/**********************************************************************************
	 * TotalSales: 
	 * This method takes an array of video games and returns the total amount of money 
	 * gotten from sales of the video games. 
	 ***********************************************************************************/
	public static double totalSales(VideoGame[] myVideoGames) {
		double total = 0.0;
		for (int i = 0; i < myVideoGames.length; ++i) {
			total += (myVideoGames[i].getPrice() * myVideoGames[i].getNumberSold() );
		}
		return total;
	}

	/**********************************************************************************
	 * Lottery: 
	 * This method takes an array of video games and returns a randomly picked video game.
	 ***********************************************************************************/
	public static VideoGame lottery(VideoGame[] myVideoGames) {
		Random rand = new Random();
		return myVideoGames[rand.nextInt(myVideoGames.length)];
	}


	/**********************************************************************************
	 * The main method in which you test all the above methods
	 * and in which you implement the scenario given to you in the lab assignment 
	 * docx file.
	 ***********************************************************************************/
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		int choice;
	
		try {	
			System.out.print("Enter the name of a file: ");
			String fileName = sc.next();
			VideoGame[] games = readFromFile(fileName);	

		
			do {	
		
				System.out.println("Enter the number for the method you wish to run:");
				System.out.println("1: sortBySold()");
				System.out.println("2: sortByPrice()");
				System.out.println("3: sortByType()");
				System.out.println("4: totalSales()");
				System.out.println("5: lottery()");
				System.out.println("0: Quit");
			
				choice = sc.nextInt();
			
				switch (choice) {
					case 1:
						sortBySold(games);
					
						System.out.println("BEST SELLING VIDEO GAME");
						System.out.print("Name: ");
						System.out.println(games[0].getName());
						System.out.print("Number Sold: ");
						System.out.println(games[0].getNumberSold());
						System.out.println("");
					
						break;
					case 2:
						sortByPrice(games);
					
						System.out.println("GAME WITH THE LOWEST PRICE");
						System.out.print("Name: ");
						System.out.println("" + games[games.length - 1].getName());
						System.out.print("Price: ");
						System.out.printf("$%.2f\n", games[games.length - 1].getPrice());
						System.out.println("");
					
						break;
					case 3:
						sortByType(games);
					
						int count = 1;
						System.out.println("LIST OF GAMES BY TYPE");
					
						for (int i = 0; i < games.length; ++i) {
							if (i == (games.length - 1)) {
								System.out.println(games[i].getTypeOfGame() + ": " + count);
							}
							else if (games[i].getTypeOfGame().equals(games[i + 1].getTypeOfGame())) {
								++count;
							}
							else {
							System.out.println(games[i].getTypeOfGame() + ": " + count);
							count = 1;
							}
						}
					
						System.out.println("");
					
						break;				
					case 4:
						System.out.println("TOTAL SALES");
						System.out.print("Total: ");
						System.out.printf("$%.2f\n", totalSales(games));
						System.out.println("");
					
						break;
					case 5:
						System.out.println("LOTTERY");
						System.out.print("Lottery game description: ");
						lottery(games).Print();
						System.out.println("");
					
						break;
					default:
						System.out.println("Exiting...");
						break;
				}
			}
			
			while (choice > 0 && choice <= 5);
		
		}
	
		catch (FileNotFoundException fnfe) {
			System.out.println("File Not Found!");
			System.out.println("Continue(y/n)");
			System.out.print("?");
			String cont = sc.next();
			if (cont.charAt(0) == 'y' || cont.charAt(0) == 'Y') {
				main(null);
			}
			else {
				System.out.println("Exiting...");
			}
		}


	}



}
