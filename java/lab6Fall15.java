import java.util.Scanner;

public class lab6Fall15 {
	
	/********************************************************************
	 * ACTIVITY 1.1
	 * 1. What does the following method do?
	 * 2. Provide feedback about the coding style
	 * 3. Rewrite it in an appropriate manner
	 ********************************************************************/
	public static int mystery(int[] a, int minNum) {
	
		int curNum = minNum;
		int index = -1;

		for (int i = 0; i < a.length; i++) { 
			
			if (a[i] >= curNum) {
				
				curNum = a[i];
				index = i;
		
			}
		}

		return index;
	}

	
	
	
/********************************************************************
 * ACTIVITY 1.2
 * 1. What does the following method do?
 * 2. Provide feedback about the coding style
 * 3. Rewrite it in an appropriate manner
 ********************************************************************/
	public static void mystery2() {
		
		Scanner sc = new Scanner(System.in); 
		
		int arrayLength;
		
		System.out.println("Enter an array length: ");

		arrayLength = sc.nextInt();
	
		String[] strArray = new String[arrayLength];
		
		int[] intArray = new int[arrayLength];
	
		for (int i = 0; i < arrayLength; i++) {
			
			System.out.println("Enter string:");
			
			strArray[i] = sc.next();
	
			System.out.println("Enter number:");							
			
			intArray[i] = sc.nextInt();
		
		}
		
		int index = 0;
		int currentArray = intArray[0];

		for (int i = 1; i < arrayLength; i++) {

			if (intArray[i] < currentArray) {	

				currentArray = intArray[i];
				index = i;
				
			}
		
		}
	
		System.out.println("Lowest number: " + currentArray + " ; Lowest String: " + strArray[index] + ".");
		
	}	


		/********************************************************************
		 * ACTIVITY 2.1
		 * Method called minmax
		 * 1. This method takes an array A of integers (of any size) as a parameter
		 * 2. and returns an array of integers of size 2 that contains:
		 * 		- the minimum value in A (as the first element of the returned array)
		 * 		- the maximum value in A (as the second element of the returned array)
		 ********************************************************************/
		public static int[] minmax(int[] A) {
			
			int[] minmaxArray = new int[2];
			int currentMax = A[0];
			int currentMin = A[0];
			
			for (int i = 0; i < A.length; ++i) {
				
				if (currentMax < A[i]) {
					currentMax = A[i];
				}
				
				if (currentMin > A[i]) {
					currentMin = A[i];
				}
			}
			
			minmaxArray[0] = currentMin;
			minmaxArray[1] = currentMax;
			
			return minmaxArray;
		}
		
		/********************************************************************
		 * ACTIVITY 2.2
		 * Method called displayArray
		 * 1. This method takes an array A of integers (of any size) as a parameter
		 * 2. and displays this array
		 * 3. Write it (almost) from scratch (see below) in such a way that 
		 * 		the calls made in the main method will work properly
		 ********************************************************************/
		public static void displayArray(int[] A) {
			for (int i = 0; i < A.length; ++i) {
				System.out.println("" + A[i]);
			}
		}
		
		
		/***********************************************************************************/
		/************* MAIN METHOD *********************************************************/
		/************* This is where you write the name ************************************/
		/************* of the code you want to execute  ************************************/
		public static void main(String[] args) {
			
			int[] A = {1,-3, 4, -19, 35};
			displayArray(A);
			displayArray(minmax(A));
		}
}
