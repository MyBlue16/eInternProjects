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
		String studId = request.getParameter("id");
			String crn1 = request.getParameter("crn1");
			String crn2 = request.getParameter("crn2");
			String crn3 = request.getParameter("crn3");
			String crn4 = request.getParameter("crn4");
			
			int id = Integer.parseInt(studId);
			
			int[] crns = new int[4];
				crns[0] = Integer.parseInt(crn1);
				crns[1] = Integer.parseInt(crn2);
				crns[2] = Integer.parseInt(crn3);
				crns[3] = Integer.parseInt(crn4);
		
			UserDAOImpl user = new UserDAOImpl();
			user.setup();

			if (user.registerForClass(id, crns) ){
			response.sendRedirect("StudDirectory.jsp");
		} else {
			response.sendRedirect("approvalFailure.jsp");
		}
	%>

</body>
</html>