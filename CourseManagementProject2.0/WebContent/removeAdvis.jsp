<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.eintern.dao.UserDAOImpl"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		String ids = request.getParameter("id");
		Integer id = Integer.parseInt(ids);

		UserDAOImpl user = new UserDAOImpl();
		user.setup();

		if (user.removeAdvisor(id)) {
			user.teardown();
			response.sendRedirect("successRemoveAdvisor.jsp");
		} else {
			user.teardown();
			response.sendRedirect("removeAdvisorFailure.jsp");
		}
	%>

</body>
</html>