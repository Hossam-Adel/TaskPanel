package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dto.Status;
import dto.Task;
import dto.User;

public class Senttasks {
	
	/**
	 * This Method is used to get All Created Tasks 
	 * @author Eman
	 * @param User ID
	 * @return Arraylist of all tasks
	 *
	 */
	
	
	public ArrayList<Task> taskDetails(int id) throws SQLException
	{
		Task task =null;
		Connection conn = Connector.connect();
		ArrayList<Task> tasks = new ArrayList<Task>();
		User reciever = new User();
		UserDAO userdata = new UserDAO();
		Status status = new Status();
		StatusDAO statusdata = new StatusDAO();
		//Statement stmt = conn.createStatement();
		
		boolean check=false,append;
		String mainquery="SELECT * FROM task WHERE Creator=?";
		PreparedStatement pst = conn.prepareStatement(mainquery);
		pst.setInt(1, id);
		ResultSet details=pst.executeQuery();
		while(details.next())
		{
			check=true;
			task = new Task();
			task.setID(details.getInt("ID"));
			task.setTitle(details.getString("Title"));
			task.setDescription(details.getString("Description"));
			
			task.setAssign_date(details.getLong("Assign_Date"));
			task.setDeadline_date(details.getLong("Deadline_Date"));
			task.setStart_date(details.getLong("Start_Date"));
			reciever = userdata.getUSerbyID(details.getInt("Receiver"));
			task.setReceiver(reciever);
			status = statusdata.getStatusbyID(details.getInt("status"));
			task.setStatus(status);
			append=tasks.add(task);
		/*	if(append == true)
			{
				System.out.println("appending...");
			}
			else
			{
				System.out.println("NOT appending...");
			}*/
		}
		
		
		
		
		
		if(!check)
		{
			tasks = null;
		}
		details.close();
		pst.close();
		conn.close();
		return tasks;
	}
}
