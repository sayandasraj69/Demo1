package com.sayandas.FirstMVCProject.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.sayandas.FirstMVCProject.model.Student;

public class Register_Student {
	public static boolean registerStudent(Student student) {
		Connection connection = MyConnection.getConnection();
		PreparedStatement preparedStatement = null;
		if (connection != null) {
			try {
				preparedStatement = connection.prepareStatement(Query.register_Query);
				preparedStatement.setString(1, student.getName());
				preparedStatement.setString(2, student.getEmail());
				preparedStatement.setString(3, student.getPhone());
				preparedStatement.setString(4, student.getPassword());
				if (preparedStatement.executeUpdate() > 0) {
					return true;
				} else {
					return false;
				} 
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Register query failed!!");
				return false;
			}
			
		} else {
			return false;
		}
		
	}
}
