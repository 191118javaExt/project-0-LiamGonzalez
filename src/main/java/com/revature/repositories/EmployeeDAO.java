package com.revature.repositories;

import java.util.List;

import com.revature.models.Employee;

public interface EmployeeDAO {
//check that these are correct
	//public List<Employee> findAll();
	//public List<Employee> Approved();
	
	//do i need to add an employee update method?
	//do i need to add an employee insert method (add new employee)?
	public Employee findEmployeeByName(String first_name, String last_name, String user_password);
	public Employee doesEmployeeExist(Employee emp);
	//public boolean insert(Employee e);
	//public boolean update(Employee e);
	
	
}
