package com.venky.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class GetConnectionDetails {
	public Connection getConnection() {
		Connection con = null;
		String dbDriver;
		try {
			Properties prop = LoadProperties.getProperties();
			dbDriver = prop.getProperty("dbDriver");
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
