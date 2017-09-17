package com.venky.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class GetConnectionDetails {
	/**
	 * This method is used to establish the connection to the database
	 * @return
	 */
	public Connection getConnection() {
		Connection con = null;
		
		try {
			Properties prop = LoadProperties.getProperties();
			String dbDriver = prop.getProperty("dbDriver");
			String dbURL = prop.getProperty("dbUrl");
			String dbUserName = prop.getProperty("userName");
			String dbPassword = prop.getProperty("password");
			Class.forName(dbDriver);
			con = DriverManager.getConnection(dbURL, dbUserName, dbPassword);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;
	}

}
