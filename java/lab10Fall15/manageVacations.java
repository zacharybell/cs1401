import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.Throwable;
import java.util.Scanner;

public class manageVacations {

	/******************** ARRAYS OF OBJECTS **************************************/
	
	/*****************************************************************************
	 * A method, readVacation, that takes a file name as a string – this file 
	 * contains vacation information, and returns an array of items of type 
	 * vacationDestination. This method should handle file reading errors via 
	 * exception handling.
	 *****************************************************************************/
	public static vacationDestination[] readFromFile(String filename) throws IOException {
		
		Scanner sc = new Scanner(new BufferedReader(new FileReader(filename)));

        int counter = 0;
				
		while (sc.hasNextLine()) {
			sc.nextLine();
			++counter;
		}
		
		sc.close();
		
		sc = new Scanner(new BufferedReader(new FileReader(filename)));
		
		vacationDestination[] vd = new vacationDestination[counter / 5];
		
		for (int i = 0; i < (counter / 5); ++i) {
			
			vd[i] = new vacationDestination();
			
			vd[i].setCityName(sc.nextLine());
			vd[i].setDistance(Integer.valueOf(sc.nextLine()));
			vd[i].setMoneySpent(Double.valueOf(sc.nextLine()));
			vd[i].setDate(Integer.valueOf(sc.nextLine()));
			vd[i].setEnjoyed(Boolean.valueOf(sc.nextLine()));
			
		}
		
		sc.close();
		
		return vd;
    }

	
	/*****************************************************************************
	 * A method, sortDate, that takes an array of items of type vacationDestination, 
	 * and sorts them by date, from oldest to newest. 
	 *****************************************************************************/
	public static void sortByDate(vacationDestination[] vacations) {

        vacationDestination temp = new vacationDestination();
		
		for (int i = 0; i < vacations.length; ++i) {
			for (int j = i + 1; j < vacations.length; ++j) {
				if (vacations[i].getDate() > vacations[j].getDate()) {

					temp = vacations[i];
					vacations[i] = vacations[j];
					vacations[j] = temp;
				
				}
			}
		}
		
    }
	
	/*****************************************************************************
	 * A method, earliest, that takes an array of items of type vacationDestination, 
	 * and returns the date your oldest vacation destinations.
	 *****************************************************************************/
	public static int earliest(vacationDestination[] vacations) {
		
		int minimum;
		
		if (vacations.length > 0) {	
			minimum = vacations[0].getDate();
		}
		
		else {
			throw new IllegalArgumentException("earliest(): Array doesn't contain values");		//EXCEPTION
		}
		
        for (int i = 0; i < vacations.length; ++i) {
			if (vacations[i].getDate() < minimum) {
				minimum = vacations[i].getDate();
			}
		}
		
		return minimum;
    }
	
	/*****************************************************************************
	 * A method, enjoyed, that takes an array of items of type vacationDestination, 
	 * and returns the number of vacation destinations that were enjoyed.
	 *****************************************************************************/
	public static int Enjoyed(vacationDestination[] vacations) {

        int enjoyedCount = 0;
		
		for (int i = 0; i < vacations.length; ++i) {
			if (vacations[i].getEnjoyed() == true) {
				++enjoyedCount;
			}
		}
		
		return enjoyedCount;
	}
	
	/*****************************************************************************
	 * A recursive method, enjoyed, that takes an array of items of type 
	 * vacationDestination, and returns the number of vacation destinations that 
	 * were enjoyed.
	 *****************************************************************************/
	public static int recEnjoyed(vacationDestination[] vacations, int n) {

        if (n < 0) {
			return 0;
		}
		else if (vacations[n].getEnjoyed() == true) {
			return 1 + recEnjoyed(vacations, n - 1);
		}
		else {
			return recEnjoyed(vacations, n - 1);
		}
		
	}
	
	/*****************************************************************************
	 * A method, betterClose, that takes:
	 * 	o	an array of items of type vacationDestination; as well as 
	 * 	o	an integer named dist that represents a distance in miles, 
	 * and returns:
	 * 	o	true if there are more (>=) vacation destinations in the array that are 
	 * closer than (<=) dist from home that were enjoyed, than vacation destinations 
	 * in the array that are farther than (>) dist from home and that were enjoyed; and 
	 * 	o	false if there are less (<) vacation destinations in the array that are 
	 * closer than (<=) dist from home that were enjoyed, than vacation destinations 
	 * in the array that are farther than (>) dist from home and that were enjoyed.
	 ******************************************************************************/ 
	public static boolean betterClose(vacationDestination[] vacations, int dist) {

        int nearCount = 0;
		int farCount = 0;
		
		for (int i = 0; i < vacations.length; ++i) {
			if ((vacations[i].getDistance() <= dist) && (vacations[i].getEnjoyed() == true)) {
				++nearCount;
			}
			else if ((vacations[i].getDistance() > dist) && (vacations[i].getEnjoyed() == true)) {
				++farCount;
			}
		}
		
		if (nearCount >= farCount) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	/*************** LINKED LISTS OF OBJECTS **************************************/
	
	/******************************************************************************
	 * A method buildLL that takes an array of items of type vacationDestination
	 * and returns a linked list of type vacDestinationLL
	 ******************************************************************************/
	
	public static vacDestinationLL buildLL(vacationDestination[] vacations) {
		
		vacDestinationLL newLinkedList = new vacDestinationLL();

		for (int i = 0; i < vacations.length; ++i) {
			newLinkedList.addTail(vacations[i]);
		}
		
		return newLinkedList;
	}
	
	
	/******************************************************************************
	 * A method chronoLLinsert that takes:
     *      a.	an array of vacationDestination vacations; and 
     *      b.	a vacationDestination extraVacation, 
     * and returns a linked-list of all of the items in vacations in chronological 
     * order (from oldest to newest) as well as extraVacation inserted at the right chronological 
     * position to ensure that the resulting list is sorting in ascending chronological order.
     * Hint: you will need to use the method sortDate and the method addTail.
	 ******************************************************************************/
	 
	 /*
	  * Takes an array of vacations and an extra vacations and sorts them by their date.
	  *
	  * @see vacDestinationLL#addTail(vacationDestination vacation)
	  * @see #sortByDate(vacationDestination[] vacations)
	  * @see #buildLL(vacationDestination[] vacations)
	  * @return a linked list (vacDestinationLL) of vacation objects sorted by date
	  */
	 
	 
   	public static vacDestinationLL chronoLLinsert(vacationDestination[] vacations, vacationDestination extraVacation) {
        
		sortByDate(vacations);
		vacDestinationLL vacationsLL = buildLL(vacations);
		vacDestinationLL temp = vacationsLL;
		int n = 0;
		
		while (temp != null) {
			if (temp.getVacation().getDate() > extraVacation.getDate()) {
				break;
			}
			++n;
			temp = temp.getNext();
		}
		
		vacationsLL.addNth(extraVacation, n);
		
		return vacationsLL;
		
    }
	
	
	/******************************************************************************
	 * Main method
	 ******************************************************************************/
	public static void main(String[] args) throws IOException {
		
		try {	
			// test ReadFromFile
			// System.out.println("Creating the array of vacation destinations:");
			// vacationDestination[] myVacations = readFromFile("./vacations.txt"); 
			
			
			// for (int i = 0; i < myVacations.length; i++) {
				// myVacations[i].print();
			// }
			
			//test SortByDate
			// System.out.println("Sorting the vacation destinations by date:");
			// sortByDate(myVacations); 
			// for (int i = 0; i < myVacations.length; i++) {
				// myVacations[i].print();
			// }
			vacationDestination[] myVacations = new vacationDestination[0];
			// test earliest
			int minDate = earliest(myVacations);
			
			// test betterClose
			if (betterClose(myVacations,700)) {
				System.out.println("You are better closer to home!");
			}
			else {
				System.out.println("You are better farther from home!");
			}
			
			
			// test buildLL
			
			vacationDestination testVac = new vacationDestination("El Paso", 0, 12.24, 20141221, false);
			vacDestinationLL myList = chronoLLinsert(myVacations, testVac);;

			// test sizeLL and sizeLLR
			System.out.println("Size of list: " + myList.sizeLLR());

			// test removeHead
			//myList.removeHead();
			//myList.printLL();
			
			
			
			myList.printLL();
			// print the rest of the methods here
		}
		
		catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		}
		catch (NullPointerException npe) {
			System.out.println(npe.getMessage());
		}
		catch (IndexOutOfBoundsException ioobe) {
			System.out.println(ioobe.getMessage());
		}
	}
}
