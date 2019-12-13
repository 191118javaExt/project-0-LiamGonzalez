package com.revature.repositories;

import java.util.List;

import com.revature.models.Employee;

//WILL NEED TO COME BACK AND CHANGE THE NAMES OF THE METHODS TO FIT MATCHING DATA IN POSTGRESQL

public interface AdministratorDAO {

	public List<Employee> findAll();
	public Employee findById(int id);
	public boolean insert(Employee e);
	public boolean update(Employee e);
}