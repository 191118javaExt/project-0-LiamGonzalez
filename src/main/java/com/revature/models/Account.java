package com.revature.models;

import java.util.Queue;

import java.util.concurrent.ArrayBlockingQueue;

public class Account {

	
	
	
		private int accountNumber;
		private final int  MIN = 1;
		private double accountBalance;
		private String userName;
		private ArrayBlockingQueue<String> recentTransactions;
		
	// constructors
		public Account(int number, double bal) {
			this.accountNumber = number;
			this.accountBalance = bal;
		}
		
		public Account() {}
		
		public Account(int number) {
			this.accountNumber = number;
		}
		
		public Account(int num, double bal, String owner) {
			this.setAccountNumber(num);
			this.setAccountBalance(bal);
			this.setUserName(owner);
		}
		
		
		
		
		
		
		
		
		// getters and setters
		public int getAccountNumber() {
			return accountNumber;
		}
		public void setAccountNumber(int accountNumber) {/////////////////////
			this.accountNumber = accountNumber;
		}
		public double getAccountBalance() {
			return accountBalance;
		}
		public void setAccountBalance(double d) {
			this.accountBalance = d;
		}
	
		public int getMIN() {
			return MIN;
		}
	
		public String getUserName() {
			return userName;
		}
	
		public void setUserName(String userName) {
			this.userName = userName;
		}
	
		public ArrayBlockingQueue<String> getRecentTransactions() {
			return recentTransactions;
		}
	
		public void setRecentTransactions(ArrayBlockingQueue<String> recentTransactions) {
			this.recentTransactions = recentTransactions;
		}
		
		
		// transaction methods
	public double deposit(double amount) {
		if (amount <= 0) {
			System.out.println("Must deposit amount greater than $0.");
			return 0;
		} else {
			this.setAccountBalance((this.getAccountBalance() + amount));
			return amount;
		}
	}
	
	
	public double withdraw(double amount) {
		if ((this.getAccountBalance() - this.getMIN()) >= amount) {
			this.setAccountBalance((this.getAccountBalance() - amount));
			return amount;
		} else {
			System.out.println("Insufficient funds.");
			return 0;
		}
	}
		
	public double transfer(double amount, Account otherAcct) {
				if((this.getAccountBalance() - this.getMIN()) >= amount) {
					otherAcct.deposit(amount);
					this.withdraw(amount);
					return amount;
				} else {
					System.out.println("Transfer did not go through, MIN balance required is $1");
					return 0;
				}
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", MIN=" + MIN + ", accountBalance=" + accountBalance
				+ ", userName=" + userName + ", recentTransactions=" + recentTransactions + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + MIN;
		long temp;
		temp = Double.doubleToLongBits(accountBalance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + accountNumber;
		result = prime * result + ((recentTransactions == null) ? 0 : recentTransactions.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
		
		if (getClass() != obj.getClass())
			return false;
		
		Account other = (Account) obj;
		if (MIN != other.MIN)
			return false;
		
		if (Double.doubleToLongBits(accountBalance) != Double.doubleToLongBits(other.accountBalance))
			return false;
		
		if (accountNumber != other.accountNumber)
			return false;
		
		if (recentTransactions == null) {
			if (other.recentTransactions != null)
				return false;
			
		} else if (!recentTransactions.equals(other.recentTransactions))
			return false;
		
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}	
	
	
	
	
		
}