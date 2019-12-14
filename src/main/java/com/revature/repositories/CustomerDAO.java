package com.revature.repositories;

import java.util.List;

import com.revature.models.Customer;
//WILL NEED TO COME BACK AND CHANGE NAMES TO MATCH TABLES IN POSTGRESQL
import com.revature.models.Employee;

public interface CustomerDAO {
	
	public int deposit();
	public int withdrawal();
	public int transfer();
	public void close_account();
	//public boolean approval_status();
	
	//deposit
	//withdrawal
	//transfer

	public List<Customer> findAll();
	//public Employee findById(int id);
	public boolean insert(Employee e);
	public boolean update(Employee e);
}