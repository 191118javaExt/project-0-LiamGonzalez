package com.revature.services;

import java.util.Scanner;

public class EmployeeService {

	// need to change this up. For employee registration and login, we want to start
	// off
	// by asking for an employee PIN. The PIN number is going to be the same across
	// ALL
	// employees ("2019"). If the user input is "2019", then we will continue with
	// the
	// login/registration process
	// Scanner el = new Scanner(System.in);
	public static void employeeLogin() {
		Scanner el = new Scanner(System.in);

		System.out.println("Please enter Employee PIN to continue.");
		String pin = el.nextLine();

		if (pin.equals("2019")) {

			System.out.println("Please enter information to login");
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

			// Need to figure out how to check SQL to verify input
		}

		else {

			System.out.println("Incorrect Employee PIN");
			System.out.println("Press 1 to exit. Press 2 to re-enter PIN:");
			String response = el.nextLine();
			if (Integer.parseInt(response) == 1) {
				Services.startingScreen();
			} else {
				employeeLogin();

			}

		}

	}
}
