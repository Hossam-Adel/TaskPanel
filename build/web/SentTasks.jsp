<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="dto.Task"%>
<%@ page import="dto.Status"%>
<%@ page import="dto.User"%>
<%@ page import="model.DateConvertor" %>
<%if(session.getAttribute("user")==null){
		RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
	   rd.forward(request,response);
	  
} %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<title>Sent Tasks</title>
 <link rel="stylesheet" href="//code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
  <script>
  $( function() {
    $( document ).tooltip();
  } );
  
  </script>



<style>
tr {
	
}

td {
	text-align: center;
	color: rgb(1, 18, 150);
	font-size: large
}
</style>
</head>

<body>
	<jsp:include page="Header.jsp"></jsp:include>
	<jsp:include page="Bar.jsp"></jsp:include>
	<h1 align="center" style="color: rgb(255, 93, 23)">Sent Tasks</h1>
<%=(request.getAttribute("message")!=null?request.getAttribute("message"):"") %>	
	<table  style="width: 100%;">

		<tr style="font-size: x-large; color: black;">

			<th>Receiver</th>
			<th>Title</th>
			<th>Start Date</th>
			<th>Current Status</th>
			<th>Status</th>
		</tr>

		<%
			//  RequestDispatcher rd= request.getRequestDispatcher("senttaskdetails");
				  ArrayList<Task> tasks =(ArrayList<Task>)request.getAttribute("TaskList");
				  ArrayList<Status> status =(ArrayList<Status>)request.getAttribute("StatusList");
				  if(tasks == null)
				  {%>
					<p align="center" style="font-size: xx-large;"> <%out.print("You have no tasks yet");%> </p>
			<%	  }
				  else
				  {
				  Status currentstatus = new Status();
				  User user = new User();
				  String startDate;
				  int taskid;
		  for(Task task : tasks){
			  taskid = task.getID();
			  String desc = task.getDescription();
		%>
		<tr>
			<td>
				<%
					user = task.getReceiver();
					out.print(user.getName());
				%>
			</td>
			<td>
			
				<%
					//rd.forward(request, response);
				%> <a  style="color: rgb(1, 18, 150)"
				href="senttaskdetails?id=<%=task.getID()%>" title="<%=task.getDescription()%>"> <%out.print(task.getTitle()); %></a>
			</td>
		
			<td>
				<%
				startDate=DateConvertor.convertunix(task.getStart_date());
					out.print(startDate);
				%>
			</td>
				<td id="currentstatus<%=task.getID()%>">
				
				 <%currentstatus = task.getStatus();%>
				  <%=currentstatus.getName()%>
				
			</td>
			<td>
				<div id="status">
						
					<select onchange="change(this.value,<%=task.getID() %>)">
					<option id="" value="">Choose</option>
						<%
							for(int x=0;x<status.size();x++){
						%>
						
						<option value="<%=status.get(x).getID()%>"><%=status.get(x).getName()%></option>
						<%
							}
						%>
					</select>
				</div>
			</td>
		</tr>
		<%
			}}
		%>
		<tr></tr>

	</table>

	<jsp:include page="Footer.jsp"></jsp:include>
<script>
var statusDisplay ;
var task;



	window.onload= function(){
		statusDisplay =document.getElementById('status');
	};
	function change(statusId,taskId) {
		task=taskId;
		var newstatus;
		if (statusId.length == 0 || taskId.length == 0) {
			
			//document.getElementById("status").innerHTML = "";
		} else {
			var xmlhttp;
			if (window.XMLHttpRequest)
			{
				xmlhttp = new XMLHttpRequest();
		    }
			xmlhttp.onreadystatechange = function() {
				if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
					//statusDisplay.innerHTML = xmlhttp.responseText;
					//newstatus =  xmlhttp.responseText;
					document.getElementById('currentstatus'+taskId).innerHTML = xmlhttp.responseText;
				}
				
			}
			xmlhttp.open('GET', 'changestatus?Tid='+ taskId +'&Sid='+statusId, true);
			xmlhttp.send(null);
			
		}
	}
	
</script>



</body>

</html>