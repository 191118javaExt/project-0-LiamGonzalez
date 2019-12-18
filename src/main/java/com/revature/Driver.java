package com.revature;

import com.revature.services.Bank;

public class Driver {

	public static void main(String[] args) {
		
		//This is the method that will initialize the starting console and 
		//allow the user to use the banking application
		
		Bank bank = new Bank();
		bank.startHere();
		
		//System.out.println("By using our bank, you are agreeing to donate 40% of your monthly earnings to help pay for my student loans. ");
	}
	
	

}
