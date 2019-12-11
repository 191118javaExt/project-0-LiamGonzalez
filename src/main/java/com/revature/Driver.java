package com.revature;
import java.util.Scanner;
 

public class Driver {
	//Let customers register with a username and password
	
	
	

	public static void main(String[] args) {
		
		
		//This will be the first screen that pops up and lets the user choose an option
		//Depending on which option is chosen, we will follow the response according to what
		//action the user wants to take. (if a customer wants to login, we'll follow up with 
		//asking for username and password)
		
	
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Hello, please choose an option below...");
		System.out.println("1. Customer Login [Press L]");
		System.out.println("2. Register [Press R]");
		System.out.println("3. Employee Login [Press E]");
		System.out.println("4. Administrative Login [Press A]");
		System.out.println("5. Exit [Press X]");
		
		//create a switch statement that will guide user to next set of options 
		//depending on 
		switch(sc.nextLine().toUpperCase()) {
		
		case "L":
			//take user to customer login screen
			
			break;
		case "R":
			//take user to registration (registration will give option
			//to register as customer, employee or administrator)
			break;
		case "E":
			//take user to employee login screen
			break;
		case "A":
			//take user to Administrator login screen
			break;
		case "X":
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

}
