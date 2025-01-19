package com.sayandas.FirstMVCProject.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sayandas.FirstMVCProject.model.Student;

public class Login_Student {
	public static boolean loginStudent(Student student) {
		Connection connection = MyConnection.getConnection();
		PreparedStatement preparedStatement = null;
		if (connection != null) {
			try {
				preparedStatement = connection.prepareStatement(Query.login_Query);
				preparedStatement.setString(1, student.getEmail());
				preparedStatement.setString(2, student.getPassword());
				ResultSet resultSet = preparedStatement.executeQuery();
				if (resultSet.next()) {
					student.setName(resultSet.getString(1));
					student.setPhone(resultSet.getString(3));
					return true;
				} else {
					return false;
				} 
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Login query failed!!");
				return false;
			}
			
		} else {
			return false;
		}
	}
}
