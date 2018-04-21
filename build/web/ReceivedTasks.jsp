<%@page import="dto.Task"%>

<%@page import="dto.Status"%>
<%@page import="model.StatusDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.DateConvertor"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<title>Received Tasks</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <link rel="stylesheet" href="WebContent/css/style.css"> 
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
  <script>
  $( function() {
    $( document ).tooltip();
  } );
  
  </script>
  <script>
  

 
$(document).ready(function(){
	 window.setInterval(function(){
    	var oldcount = $('#refresh').attr('value');
    	
        $.post("taskcount",
        {
          Oldcount: oldcount,
        },
        function(diff){
        	if(diff > 0){
        		$('#refresh').fadeIn(3000);
        		document.getElementById("refresh").innerHTML = "You have "+diff+" new Tasks";
                
        	}
        });
    
	 }, 5000);
});

$(document).ready(function(){
	$("#refresh").click(function(){
		location.reload();
	});
});
  
</script>
  
<style>
td {
	text-align: center;
	color: rgb(1, 18, 150);
	font-size: large
}
#refresh{
top : 25px;
Right: 20px;
position:absolute;
   display :none;
   z-index:9;
   font-weight:bold;
   text-align : center;
   color:rgb(255,255,255);
   font-size:x-large; 
    border-bottom: 1px dotted black;
    width: 180px;
    height :50px;
    background-color: red;
    
    padding: 5px 0;
    border-radius: 6px;
}
.scroller {
  
  scroll-snap-type: mandatory;

  /* older spec implementation */
  scroll-snap-destination: 0% 100%;
  scroll-snap-points-x: repeat(100%);
}
</style>
</head>

<body style="overflow-y:hidden; ">
	<jsp:include page="Header.jsp"></jsp:include>
	<jsp:include page="Bar.jsp"></jsp:include>
		
	
		<%ArrayList<Task> al = (ArrayList<Task>)request.getAttribute("tasks");
	int current_count= al.size(); %>
	<h1 align="center" style="color: rgb(255, 93, 23);">Received Tasks</h1>
	<label id="refresh"  value="<%=current_count %>" ></label>
   
    <label id = "notify"></label>
    <div style="width: 100%; z-index: -1;">
        <table align="center" style="width: 100%;">
    
		<tr style="font-size: x-large; color: black;">

			<th>Creator</th>
			<th>Title</th>
			<th>AssignDate</th>
			<th>Status</th>
			<th>change status</th>
		</tr>
		</table>
	</div>	
    <div id="table" style="overflow-y:scroll ;width: 100%;position:absolute; z-index: -1;height:60%;">
	<table style="width: 100%;">
    
		

		<% 
			
			
				 StatusDAO statusdao = new StatusDAO();    
				     for(int i = 0 ; i < al.size() ; i++){
				    	
				    	Task task = al.get(i);
				        long assign_date = task.getAssign_date();
		%>
		
		<tr>
			<td>
				<%
					out.print(task.getCreator().getName());
				%>
			</td>
			<td><a style="color: rgb(1, 18, 150)"
				href="receivedtaskdetails?id=<%=task.getID()%>" title= "<%=task.getDescription()%>" > <%
 	out.print(task.getTitle());
 %></a></td>
			<td>
				<%
					DateConvertor dc = new DateConvertor();
						out.print(dc.convertunix(assign_date));
				%>
			</td>
			<td id="currentstatus<%= task.getID()%>">
				<%
					out.print(task.getStatus().getName());
				%>
			</td>
			<td>
				<div id="status" >
					<select onchange="changeStatus(this.value,<%=task.getID()%>)">
						<option>choose</option>
						<%
							ArrayList<Status> receiver_statusNames = (ArrayList<Status>) request.getAttribute("status");
										for(int u=0;u<receiver_statusNames.size();u++){
						%>
						<option value="<%=receiver_statusNames.get(u).getID()%>">
							<%
								out.print(receiver_statusNames.get(u).getName());
							%>
						</option>

						<%
							}
						%>
					</select>
				</div>
			</td>

		</tr>

		<%
			}
		%>





		<tr></tr>

	</table>
	

	
	</div>
	
		<jsp:include page="Footer.jsp"></jsp:include>
	
</body>

<script>


window.onload= function(){
	statusDisplay =document.getElementById('status');
};

    function changeStatus(status_id,task_id){
        if (status_id.length == 0) {
		document.getElementById("status").innerHTML = "";
        }else{
        	var xmlhttp;
			if (window.XMLHttpRequest)
			{
				xmlhttp = new XMLHttpRequest();
		    }
			xmlhttp.onreadystatechange = function() {
				if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
					document.getElementById('currentstatus'+task_id).innerHTML = xmlhttp.responseText;
				}
			}
			xmlhttp.open('GET', 'changestatus?Sid='+status_id+'&Tid='+task_id, true);
			xmlhttp.send();
        }
    
  }
       
     
   
</script>

</html>





