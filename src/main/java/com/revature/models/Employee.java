package com.revature.models;

public class Employee extends Person {
	private String name;
	private String userName;
	private int accountId;
	private int password;
	
	public Employee(String name, String userName, int accountId, int password) {
		super();
		this.name = name;
		this.userName = userName;
		this.accountId = accountId;
		this.password = password;
	}

	
	
	
	public Employee(int id, String first_name, String last_name, String email, double salary, Object object) {
		// TODO Auto-generated constructor stub
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



//might not need to put this in an abstract class
//just put the login methods for 
	@Override
	public void registerForAccount() {
		// TODO Auto-generated method stub
		
	}
	
	//need method(s) to approve/deny customer applications,
	//as well as view customer information
	
	

}
