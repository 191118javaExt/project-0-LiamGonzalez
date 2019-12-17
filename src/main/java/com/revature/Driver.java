package com.revature;
import java.util.Scanner;
import com.revature.models.*;
import com.revature.repositories.EmployeeDAOImpl;
import com.revature.services.Services;
import com.revature.util.ConnectionUtil;
 

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
					Services.customerLogin();
					break;
					
				case "2":
					Services.registerForCustomerAccount();
					break;
					
				case "3":	
					Employee.employeeRegistration();
					break;
					
				case "4":
					Services.employeeLogin();
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
		
		System.out.println("Thank you for using our bank.");
		
		//add a logger to show "application initiated".
		EmployeeDAOImpl x = new EmployeeDAOImpl();
		x.findAll();
		startingScreen();
		

	}

}
