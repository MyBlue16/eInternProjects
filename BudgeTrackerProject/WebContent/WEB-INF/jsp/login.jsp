
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign-in Page</title>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/Resources/loginCSS.css" />

</head>

<body>
	<h1 class="header">Financial Department</h1>
	<div class="container">
		<div class="card card-container">
			<form class="form-signin"
				action="<c:url value="/j_spring_security_check"/>"
				method='POST' name="">

				<input name="j_username" type="text" class="form-control"
					placeholder="Username" required="true" autofocus="true" />
				<br />
				<input name="j_password" type="password" class="form-control"
					placeholder="Password" required="true" />
				<br />
				<button class="btn btn-lg btn-primary btn-signin" type="submit">Sign
					in</button>
					<button class="btn btn-lg btn-primary btn-signin" type="reset">Reset</button>

			</form>
			<!-- /form -->
		</div>
		<!-- /card-container -->
	</div>
	<!-- /container -->

</body>
</html>