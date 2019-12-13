package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

/**
 * This is a JavaDoc comment
 * It is similar to a multi-line comment, except there are 2 *'s at the top
 * This information will be displayed in the IDE, when you hover over the class/method
 * 
 * Can be used directly above classes or methods to support hover info.
 * 
 * @author Liam Gonzalez
 *
 */
public class ConnectionUtil {
	
	private static Logger logger = Logger.getLogger(ConnectionUtil.class);

	public static Connection getConnection() {
		
		// The url includes the driver we're using, which is from postgres,
		// as well as the computer, which local host, and the port, which is 5432
		// The last '/' is important, as it refers to the specific database
		// we are connecting to
		// However, since we only have 1 database, we can connect to that one
		// without specifying
		String url = "jdbc:postgresql://localhost:5432/";
		String username = "postgres";
		String password = "230fedf32eae4c858c2bbd1e4ce736af";
		
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			logger.warn("Unable to obtain connection to database", e);
		}
		
		return conn;
	}
}