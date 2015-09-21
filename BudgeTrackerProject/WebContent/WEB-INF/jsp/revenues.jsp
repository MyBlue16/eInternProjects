<%@page import="org.springframework.ui.Model"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Directory</title>

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
			<a class="navbar-brand">FD Directory <span
				class="glyphicon glyphicon-globe" aria-hidden="true"> </span>
			</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">

				<!-- Administrator options -->

				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false"> Manage Users <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a
							href="${pageContext.request.contextPath}/registerUser.do">Register
								User</a></li>
						<li><a
							href="${pageContext.request.contextPath}/removeUser.do">Remove
								User</a></li>
					</ul></li>

				<!-- Expense Options -->
				<li><a href="${pageContext.request.contextPath}/expenses.do">Expenses</a></li>

				<!-- Revenue options DropDown -->
				<li><a href="${pageContext.request.contextPath}/revenues.do">
						Revenues</a></li>

			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="${pageContext.request.contextPath}/Logout">Logout</a></li>
			</ul>

		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid --> </nav>
	<!-- End NavBar -->

	<!-- Welcome Message -->
	<div class="jumbotron">
		<h1>Revenue</h1>


		<div class="container-fluid">
			<table width="100%" align="center" class="table table-striped">
				<tr>
					<td><strong>ID</strong></td>
					<td><strong>Date</strong></td>
					<td><strong>Client</strong></td>
					<td><strong>Amount</strong></td>
				</tr>
				<c:forEach var="revenue" items="${requestScope.revenues}">
					<tr>
						<td><c:out value="${revenue.id}" /></td>
						<td><fmt:formatDate pattern="MM/dd/20yy"
								value="${revenue.datePaid}" /></td>
						<td><c:out value="${revenue.client}" /></td>
						<td><c:out value="${revenue.amount}" /></td>
					</tr>
				</c:forEach>
			</table>
			</td>
			</table>
		</div>
	</div>

	<table>
		<tr>
			<td>
				<!-- Add Button trigger modal -->
				<button type="button" class="btn btn-primary btn-lg floatbutt"
					data-toggle="modal" data-target="#addModal">Add Record</button> <!-- End Trigger Modal -->

				<!-- Add Revenue Modal -->
				<div class="modal fade" id="addModal" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
								<h4 class="modal-title" id="myModalLabel">Add Revenue
									Record</h4>
							</div>
							<div class="modal-body">
								<!-- Add Revenue Form -->
								<h1>Add Revenue Form</h1>
								<div class="padding-form">
									<sf:form modelAttribute="revenue"
										action="${pageContext.request.contextPath}/addRevenue/submit.do"
										method="post">
										<div class="form-group">
											<label for="datePaid">Date Payment Received</label>
											<sf:input path="datePaid" type="date" class="form-control"
												placeholder="Date Payment Received" required="true" />
										</div>
										<div class="form-group">
											<sf:input path="client" name="client" class="form-control"
												id="client" placeholder="Client" required="true" />
										</div>
										<div class="input-group">
											<div class="input-group-addon">$</div>
											<sf:input path="amount" type="number" step="0.01"
												minValue="0.00" class="form-control" placeholder="Amount"
												required="true" />
										</div>
										<button type="submit"
											class="btn btn-default btn-primary btn-lg">Submit</button>
									</sf:form>
								</div>
								<!-- End Form -->
							</div>
						</div>
					</div>
					<!-- End Modal -->
				</div>
			</td>
			<td>
				<!-- Delete Button trigger modal -->
				<button type="button" class="btn btn-primary btn-lg floatbutt"
					data-toggle="modal" data-target="#deleteModal">Delete
					Record</button> <!-- End Trigger Modal --> <!-- Delete Expense Modal -->
				<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
								<h4 class="modal-title" id="myModalLabel">Delete Revenue
									Record</h4>
							</div>
							<div class="modal-body">
								<!-- Delete Revenue Form -->
								<h1>Delete Revenue Form</h1>
								<div class="padding-form">
									<sf:form modelAttribute="revenue"
										action="${pageContext.request.contextPath}/removeRevenue/submit.do"
										method="post">
										<div class="form-group">
											<sf:input path="id" type="number" class="form-control"
												placeholder="Revenue ID" required="true" autofocused="true" />
										</div>
										<button type="submit"
											class="btn btn-default btn-primary btn-lg">Submit</button>
									</sf:form>
								</div>
								<!-- End Form -->
							</div>
						</div>
					</div>
				</div> <!-- End Modal -->
			</td>
			<td>
				<!-- Select Button trigger modal -->
				<button type="button" class="btn btn-primary btn-lg floatbutt"
					data-toggle="modal" data-target="#selectModal">Select
					Range By Client</button> <!-- End Trigger Modal --> <!-- Select Expense Modal -->
				<div class="modal fade" id="selectModal" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
								<h4 class="modal-title" id="myModalLabel">Select Revenue By
									Client</h4>
							</div>
							<div class="modal-body">
								<!-- Select Revenue Form -->
								<h1>Select Revenue Form</h1>
								<div class="padding-form">
									<sf:form modelAttribute="revenue"
										action="${pageContext.request.contextPath}/selectRevenue/submit.do"
										method="post">
										<div class="form-group">
											<sf:input path="client" type="text" class="form-control"
												placeholder="Client" required="true" autofocused="true" />
										</div>
										<button type="submit"
											class="btn btn-default btn-primary btn-lg">Submit</button>
									</sf:form>
								</div>
								<!-- End Form -->
							</div>
						</div>
					</div>
				</div> <!-- End Modal -->
			</td>
	</table>

</body>
</html>