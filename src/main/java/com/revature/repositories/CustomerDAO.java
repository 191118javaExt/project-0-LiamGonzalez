package com.revature.repositories;

import java.util.List;

import com.revature.models.Customer;
//WILL NEED TO COME BACK AND CHANGE NAMES TO MATCH TABLES IN POSTGRESQL
import com.revature.models.Employee;

public interface CustomerDAO {
	
	
	public void open_account();  //'new customer'
	public Customer findCustomerByName(String first_name, String last_name, String user_password);
	public boolean customerUpdate(Customer customer);
	public boolean doesCustomerExist(Customer customer);
	//public boolean approval_status();
	
	//deposit
	//withdrawal
	//transfer

	//public List<Customer> findAll();
	//public boolean insert(Employee e);
	//public boolean update(Employee e);
}