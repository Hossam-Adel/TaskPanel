<%@page import="model.AllUsers"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dto.User"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	if(session.getAttribute("user")==null){
		RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
	   rd.forward(request,response);
	  
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Task</title>
</head>
<body>
	<jsp:include page="Header.jsp" />
	<jsp:include page="Bar.jsp" />
	<%
		ArrayList<User> users = AllUsers.getAllUser();
	%>

	<h1 align="center" style="color: rgb(255, 93, 23);">New Task</h1>

	<form action="newTask" method="POST" style="margin-left: 100px;">

		<strong>Title</strong> <input type="text" name="title"
			style="width: 300px; height: 25px; font-size: large;"> <br>
		<br> <strong>Deadline Date</strong><input type="date"
			name="deadline" style="margin-left: 40px;"> <br> <br>
		<strong> To Whom </strong><select name="reciever">
			<%
				//String[] username = new String[2];
						
						for(int i=0;users.size()>i;i++){
			%>
			<option value="<%=users.get(i).getUsername()%>">
				<%=users.get(i).getName()%>
			</option>
			<%
				}
			%>
		</select> <br> <br>
		<p>
			<strong> Description</strong>
		</p>
		<textarea style="overflow: scroll; height: 130px; width: 400px;"
			name="description"></textarea>

		<br> <input type="submit" value="Create">

	</form>
	<jsp:include page="Footer.jsp" />
</body>
</html>


