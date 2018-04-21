<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="dto.Task" %>
    <%@ page import="dto.Status" %>
    <%@ page import="dto.User" %>
    <%@ page import="model.DateConvertor" %>
    <%if(session.getAttribute("user")==null){
		RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
	   rd.forward(request,response);
	  
} %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Task Details</title>
<style>

.tb td{padding-top: 10px;padding-bottom:10px ;font-size: large }
</style>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<jsp:include page="Bar.jsp"></jsp:include>
<div>
<table class="tb" style="width: 90%;top: 30%;" align="center">
<col width="70%">
  <col width="20%">
  <%
Task wantedtask= new Task();
wantedtask = (Task) request.getAttribute("TaskDetails");
User user = new User();
String startDate,assignDate,deadlineDate;
Status currentstatus = new Status(); %>
<tr >
  <td>
  Receiver : 
  <% user = wantedtask.getReceiver();
out.print(user.getName());%>
  </td>
  <td>Assign Date : <%=assignDate=DateConvertor.convertunix(wantedtask.getAssign_date()) %></td>
</tr>
<tr>
  <td>
  Title : <%=wantedtask.getTitle() %>
  </td>
</tr>
<tr>
  <td  width="70px">
  Description
  <textarea style="overflow: scroll; height:150px;width:100%; resize: none ;border:none" name="description" readonly="readonly" >
  <%=wantedtask.getDescription() %>
  </textarea>
  </td>
</tr>
<tr>
  <td></td>
  <td >
  Start Date : 
 <%= startDate=DateConvertor.convertunix(wantedtask.getStart_date())
  %>
  </td>
</tr>
<tr>
  <td></td>
  <td>
  Deadline Date : 
 <%=deadlineDate=DateConvertor.convertunix(wantedtask.getDeadline_date()) %>
  </td>
</tr>
<tr>
  <td></td>
  <td >
  Current Status : 
  <%currentstatus = wantedtask.getStatus();%>
  <%=currentstatus.getName()%>
  </td>
</tr>

</table>
</div>
<jsp:include page="Footer.jsp"></jsp:include>

</body>
</html>