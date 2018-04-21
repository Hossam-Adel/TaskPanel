<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<style>
.mytr {
	margin-left: 220px;
}

table {
	margin-top: 7%;
	border-color: black;
	background-color: rgb(179, 180, 184)
}

td {
	color: rgb(10, 28, 120);
}
</style>
<body style="background-color: rgb(179, 180, 184);">
	<jsp:include page="Header.jsp" />
	<br>
	<br>
	<table width="100%">
		<col width="10%">
		<col width="90%">
		<tr>
			<td style="color: rgb(1, 18, 88); font-size: large;">
			<strong>AboutApplication</strong></td>
			
			<td rowspan="2" style="">
				<form action="register" method="post">
					<p style="text-indent: 20%; font-size: x-large;">
						<strong>Name </strong>&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;<input
							type="text" name="name"
							style="width: 300px; height: 25px; font-size: large;">
					</p>
					<p style="text-indent: 20%; font-size: x-large;">
						<strong>User name </strong> <input type="text" name="username"
							style="width: 300px; height: 25px; font-size: large;">
					</p>
					<p style="text-indent: 20%; font-size: x-large;">
						<strong>Password</strong> &nbsp; <input type="password"
							name="password"
							style="width: 300px; height: 25px; font-size: large;">
					</p>
					<p style="text-indent: 20%; font-size: x-large;">
						<strong>Email </strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="text" name="email"
							style="width: 300px; height: 25px; font-size: large;">
					</p>
					<p style="text-indent: 20%;">
						<input class="mytr" type="submit" value="Register"
							style="width: 100px; height: 40px;">
					</p>
				</form>

			</td>

		</tr>

		<tr>
			<td>This application is designed for ITS employees to help them
				to assign tasks to each others,control their tasks and view their
				sent and received tasks.</td>
		</tr>

	</table>
	<jsp:include page="Footer.jsp" />
</body>
</html>
