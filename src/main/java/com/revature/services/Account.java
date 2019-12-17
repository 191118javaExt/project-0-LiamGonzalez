package com.revature.services;

public class Account {
	/*
	 * 
	 * 
	 * go over this
	 * 
	 * 
	 * 
	 * 
	 */
	
	//???
	private final int  MIN = 1;
	private double account_balance;
	private int account_number;
	private String userName;
	
	

	public Account(int account_number, double account_balance) {
		this.account_number = account_number;
		this.account_balance = account_balance;
	}
	
	public Account() {}
	
	public Account(int number) {
		this.account_number = number;
	}
	
	public Account(int num, double bal, String account_owner) {
		this.setAccountNumber(num);
		this.setAccountBalance(account_balance);
		this.setUserName(account_owner);
	}
	
	
	
	
	
	
	
	
	
	public int getAccountNumber() {
		return account_number;
	}
	public void setAccountNumber(int accountNumber) {
		this.account_number = account_number;
	}
	public double getAccountBalance() {
		return account_balance;
	}
	public void setAccountBalance(double accb) {
		this.account_balance = accb;
	}
	
//???
	public int getMIN() {
		return MIN;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	

	
	
	//Go over this to check accuracy.............................
	// transaction 
public void deposit(double amount) {
	if (amount <= 0) {
		System.out.println("you have to deposit a positive amount.");
	} else {
		this.setAccountBalance((this.getAccountBalance() + amount));
		// probably need to add transaction to a list here too...
	}
}


public void withdraw(double amount) {
	//if acct bal - min >= amt 
	if ((this.getAccountBalance() - this.getMIN()) >= amount) {
		this.setAccountBalance((this.getAccountBalance() - amount));
		
	} else {
		System.out.println("Insufficient funds.");
	}
}
	
public void transfer(double amount, Account otherAcct) {
			if((this.getAccountBalance() - this.getMIN()) >= amount) {
				otherAcct.deposit(amount);
				this.withdraw(amount);
				
				
			} else {
				System.out.println("Transfer failed. MIN balalce required is $1");
			}
		
	
}

}
