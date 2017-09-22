<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%-- <%@ page import="imcs.core.model.Employee"%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
.row.content {
	height: 1400px
}

/* Set gray background color and 100% height */
.sidenav {
	padding-top: 20px;
	background-color: #f1f1f1;
	height: 100%;
}

@media screen and (max-width: 767px) {
	.sidenav {
		height: auto;
		padding: 15px;
	}
	.row.content {
		height: auto;
	}
}
</style>
</head>
<body>

	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href='${contextPath}/employee/'>IMCS
				GROUP</a>
		</div>
		<form action="/EmployeeWebApp/loginServlet" method="post">
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav navbar-right">
					<li><button type="submit">Logout</button></li>

				</ul>
			</div>
		</form>

	</div>
	</nav>

	<div class="container-fluid text-center">
		<div class="row content">
			<div class="col-sm-2 sidenav"></div>
			<div class="col-sm-8 text-left">
				<br>
				<div class="row">
					<div class="col-sm-6">
						<form action="${contextPath}/passenger/eSearch" id="search"
							method="get">
							<input type="hidden" id="operations" name="operations"
								value="updateOperFrmEmp" />
							<tr>
								<th>Passenger ID</th>
								<td><input class="requiredAttr" name="eSearch" id="eSearch"
									placeholder="Enter ID to get Info" type="number" required><span
									id="error_msg0" style="color: red"></span></td>
								<td><input id="eSearch1" type="submit" class="btn btn-info"
									value="Submit"></td>
							</tr>
						</form>
					</div>

					<div class="col-sm-6">
						<tr>
							<input id="add" type="submit" class="btn btn-info" value="ADD">
						</tr>

					</div>

				</div>
				<br>
				<div id="msg">
					<c:if test="${not empty msg}">${msg}</c:if>
				</div>

				<div id="eInfo">
					<c:if test="${not empty eInfo}">
						<br><jsp:directive.include file="empInfo.jsp" /></c:if>
				</div>



				<div class="container">

					<form:form action="${contextPath}/passenger/addPassenger"
						id="addform" commandName="addForm" style="display: none"
						method="post">


						<table class="table table-hover">
							<br>

							<tr>
								<th>Password</th>
								<td><input class="requiredAttr" name="password" id="password"
									type="password" required></td>
							</tr>

							<tr>
								<th>First Name</th>
								<td><input class="requiredAttr" name="firstName"
									id="username" type="text" required></td>
							</tr>

							<tr>
								<th>Last Name</th>
								<td><input class="requiredAttr" name="lastName"
									id="lastName" type="text" value="${eInfo.password}"
									required></td>
							</tr>

							<tr>
								<th>Address</th>
								<td><input class="requiredAttr" name="address" id="address"
									type="text" value="" required></td>
							</tr>
							<tr>
								<th>Tel No</th>
								<td><input class="requiredAttr" type="text"
									name="telNo" id="telNo" value="" required></td>
							</tr>


							<tr>
								<th>Email ID</th>
								<td><input class="requiredAttr" id="inp1" type="text"
									name="emailId" id="emailId" required></td>
							</tr>
						

							<tr>
								<td><input id="adduser" type="submit" class="btn btn-info"
									value="Add Passenger"></td>
							</tr>
						</table>
					</form:form>

				</div>

			</div>
			<div class="col-sm-2 sidenav"></div>
		</div>
</body>

<script>
	$(document).ready(function() {
		$("#add").click(function() {
			$("#addform").show();
			$("#eInfo").hide();
			$("#msg").hide();
		});

		$("#search").click(function() {
			$("#addform").hide();
			$("#eInfo").hide();
			$("#msg").hide();
		});

		$("#adduser").click(function() {
			$("#save").hide()
			$("#updatediv").hide()
			$("#deletediv").hide()
			$("#msg").hide();

		});
	});
</script>
<!-- <script>
	$(document).ready(function() {
		$("#a1").click(function() {
			$("#p1").show();
			$("#p2").hide();
			$("#p3").hide();
			$("#p4").hide();
			$("#p5").hide();
			$("#p6").hide();
			$("#msg").hide();
			$("#temp").hide();
			$("#EmpInDept").hide();
			$("#update").hide();
			$("#empInfo").hide();

		});

		$("#a2").click(function() {
			$("#p2").show();
			$("#p1").hide();
			$("#p3").hide();
			$("#p4").hide();
			$("#p5").hide();
			$("#p6").hide();
			$("#msg").hide();
			$("#temp").hide();
			$("#EmpInDept").hide();
			$("#update").hide();
			$("#empInfo").hide();

		});

		$("#D1").click(function() {
			$("#p1").show();
			$("#p3").show();
			$("#p2").hide();
			$("#p4").hide();
			$("#p5").hide();
			$("#p6").hide();
			$("#p41").hide();
			$("#msg").hide();
			$("#temp").hide();
			$("#EmpInDept").hide();
			$("#update").hide();
			$("#empInfo").hide();

		});

		$("#D2").click(function() {
			$("#p1").show();
			$("#p4").show();
			$("#p2").hide();
			$("#p3").hide();
			$("#p5").hide();
			$("#p6").hide();
			$("#p41").hide();
			$("#msg").hide();
			$("#temp").hide();
			$("#EmpInDept").hide();
			$("#update").hide();
			$("#empInfo").hide();

		});

		$("#D3").click(function() {
			$("#p5").show();
			$("#p1").show();
			$("#p2").hide();
			$("#p3").hide();
			$("#p4").hide();
			$("#p6").hide();
			$("#p41").hide();
			$("#msg").hide();
			$("#temp").hide();
			$("#EmpInDept").hide();
			$("#update").hide();
			$("#empInfo").hide();

		});

		$("#D4").click(function() {
			$("#p6").show();
			$("#p1").show();
			$("#p2").hide();
			$("#p3").hide();
			$("#p4").hide();
			$("#p5").hide();
			$("#p41").hide();
			$("#msg").hide();
			$("#temp").hide();
			$("#EmpInDept").hide();
			$("#update").hide();
			$("#empInfo").hide();
		});

		$("#DS").click(function() {
			$("#p41").show();
			$("#p1").show();
			$("#p2").hide();
			$("#p3").hide();
			$("#p4").hide();
			$("#p5").hide();
			$("#p6").hide();
			$("#msg").hide();
			$("#temp").hide();
			$("#EmpInDept").hide();
			$("#update").hide();
			$("#empInfo").hide();
		});

	});
</script> -->
</html>