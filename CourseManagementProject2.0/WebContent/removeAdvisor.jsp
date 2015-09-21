<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>removeAdvisor.jsp</title>

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
				<span class="glyphicon glyphicon-user" 
				data-placement="bottom"
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
		data-toggle="modal" data-target="#myModal" >HELP!</button>
	<!-- End Trigger Modal -->
	
	<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Help</h4>
      </div>
      <div class="modal-body">
        Please input all of the information correctly into the form. 
         If you would like to see a list of all advisors. Please click the "Show All Advisors" Button.
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>
	<!-- End Modal -->

	<!-- Registration Form -->
	<h1>Remove Advisor Form</h1>
<div class="padding-form">
	<form name="remove" id="remove" action="removeAdvis.jsp" method="post">
		<div class="form-group">
			<label for="advisorID">Advisor ID:</label> <input name="id" type="number"
				class="form-control" id="id" placeholder="Advisor ID">
		</div>
		<button type="submit" class="btn btn-default btn-primary btn-lg">Submit</button>
	</form>
	</div>
	<!-- End Form -->

	<div class="button-pad">
		<button id="displayAdvisors" type="button"
			class="btn btn-primary btn-lg btn-block">Show All Advisors</button>
	</div>

	<p class="para" id="message"></p>


	<script type="text/javascript" src="removeAdvisorScript.js"></script> 

</body>
</html>