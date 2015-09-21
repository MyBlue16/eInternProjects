<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AdvisorDirectory</title>

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
			<a class="navbar-brand" href="AdvisorDirectory.jsp">Advisor Directory
				<span class="glyphicon glyphicon-apple" 
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
					aria-expanded="false"> Students <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="approveStudent.jsp">Approve Student</a></li>
					</ul></li>
		
			</ul>

		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid --> </nav>
	<!-- End NavBar -->
	
	<!-- Welcome Message -->
	<div class="jumbotron" >
  <h1>Hello <%=session.getAttribute("username") %>!</h1>
  <p>Welcome to the Advisor Dashboard. <br/>
  Please select an option from one of the dropdown menus. <br/>
  If at any time you need help, look for the help button in the top right corner! <br/>
  Make sure that your advisee has all the necessary requirements so that they may graduate on time!!
  
  </p>
</div>

</body>
</html>