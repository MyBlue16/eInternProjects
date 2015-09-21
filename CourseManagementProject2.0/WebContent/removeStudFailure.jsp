<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>removeStudFailure.jsp</title>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>


</head>
<body>

	<!-- NavBar -->
	<nav class="navbar navbar-default">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="AdminDirectory.jsp">Admin Directory
				<span class="glyphicon glyphicon-user" data-toggle="popover"
				data-placement="bottom" title="Help"
				data-content="I'll always be here when you need me!"
				aria-hidden="true"> </span>
			</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">

				<!-- Administrator options -->

				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false"> Administrators <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="registerAdmin.jsp">Register Admin</a></li>
						<li><a href="removeAdmin.jsp">Remove Admin</a></li>
					</ul></li>

				<!-- Advisor Options -->
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false"> Advisors<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="registerAdvisor.jsp">Register Advisor</a></li>
						<li><a href="removeAdvisor.jsp">Remove Advisor</a></li>
					</ul></li>

				<!-- Student options DropDown -->
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false"> Students <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="registerStudent.jsp">Register Student</a></li>
						<li><a href="removeStudent.jsp">Remove Student</a></li>
					</ul></li>

				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false"> Academics <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="addMajor.jsp">Add Major</a></li>
						<li><a href="addCourses.jsp">Add Courses</a></li>
  						<li role="separator" class="divider"></li>

						<li><a href="removeMajor.jsp">Remove Major</a></li>

						<li><a href="removeCourses.jsp">Remove Course</a></li>
					</ul></li>
			</ul>

		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid --> </nav>
	<!-- End NavBar -->
	
	<!-- Welcome Message -->
	<div class="jumbotron" >
  <h1>Student Removal Unsuccessful!</h1>
</div>


</body>
</html>