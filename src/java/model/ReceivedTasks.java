package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.sql.PreparedStatement;

import dto.Status;
import dto.Task;
import dto.User;

public class ReceivedTasks {
	/**
	 * this method returns ArrayList of Received tasks
	 * @author Hossam
	 *returns connection object
	 */
	public static ArrayList<Task> importReceivedTasks(int id) throws SQLException {
		ArrayList<Task> al = new ArrayList<Task>();
		try {
			
			
			
			
			Connector f = new Connector();
			
			Connection conn = f.connect();
			String retrieve_task = "SELECT * FROM task where Receiver=?";
			PreparedStatement st = conn.prepareStatement(retrieve_task);
			st.setInt(1, id );
			
			ResultSet rs = st.executeQuery();
					
			while( rs.next()) {
				Task task = new Task();		
				task.setID(rs.getInt("ID"));
				task.setTitle(rs.getString("Title"));
				task.setDescription(rs.getString("Description"));
				task.setAssign_date(rs.getLong("Assign_Date"));
				task.setDeadline_date(rs.getLong("Deadline_Date"));
				task.setStart_date(rs.getLong("Start_Date"));
				
				
				UserDAO userdao = new UserDAO();
				User creator= userdao.getUSerbyID(rs.getInt("Creator"));
				
				StatusDAO statusdao = new StatusDAO();
				Status status = statusdao.getStatusbyID(rs.getInt("Status"));
				
				task.setCreator(creator);
				task.setStatus(status);
				
				al.add(task);
              
			}
			rs.close();
			st.close();
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return al;
	}
}
