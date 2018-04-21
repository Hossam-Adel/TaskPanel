package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import constants.Constants;
import dto.Task;
import dto.User;

public class NewTask {
	
	public int addTask(Task newTask)  {
		Connection con = Connector.connect();
		User user = new User();
		User ruser = new User();
		int found = 0;
		String query = ("insert into task(Title,Description,Assign_Date,Deadline_Date,Creator,Receiver,Status)"
				+ " values(?,?,?,?,?,?,?)");
		try {
			user = newTask.getCreator();
			System.out.println(user.getID());
			ruser = newTask.getReceiver();
			System.out.println(ruser.getID());
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			// get current date time with Date()
			Date date = new Date();
			String datee = dateFormat.format(date);
			System.out.println(datee);
			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, newTask.getTitle());
			ps.setString(2, newTask.getDescription());
			ps.setLong (3, newTask.getAssign_date()); 
			ps.setLong	(4, newTask.getDeadline_date());
			ps.setInt	(5, newTask.getCreator().getID());
			ps.setInt	(6, newTask.getReceiver().getID());
			ps.setInt	(7, Constants.WAITING_STATUS);
			found = ps.executeUpdate();
			ps.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			try {
				con.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return found;
	}
}
