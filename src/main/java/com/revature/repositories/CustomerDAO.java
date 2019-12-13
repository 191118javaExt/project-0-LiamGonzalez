package com.revature.repositories;

import java.util.List;

//WILL NEED TO COME BACK AND CHANGE NAMES TO MATCH TABLES IN POSTGRESQL
import com.revature.models.Employee;

public interface CustomerDAO {

	public List<Employee> findAll();
	public Employee findById(int id);
	public boolean insert(Employee e);
	public boolean update(Employee e);
}