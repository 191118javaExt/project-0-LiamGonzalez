package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.revature.models.Customer;
import com.revature.util.ConnectionUtil;

public class CustomersDAOImpl implements CustomersDAO{
	
	private static Logger logger = Logger.getLogger(CustomersDAOImpl.class);

	
	@Override
	public Customer getCustomerByUserName(String userName, String password) {
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			// prepared statement
			String sql = "SELECT * FROM project0.customers WHERE userName = ? AND userPassword = ?;";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, userName);
			stmt.setString(2, password);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				String dbUserName = rs.getString("userName");
				String userPassword = rs.getString("userPassword");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				boolean approved = rs.getBoolean("approved");
				
				Customer customer = new Customer(dbUserName, userPassword, firstName, lastName, approved);
				rs.close();
				return customer;
			}
			rs.close();
		} catch (SQLException e) {
			logger.warn("Unable to get Customer from database", e);
			e.printStackTrace();
		}
		return null;
	}

	
	
	@Override
	public boolean updateCustomer(Customer customer) {
		
	
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "UPDATE project0.customers SET userName = ?, userPassword = ?, firstName = ?, lastName = ?, approved = ? WHERE userName = ?;";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, customer.getUserName());
			stmt.setString(2, customer.getPassword());
			stmt.setString(3, customer.getFirstName());
			stmt.setString(4, customer.getLastName());
			stmt.setBoolean(6, customer.Approved());
			stmt.setString(7, customer.getUserName());
			boolean success = stmt.execute();
			return success;
		} catch (SQLException e) {
			logger.warn("Can't get user information", e);
			e.printStackTrace();
		}
		return false;
	}

	
	
	@Override
	public boolean customerExists(String userName) {
		Customer c = new Customer();
		c.setUserName(userName);
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM project0.customers WHERE userName = ?;";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, userName);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String dbUserName = rs.getString("userName");
				boolean exists = false;
				if (userName.equals(dbUserName)) {
					exists = true;
					return exists;
				} else {
					return exists;
				}
			}
		} catch (SQLException e) {
			logger.warn("Can't find out if user exists or not", e);
			e.printStackTrace();
		}
		return false;
	}

	
	
	@Override
	public boolean createCustomer(Customer customer) {

		try (Connection conn = ConnectionUtil.getConnection()) {
			
			

			String sql = "INSERT into project0.customers (userName, userPassword, firstName, lastName, approved) " +
						"VALUES (?,?,?,?,?);";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, customer.getUserName());
			stmt.setString(2, customer.getPassword());
			stmt.setString(3, customer.getFirstName());
			stmt.setString(4, customer.getLastName());
			stmt.setBoolean(5, customer.Approved());
			
			return stmt.execute();

		} catch (SQLException e) {
			logger.warn("///", e);
			e.printStackTrace();
		}
		return false;
	}



	@Override
	public Customer getCustomerByUserNameOnly(String userName) {

	try(Connection conn = ConnectionUtil.getConnection()) {
			
			// prepared statement
			String sql = "SELECT * FROM project0.customers WHERE userName = ?;";  //project0.customers
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, userName);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				String dbUserName = rs.getString("userName");////////////
				String userPassword = rs.getString("userPassword");////////
				String firstName = rs.getString("firstName");/////////
				String lastName = rs.getString("lastName");///////////
				boolean approved = rs.getBoolean("approved");////////////
				
				Customer customer = new Customer(dbUserName, userPassword, firstName, lastName, approved);
				rs.close();
				return customer;
			}
			rs.close();
		} catch (SQLException e) {
			logger.warn("Can't get user from database", e);
			e.printStackTrace();
		}
		return null;
	}

}