package com.revature.services;

import java.text.SimpleDateFormat;


import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

import com.revature.Driver;
import com.revature.models.Admin;
import com.revature.models.Account;
import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.repositories.CustomersDAO;
import com.revature.repositories.CustomersDAOImpl;


public class Bank {

	public Bank(){
		super();
	}

	CustomerLogic cLogic = new CustomerLogic();
	AccountsProcess aLogic = new AccountsProcess();
	EmployeeAdminLogic eaLogic = new EmployeeAdminLogic();
	static TransactionsLogic tLogic = new TransactionsLogic();
	
	
	public void startHere() {
		Scanner scan = new Scanner(System.in);
		System.out.println("\r\n" + 
				"      ___            __  \r\n" + 
				"|__| |__  |    |    /  \\ \r\n" + 
				"|  | |___ |___ |___ \\__/ \r\n" + 
				"                         \r\n" + 
				"");
		System.out.println("Thank you for using our bank.");
		System.out.println("Press ENTER to start application.");
		String input = scan.nextLine().split(" ")[0];
		do {
			initialScreen();
			try {
				input = scan.nextLine().split(" ")[0];
				switch (input) {
				// existing user login
				case "1":
					int employeeCheck = existingUserLogin();
					switch (employeeCheck) {
					// existing customer login
					case 1:
						Customer signInCustomer = cLogic.existingUserLoginCustomer();
						if (signInCustomer == null) {
							break;
						}

						existingCustomerMainMenu(signInCustomer);
						break;
						// existing employee login
					case 2:
						Employee signInEmployee = eaLogic.existingUserLoginEmployee();
						if (signInEmployee != null) {
							eaLogic.existingEmployeeMainMenu(signInEmployee);
						}
						break;
						// existing admin login
					case 3:
						try {
							Admin signInAdmin = (Admin) eaLogic.existingUserLoginEmployee();
							if (signInAdmin != null) {
								if (signInAdmin.isAdmin) {
									eaLogic.existingAdminMainMenu(signInAdmin);
								} else {
									System.out.println("Must be Administrator for this access.");
								}
							}
						} catch (ClassCastException e) {
							System.out.println("Must be an Administrator for this access.");
						}
					case 0:
						input = "r";
						break;
					}
					break;
					// new customer register
				case "2":
					Customer newCust = createNewCustomer();
					cLogic.setNewUserFields(newCust);
					break;
				}
			} catch (NumberFormatException e) {
				System.out.println("Unrecognized input");
				input.equals("E");
			} catch (NullPointerException e) {
				System.out.println("Unrecognized input");
			}

		} while (!input.toUpperCase().equals("Q"));

		goodByeScreen();
		scan.close();
	}
	
	public void initialScreen() {
		
		System.out.println("Please select an option:");
		System.out.println("[1] member login");
		System.out.println("[2] New User");
		System.out.println("[E]. EXIT");
	
	}
	
	public void goodByeScreen() {
		System.out.println("Thank you for using this bank");
	
	}
	
	
	
	
	public int existingUserLogin() {
		
		System.out.println("Please choose an option:");
		System.out.println("[0] Back");
		System.out.println("[1] Customer login");
		System.out.println("[2] Employee login");
		System.out.println("[3] Administrator login");
		
		
		Scanner scan = new Scanner(System.in);
		int employeeCheck = Integer.parseInt(scan.nextLine().split(" ")[0]);					
		if(employeeCheck == 1 || employeeCheck == 2 || employeeCheck == 3 || employeeCheck == 0) {
			return employeeCheck;
		}
		
		
		else{
			while(employeeCheck != 1 || employeeCheck != 2 || employeeCheck != 3) {
				System.out.println("Please select an option:");
				System.out.println("[0] Back");
				System.out.println("[1] Customer");
				System.out.println("[2] Employee");
				System.out.println("[3] Administrator");
			
			employeeCheck = Integer.parseInt(scan.nextLine().split(" ")[0]);
			}
		}
		return 0;
	}
	
	
	
	
	
	public Customer createNewCustomer() {
		Customer customer = new Customer();
		System.out.println("Please select a username.");
		System.out.println("must be atleast 5 characters long, no longer than 40");
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		while(!userNameIsAcceptable(input)) {
			System.out.println("Usernames must be between 5 and 40 characters in length.");
			System.out.println("Use a different username:");
			input = scan.nextLine();										
		}
		if(userNameIsAcceptable(input)) {
			customer.setUserName(input);
		}
		System.out.println("Please select a password:");
		System.out.println("for proper security measures, make sure your password meets the following criteria:");
		System.out.println("Between 5 - 40 characters in length,");
		System.out.println("Must contain at least one uppercase letter,");
		System.out.println("Must contain at least one lowercase letter,");
		System.out.println("Must contain at least one number.");
		
		String input2 = scan.nextLine();							
		while(!userPasswordIsAcceptable(input2)) {
			System.out.println("Password does not meet security requirements:");
			System.out.println("Between 5 - 40 characters in length,");
			System.out.println("Must contain at least one uppercase letter,");
			System.out.println("Must contain at least one lowercase letter,");
			System.out.println("Must contain at least one number.");
			
			
			System.out.println("Please try another password:");
			input2 = scan.nextLine();												
		}
		if(userPasswordIsAcceptable(input2)) {
			System.out.println("Re-enter password:");
			String input3 = scan.nextLine();
			//scan3.close(); 															
			if(input2.equals(input3)) {
				customer.setPassword(input3);
			} else {
				while(!input2.equals(input3)) {
					System.out.println("Passwords don't match, please re-enter password.");
					input3 = scan.nextLine();
				}
			}
		}
		return customer;
	}
	
	boolean userNameIsAcceptable(String nameTry) {
		if((nameTry.length() >4) && (nameTry.length() <= 40)) {
			return true;
		}
		else return false;
	}
	
	boolean userPasswordIsAcceptable(String passTry) {
		if((passTry.length() <= 40) && (passTry.length() > 4) && (passTry.contains("0") || passTry.contains("1") || passTry.contains("2") || passTry.contains("3") || passTry.contains("4") || 
				passTry.contains("5") || passTry.contains("6") || passTry.contains("7") || passTry.contains("8") || passTry.contains("9")) &&
				(passTry.contains("A") || passTry.contains("B") || passTry.contains("C") || passTry.contains("D") || passTry.contains("E") || passTry.contains("F") || 
						passTry.contains("G") || passTry.contains("H") || passTry.contains("I") || passTry.contains("J") || passTry.contains("K") || passTry.contains("L") || 
						passTry.contains("M") || passTry.contains("N") || passTry.contains("O") || passTry.contains("P") || passTry.contains("Q") || passTry.contains("R") || 
						passTry.contains("S") || passTry.contains("T") || passTry.contains("U") || passTry.contains("V") || passTry.contains("W") || passTry.contains("X") || 
						passTry.contains("Y") || passTry.contains("Z")) &&
				(passTry.contains("a") || passTry.contains("b") || passTry.contains("c") || passTry.contains("d") || passTry.contains("e") || passTry.contains("f") || 
						passTry.contains("g") || passTry.contains("h") || passTry.contains("i") || passTry.contains("j") || passTry.contains("k") || passTry.contains("l") || 
						passTry.contains("m") || passTry.contains("n") || passTry.contains("o") || passTry.contains("p") || passTry.contains("q") || passTry.contains("r") || 
						passTry.contains("s") || passTry.contains("t") || passTry.contains("u") || passTry.contains("v") || passTry.contains("w") || passTry.contains("x") || 
						passTry.contains("y") || passTry.contains("z"))) {
			return true;
		}
		else return false;
	}
	
	

	public void existingCustomerMainMenu(Customer customer) {
		int rep = 1;
		try {
		do {
		userFriendlyDate();
		
		System.out.println("Welcome back, " + customer.getFirstName() + ".");
		
		System.out.println("Accounts:");
		Account actSelect = existingCustomerAccountsDisplay(customer);
		System.out.println("");////////////////////
		int typeOfTrans;
		if(actSelect == null) {
			rep = 0;
		}
		do {
		typeOfTrans = customerAccountMenuOptions(actSelect);
		aLogic.doTransaction(actSelect, typeOfTrans);
		
		} while (typeOfTrans != 4);
		} while (rep != 0);
		} catch (NullPointerException e) {
			return;
		}
	}
	
	public static void userFriendlyDate() {
		Date dateObj = new Date();
		String dateFormat = "EEEE, MMM d, y      h:mm a ";
		SimpleDateFormat simpleDF = new SimpleDateFormat(dateFormat);
		System.out.println(simpleDF.format(dateObj));
	}
	
	public static Account existingCustomerAccountsDisplay(Customer customer) {
		int acctChoice;
		try {
		//do {
		System.out.println("");
		System.out.println("Select account:");
		for(int actSelect = 1; actSelect <= customer.getUserAccounts().size(); actSelect++) {
			int accountName = customer.getUserAccounts().get(actSelect).getAccountNumber();
			double accountBalance = customer.getUserAccounts().get(actSelect).getAccountBalance();
			System.out.println(actSelect + ".      Account No." + accountName + "$ " + accountBalance);
			System.out.println("");
		}
		System.out.println("0. Go Back");
		Scanner scan = new Scanner(System.in);
		
		acctChoice = Integer.parseInt(scan.nextLine().split(" ")[0]);
		while((!(acctChoice >= 0)) || !((acctChoice <= customer.getUserAccounts().size()))) {
			System.out.println("Choose a valid option.");
			acctChoice = Integer.parseInt(scan.nextLine().split(" ")[0]);
		}
		
		if (acctChoice == 0) {
			return null;
		}
		
		return customer.getUserAccounts().get(acctChoice);
		}catch(NumberFormatException e) {
			System.out.println("Invalid input.");
			return null;
		}
	}
	
	
	
	
	public static int customerAccountMenuOptions(Account account) {
		System.out.println("Acct. " + account.getAccountNumber() + "  $ " + account.getAccountBalance() + "\n");
		tLogic.transDisplay(account.getRecentTransactions());
		System.out.println("Select an option:");
		System.out.println("[1] Deposit");
		System.out.println("[2] Withdrawal");
		System.out.println("[3] Funds Transfer");
		System.out.println("[4] Back");
		
		Scanner scan = new Scanner(System.in);
		int customerSelection = Integer.parseInt(scan.nextLine().split(" ")[0]);	
		while((customerSelection < 1) || (customerSelection > 5)) {
			System.out.println("Select a valid option.");
			customerSelection = Integer.parseInt(scan.nextLine().split(" ")[0]);	
		}
		
		return customerSelection;
	}
	
	

	
	
	
	
	
	
	
}