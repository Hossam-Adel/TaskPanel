package services;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;


import javax.ws.rs.Produces;

import model.UserDAO;

import com.google.gson.Gson;

import dto.Task;

@Path("/tasks")
public class ReceivedTasks {
@POST
@Path("/received")
@Produces("text/html")
public String tasks(@FormParam("id") int id) throws SQLException{
	ArrayList<Task> al = model.ReceivedTasks.importReceivedTasks(id);
	Gson json = new Gson();
	String tasks = json.toJson(al);
	return tasks;
}





@POST
@Path("/mobilereceived")
@Produces("application/json")
public String tasks(@FormParam("ieme") String iemeNo) throws SQLException{
	UserDAO user = new UserDAO();
	int id=user.getuserid(iemeNo); 
	ArrayList<Task> al = model.ReceivedTasks.importReceivedTasks(id);
	Gson json = new Gson();
	String tasks = json.toJson(al);
	return tasks;
}
}
