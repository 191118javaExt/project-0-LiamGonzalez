package com.revature.models;

import java.util.Scanner;

import com.revature.Driver;


public class Customer extends Person {
	private int id;
	private String first_name;
	private String last_name;
	private String user_password;
	private int accountId;
	private double checking_balance;
	private double savings_balance;
	
	public Customer(String first_name, String last_name, String password, double checking_balance, double savings_balance) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.user_password = user_password;
		this.accountId = accountId;
		this.checking_balance = checking_balance;
		this.savings_balance = savings_balance;
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


	public String getUserPassword() {
		return user_password;
	}

	public void setUserPassword(String password) {
		this.user_password = user_password;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	
	public double checking_balance() {
		return checking_balance;
	}
	
	public void setCheckingBalance(double checking_balance) {
		this.checking_balance = checking_balance;
	}
	
	public double savings_balance() {
		return savings_balance;
	}
	
	public void setSavingsBalance(double savings_balance) {
		this.savings_balance = savings_balance;
	}

	@Override
	public void registerForAccount() {
		// TODO Auto-generated method stub
		
	}
	
	
	

	
	
	
	
	
	
	
	
	

}
