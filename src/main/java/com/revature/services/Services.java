package com.revature.services;

import java.util.Scanner;

import com.revature.Driver;

public class Services {
	
	//need to change this up. For employee registration and login, we want to start off
		//by asking for an employee PIN. The PIN number is going to be the same across ALL 
		//employees ("2019"). If the user input is "2019", then we will continue with the 
		//login/registration process
		public static void employeeLogin() {
			Scanner el = new Scanner(System.in);
			
			System.out.println("Please enter information to login");
			System.out.println("");
			
			System.out.println("Employee PIN: ");
			String pin = el.nextLine();
			System.out.println("");
			
			System.out.println("First Name: ");
			String firstName = el.nextLine();
			System.out.println("");

			System.out.println("Last Name: ");
			String lastName = el.nextLine();
			System.out.println("");
			
			System.out.println("Password: ");
			String empPassword = el.nextLine();
			System.out.println("");
			
			//Need to figure out how to check SQL to verify input
			
		}	
		
		
		
		
		
		// This is the method that is called when "R" is chosen on the console
		//the customer will fill out their application for a bank account
			//@Override
			public static void registerForCustomerAccount() {
				Scanner customerscan = new Scanner(System.in);
				
				System.out.println("Thank you for registering for an account.");
				System.out.println("Please provide the following information.");
				System.out.println("");
				
				System.out.println("First Name: ");
				String first_name = customerscan.nextLine();
				
				System.out.println("Last Name: ");
				String last_name = customerscan.nextLine();
				
				System.out.println("Password:");
				String password1 = customerscan.nextLine();
				System.out.println("");
				
				System.out.println("Re-enter Password:");
				String password2 = customerscan.nextLine();
				
				if(password1.equals(password2)) {
				
				System.out.println("-----------------------------");
				System.out.println("This is the information you submitted: ");
				System.out.println("Name: " + first_name + " " + last_name);
				System.out.println("Password: " + password1);
				System.out.println("");
				System.out.println("Is the above information correct?");
				System.out.println("Press 'Y' for YES. Press any other key for NO:");
				String decide = customerscan.nextLine().toUpperCase();
				
				if(decide.equals("Y") == false) {
					System.out.println("Is this the problem?");
					//registerForCustomerAccount();
				}
				else {
				
				System.out.println("Thank you for applying for an account.");
				System.out.println("This is your account information: ");
				System.out.println("");
				System.out.println("Name: " + first_name + " " + last_name);
				System.out.println("Password: " + password1);
				System.out.println("Your application will be reviewed by an employee soon. ");
				System.out.println("-----------------------------");
				
				System.out.println("Press any key to continue.");
				String nextStep = customerscan.nextLine(); 
				
				
				if(nextStep != null) {
				
				Driver.startingScreen();
				}
				
				}	
				
				}else {
					do {
					System.out.println("passwords don't match.");
					System.out.println("");
					System.out.println("Re-enter Password:");
					password2 = customerscan.nextLine();
					
					}while(password1.equals(password2) == false);
						if(password1.equals(password2)) {
							System.out.println("-----------------------------");
							System.out.println("This is the information you submitted: ");
							System.out.println("Name: " + first_name + " " + last_name);
							System.out.println("Password: " + password1);
							System.out.println("");
							System.out.println("Is the above information correct?");
							System.out.println("Press 'Y' for YES. Press any other key for NO");
							String decide = customerscan.nextLine().toUpperCase();
							
							if(decide == "Y") {
								//registerForCustomerAccount();
								System.out.println("Thank you for applying for an account.");
								System.out.println("This is your account information: ");
								System.out.println("");
								System.out.println("Name: " + first_name + " " + last_name);
								System.out.println("Password: " + password1);
								System.out.println("Your application will be reviewed by an employee soon. ");
								System.out.println("-----------------------------");
								
								System.out.println("Press any key to continue.");
								String nextStep = customerscan.nextLine(); 
								
								
								if(nextStep != null) {
								
								Driver.startingScreen();
								}
								
								}
							}else {
								registerForCustomerAccount();
							
							}
							
							
						}
					
				}
				
				
			
			
			public static void customerLogin() {
				Scanner cl = new Scanner(System.in);
				System.out.println("Please enter your information to login: ");
				System.out.println("");
				
				System.out.println("First Name: ");
				String first_name = cl.nextLine();
				System.out.println(" ");
				
				System.out.println("Last Name: ");
				String last_name = cl.nextLine();
				
				System.out.println("Password: ");
				String user_password = cl.nextLine();
				
				
				//Need to figure out how to check SQL database to verify
				//if the input is correct***************************************
				
			}

			
			public void registerForAccount() {
				// TODO Auto-generated method stub
				
			}
			
			//Need method(s) that allow customer to make transactions in account...
			

}
