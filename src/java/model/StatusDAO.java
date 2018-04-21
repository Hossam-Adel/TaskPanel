package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.Status;

public class StatusDAO {
	
	/**
	 * This Method is used to get Status by ID
	 * @author Eman
	 * @param ID
	 * @return Status
	 *
	 */
	
	
	public Status getStatusbyID(int ID) throws SQLException{
		Status status = new Status();
		Connection conn = Connector.connect();
		String query = "SELECT Name,status.Check FROM status WHERE ID =?";
		PreparedStatement pst = conn.prepareStatement(query);
		pst.setInt(1, ID);
		ResultSet statusdata = pst.executeQuery();
		boolean check=false;
		while(statusdata.next())
		{
			check=true;
			status.setName(statusdata.getString("Name"));
			status.setCheck(statusdata.getInt("Check"));
		}
		
		if(!check)
		{
			status = null;
		}
		statusdata.close();
		pst.close();
		conn.close();
		return status;
	}
	
	
	
	/**
	 * This Method is used to get Status by Type of user
	 * @author Eman
	 * @param check
	 * @return ArrayList of Status
	 *
	 */
	
	
	public ArrayList<Status> getStatusbyCheck(int check) throws SQLException{
		Status status = null;
		Connection conn = Connector.connect();
		ArrayList<Status> StatusNames=new ArrayList<Status>() ;
		String query = "SELECT Name,ID FROM `taskpanel`.`status` WHERE status.Check =?";
		PreparedStatement pst = conn.prepareStatement(query);
		pst.setInt(1, check);
		ResultSet statusdata = pst.executeQuery();
		boolean found=false;
		while(statusdata.next())
		{
			status = new Status();
			found=true;
			status.setName(statusdata.getString("Name"));
			status.setID(statusdata.getInt("ID"));
			StatusNames.add(status);
		}
		
		if(!found)
		{
			status = null;
		}
		
		statusdata.close();
		pst.close();
		conn.close();
		return StatusNames;
	}
	
	
	/**
	 * This Method is used to change the status 
	 * @author Eman
	 * @param statusid , taskid
	 * @return New Status object
	 *
	 */
	
	public Status ChangeStatus(int statusid,int taskid) throws SQLException
	{
		Status newstatus=null;
		Connection conn = Connector.connect();
		String query = "update task set Status = ? where ID=? ";
		PreparedStatement pst = conn.prepareStatement(query);
		pst.setInt(1, statusid);
		pst.setInt(2, taskid);
		int check = pst.executeUpdate();
		if(check == 1)
		{
			newstatus = new Status();
			newstatus = getStatusbyID(statusid);
		}
		pst.close();
		conn.close();
		return newstatus;
	}
	
	/**
	 * This Method is used to change the start date of tasks with status onprogress
	 * @author Hossam
	 * @param startdate , taskid
	 * @return bolean object
	 *
	 */
	
	public boolean changeStartDate(long startdate,int taskid) throws SQLException{
		Connection conn = Connector.connect();
		boolean done= false;
		String query = "update task set Start_Date = ? where ID=? ";
		PreparedStatement pst = conn.prepareStatement(query);
		pst.setLong(1, startdate);
		pst.setInt(2, taskid);
		int check = pst.executeUpdate();
		if(check == 1)
		{
			done= true;
		}
		pst.close();
		conn.close();
		return done;
	}
	

}
