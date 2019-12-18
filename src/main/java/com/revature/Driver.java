package com.revature;

import com.revature.services.Bank;

public class Driver {

	public static void main(String[] args) {
		
		//This is the method that will initialize the starting console and 
		//allow the user to use the banking application
		
		Bank bank = new Bank();
		bank.startHere();
	}

}
