import java.util.Arrays;
import java.util.Scanner;

public class lab8Fall15 {
	/*****************************************************************************
	 * Activity 1. Factorial
	 * The factorial of a number is defined as follows:
	 * 		Factorial(n) = n x (n-1) x (n-2) x … x 2 x 1, for all n >= 1
	 * 		Factorial(0) = 1
	 *****************************************************************************/
	// iterative version of the Factorial method: 
	// hint: do use a for loop or a while loop
	public static int iterFactorial(int n) {
		
		if (n < 0) {
			System.out.println(n + "! is undefined.");
			return 0;
		}
		
		else if (n == 0 || n == 1) {
			return 1;
		}
		
		else {
			for (int i = n - 1; i > 0; --i) {
				n *= i;
			}
			return n;			
		}
	}
	
	// recursive version of the Factorial method:
	// hint: your code should contain a call to the method RecFactorial
	public static int recFactorial(int n) {
		
		if (n < 0) {
			System.out.println(n + "! is undefined.");
			return 0;
		}
		
		else if (n == 0 || n == 1) {
			return 1;
		}
		
		else {
			return n * recFactorial(n - 1);
		}
	}

	// a third version of this method has to be implemented in Prolog
	// see prolog file provided with this lab.
	
	/*****************************************************************************
	 * Activity 2. Fibonacci numbers
	 * Fibonacci numbers are defined as the following series:
	 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, …,  
	 * where every Fibonacci number is the sum of the previous two Fibonacci numbers:
	 * 		Fibonacci(n) = Fibonacci(n-1) + Fibonacci(n-2), for n >= 2
	 * 		Fibonacci(1) = 0
	 * 		Fibonacci(2) = 1
	 *****************************************************************************/
	// iterative version of the Fibonacci method: 
	// hint: do use a for loop and an array
	public static int iterFibonacci(int n) {
		
		int[] A = new int[n + 1];
		
		if (n <= 1) {
			return 0;
		}
		
		else if (n <= 2) {
			return 1;
		}
		
		else {
			
			A[0] = 0;
			A[1] = 1;
			A[2] = 1;
			
			for (int i = 2; i < n; ++i) {
				A[i] = A[i - 1] + A[i - 2];
			}
			
			return A[n - 1];
		}
	}
	
	// recursive version of the Fibonacci method:
	// hint: your code should contain a call to the method RecFibonacci
	public static int recFibonacci(int n) {
		if (n <= 1) {
			return 0;
		}
		else if (n <= 2) {
			return 1;
		}
		else {
			return recFibonacci(n - 1) + recFibonacci(n - 2);
		}
	}

	/*****************************************************************************
	 * Activity 3. Say-it-out-loud (SIOL) Sequence
	 * The say-it-out-loud sequence start with any number you want, say 1, and then goes as follows:
	 * 			1, 11, 21, 1211, 111221, 312211, …
	 * which is just the way you would say it: each number is the number before said out loud.
	 * Let’s look at the sequence again:
	 * 		•	We started with 1
	 * 		•	This is one 1: we write 11
	 * 		•	These are two ones: we write 21
	 * 		•	This is one 2 and one 1: we write 1211
	 * 		•	This is one 1, one 2, and two ones: 111221
	 * 		•	etc.
	 *****************************************************************************/
	// iterative version of the SIOL method: 
	// hint: you are going to need to use two loops 
	public static int[] iterSIOL(int seed, int n) {
		int[] result = new int[n];
		
		for (int i = 0; i < n; ++i) {
			if (i == 0) {
				result[0] = seed;
			}
			else {
				result[i] = SIOL(result[i - 1]);
			}
		}
		
		return result;
	}
	
	/**
	 * Takes an integer and returns a string out loud version of that integer as an integer.
	 * Ex. 1 -> 11, 1244 -> 111224
	*/
	
	public static int SIOL(int x) {
	
		int charCount;
		
		String A = Integer.toString(x); //integer converted to string
		String B = new String();		//used to store final output as a string
	
		for (int i = 0; i < A.length(); ++i) {
		
			charCount = 1;
		
			for (int j = i + 1; j < A.length(); ++j) {
				if (A.charAt(i) == A.charAt(j)) {
					++charCount;
					i = j;
				}
				else {
					break;
				}
		
			}	
		
			B = B + charCount + A.charAt(i);
		
		}
		
		return Integer.parseInt(B);
	
	}
	
	// recursive version of the SIOL method: 
	// hint: you may need to define a new auxiliary method
	public static int[] recSIOL(int seed, int n) {
		
		int[] result = new int[n];
		int i = 0;
		
		if (n > 0) {
			result = recSIOL(seed, n, i, result);
		}
		
		return result;
	}
	
	public static int[] recSIOL(int seed, int n, int i, int[] result) {
		
		if (n == 1) {
			result[i] = seed;
		}
		else {
			result[i] = seed;
			recSIOL(SIOL(seed), n - 1, ++i, result);
		}
		
		return result;
	}
	
	/*****************************************************************************
	 * Activity 4. Palindrome
	 * A word is a palindrome if it has the same spelling whether read from left 
	 * to right or from right to left. For instance, kayak is a palindrome 
	 * and racecar is a palindrome.
	 *****************************************************************************/
	// iterative version of the Palindrome method: 
	// hint: you are going to need to use a loop (while or for) 
	public static boolean iterPalindrome(String input) {
		
		input = input.toLowerCase();
		
		for (int i = 0; i < input.length() / 2; ++i) {
			if (input.charAt(i) != input.charAt(input.length() - 1 - i)) {
				return false;
			}
		}
		
		return true;
	}

	// recursive version of the Palindrome method:
	public static boolean recPalindrome(String input) {
		
		input = input.toLowerCase();
		
		if (input.length() == 1 || input.length() == 0) {
			return true;
		}
		else if (input.charAt(0) == input.charAt(input.length() - 1)) {
			return recPalindrome(input.substring(1, input.length() - 1));
		}
		else {
			return false;
		}
		
	}
	
	/*****************************************************************************
	 * Activity 5. Selection sort
	 *****************************************************************************/

	// the code below if the one you have to trace (see lab instructions)
	public static void iterSelectionSort(int[] A) {
		int max;
		int index;
		int aux;
		
		for (int size = A.length - 1; size > 0; --size) {
			max = A[0];
			index = 0;
			for (int i = 1; i <= size; ++i) {
				if (A[i] > max) {
					max = A[i];
					index = i;
				}
			}
			aux = A[index];
			A[index] = A[size];
			A[size] = aux;
		}

	}
	
	// recursive version of selection sort
	public static void recSelectionSort(int[] A) {
		recSelectionSort(A, A.length - 1);
	}
	
	public static void recSelectionSort(int[] A, int n) {
		int temp;
		
		if (n != 0) {
			for (int i = 0; i < n; ++i) {
				if (A[i] > A[n]) {
					temp = A[i];
					A[i] = A[n];
					A[n] = temp;
				}
				
				recSelectionSort(A, n - 1);
				
			}
			
		}
	}
	
	
	/***************************************************************************
	 * Main Method
	 ***************************************************************************/
	public static void main(String[] args) {
		
		int choice, x, y;
		String A;
		
		Scanner sc = new Scanner(System.in);
		
		do {
		
			System.out.println("Enter the number for the method you wish to test:");
			System.out.println("1: iterFactorial()");
			System.out.println("2: recFactorial()");
			System.out.println("3: iterFibonacci()");
			System.out.println("4: recFibonacci()");
			System.out.println("5: iterSIOL()");
			System.out.println("6: recSIOL()");
			System.out.println("7: iterPalindrome()");
			System.out.println("8: recPalindrome()");
			System.out.println("9: recSelectionSort()");
			System.out.println("0: Quit");
			
			choice = sc.nextInt();
		
			switch (choice) {
				case 1:
					System.out.print("!");
					x = sc.nextInt();
					System.out.println("!" + x + " = " + iterFactorial(x));
					break;
				case 2:
					System.out.print("!");
					x = sc.nextInt();
					System.out.println("!" + x + " = " + recFactorial(x));
					break;
				case 3:
					System.out.print("Length: ");
					x = sc.nextInt();
					System.out.println(iterFibonacci(x));
					break;
				case 4:
					System.out.print("Length: ");
					x = sc.nextInt();
					System.out.println(recFibonacci(x));
					break;				
				case 5:
					System.out.println("Enter a seed number and a length: ");
					System.out.print("Seed number: ");
					x = sc.nextInt();
					System.out.print("Length: ");
					y = sc.nextInt();
					System.out.println(Arrays.toString(iterSIOL(x, y)));
					break;
				case 6:
					System.out.println("Enter a seed number and a length: ");
					System.out.print("Seed number: ");
					x = sc.nextInt();
					System.out.print("Length: ");
					y = sc.nextInt();
					System.out.println(Arrays.toString(recSIOL(x, y)));
					break;
				case 7:
					System.out.println("Enter a String: ");
					System.out.print("String: ");
					A = sc.next();
					if (iterPalindrome(A)) {
						System.out.println("True");
					}
					else {
						System.out.println("False");
					}
					break;
				case 8:
					System.out.println("Enter a String: ");
					System.out.print("String: ");
					A = sc.next();
					if (recPalindrome(A)) {
						System.out.println("True");
					}
					else {
						System.out.println("False");
					}
					break;	
				case 9:
					System.out.println("Enter an array: ");
					System.out.print("Length of array: ");
					x = sc.nextInt();
					int[] unsortedArray = new int[x];
					for (int i = 0; i < x; ++i) {
						System.out.print("Enter a number: ");
						unsortedArray[i] = sc.nextInt();
					}
					recSelectionSort(unsortedArray);
					System.out.println(Arrays.toString(unsortedArray));
				default:
					break;
			}
		
		}
		
		while (choice > 0 && choice <= 9);

	}
}
