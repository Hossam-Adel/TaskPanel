<%@page import="model.DateConvertor"%>
<%@page import="dto.User"%>
<%@page import="dto.Task"%>
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
<title>Insert title here</title>
<style>

.tb td{padding-top: 10px;padding-bottom:10px ;font-size: large }
</style>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<jsp:include page="Bar.jsp"></jsp:include>

<div>
<table class="tb" style="width: 90%;top: 30%;" align="center">
<%Task task =(Task)request.getAttribute("task to be viewed"); %>
<%User user =task.getCreator();%> 
<col width="70%">
  <col width="20%">
<tr >
  <td>
  creator: <%=user.getName() %> 
  </td>
  <td>assign date: <%=DateConvertor.convertunix(task.getAssign_date()) %> </td>
</tr>
<tr>
  <td>
  title: <%=task.getTitle() %>
  </td>
</tr>
<tr>
  <td  width="70px">
  Description: 
  <textarea style="overflow: scroll; height:150px;width:100%; resize: none ;border:none" name="description" readonly="readonly" >
  <%=task.getDescription() %>
  </textarea>
  </td>
</tr>
<tr>
  <td></td>
  <td >
  Start date: <%=DateConvertor.convertunix(task.getStart_date()) %>
  </td>
</tr>
<tr>
  <td></td>
  <td   >
  deadline date: <%=DateConvertor.convertunix(task.getDeadline_date()) %>
  </td>
</tr>
<tr>
  <td></td>
  <td >
  status: <%=task.getStatus().getName() %>
  </td>
</tr>

</table>
</div>
<jsp:include page="Footer.jsp"></jsp:include>

</body>
</html>