<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>dropClass</title>

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
			<a class="navbar-brand" href="StudDirectory.jsp">Student Directory
				<span class="glyphicon glyphicon-education" 
				data-placement="bottom"
				aria-hidden="true"> </span>
			</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">

				<!-- Student options -->

				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false"> Class Manager <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="registerForClass.jsp">Add Classes</a></li>
						<li><a href="dropClass.jsp">Drop Classes</a></li>
				
					</ul></li>
		
			</ul>

		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid --> </nav>
	<!-- End NavBar -->
	
	<!-- DropClass Form -->
	<h1>Drop Class Form</h1>
<div class="padding-form">
	<form name="register" id="register" action="drop.jsp" method="post">
		<div class="form-group">
			<label for="name">Student ID</label><input name="id" type="number"
				class="form-control" id="id" placeholder="Student ID" required>
		</div>
		<div class="form-group">
			<input name="crn" type="number" value="0"
				class="form-control" id="crn" placeholder="CRN" required>
		</div>
		<button type="submit" class="btn btn-default btn-primary btn-lg">Submit</button>
	</form>
	</div>
	<!-- End Form -->

</body>
</html>