package com.jdc.todo.model.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
	
	private static final String url = "jdbc:mysql://localhost:3306/os3_db";
	private static final String usr = "root";
	private static final String pwd = "pyaephyo";
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, usr, pwd);
	}

}
