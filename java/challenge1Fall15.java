import java.lang.RuntimeException;
import java.util.Scanner;

public class challenge1Fall15 {

	/****************** METHOD Conversion ******************************************** 
	 * Method Conversion takes the following inputs:
	 * •	The number the user plans to convert;
	 * •	The original base (an integer); and 
	 * •	The target base (an integer);
	 * And it returns the number, given in the original base, now translated in 
	 * the target base.
	 * Note: the base numbers can be anything between 2 and 36.
	 *********************************************************************************/
	public static String Conversion(String number, int original, int target) {
		
		StringBuffer sb = new StringBuffer("");
		
		String str = "";
		final String alphabet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int baseTen = 0;
		int j = number.length();
		
	
		for (int i = 0; i < number.length(); ++i) {
				
			--j;
				
			if (((number.charAt(j) >= 48 && number.charAt(j) <= (47 + original)) 		//checks to see if the number is within parameters i.e. 0 - 9
					|| ((Character.toUpperCase(number.charAt(j)) <= (65 + original) 
					&& Character.toUpperCase(number.charAt(j)) >= 65) && ((original > 10) && (original <= 36))))		//checks to see if any character values are within parameters i.e. A to Z
					&& ((original >= 2 && original <= 36) && (target >= 2 && target <= 36))) {		//checks to see if the bases are within parameters i.e. 2 to 36
			
				if (Character.isLetter(number.charAt(j))) {

					baseTen += (Character.toUpperCase(number.charAt(j)) - 55) * Math.pow(original, i);				
				
				}
			
				else {
					
					baseTen += (number.charAt(j) - 48)  * Math.pow(original, i);
				
				}
			}
			
			else {
				
				baseTen = 0;		//set to 0 so it kills while loop
				break;		//exits loop if parameters are bad, this will cause the method to return a blank string
			
			}
		}
		
		while (!(baseTen == 0)) {
			
			sb.insert(0, alphabet.charAt(baseTen % target));
			
			baseTen /= target;
		
		}
		
		str = sb.toString();
		
		return str;
	}
	
	
	
	/***********************************************************************************/
	/************* MAIN METHOD *********************************************************/
	/************* This is where you write the name ************************************/
	/************* of the code you want to execute  ************************************/
	public static void main(String[] args) {
		
		int first, last;
		String number = "";
		char testChar;
		boolean testBoo = false;
		
		
		Scanner sc = new Scanner(System.in);
		
		while (testBoo == false) {

			System.out.print("Enter the number you would like to convert: ");
			number = sc.next();
			System.out.print("Enter that numbers base: ");
			first = sc.nextInt();
			System.out.print("Enter the base you would like to convert to: ");
			last = sc.nextInt();
		
			System.out.println(Conversion(number, first, last));
			
			System.out.print("Would you like to continue? (y/n)");
			testChar = sc.next().charAt(0);
			
			if (testChar == 'n' || testChar == 'N') {
				testBoo = true;
			}
			
		}
		
		
		// System.out.println((Conversion("475762", 10, 2).equals("1110100001001110010")) ? "true" : "((10, 2) == 0) failed");			//test cases
		// System.out.println((Conversion("1E", 16, 2).equals("11110")) ? "true": "(16, 2) failed");
		// System.out.println((Conversion("101010", 2, 3).equals("1120")) ? "true" : "(2, 3) failed");
		// System.out.println((Conversion("111011110", 2, 12).equals("33A")) ? "true" : "(2, 12) failed");
		// System.out.println((Conversion("6715317", 8, 14).equals("351419")) ? "true"	: "(8, 14) failed");
		// System.out.println((Conversion("2D4A9E", 15, 13).equals("5BA0CC")) ? "true" : "(15, 13) failed");
		// System.out.println((Conversion("ZZZZZZ", 15, 13).equals("")) ? "true" : "(ZZZZZZ) failed");
		// System.out.println((Conversion("12", -1, 2).equals("")) ? "true" : "(-1, 2) failed");
		// System.out.println((Conversion("12", 3, 37).equals("")) ? "true" : "(3, 37) failed");
		
	}
	
}
