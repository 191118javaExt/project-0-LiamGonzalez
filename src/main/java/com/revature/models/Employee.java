package com.revature.models;

import java.util.Scanner;

import com.revature.Driver;

public class Employee extends Person {
	private String first_name;
	private String last_name;
	private String userName = first_name + last_name;
	private int accountId;
	private int password;
	
	
	public Employee(String first_name, String last_name, String userName, int accountId, int password) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.userName = userName;
		this.accountId = accountId;
		this.password = password;
	}

	
	
	
	public Employee(int id, String first_name, String last_name, String email, double salary, Object object) {
		// TODO Auto-generated constructor stub
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




	public String getUserName() {
		return userName;
	}




	public void setUserName(String userName) {
		this.userName = userName;
	}




	public int getAccountId() {
		return accountId;
	}




	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}




	public int getPassword() {
		return password;
	}




	public void setPassword(int password) {
		this.password = password;
	}

	
	
//this method is called when an employee registers for an employee account
	public static void employeeRegistration() {
		Scanner empscan = new Scanner(System.in);
		
		System.out.println("Welcome to the Employee Registration page.");
		System.out.println("Only Bank Employees may register as an employee,");
		System.out.println("Press any key to continue");
		//System.out.println("if you are not an employee, please exit the terminal.");
		System.out.println("---------------------------------------------------------");
		
	//	System.out.println("Please verify that you are an employee.");
	//	System.out.println("Press 1 for YES");
	//	System.out.println("Press 2 for NO");
	//	System.out.println("Press any other key to return to main menu");
		
		String employeeVerify = empscan.nextLine();
		
	
		//if user is not employee
	//	if(employeeVerify == "2") {
	//		System.out.println("You are not eligible to register as an employee");
	//		Driver.startingScreen();
			
			//if user is employee
	//	}else if(employeeVerify == "1") {
		//	System.out.println("You have verified that you are an employee.");
			System.out.println("Please fill out the required information:");
			System.out.println(".......");
			
			System.out.println("First Name: ");
			String first_name = empscan.nextLine();
			
			System.out.println("Last Name: ");
			String last_name = empscan.nextLine();
			
			System.out.println("Password: ");
			String password = empscan.nextLine();
			
			System.out.println(" ");
			
			System.out.println("Your employee username is: " + first_name + last_name);
			System.out.println("Your password is: " + password);
			System.out.println("---------------------------------");
			System.out.println("Press any key to return to main menu");}/////////////////////////////
	
		
	//	}else {
			
		//	Driver.startingScreen();
		
	//	}
		
//	}

//might not need to put this in an abstract class
//just put the login methods for 
	@Override
	public void registerForAccount() {
		// TODO Auto-generated method stub
		
	}
	
	//need method(s) to approve/deny customer applications,
	//as well as view customer information
	
	

}
