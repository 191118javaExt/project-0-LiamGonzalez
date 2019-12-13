package com.revature;
import java.util.Scanner;
import com.revature.models.*;
 

public class Driver {
	//Let customers register with a username and password
	
	public static void startingScreen() {
		//This will be the first screen that pops up and lets the user choose an option
				//Depending on which option is chosen, we will follow the response according to what
				//action the user wants to take. (if a customer wants to login, we'll follow up with 
				//asking for user name and password)
				
			
				Scanner sc = new Scanner(System.in);
				
				System.out.println("Hello, please choose an option below...");
				System.out.println("1. Customer Login [Press 1]");
				System.out.println("2. Customer Registration [Press 2]");
				System.out.println("3. Employee Registration [Press 3] ");
				System.out.println("4. Employee Login [Press 4]");
				System.out.println("5. Administrator Registration [Press 5]");
				System.out.println("6. Administrative Login [Press 6]");
				System.out.println("7. Exit [Press 7]");
				
				//create a switch statement that will guide user to next set of options 
				//depending on 
				switch(sc.nextLine().toUpperCase()) {
				
				case "1":
					//take user to customer login screen
					
					break;
				case "2":
					//take user to customer registration 
					Customer.registerForCustomerAccount();
					break;
				case "3":
					//take user to employee registration screen
					Employee.employeeRegistration();
					break;
				case "4":
					//take user to employee login screen
					break;
				case "5":
					//take user to administrator registration screen
					break;
				case "6":
					//take user to administrator login
					break;
				case "7":
					//console will terminate program
					System.out.println("Thank you for visiting.");
					sc.close();
					break;
					
				default:
					System.out.println("Invalid input, choose from given options.");
					System.out.println("1. Customer Login [Press L]");
					System.out.println("2. Register [Press R]");
					System.out.println("3. Employee Login [Press E]");
					System.out.println("4. Administrative Login [Press A]");
					System.out.println("5. Exit [Press X]");
					break;
					
				}
		
	}
	

	public static void main(String[] args) {
		
		startingScreen();
		
		

	}

}
