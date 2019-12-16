package com.revature.repositories;

import java.util.List;

import com.revature.models.Employee;

public interface EmployeeDAO {
//check that these are correct
	public List<Employee> findAll();
	public List<Employee> Approved();
	public Employee findById(int id);
	public boolean insert(Employee e);
	public boolean update(Employee e);
	
	
}
