<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.eintern.dao.UserDAOImpl"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>addMajor</title>
</head>
<body>
	<%
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String location = request.getParameter("location");
		String semester = request.getParameter("semester");
		String department = request.getParameter("department");
		String start = request.getParameter("start");

		String end = request.getParameter("end");
		String size = request.getParameter("size");

		UserDAOImpl user = new UserDAOImpl();
		user.setup();

		if (user.addCourse(name,id,department,location,semester,size,start,end)) {
			response.sendRedirect("successAddCourse.jsp");
		} else {
			response.sendRedirect("addCourseFailure.jsp");
		}
	%>
</body>
</html>