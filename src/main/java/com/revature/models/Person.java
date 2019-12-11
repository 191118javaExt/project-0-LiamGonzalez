package com.revature.models;

public abstract class Person {
	private String name;
	private String userName;
	private String password;
	private int accountId;
	//private int age;
	
	
	public abstract void registerForAccount();
	//****IDK YET IF I WANT TO CUSTOMIZE LOGIN FOR EACH TYPE OF USER****
	//this method will be inherited and set up to 
	//actually "apply" for a bank account
	
	
	
	public void accessAccount() {
		//this method will be inherited by Employees and Administrators
		//for Employees, they will only be able to VIEW customer accounts
		//Administrators will be allowed to VIEW and EDIT customer accounts
		
		
	}
	
	
	
	
	
	

}
