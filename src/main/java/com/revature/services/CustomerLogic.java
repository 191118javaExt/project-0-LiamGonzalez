package com.revature.services;

import java.util.Scanner;

import java.util.TreeMap;
import java.util.concurrent.ArrayBlockingQueue;

import com.revature.models.Account;
import com.revature.models.Customer;
import com.revature.repositories.AccountsDAO;
import com.revature.repositories.AccountsDAOImpl;
import com.revature.repositories.CustomersDAO;
import com.revature.repositories.CustomersDAOImpl;
import com.revature.repositories.TransactionsDAO;
import com.revature.repositories.TransactionsDAOImpl;

public class CustomerLogic {
	
		CustomersDAO cDAO = new CustomersDAOImpl();
		TransactionsDAO tDAO = new TransactionsDAOImpl();
		
		
	public Customer grabWholeCustomer(String userName, String password) {
		Customer customer = cDAO.getCustomerByUserName(userName, password);
		AccountsDAO baDAO = new AccountsDAOImpl();
		TreeMap<Integer, Account> userAccounts = baDAO.getAccountFromUser(userName);
		customer.setUserAccounts(userAccounts);
		for(int i = 1; i <= userAccounts.size(); i++) {
			ArrayBlockingQueue<String> trans = tDAO.getTransactions(userAccounts.get(i).getAccountNumber());
			userAccounts.get(i).setRecentTransactions(trans);
		}
		return customer;
	}
	
	
public Customer existingUserLoginCustomer() {
		
		Customer thisCustomer = new Customer();
		
		System.out.println("please enter your username:");
		Scanner scan = new Scanner(System.in);
		String loginName = scan.nextLine();
		thisCustomer.setUserName(loginName);
		
		System.out.println("Enter password:");
		String loginPass = scan.nextLine();							
		thisCustomer.setPassword(loginPass);
		
		return existingCustomerCheck(thisCustomer,loginName,loginPass);
		
	}

	Customer setNewUserFields(Customer newCustomer) {
		System.out.println("Please fill out required fields:");
		System.out.println("First Name:");
		Scanner scan = new Scanner(System.in);
		String typeFirstName = scan.nextLine();

		if (acceptableFirstName(typeFirstName)) {
			newCustomer.setFirstName(typeFirstName);
		} else {
			while (acceptableFirstName(typeFirstName)) {
				System.out.println("Enter First Name:");
				typeFirstName = scan.nextLine();
			}
		}
		System.out.println("Please enter your last name (40 characters max):");
		String typeLastName = scan.nextLine();
		
		if (acceptableLastName(typeLastName)) {
			newCustomer.setLastName(typeLastName);
		} else {
			while (acceptableLastName(typeLastName)) {
				System.out.println("Enter Last Name:");
				typeLastName = scan.nextLine();
			}
		}
	
		
		newCustomer.setApproved(false);
		cDAO.createCustomer(newCustomer);
		System.out.println(
				"Your account will be reviewed for approval");
		System.out.println("Press ENTER to exit");
		scan.nextLine();
		return newCustomer;
	}
	
	public Customer existingCustomerCheck(Customer thisCustomer, String loginName, String loginPass) {
		CustomersDAO cDaoObj = new CustomersDAOImpl();
		if (cDaoObj.customerExists(loginName)) {
			Customer check = cDaoObj.getCustomerByUserName(loginName, loginPass);
			if(check.getPassword().equals(loginPass)) {
				thisCustomer = check;
				return grabWholeCustomer(loginName, loginPass);
			} else {
				System.out.println("Incorrect password.");
				return null;
			}
		} else {
			System.out.println("Invalid username.");
		}
		return null;
	}
	
	public boolean acceptableFirstName(String typeFirstName) {
		if ((!typeFirstName.equals("")) && (typeFirstName.length() <= 50)) {
			return true;
		} else return false;
	}

	public boolean acceptableLastName(String typeLastName) {
		if ((!typeLastName.equals("")) && (typeLastName.length() <= 50)) {
			return true;
		} else return false;
	}
	public boolean acceptableAddress(String typeAddress) {
		if ((!typeAddress.equals("")) && (typeAddress.length() <= 150)) {
			return true;
		} else return false;
	}
	
}