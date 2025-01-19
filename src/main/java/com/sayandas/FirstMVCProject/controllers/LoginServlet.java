package com.sayandas.FirstMVCProject.controllers;

import java.io.IOException;

import com.mysql.cj.Session;
import com.sayandas.FirstMVCProject.jdbc.Login_Student;
import com.sayandas.FirstMVCProject.model.Student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		String email = req.getParameter("email");
		String password = req.getParameter("password"); 
		
		Student student = new Student();
		student.setEmail(email);
		student.setPassword(password);
		
		boolean is_LoggedIn = Login_Student.loginStudent(student);
		RequestDispatcher requestDispatcher = null;
		if (is_LoggedIn) {
			HttpSession httpsession =  req.getSession();
			httpsession.setAttribute("Student", student);
			requestDispatcher = req.getRequestDispatcher("profile.jsp");
			requestDispatcher.forward(req, resp);
		} else {
			resp.getWriter().println("<h3 style='color:red'> Email and password combination didn't match </h3>");
			requestDispatcher = req.getRequestDispatcher("Login.html");
			requestDispatcher.include(req, resp);
		}
		
	}
	
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		doPost(req, resp);
//	}
}
