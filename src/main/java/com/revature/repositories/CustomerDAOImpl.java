/*
 * 
 * Go through entire class to ensure everything is accurate
 * 
 * 
 */




package com.revature.repositories;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.util.ConnectionUtil;

public class CustomerDAOImpl implements CustomerDAO {
	
	private static Logger logger = Logger.getLogger(EmployeeDAOImpl.class);
	
	
	 
	 
	
	//Do we want to make a list of accounts?
	public Customer getCustomerByName(String first_name, String last_name, String user_password) {
		  
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			// This String represents the SQL which we will execute on our database
			String sql = "SELECT * FROM project0.users WHERE first_name = ? AND last_name = ? AND user_password = ?;";
			
			//where is this needed?
			//Statement stmt = conn.createStatement();
					
					
			PreparedStatement stmt = conn.prepareStatement(sql);
	  		stmt.setString(1, first_name);
	  		stmt.setString(2, last_name);
	 		stmt.setString(3, user_password);
			
			// This Statement object is a wrapper around our SQL string
			// And is obtained through our connection to the database
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			
			// ResultSets start 1 position behind the starting point
			// So, in order to access the first value, we invoke next to start
			// This is a small difference, the only thing is that it simplifies
			// our syntax. Since we can use a while loop instead of a do-while loop
			while(rs.next()) {
				int id = rs.getInt("user_id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				String userPassword = rs.getString("user_password");
				double checking_balance = rs.getDouble("checking_balance");
				double savings_balance = rs.getDouble("Savings_balance");
				boolean account_approval = rs.getBoolean("account_approval");
				
				
				Customer c = new Customer(first_name, last_name, user_password, checking_balance, savings_balance, account_approval);{
					c.setFirstName(first_name);
					c.setLastName(last_name);
					c.setUserPassword(user_password);
					c.setCheckingBalance(checking_balance);
					c.setSavingsBalance(savings_balance);
					c.setAccountApproved(account_approval);
					
				}
				
			}
		
		
		} 
		
	}

	

	@Override       ///////////////
	public boolean open_account(Customer c) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			
			// This String represents the SQL which we will execute on our database
			// We use ?'s as place holders, which we can insert values from Java using
			// PreparedStatements
			String sql = "INSERT INTO Customer (first_name, last_name, user_password, checking_balance, savings_balance, account_approved) " +
					"VALUES (?, ?, ?, ?, ?, ?);";
			
			// This PreparedStatement object is a wrapper around our SQL string
			// And is obtained through our connection to the database
			// And allows us to insert into the place holders
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, c.getFirstName());
			stmt.setString(2, c.getLastName());
			stmt.setString(3, c.getUserPassword());
			stmt.setDouble(4, c.getCheckingBalance());
			stmt.setDouble(5, c.getSavingsBalance());
			stmt.setBoolean(6, c.getAccountApproved());
			
			return stmt.execute();
			
			
		}
		catch (SQLException e) {
			e.printStackTrace();
			
		}
		
		return false;
	}



	

	@Override
	public Customer findCustomerByName(String first_name, String last_name, String user_password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean customerUpdate(Customer customer) {
		
try(Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "UPDATE project0.customers SET first_name = ?, last_name = ?, user_password = ?, approved = ?;";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, customer.getFirstName());
			stmt.setString(2, customer.getLastName());
			stmt.setString(3, customer.getUserPassword());
			stmt.setBoolean(5, customer.getAccountApproved());
			
			boolean success = stmt.execute();
			return success;
		} catch (SQLException e) {
			logger.warn("Cannot update customer info", e);
			e.printStackTrace();
		}
		return false;
	
	
	}

	@Override
	public boolean doesCustomerExist(Customer customer) {
		// TODO Auto-generated method stub
		return false;
	}

}

