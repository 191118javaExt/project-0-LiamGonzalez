package com.revature;
import java.util.Scanner;
import com.revature.models.*;
import com.revature.repositories.EmployeeDAOImpl;
import com.revature.services.Services;
import com.revature.util.ConnectionUtil;
 

public class Driver {
	

	public static void main(String[] args) {
		
		System.out.println("Thank you for using our bank.");
		
		//add a logger to show "application initiated".
		EmployeeDAOImpl x = new EmployeeDAOImpl();/////////
		x.findAll();///////
		Services.startingScreen();
		

	}

}
