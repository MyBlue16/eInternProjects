
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>removeUser</title>

<!-- JQuery -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/Resources/forms.css" />

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
					correctly into the form. Enter in the correct Employee ID number to be removed.</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
	<!-- End Modal -->


	<!-- Regitration Form -->
	<h1>Delete Employee Form</h1>
	<div class="padding-form">
		<sf:form modelAttribute="user"
			action="${pageContext.request.contextPath}/removeUser/submit.do"
			method="post">
			<div class="form-group">
				<sf:input path="id" type="number"
					class="form-control" placeholder="User ID"
					required="true" autofocused="true" />
			</div>
			<button type="submit" class="btn btn-default btn-primary btn-lg">Submit</button>
		</sf:form>
	</div>
	<!-- End Form -->

</body>
</html>