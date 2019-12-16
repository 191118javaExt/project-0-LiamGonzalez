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

	@Override
	public List<Employee> findAll() {

		List<Employee> list = new ArrayList<>();
		List<Integer> supervisors = new ArrayList<>();

		try (Connection conn = ConnectionUtil.getConnection()) {

			// This String represents the SQL which we will execute on our database
			String sql = "SELECT * FROM \"Project0\".\"users\";";

			// This Statement object is a wrapper around our SQL string
			// And is obtained through our connection to the database
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(sql);

			// ResultSets start 1 position behind the starting point
			// So, in order to access the first value, we invoke next to start
			// This is a small difference, the only thing is that it simplifies
			// our syntax. Since we can use a while loop instead of a do-while loop
			while (rs.next()) {
				int id = rs.getInt("user_id");
				String first_name = rs.getString("first_name");///////////
				String last_name = rs.getString("last_name");////////////
				String user_password = rs.getString("user_password");//////////
				boolean approved;/////////////

				Employee e = new Employee();
				e.setFirstName(first_name);
				e.setLastName(last_name);
				e.setPassword(user_password);
				int sup_id = rs.getInt("supervisor");

				list.add(e);
				supervisors.add(sup_id);
			}

			rs.close();
		} catch (SQLException e) {
			logger.warn("Unable to retrieve all users", e);
		}

		for (int i = 0; i < list.size(); i++) {
			int sup_id = supervisors.get(i);

			// Find Employee that matches supervisor id
			// for(Employee e: list) {
			// if(e.getEmployeeId() == sup_id) {///////////////
			// list.get(i).setSupervisor(e);/////////////////
			// }
		}

	 return list;
	}

	@Override
	public Employee findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(Employee e) {
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

	@Override
	public boolean update(Employee e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Employee> Approved() {
		// TODO Auto-generated method stub
		return null;
	}
}