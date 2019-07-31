import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Random;
import java.util.StringTokenizer;
import java.lang.Math;
import java.lang.String;


public class lab4Fall15 {


	public static void numberGuessingGame() throws IOException  {
		
		Scanner scan = new Scanner(System.in);
		PrintWriter mywriter = new PrintWriter("mysteryNumber.txt");
		Random randgen = new Random();
		

		int userNumber;
		int randomNumber;
		int numberInFile;
		int i;
		int userScore = 0;
		

		for (i = 0; i < 10; ++i) {
			randomNumber = randgen.nextInt(11);		//random # (0 - 10)
//			System.out.println(randomNumber);		//print test

			mywriter.println(randomNumber);		//stores randomNumber to "mysteryNumber.txt"
        }
		mywriter.close();


		FileReader fileread = new FileReader("./mysteryNumber.txt");
		BufferedReader textreader = new BufferedReader(fileread);
		

//		the number in your file is as follows:
		for (i = 0; i < 10; ++i) {

			numberInFile = Integer.valueOf(textreader.readLine());

//			System.out.println(numberInFile);		//print test
			
			System.out.print("Enter an interger between 0 and 10: ");
			userNumber = scan.nextInt();
			
			while (userNumber < 0 || userNumber > 10) {		//gets a (0 - 10) from user and checks to see if it is acceptable
				System.out.print("Invalid input\n Type an interger between 0 and 10: ");
				userNumber = scan.nextInt();
			}
			
			if (numberInFile == userNumber) {		//subtracts 10 if users guess correct
				userScore -= 10;
			}
			else{
				userScore += Math.abs(numberInFile - userNumber);		//adds abs(numberInFile - userNumber) if user is wrong
			}

			System.out.println("Score " + userScore);
		}
	
		textreader.close();
	
		System.out.println("Your total score is " + userScore);
	
	}

	

	
	public static void articlePricing() throws IOException  {

		Scanner scan = new Scanner(System.in);
		
		String fileName = "";
		String text = "";
		int totalWordCount = 0;
		int totalLineCount = 0;
	
		
		System.out.print("Enter the name of the file: ");		//asks user for the file name and saves it as fileName
		fileName = scan.next();
		
		// System.out.println(fileName);		//test print
		
		FileReader fileStream = new FileReader(fileName);
		BufferedReader textreader = new BufferedReader(fileStream);
		Scanner fileScan = new Scanner(textreader);
		
		while (fileScan.hasNext()) {		//checks to see if filescan can retrieve a value
			text = fileScan.nextLine();		//sets text equal to the string of the next line
			if (!text.isEmpty()) {
				StringTokenizer token = new StringTokenizer(text);			
				totalWordCount += token.countTokens();			//counts the total tokens/words and stores
				totalLineCount += 1;							//tallies the total number of lines
			}
		}
		
		fileStream.close();
		

		double price = (10.0 * (double)totalLineCount) + (0.25 * (double)totalWordCount);


		System.out.println("Total word count: " + totalWordCount);
		System.out.println("Total line count: " + totalLineCount);		
		
		System.out.printf("Price: $%.2f", price);
	}
	
	
	public static void main(String[] args) throws IOException {
		//numberGuessingGame();
		articlePricing();
	}
}
