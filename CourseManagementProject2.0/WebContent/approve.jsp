<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.eintern.dao.UserDAOImpl" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
		String studID = request.getParameter("studID");
		String approved = request.getParameter("approved");
			
		UserDAOImpl user = new UserDAOImpl();
		user.setup();

		if (user.approveStudent(studID, approved)) {
				response.sendRedirect("successfulApproval.jsp");
			} else {
				response.sendRedirect("approvalFailure.jsp");
			}
		
		%>

</body>
</html>