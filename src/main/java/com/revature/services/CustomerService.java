package com.revature.services;

import java.util.Scanner;
/*
 * 
 * 
 * 
 * 
 * 
 * 
 * work on this
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */

import com.revature.models.Customer;

public class CustomerService {
	
	//this is the customer login method. 	
	
	public static void customerLogin() {
		Scanner cl = new Scanner(System.in);
		System.out.println("Please enter your information to login: ");
		System.out.println("");
		
		System.out.println("First Name: ");
		String first_name = cl.nextLine();
		System.out.println(" ");
		
		System.out.println("Last Name: ");
		String last_name = cl.nextLine();
		System.out.println("");
		
		System.out.println("Password: ");
		String user_password = cl.nextLine();
		
		
		//Need to figure out how to check SQL database to verify
		//if the input is correct***************************************
		
	}
	
	
	


}
