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
		String degreeName = request.getParameter("name");
		Integer numClasses = Integer.parseInt(request
				.getParameter("numClasses"));

		UserDAOImpl user = new UserDAOImpl();
		user.setup();

		if (user.addMajor(degreeName, numClasses)) {
			response.sendRedirect("successAddMajor.jsp");
		} else {
			response.sendRedirect("addMajorFailure.jsp");
		}
	%>
</body>
</html>