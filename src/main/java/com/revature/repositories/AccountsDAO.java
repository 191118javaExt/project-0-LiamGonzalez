package com.revature.repositories;

import java.util.TreeMap;

import com.revature.models.Account;
import com.revature.models.Account;

public interface AccountsDAO {
	
	
	
	public TreeMap<Integer, Account> getAccountFromUser(String userName);
	public Account getNewAccount(String userName);
	public boolean updateAccount(int accountNumber, double accountBalance);
	
	public boolean createAccount(String userName);
	
	public Account getAccountFromNum(int accountNumber);
	
	public boolean deleteAccount(int accountNumber);
	
	

}