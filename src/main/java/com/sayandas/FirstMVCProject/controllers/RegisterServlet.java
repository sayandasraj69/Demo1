package com.sayandas.FirstMVCProject.controllers;

import java.io.IOException;

import com.sayandas.FirstMVCProject.jdbc.Register_Student;
import com.sayandas.FirstMVCProject.model.Student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String password = req.getParameter("password");

		Student student = new Student();
		student.setName(name);
		student.setEmail(email);
		student.setPhone(phone);
		student.setPassword(password);
		
		boolean is_Registered = Register_Student.registerStudent(student);
		RequestDispatcher requestDispatcher = null;
		if (is_Registered) {
			resp.getWriter().println("<h3 style='color:green'> Registered succesfully </h3>");
			requestDispatcher = req.getRequestDispatcher("Login.html");
			requestDispatcher.include(req, resp);
		} else {
			resp.getWriter().println("<h3 style='color:red'> Registration not successful due to some error!! </h3>");
			requestDispatcher = req.getRequestDispatcher("index.html");
			requestDispatcher.include(req, resp);
		}
	}
}

//so this was for the tutorial, kindly like share subscribe 😊😊😊