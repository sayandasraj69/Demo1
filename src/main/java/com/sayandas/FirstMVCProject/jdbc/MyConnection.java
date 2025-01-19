package com.sayandas.FirstMVCProject.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {

	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/FirstMVCProject_db", "root", "computer");			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
			System.out.println("Database Connection failed!!");
		}
		return connection;
	}
}
