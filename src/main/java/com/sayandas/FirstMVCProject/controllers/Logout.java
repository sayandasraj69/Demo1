package com.sayandas.FirstMVCProject.controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/logout")
public class Logout extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
//		HttpSession httpSession = (HttpSession) req.getAttribute("Student");
		HttpSession httpSession = req.getSession();
		httpSession.invalidate();
		resp.getWriter().append("<h3 style='color:green'> Logged out </h3>");
		req.getRequestDispatcher("Login.html").include(req, resp);
	}
}
