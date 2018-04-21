<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
<script>
	jQuery(document).ready(function($) {

		if (window.history && window.history.pushState) {

			$(window).on('popstate', function() {
				var hashLocation = location.hash;
				var hashSplit = hashLocation.split("#!/");
				var hashName = hashSplit[1];

				if (hashName !== '') {
					var hash = window.location.hash;
					if (hash === '') {
						//alert('Back button was pressed.');
						window.location = 'Login.jsp';
						return false;
					}
				}
			});

			window.history.pushState('forward', null, './#forward');
		}

	});
</script>

</head>
<style>
.mytr {
	margin-left: 220px;
}

table {
	margin-top: 7%;
	border-color: black;
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
		<col width="15%">
		<col width="85%">
		<tr>
			<td style="color: red; font-size: large;"><mark
					style="background-color:rgb(0,0,102)"> <strong><font
					color="orange">About Application </font></strong> </mark></td>
			<td rowspan="2" style="">
				<form action="login" method="POST">
					<p style="text-indent: 20%; font-size: x-large;">
						<strong>User name </strong> <input type="text" name="username"
							style="width: 300px; height: 25px; font-size: large;">
					</p>
					<p style="text-indent: 20%; font-size: x-large;">
						<strong>Password</strong> &nbsp; <input type="password"
							name="password"
							style="width: 300px; height: 25px; font-size: large;">
					</p>
					<p style="text-indent: 20%;">
						<input type="submit" value="Login"
							style="width: 80px; height: 30px; margin-left: 20px;"> <input
							href="Register.jsp" onClick="location.href='Register.jsp'"
							class="mytr" type="button" value="Register"
							style="width: 80px; height: 30px;">
				</form>
				</p>



			</td>

		</tr>

		<tr>

			<td ><strong><font
					color="rgb(0, 0, 102)">This application is designed for ITS employees
						to help them to assign tasks to each others,control their tasks
						and view their sent and received tasks. </font></strong></td>
		</tr>

	</table>
	<jsp:include page="Footer.jsp" />
</body>
</html>
