package com.sayandas.FirstMVCProject.jdbc;

public class Query {
	public static String register_Query = "INSERT INTO students VALUES (?,?,?,?)";
	public static String login_Query = "SELECT * FROM students WHERE email = ? AND password = ?";
}
