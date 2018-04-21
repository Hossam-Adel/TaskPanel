<%@page import="dto.User"%>
<%@page import="model.Editprofilesql"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	if (session.getAttribute("user") == null) {
		RequestDispatcher rd = request
				.getRequestDispatcher("Login.jsp");
		rd.forward(request, response);

	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit profile</title>
</head>
<body  >

	<jsp:include page="Header.jsp" />
	<jsp:include page="Bar.jsp" />
	<form action="editprofile" method="POST">
		<p style="font-size: large;
		
		
		
		.
		">
			<img width="150px" src="555.JPG"> <strong> Welcome</strong>
			<%
				User userdata = (User) session.getAttribute("user");
			%><%=userdata.getName()%>
		</p>
		<br>
		<p style="margin-left:12%;font-size: X-large;  ">
			<strong> Name</strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
				type="text" name="namefield"
				style="width: 250px; height: 22px; font-size: medium;"
				value=<%=userdata.getName()%>>
		</p>

		<p style="margin-left:12%;font-size: X-large; ">
			<strong> password</strong> &nbsp;<input type="password"
				name="passwordfield"
				style="width: 250px; height: 22px; font-size: large;value=<%=userdata.getPassword()%>">
		</p>
		<p>
			<input type="submit" value="submit"
				style="width: 80px; height: 45px; margin-left: 25%; font-size: large;">
		</p>
	</form>
	<jsp:include page="Footer.jsp" />
</body>
</html>




