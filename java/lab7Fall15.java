import java.lang.Math;
import java.util.Arrays;
import java.util.Scanner;


/****************************************************
 * In this lab, you will work on:
 * ** Arrays
 * ** Strings
 * ** Methods
 * and you will start working on testing (white box)
 * @author mceberio
 ****************************************************/

public class lab7Fall15 {

	/********************************************************************
	 * ACTIVITY 1.1
	 * Method called closest
	 * 1. This method takes an array A of integers (of any size) as a parameter
	 * 		Array A contains integers that can be positive, negative, both
	 * 2. It prints the indices of the two closest numbers along with their values
	 * 3. and returns an array of integers of size 2 that contains the values
	 * 		of the two closest numbers
	 ********************************************************************/
	public static int[] closest(int[] A) {

		int first = 0;			//the first index of the closest int
		int second = 0;			//the second index of the closest int
		int gap = -1;			//sets the gap to -1 because abs(A[x] - A[x + n]) can never equal -1
		int[] B = new int[2];	//the return array
		
		if (A.length > 1) {		//decides if gap should be set
			gap = Math.abs(A[0] - A[1]) + 1;
		}
		
		
		for (int i = 0; i < A.length ;++i ) {
			for (int j = i + 1; j < A.length; ++j) {
				if (Math.abs(A[i] - A[j]) < gap) {		
					
					gap = Math.abs(A[i] - A[j]);
					
					B[0] = A[i];
					B[1] = A[j];
					
					first = i;
					second = j;
				}
			}
		}

		if (gap != -1) {		//won't print unless gap has been set (i.e. there were two ints present in array A)
			
			System.out.println("The two closest integers in " + Arrays.toString(A) + " are " + B[0] + " and " + B[1] + ", respectively at indices " + first + 
					" and " + second);
		}
		
		//System.out.println("Array B: " + Arrays.toString(B));

		return B;
		
	}
	
	
	/********************************************************************
	 * ACTIVITY 1.2
	 * Method called prefix
	 * 1. This method takes two strings str1 and str2 as parameters
	 * 2. and returns:
	 * 		- true if str1 is the start of str2 (i.e., str1 is a prefix of str2)
	 * 		- true if str2 is the start of str1 (i.e., str2 is a prefix of str1)
	 *  	- false otherwise
	 *  NOTE 1: you should not use the method subString
	 *  NOTE 2: you will get extra credit if you manage to break your code
	 *  		into two methods to make it easier to read
	 ********************************************************************/
	public static boolean prefix(String str1, String str2) {

		boolean isPrefix = false;
		int minLength = Math.min(str1.length(), str2.length());


		for (int i = 0; i < Math.min(str1.length(), str2.length()); ++i) {

 			if (charIsEqual(str1, str2, i)) {
				
				--minLength;
				
				if (minLength == 0) {
					isPrefix = true;
				}
			}

		}			
	
		return isPrefix;
	}
	
	public static boolean charIsEqual(String str1, String str2, int index) {
		
		if(str1.charAt(index) == str2.charAt(index)) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	
	/********************************************************************
	 * ACTIVITY 2
	 * Write a White-Box testing strategy for Method Closest
	 * To be done in the docx file only
	 ********************************************************************/
	
	
	/***********************************************************************************/
	/************* MAIN METHOD *********************************************************/
	/************* This is where you write the name ************************************/
	/************* of the code you want to execute  ************************************/
	public static void main(String[] args) {
		
		int[] A = {1,-3, 4, -19, 35};

		

		Scanner sc = new Scanner(System.in);
		
		int choice = 0;
		int length;
		String string1 = new String();
		String string2 = new String();
		
		do {
		
			System.out.println("Enter the number for the method you wish to test:");
			System.out.println("1: closest()");
			System.out.println("2: prefix()");
			System.out.println("0: Quit");
			
			choice = sc.nextInt();
		
			switch (choice) {
				case 1:
					System.out.println("Enter the length of your array: ");
					System.out.print("Length: ");
					length = sc.nextInt();

					int[] intArray = new int[length];

					for (int i = 0; i < length; ++i) {
						System.out.print("Enter a number: ");
						intArray[i] = sc.nextInt();
					}
				
					int[] results = closest(intArray);
					break;
				
				case 2:
					System.out.println("Enter two strings");
					System.out.print("String 1: ");
					string1 = sc.next();
					System.out.print("String 2: ");
					string2 = sc.next();
					
					if (prefix(string1, string2) && (string1.length() < string2.length())) {
						System.out.println(string1 + " is a prefix of " + string2 + ".");
					}
					else if (prefix(string1, string2) && (string2.length() <= string1.length())) {
						System.out.println(string2 + " is a prefix of " + string1 + ".");
					}
					else {
						System.out.println("There are no prefixes present.");
					}
					break;
				
				default:
					break;
			}
		
		}
		
		while (choice > 0 && choice <= 2);
	}

}
