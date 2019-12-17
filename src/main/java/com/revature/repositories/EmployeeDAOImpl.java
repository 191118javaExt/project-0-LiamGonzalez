package com.revature.repositories;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.models.Employee;
import com.revature.util.ConnectionUtil;

public class EmployeeDAOImpl implements EmployeeDAO {

	private static Logger logger = Logger.getLogger(EmployeeDAOImpl.class);

	//@Override
	//public List<Employee> findAll() {

	//	List<Employee> list = new ArrayList<>();
	//	List<Integer> supervisors = new ArrayList<>();

	//	try (Connection conn = ConnectionUtil.getConnection()) {

			// This String represents the SQL which we will execute on our database
	//		String sql = "SELECT * FROM \"Project0\".\"users\";";

			// This Statement object is a wrapper around our SQL string
			// And is obtained through our connection to the database
	//		Statement stmt = conn.createStatement();
//
	//		ResultSet rs = stmt.executeQuery(sql);

			// ResultSets start 1 position behind the starting point
			// So, in order to access the first value, we invoke next to start
			// This is a small difference, the only thing is that it simplifies
			// our syntax. Since we can use a while loop instead of a do-while loop
		//	while (rs.next()) {
		//		int id = rs.getInt("user_id");
		//		String first_name = rs.getString("first_name");///////////
		//		String last_name = rs.getString("last_name");////////////
		//		String user_password = rs.getString("user_password");//////////
		//		String emp_type = rs.getString("emp_type");
		//		boolean approved;/////////////
//
		//		Employee e = new Employee();
		//		e.setFirstName(first_name);
		//		e.setLastName(last_name);
		//		e.setPassword(user_password);
		//		e.setEmployeeType(emp_type);
			//	int sup_id = rs.getInt("supervisor");

			//	list.add(e);
			//	supervisors.add(sup_id);
			//}

	//		rs.close();
	//	} catch (SQLException e) {                       //////
	//		logger.warn("Unable to retrieve all users 'employees' ", e);////////////
	//	}

	//	for (int i = 0; i < list.size(); i++) {
	//		int sup_id = supervisors.get(i);

			// Find Employee that matches supervisor id
			// for(Employee e: list) {
			// if(e.getEmployeeId() == sup_id) {///////////////
			// list.get(i).setSupervisor(e);/////////////////
			// }
	//	}

	// return list;
//	}

	

	/*@Override
	public boolean insert(Employee emp) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			// This String represents the SQL which we will execute on our database
			// We use ?'s as place holders, which we can insert values from Java using
			// PreparedStatements
			String sql = "INSERT INTO employee (id, first_name, last_name, password, approved) "
					+ "VALUES (?, ?, ?, ?, ?);";

			// This PreparedStatement object is a wrapper around our SQL string
			// And is obtained through our connection to the database
			// And allows us to insert into the place holders
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, e.getFirstName());
			stmt.setString(2, e.getLastName());
			stmt.setInt(3, e.getAccountId());/////////
			stmt.setDouble(4, e.getEmployeeId());
		///////////////////////////////////////////
		// Employee sup = e.getSupervisor();

//		if (sup != null) {
//			stmt.setInt(5, sup.getEmployeeId());
//
//		} else {
//			stmt.setNull(5, java.sql.Types.INTEGER);
//		}

		if (!stmt.execute()) {
			return false;
		}
	}catch(

	SQLException ex)
	{
			logger.warn("Unable to retrieve all users", ex);
			return false;
		}

	return true;
	}
*/
	//@Override
	//public boolean update(Employee e) {
		// TODO Auto-generated method stub
	//	return false;
	//}

	

	@Override
	public Employee findEmployeeByName(String first_name, String last_name, String user_password) {

		try (Connection conn = ConnectionUtil.getConnection()) {

			//statement?
			
			String sql = "SELECT * FROM project0.employeesadmins WHERE username = ? AND userpassword = ?;";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, first_name);
			stmt.setString(2, last_name);
			stmt.setString(3, user_password);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				String userPassword = rs.getString("user_password");
				//administrator variable?
				boolean admin = rs.getBoolean("isadmin");

				if (admin) {
					rs.close();
					return new Admin(firstName, lastName);
				} else {
					rs.close();
					return new Employee(firstName, lastName, userPassword);
				}
				 
			}
			rs.close();
		} catch (SQLException e) {
			logger.warn("Unable to get Employee from database", e);
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Employee doesEmployeeExist(Employee emp) {
		// TODO Auto-generated method stub
		return null;
	}
}