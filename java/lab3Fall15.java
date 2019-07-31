import java.util.Scanner;

public class lab3Fall15 {

 /*****************************************************************/
 /*************   ACTIVITY 1   ******************************/
 /* Input / output / variables */
 /* In this activity, you will implement the solution code of the 
  * exercise that is described in this lab's instructions and below.
  */
 public static void SoftwareSales() {
  /* A software company sells a package that retails for $99. Quantity discounts are 
   * given according to the following table:
   * Quantity:   Discount:
   *   10 - 19   20%
   *   20 - 49   30%
   *   50 - 99   40%
   *   100 or more  50%
   * Design a program that asks the user to enter the number of packages purchased. 
   * The program should then display the amount of the discount (if any) and the total 
   * amount of the purchase after the discount.
   */
    
  /********************************************************************************** 
   * The rest of your code goes here. You will very likely need to define variables *
   * Below, we are following the pseudocode provided in your instruction file       *
   * We help you with some of the steps (they are marked completed), you have to    *
   * write code for the remaining ones.                                             *
   **********************************************************************************/ 
 
  /*!!!!!!!!!!!!!!!!!!!!VERSION 2!!!!!!!!!!!!!!!!!!!!*/ 

  int softwareUnitPrice = 99;
  int numSoftware;
  double discount = 0.0;
  double discountedPrice = 0.0;

  
  Scanner myscnr = new Scanner(System.in);
  

  // 1. [Completed] Ask the client for the number of packages s/he wants to buy
  System.out.println("Please enter the number of packages that the client wants to buy");
  
  // 2. Retrieve this number using some kind of a listener (declared above) 
  // and store it in an integer variable called numSoftware
  numSoftware = myscnr.nextInt();
  
  // 3. [Completed] If the value stored in numSoftware is 9 or less, 
  //  then store the real value 0 in a variable called discount
  
  if (numSoftware <= 9) {
	discount = 0;
  }
  
  // 4. [Completed] If the value stored in numSoftware is between 10 and 19, 
  //  then store the real value 0.2 in the variable called discount
  else if ((numSoftware >= 10) && (numSoftware <=19)) {
	discount = 0.2;
  }
  
  // 5. [Completed] If the value stored in numSoftware is between 20 and 49, 
  //  then store the real value 0.3 in the variable called discount
  else if ((numSoftware >= 20) && (numSoftware <=49)) {
   discount = 0.3;
  }
  
  // 6. If the value stored in numSoftware is between 50 and 99, 
  //  then store the real value 0.4 in the variable called discount
  else if ((numSoftware >= 50) && (numSoftware <=99)) {
   discount = 0.4;
  }

  // 7. If the value stored in numSoftware is 100 or more, 
  //  then store the real value 0.5 in the variable called discount
  else if ((numSoftware >= 100)) {
   discount = 0.5;
  }
  
  // 8. Compute the following: 99 * numSoftware * (1 – discount) 
  //  and store this value in the real variable called discountedPrice
  
  discountedPrice = softwareUnitPrice * numSoftware * (1.0 - discount);

  // 9. Display the value of the discount by outputting what is stored 
  //  in your variable called discount
  
	System.out.println("Discount: " + discount);

  // 10. Display the price the client has to pay by outputting what is stored 
  //  in your variable called discountedPrice
	System.out.println("Discounted Price: " + discountedPrice);
	return;
 }
 
 /*****************************************************************/
 /*************   ACTIVITY 2   ******************************/
 /* Variables, types */
 public static void tradingPiggyBanks() {
  /* Trading Piggy Banks
   * Zoe lives in the US and has a piggy bank filled with US dollars.
   * Gonzague lives in France and has a piggy bank filled with Euros. 
   * They want to trade the content of their piggy banks but they need the transferred 
   * amount to be also converted to their respected currencies.
   * 
   * You have to implement a piece of software that allows them to do just this. 
   * More specifically, you should design a program that:
   * -- asks Zoe the amount of dollars that she has
   * -- asks Gonzague the amount of euros that he has
   * -- displays these original amounts
   * -- converts the amount of dollars of Zoe into euros and sets this amount to be 
   *   the new amount that Gonzague owns
   * -- converts the original amount of euros of Gonzague into dollars and sets this 
   *   amount to be the new amount that Zoe owns
   * -- displays the new amounts along with their owners and respective currencies 
   */

  /********************************************************************************** 
   * The rest of your code goes here. You will very likely need to define variables *
   * Below, we are following the pseudocode provided in your instruction file       *
   * We help you with some of the steps (they are marked completed or partially
   * completed), you have to write code for the remaining ones.                                             *
   **********************************************************************************/ 

  
  
  
		double zoe;
		double gon;
		double exchangeRate;
		
		//to be replace by a method to retrieve instantanous exhange rate
		exchangeRate = (111.0 / 100.0);  
  
  
		Scanner myscnr = new Scanner(System.in);
  
		System.out.print("Please enter the amount of dollars in Zoe's piggy bank: ");
		zoe = myscnr.nextDouble();
  
		System.out.print("Please enter the amount of euros in Gonzague's piggy bank: ");
		gon = myscnr.nextDouble();
  
		System.out.println("Zoe has $" + zoe + " in her piggy bank.");
		System.out.println("Gonzague has " + gon + " euros in his piggy bank.");
		
		gon = gon * exchangeRate;
		zoe = zoe / exchangeRate;
		
		
		
		System.out.println("After the trade, Zoe now owns $" + (int)gon + " and Gonzague now owns " + (int)zoe + " euros.");

 }
 
 /*****************************************************************/
 /************* This is where you write the name ******************/
 /************* of the code you want to execute  ******************/

 public static void main(String[] args) {
  // here goes what you want to execute.
  // let's start with SoftwareSales and we will modify this as we go
//  SoftwareSales();
  tradingPiggyBanks();
 }

}
