<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.eintern.dao.UserDAOImpl"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		String username = request.getParameter("user");
		String password = request.getParameter("pass");
		session.setAttribute("username", username);
		UserDAOImpl dao = new UserDAOImpl();
		dao.setup();
		if (dao.authenticateUser(username, password) == 0) {
			dao.teardown();
			response.sendRedirect("AdminDirectory.jsp");
		} else if (dao.authenticateUser(username, password) == 1) {
			dao.teardown();
			response.sendRedirect("AdvisorDirectory.jsp");
		} else if (dao.authenticateUser(username, password) == 2) {
			dao.teardown();
			response.sendRedirect("StudDirectory.jsp");
		} else {
			dao.teardown();
			response.sendRedirect("loginFailure.jsp");
		}
	%>

</body>
</html>