package com.revature.models;


public class Administrator extends Person {
	private String name;
	private String userName;
	private String password;
	private int accountId;
	
	
	public Administrator(String name, String userName, String password, int accountId) {
		super();
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.accountId = accountId;
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


	@Override
	public void registerForAccount() {
		// TODO Auto-generated method stub
		
	}
	
	//need methods to approve/deny customer applications,
	//view customer information, and edit customer info/transactions
	
	
	
	

}
