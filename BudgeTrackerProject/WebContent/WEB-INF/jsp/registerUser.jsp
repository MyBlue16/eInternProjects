
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
		<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Directory</title>

<!-- JQuery -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/Resources/forms.css"/>

</head>
<body>	
	<!-- Button trigger modal -->
	<button type="button" class="btn btn-primary btn-lg floatbutt"
		data-toggle="modal" data-target="#myModal">HELP!</button>
	<!-- End Trigger Modal -->

	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Help</h4>
				</div>
				<div class="modal-body">Please input all of the information
					correctly into the form. </div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
	<!-- End Modal -->
	
	
	<!-- Regitration Form -->
	<h1>User Registration Form</h1>
<div class="padding-form">
	<sf:form action="${pageContext.request.contextPath}/registerUser/submit.do" modelAttribute="user" method="post">
		<div class="form-group">
			<sf:input path="name"
				class="form-control" placeholder="Name" required="true" autofocus="true" />
				<sf:errors path="name" cssClass="error" />
		</div>
		<div class="form-group">
			<sf:input path="username" name="user" type="text"
				class="form-control" id="user" placeholder="Username" required="true" />
				<sf:errors path="username" cssClass="error" />
		</div>
		<div class="form-group">
			<sf:password path="password" name="pass" type="password"
				class="form-control" id="pass" placeholder="Password" required="true"/>
				<sf:errors path="password" cssClass="error" />
		</div>
		<div class="form-group">
			<sf:input path="email" name="email" type="email"
				class="form-control" id="email" placeholder="Email" required="true"/>
				<sf:errors path="email" cssClass="error" />
		</div>
		<button type="submit" class="btn btn-default btn-primary btn-lg">Submit</button>
	</sf:form>
	</div>
	<!-- End Form -->

</body>
</html>