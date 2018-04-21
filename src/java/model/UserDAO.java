package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.User;

/**
 * This Method is used to get User by ID
 * @author Eman
 * @param ID
 * @return User
 *
 */

public class UserDAO {
	public User getUSerbyID(int ID) throws SQLException
	{
		User user = new User();
		Connection conn = Connector.connect();
		String query = "SELECT Name,Username,Email,Password FROM `taskpanel`.`user` WHERE ID =?";
		PreparedStatement pst = conn.prepareStatement(query);
		pst.setInt(1, ID);
		ResultSet userdata = pst.executeQuery();
		boolean check=false;
		while(userdata.next())
		{
			check=true;
			user.setName(userdata.getString("Name"));
			user.setUsername(userdata.getString("Username"));
			user.setEmail(userdata.getString("Email"));
			user.setID(ID);
			user.setPassword(userdata.getString("password"));
		}
		
		if(!check)
		{
			user = null;
		}
		userdata.close();
		pst.close();
		conn.close();
		return user;
	}
	
	
	
	
	/**
	 * This Method is used to get User by Username
	 * @author Eman
	 * @param username
	 * @return User
	 *
	 */
	
	
	public User getUSerbyUsername(String username) throws SQLException
	{
		User user = new User();
		Connection conn = Connector.connect();
		String query = "SELECT ID,Name,Email FROM `taskpanel`.`user` WHERE Username =?";
		PreparedStatement pst = conn.prepareStatement(query);
		pst.setString(1, username);
		ResultSet userdata = pst.executeQuery();
		boolean check=false;
		while(userdata.next())
		{
			check=true;
			user.setName(userdata.getString("Name"));
			user.setID(userdata.getInt("ID"));
			user.setEmail(userdata.getString("Email"));
		}
		
		if(!check)
		{
			user = null;
		}
		userdata.close();
		pst.close();
		conn.close();
		return user;
	}
	
	/**
	 * This Method is used to get Id of user by ieme number
	 * @author Eman
	 * @param ieme number
	 * @return ID of user
	 *
	 */
	
	
	public int getuserid(String ieme) throws SQLException
	{
		int id = 0;
		Connection conn = Connector.connect();
		String query = "SELECT ID FROM `taskpanel`.`user` WHERE Ieme =?";
		PreparedStatement pst = conn.prepareStatement(query);
		pst.setString(1, ieme);
		ResultSet userdata = pst.executeQuery();
		while(userdata.next())
		{
			id = userdata.getInt("ID");
		}
		
		userdata.close();
		pst.close();
		conn.close();
		
		return id;
	}
	
}
