<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>RegisterStudent.jsp</title>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	
<link rel="stylesheet" type="text/css" href="forms.css"/>

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
					correctly into the form. If you would like to see a list of all
					available majors. Please click the "Show All Majors" Button.</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
	<!-- End Modal -->


	<h1>Student Registration Form</h1>
	<!-- Registration Form -->
	<div class="padding-form">
		<form name="register" id="register" action="updateAdvisor.jsp"
			method="post" class="form-signin">
			<div class="form-group">
				<label for="name">Name</label> <input name="name" type="text"
					class="form-control" id="name" placeholder="Name">
			</div>
			<div class="form-group">
				<label for="username">Username</label> <input name="user"
					type="text" class="form-control" id="user" placeholder="Username">
			</div>
			<div class="form-group">
				<label for="password">Password</label> <input name="pass"
					type="password" class="form-control" id="pass"
					placeholder="Password">
			</div>
			<div class="form-group">
				<label for="confirmPass">Confirm Password</label> <input
					name="confirmPass" type="password" class="form-control"
					id="confirmPass" placeholder="Confirm Password">
			</div>
			<div class="form-group">
				<label for="email">Email</label> <input name="email" type="email"
					class="form-control" id="email" placeholder="Email">
			</div>
			<div class="form-group">
				<label> Classification: <br /> <input type="radio"
					name="class" value="Freshman" />Freshman <br> <input
					type="radio" name="class" value="Sophmore" />Sophomore <br> <input
					type="radio" name="class" value="Junior" />Junior <br> <input
					type="radio" name="class" value="Senior" />Senior <br>
				</label>
			</div>
			<div class="form-group">
				<label for="Major" class="sr-only">Major</label> <input type="text"
					id="major" name="major" class="form-control" placeholder="Major" />
			</div>
			<button type="submit" class="btn btn-default btn-primary btn-lg">Submit</button>
		</form>
	</div>
	<!-- End Form -->

	<!-- Registration Form -->

	<div class="button-pad">
		<button id="displayMajors" type="button"
			class="btn btn-primary btn-lg btn-block">See Available
			Majors</button>
	</div>

	<p id="message"></p>

	<script type="text/javascript" src="regStudentScript.js"></script>
</body>
</html>