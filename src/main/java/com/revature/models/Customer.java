package com.revature.models;

import java.util.Scanner;

import com.revature.Driver;


public class Customer extends Person {
	private String first_name;
	private String last_name;
	//private String userName = first_name + last_name;
	private String user_password;
	private int accountId;
	private double balance;
	
	public Customer(String name, String userName, String password, int accountId) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		//this.userName = userName;
		this.user_password = user_password;
		this.accountId = accountId;
		this.balance = balance;
	}

	public String getFirstName() {
		return first_name;
	}

	public void setFirstName(String first_name) {
		this.first_name = first_name;
	}
	
	public String getLastName() {
		return last_name;
	}
	
	public void setLastName(String last_name) {
		this.last_name = last_name;
	}

	//public String getUserName() {
	//	return userName;
	//}

	//public void setUserName(String userName) {
	//	this.userName = userName;
	//}

	public String getUserPassword() {
		return user_password;
	}

	public void setPassword(String password) {
		this.user_password = user_password;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	
	public double Balance() {
		return balance;
	}
	
	public void setBalance(double Balance) {
		this.balance = balance;
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
		String password = customerscan.nextLine();
		
		System.out.println("-----------------------------");
		System.out.println("Name: " + first_name + " " + last_name);
		System.out.println("Password: " + password);
		
		System.out.println("Thank you for applying for an account.");
		System.out.println("Your application will be reviewed by an employee soon. ");
		System.out.println("-----------------------------");
		Driver.startingScreen();
		
		
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

	@Override
	public void registerForAccount() {
		// TODO Auto-generated method stub
		
	}
	
	//Need method(s) that allow customer to make transactions in account...
	
	
	
	
	
	
	
	
	
	

}
