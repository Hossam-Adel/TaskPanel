package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import java.sql.Statement;

import dto.Status;
import dto.Task;
import dto.User;

public class TaskDAO {
	
	
	/**
	 * This Method is used to get Task Details by ID
	 * @author Eman
	 * @param ID
	 * @return Task
	 *
	 */
	
	
 public Task TaskDetails(int ID) throws SQLException
 {
		Connection conn = Connector.connect();
	    Task wantedtask = new Task();
	    User reciever = new User();
	    User creator = new User();
		UserDAO userdata = new UserDAO();
		Status status = new Status();
		StatusDAO statusdata = new StatusDAO();
		
		boolean check=false;
		String query="SELECT * FROM task WHERE ID=?";
		PreparedStatement pst = conn.prepareStatement(query);
		pst.setInt(1, ID);
		ResultSet details=pst.executeQuery();;
		while(details.next())
		{
			check=true;
			wantedtask.setTitle(details.getString("Title"));
			wantedtask.setDescription(details.getString("Description"));
			wantedtask.setAssign_date(details.getLong("Assign_Date"));
			wantedtask.setDeadline_date(details.getLong("Deadline_Date"));
			wantedtask.setStart_date(details.getLong("Start_Date"));
			creator=userdata.getUSerbyID(details.getInt("Creator"));
			wantedtask.setCreator(creator);
			reciever = userdata.getUSerbyID(details.getInt("Receiver"));
			wantedtask.setReceiver(reciever);
			status = statusdata.getStatusbyID(details.getInt("status"));
			wantedtask.setStatus(status);
		}
		if(!check)
		{
			//System.out.println("NOT Found");
			wantedtask = null;
		}
		details.close();
		pst.close();
		conn.close();
	 return wantedtask;
 }
 
 
 /**
	 * This Method is used to get the number of Tasks related to user
	 * @author Eman
	 * @param ID
	 * @return count of tasks
	 *
	 */
 
 
 
 public int gettaskscount (int ID)
 {
	 int count=0;
	 Connection conn = Connector.connect();
	
	 try {
		 String query = "SELECT COUNT(*) FROM task WHERE Receiver=?";
		 PreparedStatement pst = conn.prepareStatement(query);
		 pst.setInt(1, ID);
		 //System.out.println(ID);
		 ResultSet rs =pst.executeQuery();
		 while(rs.next())
		 {
			 count = rs.getInt(1);
		 }
		 rs.close();
		 pst.close();
		conn.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 return count;
 }
 
 
 
 
}
