package com.revature.models;

import java.util.Scanner;

import com.revature.Driver;

public class Employee extends Person {
	private String first_name;
	private String last_name;
	private int accountId;
	private String password;
	static String employee_code = "2019";
	private int emp_id;
	
	public Employee() {
		
	}
	
	
	public Employee(String first_name, String last_name, String userName, int accountId, String password, int id) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.accountId = accountId;
		this.password = password;
		this.emp_id = emp_id;//not sure that i will need this
	}

	
	
	
	public Employee(int emp_id, String first_name, String last_name, Object object) { //check to make sure this is complete
		// TODO Auto-generated constructor stub
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

	
	public int getAccountId() {
		return accountId;
	}




	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmployeeCode() {
		return employee_code;
	}
	
	public void setEmployeeCode (int employee_pin) {
		this.employee_code = employee_code;
	}
	
	public int getEmployeeId() {
		return emp_id;
	}
	
	public void setEmployeeId(int emp_id) {
		this.emp_id = emp_id;
	}

	
	
//this method is called when an employee registers for an employee account
	public static void employeeRegistration() {
		Scanner empscan = new Scanner(System.in);
		
		System.out.println("Welcome to the Employee Registration page.");
		System.out.println("Only Bank Employees may register as an employee,");
		System.out.println("Press any key to continue");
		//System.out.println("if you are not an employee, please exit the terminal.");
		System.out.println("---------------------------------------------------------");
		
	
		
	

			System.out.println("Please fill out the required information:");
			System.out.println(".............................");
			
			System.out.println("Employee PIN: ");
			String code = empscan.nextLine();
			
			if (code.equals(employee_code)) {
			
			
			System.out.println("First Name: ");
			String first_name = empscan.nextLine();
			
			System.out.println("Last Name: ");
			String last_name = empscan.nextLine();
			
			System.out.println("Password: ");
			String password = empscan.nextLine();
			
			System.out.println(" ");
			
			System.out.println("Your employee username is: " + first_name + last_name);
			System.out.println("Your password is: " + password);
			System.out.println("---------------------------------");
			System.out.println("Press any key to return to main menu");////////////////////
			
			String nextStep = empscan.nextLine();
			if(nextStep != null) {
				Driver.startingScreen();
			}
		}else {
			System.out.println("Employee code incorrect, returning to main menu...");
			Driver.startingScreen();
		}
			
	}


	@Override
	public void registerForAccount() {
		// TODO Auto-generated method stub
		
	}	
	
		
	
	
	
	
	/*
	//need to change this up. For employee registration and login, we want to start off
	//by asking for an employee PIN. The PIN number is going to be the same across ALL 
	//employees ("2019"). If the user input is "2019", then we will continue with the 
	//login/registration process
	public static void employeeLogin() {
		Scanner el = new Scanner(System.in);
		
		System.out.println("Please enter information to login");
		System.out.println("");
		
		System.out.println("Employee PIN: ");
		String pin = el.nextLine();
		System.out.println("");
		
		System.out.println("First Name: ");
		String firstName = el.nextLine();
		System.out.println("");

		System.out.println("Last Name: ");
		String lastName = el.nextLine();
		System.out.println("");
		
		System.out.println("Password: ");
		String empPassword = el.nextLine();
		System.out.println("");
		
		//Need to figure out how to check SQL to verify input
		
	}

//might not need to put this in an abstract class
//just put the login methods for 
	@Override
	public void registerForAccount() {
		// TODO Auto-generated method stub
		
	}
	
	//need method(s) to approve/deny customer applications,
	//as well as view customer information
	
	
*/
}
