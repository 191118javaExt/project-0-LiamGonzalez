package com.revature.models;

import java.util.Scanner;


public class Customer extends Person {
	private String name;
	private String userName;
	private String password;
	private int accountId;
	private double accountBalance;
	
	public Customer(String name, String userName, String password, int accountId) {
		super();
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.accountId = accountId;
		this.accountBalance = accountBalance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
