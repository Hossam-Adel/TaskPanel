<%@page import="dto.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%if(session.getAttribute("user")==null){
		RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
	   rd.forward(request,response);
	  
} %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My profile</title>

</head>
<body>
<form action=Editprofile.jsp>
<jsp:include page="Header.jsp" />
<jsp:include page="Bar.jsp" />
<p><img width="150px" src="555.JPG" > Welcome <% 
User userdata =(User) session.getAttribute( "user" );
%>
<%= userdata.getName() %> </p>
<input type="submit" value="edit"  />

<jsp:include page="Footer.jsp" />
</form>
</body>
</html>