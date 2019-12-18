package com.revature.services;


import java.sql.Timestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.models.Account;

import com.revature.models.Account;
import com.revature.repositories.AccountsDAO;
import com.revature.repositories.AccountsDAOImpl;
import com.revature.repositories.TransactionsDAO;
import com.revature.repositories.TransactionsDAOImpl;
		
public class AccountsProcess {
	
	Date date = new Date();
	long time = date.getTime();
	private static Logger logger = Logger.getLogger(AccountsProcess.class);
	AccountsDAO baDAO = new AccountsDAOImpl();
	TransactionsDAO tDAO = new TransactionsDAOImpl();
	TransactionsLogic tLogic = new TransactionsLogic();
	
	//transactions menu
	public void doTransaction(Account account, int transType) {
		switch (transType) {
		case 1 : 
			System.out.println("What's the deposit amount?");
			Scanner scanD = new Scanner(System.in);
			double amtD = Double.parseDouble(scanD.nextLine().split(" ")[0]);
			deposit(account, amtD);
			tDAO.addTransaction(tLogic.transactionTime(), account.getAccountNumber(), "Deposit: +$" + amtD);
			account.setRecentTransactions(tDAO.getTransactions(account.getAccountNumber()));
			break;
		case 2 :
			System.out.println("What's the withdrawal amount?");
			Scanner scanW = new Scanner(System.in);
			double amtW = Double.parseDouble(scanW.nextLine().split(" ")[0]);
			withdraw(account, amtW);
			tDAO.addTransaction(tLogic.transactionTime(), account.getAccountNumber(), "Withdrawal: -$" + amtW);
			account.setRecentTransactions(tDAO.getTransactions(account.getAccountNumber()));
			break;
		case 3 :
			System.out.println("Which account number will you transfer to?");
			Scanner scanT = new Scanner(System.in);
			int act2T2 = Integer.parseInt(scanT.nextLine().split(" ")[0]);
			Account otherAccount = baDAO.getAccountFromNum(act2T2);
			System.out.println("How much do you want to transfer?");
			double amtT = Double.parseDouble(scanT.nextLine().split(" ")[0]);
			transfer(account, amtT, otherAccount);
			tDAO.addTransaction(tLogic.transactionTime(), account.getAccountNumber(), "Outgoing Transaction: -$" + amtT);
			tDAO.addTransaction(tLogic.transactionTime(), otherAccount.getAccountNumber(), "Incoming Transaction: +$" + amtT);
			account.setRecentTransactions(tDAO.getTransactions(account.getAccountNumber()));
			otherAccount.setRecentTransactions(tDAO.getTransactions(otherAccount.getAccountNumber()));
			break;
		}
	}
	
	public double deposit(Account account, double amtD) {
		
		amtD = ((double)((int)(amtD * 100)))/100;
		if((account.getAccountBalance() + amtD) > 1000000000.00) {
			System.out.println("ERROR: Threshold is$1000000000.00");
			return 0;
		} else if(amtD < 0) {
			System.out.println("Invalid deposit, cannot deposit less than $1.00");
			return 0;
		}
		account.deposit(amtD);
		baDAO.updateAccount(account.getAccountNumber(), account.getAccountBalance());
		
		System.out.println("You deposited $" + amtD + "\nNew Balance: $" + account.getAccountBalance() );
		logger.info(time + ": Acct. No. " + account.getAccountNumber() + ", Desposit: +$" + amtD + " , UserName: " + account.getUserName());
		return amtD;
		
	}
	
	public double withdraw(Account account, double amtW) {
		amtW = ((double)((int)(amtW * 100)))/100;
		if(amtW < 0) {
			System.out.println("You cannot withdraw a negative amount.");
			return 0;
		}
		if((account.getAccountBalance() - amtW) < 1) {
			System.out.println("Minimum account balance is $1.00, Cannot process withdrawal.");
			return 0;
		}
		account.withdraw(amtW);
		baDAO.updateAccount(account.getAccountNumber(), account.getAccountBalance());
		
		System.out.println("You have withdrawn $" + amtW + "\nNew Balance: $" + account.getAccountBalance());
		logger.info(time + ": Acct. No. " + account.getAccountNumber() + ", Withdraw: +$" + amtW + " , UserName: " + account.getUserName());
		return amtW;
	}
	
	public double transfer(Account account, double amtT, Account otherAccount) {
		
		amtT = ((double)((int)(amtT * 100)))/100;
		if((otherAccount.getAccountBalance() + amtT ) > 1000000000.00) {
			System.out.println("Account maximum is $1000000000.00, transfer amount too high.");
			return 0;
		} else if (amtT < 0) {
			System.out.println("You shouldn't try to steal... shame on you!");
			return 0;
		}
		if(account.getAccountNumber() == otherAccount.getAccountNumber()) {
			logger.info(time + ": From Acct. No. " + account.getAccountNumber() + " To Acct. No. " + otherAccount.getAccountNumber() + " , Transfer: $" + amtT);
			return 0;
		}
		if((account.getAccountBalance() - amtT) < 1) {
			System.out.println("Minimum account balance is $1.00, cannot perform transfer.");
			return 0;
		}
		account.transfer(amtT, otherAccount);
		baDAO.updateAccount(account.getAccountNumber(), account.getAccountBalance());
		baDAO.updateAccount(otherAccount.getAccountNumber(), otherAccount.getAccountBalance());
	
		logger.info(time + ": From Account Number " + account.getAccountNumber() + " To Account Number " + otherAccount.getAccountNumber() + " , Transfer: $" + amtT);
		return amtT;
	}
	
}