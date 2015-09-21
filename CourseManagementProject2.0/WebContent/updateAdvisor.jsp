<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.eintern.dao.UserDAOImpl"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>updateAdvisor.jsp</title>
</head>
<body>

	<%
		String name = request.getParameter("name");
		String username = request.getParameter("user");
		String password = request.getParameter("pass");
		String email = request.getParameter("email");
		String department = request.getParameter("dept");

		UserDAOImpl user = new UserDAOImpl();
		user.setup();

		if (user.addAdvisor(name, username, password, email, department)) {
			user.teardown();
			response.sendRedirect("successRegister.jsp");
		} else {
			user.teardown();
			response.sendRedirect("registrationFailure.jsp");
		}
	%>

</body>
</html>