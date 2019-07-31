import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Scanner;
import java.lang.String;
import java.lang.Math;

/****** Expected Outcomes *************************/
/** Repeat statements							***/
/** Recap of input / output on System.out / in  ***/
/** Strings										***/
/**************************************************/

public class lab5Fall15 {
	
	
	/*********************************************************************************/
	/****************** ACTIVITY 1: STRING MATCHING **********************************/
	
	/*********************************************************************************/
	/****************** METHOD 1: lastIndexSubStringMatch ****************************
	 * Write a method, called lastIndexSubStringMatch, which takes three arguments (parameters): 
	 * 		- a key string, 
	 * 		- a target string, and 
	 * 		- an integer index. 
	 * This method checks if the key string appears in the target string after (including) character 
	 * at location index.
	 * It will return the last index of the first occurrence if the key string does appear in the 
	 * target string after location index.
	 * It will return -1 otherwise.
	 *********************************************************************************/
	public static int lastIndexSubStringMatch(String Key, String Target, int index) {
		
		int lastIndex = -1;
		int charCount;
		
		for (int i = index; i <= Target.length() - Key.length(); ++i) {
			
			charCount = 0;
			
			for(int j = 0; j < Key.length(); ++j) {
			
				if (Target.charAt(i + j) == Key.charAt(j)) {
					++charCount;
				}
				else {
					break;
				}
			
			}
			
			if (charCount == Key.length()) {
				lastIndex = i + charCount - 1;
				break;
			}
		}
		
		return lastIndex;
		
	}

	/*********************************************************************************/
	/****************** METHOD 2: countSubStringMatch ******************************** 
	 * Write a method, called countSubStringMatch, which takes two arguments: 
	 * 		- a key string and 
	 * 		- a target string. 
	 * This method iteratively counts the number of instances of the key string in 
	 * the target string.
	 *********************************************************************************/
	public static int countSubStringMatch(String Key, String Target) {
		int occurrences = 0;
		
		for (int i = 0; i <= (Target.length() - Key.length()); ++i) {
			if (lastIndexSubStringMatch(Key, Target, i) != -1) {
				++occurrences;
				i = lastIndexSubStringMatch(Key, Target, i);
			}
		}
		
		return occurrences;
	}
	
	/*********************************************************************************/
	/****************** METHOD 3: ratioSubStringMatch ******************************** 
	 * Write a method, called ratioSubStringMatch, which takes two arguments: 
	 * 		- a key string and 
	 * 		- a target string. 
	 * This method will return the percentage of likeliness of the target string and 
	 * the key string. 
	 *********************************************************************************/
	public static double ratioSubStringMatch(String Key, String Target) {
		double ratio = 0;

		ratio = (((double)Key.length() * (double)countSubStringMatch(Key, Target)) / (double)Target.length()) * 100.0;
		
		return ratio;
	}
	
	/*********************************************************************************/
	/****************** METHOD 4: SubStringMatch ******************************** 
	 * Write a method called SubStringMatch, which takes three arguments: 
	 * 		- the name of a file, 
	 * 		- and two integers, called first and second, representing line numbers in the file. 
	 * This method returns the result of ratioSubStringMatch applied to the string at 
	 * line first and the string at line second.
	 *********************************************************************************/
	public static double SubStringMatch(String filename, int first, int second) throws IOException {
		double ratio = 0;
		String FirstString = "";
		String SecondString = "";
		
		Scanner sc = new Scanner(new BufferedReader(new FileReader(filename)));
		
		for (int i = 0; i < Math.max(first, second); ++i)	{		//assigns strings in file to FirstString and SecondString
			
			if (sc.hasNext()) {
				if (first == second) {		//ensures a value is returned even if the user enters the same two ints arguements into the method
					FirstString = sc.nextLine();
					SecondString = FirstString;
					break;
				}
				
				else if (first == (i + 1))  {
					FirstString = sc.nextLine();
				}
				
				else if (second == (i + 1)) {
					SecondString = sc.nextLine();
				}
				
				else if (!FirstString.isEmpty() && !SecondString.isEmpty()) {		//checks to see if the values have been filled and exits the loop
					break;
				}
				
				else {
					sc.nextLine();
				}
			}
			
			else if (FirstString.isEmpty() || SecondString.isEmpty()) {
				ratio = -1;
				break;
			}
			
		}
		sc.close();
		
		//System.out.println(FirstString + " " + SecondString);		//print test
		
		if (FirstString.length() > SecondString.length()) {
			ratio = ratioSubStringMatch(SecondString, FirstString);
		}
		
		else {
			ratio = ratioSubStringMatch(FirstString, SecondString);
		}
		
		return ratio;
	}
	
	/*********************************************************************************/
	/****************** CHALLENGE ACTIVITY (OPTIONAL) ********************************
	 * **************** METHOD MaxRatioSubString ************************************* 
	 * Write a method MaxRatioSubString, which takes one argument: 
	 * 		- the name of a file, containing one string per line. 
	 * It finds the two strings in the file with the maximum percentage of likeliness 
	 * (value of ratioSubStringMatch), displays these two strings along with their 
	 * percentage of likeliness (value of ratioSubStringMatch), and also writes 
	 * this information at the bottom of the given file.
	 *********************************************************************************/
	public static double MaxRatioSubString(String filename) throws IOException {

		int counter = 0;
		double bestMatch = 0.0;
		int first = 0;
		int second = 0;
		
		Scanner sc = new Scanner(new BufferedReader(new FileReader(filename)));
		
		while (sc.hasNext()) {			//counts the number of lines in the file
			sc.nextLine();
			++counter;
		}
		sc.close();
		
		for (int i = 1; i <= counter; ++i) {;
			for (int j = i + 1; j <= counter; ++j) {
				if (SubStringMatch(filename, i, j) > bestMatch) {
					bestMatch = SubStringMatch(filename, i, j);
					first = i;
					second = j;
				} 
			}
		}
		
		PrintWriter wr = new PrintWriter(new BufferedWriter(new FileWriter(filename, true)));
		wr.println("");
		wr.println("Best match at line " + first + " and " + second + " have a " + bestMatch + "% match!");
		wr.close();

		System.out.println("The first string at line:" + first + " is:");
		PrintSubString(filename, first);
		System.out.println("The second string at line:" + second + " is:");
		PrintSubString(filename, second);
		
		return bestMatch;
	
	}
	
	public static void PrintSubString(String filename, int index) throws IOException {
		//Note: index starts at 1
		Scanner sc = new Scanner(new BufferedReader(new FileReader(filename)));
		
		int i = 0;
		
		while (sc.hasNext()) {
			
			++i;
			
			if (index == i) {
				System.out.println(sc.nextLine());
			}
			else {
				sc.nextLine();
			}
		}
		
		sc.close();
	}
	
	/***********************************************************************************/
	/************* MAIN METHOD *********************************************************/
	/************* This is where you write the name ************************************/
	/************* of the code you want to execute  ************************************/
	public static void main(String[] args) throws IOException {
		
		int choice;
		
		Scanner sc = new Scanner(System.in);
		
		String Key = "";
		String Target = "";
		String filename = "";
		
		int index, first, second;
		
		do {
		
			System.out.println("Enter the number for the method you wish to test:");
			System.out.println("1: lastIndexSubStringMatch()");
			System.out.println("2: countSubStringMatch()");
			System.out.println("3: ratioSubStringMatch()");
			System.out.println("4: SubStringMatch()");
			System.out.println("5: MaxRatioSubString()");
			System.out.println("0: Quit");
			
			choice = sc.nextInt();
		
			switch (choice) {
				case 1:
					System.out.println("Enter String Key, String Target, int index:");
					System.out.print("Key: ");
					Key = sc.next();
					System.out.print("Target: ");
					Target = sc.next();
					System.out.print("Index: ");
					index = sc.nextInt();
					System.out.println("Returns " + lastIndexSubStringMatch(Key, Target, index));
					break;
				case 2:
					System.out.println("Enter String Key, String Target:");
					System.out.print("Key: ");
					Key = sc.next();
					System.out.print("Target: ");
					Target = sc.next();
					System.out.println("Returns " + countSubStringMatch(Key, Target));
					break;
				case 3:
					System.out.println("Enter String Key, String Target:");
					System.out.print("Key: ");
					Key = sc.next();
					System.out.print("Target: ");
					Target = sc.next();
					System.out.println("Returns " + ratioSubStringMatch(Key, Target) + "%");
					break;
				case 4:
					System.out.println("Enter String filename, int first line number, int second line number:");
					System.out.print("filename: ");
					filename = sc.next();
					System.out.print("first: ");
					first = sc.nextInt();
					System.out.print("second: ");
					second = sc.nextInt();
					System.out.println("Returns " + SubStringMatch(filename, first, second));
					break;
				case 5:
					System.out.println("Enter String filename:");
					System.out.print("filename: ");
					filename = sc.next();
					System.out.println("Returns " + MaxRatioSubString(filename));
					break;
				default:
					break;
			}
		
		}
		
		while (choice > 0 && choice <= 5);

	}

}
