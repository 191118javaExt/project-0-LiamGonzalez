package com.revature;
import java.util.Scanner;
import com.revature.models.*;
 

public class Driver {
	
	
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
				System.out.println("7. Exit [Press 5]");
				
				
				switch(sc.nextLine().toUpperCase()) {
				
				case "1":
					Customer.customerLogin();
					break;
					
				case "2":
					Customer.registerForCustomerAccount();
					break;
					
				case "3":	
					Employee.employeeRegistration();
					break;
					
				case "4":
					Employee.employeeLogin();
					break;
					
				case "5":
					System.out.println("Thank you for visiting.");
					sc.close();
					break;
					
				default:
					System.out.println("Invalid input, choose from given options.");
					System.out.println("1. Customer Login [Press 1]");
					System.out.println("2. Customer Register [Press 2]");
					System.out.println("3. Employee Registration [Press 3]");
					System.out.println("4. Employee Login [Press 4]");
					System.out.println("5. Exit [Press 5]");
					break;
					
				}
		
	}
	

	public static void main(String[] args) {
		
		startingScreen();
		

	}

}
