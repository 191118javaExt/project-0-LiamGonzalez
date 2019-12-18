package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.TreeMap;

import org.apache.log4j.Logger;

import com.revature.models.Account;
import com.revature.util.ConnectionUtil;
import com.revature.util.ConnectionUtil;

public class AccountsDAOImpl implements AccountsDAO{
	
	private static Logger logger = Logger.getLogger(AccountsDAOImpl.class);
///////////////////////////
	//@Override
	public Account getAccountFromNum(int accountNumber) {

		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM project0.bankaccounts WHERE accountnumber = ?;";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, accountNumber);

			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				int accountNum = rs.getInt("accountnumber");
				double accountBal = rs.getDouble("accountbalance");
				String accountOwner = rs.getString("username");
				
				
				Account Account = new Account(accountNum, accountBal, accountOwner);
				rs.close();
				return Account;
			}
			rs.close();
			
		} catch (SQLException e) {
			logger.warn("Couldn't access account", e);
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public TreeMap<Integer,Account> getAccountFromUser(String userName) {
		TreeMap<Integer, Account> accounts = new TreeMap<>();
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM project0.bankaccounts WHERE usernam = ?;";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, userName);

			
			ResultSet rs = stmt.executeQuery();
			int i = 1;
			while(rs.next()) {
				int accountNum = rs.getInt("accountnumber");
				double accountBal = rs.getDouble("accountbalance");
				String accountOwner = rs.getString("usernam");
				
				Account bankAccount = new Account(accountNum, accountBal, accountOwner);
				accounts.put(i, bankAccount);
				i++;
				
//				rs.close();
//				return accounts;
			}
			rs.close();
			
		} catch (SQLException e) {
			logger.warn("Can't get user's accounts", e);
			e.printStackTrace();
		}
		return accounts;
		
	}

	@Override
	public boolean updateAccount(int accountNumber, double accountBalance) {

		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "UPDATE project0.bankaccounts SET accountbalance = ? WHERE accountnumber = ?;";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setDouble(1, accountBalance);
			stmt.setInt(2, accountNumber);
			return stmt.execute();

		} catch (SQLException e) {
			logger.warn("Unable to update customer information", e);
			e.printStackTrace();
		}
		return false;

	}

	@Override	////////////////////////////////////////
	public boolean createAccount(String userName) {

		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql ="INSERT into project0.bankaccounts (usernam) " +
						"VALUES (?);";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, userName);
			return stmt.execute();
			
			
			
		
			
		} catch (SQLException e) {
			logger.warn("Unable to open new account", e);
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public Account getNewAccount(String userName) {
		
		try (Connection conn = ConnectionUtil.getConnection()) {

			
			String sql = "SELECT accountnumber FROM project0.bankaccounts WHERE usernam = ? AND accountbalance = 0;";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, userName);
			
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				int accountNum = rs.getInt("accountnumber");
				
				
				Account bankAccount = new Account(accountNum, 0, userName);
				rs.close();
				return bankAccount;
			}
			rs.close();
			
		} catch (SQLException e) {
			logger.warn("Unable to retrieve new account", e);
			e.printStackTrace();
		}
		System.out.println("Unable to retrieve new account.");
		return null;
	}
	
	
	@Override
	public boolean deleteAccount(int accountNumber) {
		
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "DELETE FROM project0.bankaccounts WHERE accountnumber = ?;";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, accountNumber);
			return stmt.execute();

		} catch (SQLException e) {
			logger.warn("Unable to delete customer bank account on database", e);
			e.printStackTrace();
		}
		return false;
	}
	
	

}