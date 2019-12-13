package com.revature.models;

import java.util.Scanner;


public class Customer extends Person {
	private String first_name;
	private String last_name;
	private String userName = first_name + last_name;
	private String password;
	private int accountId;
	private double accountBalance;
	
	public Customer(String name, String userName, String password, int accountId) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.userName = userName;
		this.password = password;
		this.accountId = accountId;
		this.accountBalance = accountBalance;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	
	public double getAccountBalance() {
		return accountBalance;
	}
	
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	

	//@Override
	public static void registerForCustomerAccount() {
		Scanner customerscan = new Scanner(System.in);
		
		System.out.println("Thank you for registering for an account.");
		System.out.println("Please provide the following information.");
		System.out.println("");
		
		System.out.println("Name: ");
		String name = customerscan.nextLine();
		
		System.out.println("Password:");
		String password = customerscan.nextLine();
		
		System.out.println("-----------------------------");
		System.out.println("Name: " + name);
		System.out.println("Password: " + password);
		System.out.println("-----------------------------");
		
		
		
		
		
		
	}

	@Override
	public void registerForAccount() {
		// TODO Auto-generated method stub
		
	}
	
	//Need method(s) that allow customer to make transactions in account...
	
	
	
	
	
	
	
	
	
	

}
