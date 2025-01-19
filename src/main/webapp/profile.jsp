<%@page import="com.sayandas.FirstMVCProject.model.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile Page</title>
</head>
<body>
	
	<%
	
		Student student = (Student) session.getAttribute("Student");
	%>
	
	<h3>Welcome <%= student.getName() %></h3>
	
	Name : <%= student.getName() %> <br><br>
	Phone : <%= student.getPhone() %> <br><br>
	Email : <%= student.getEmail() %> <br><br>
	
	<a href="logout"> Logout</a>
	
</body>
</html>