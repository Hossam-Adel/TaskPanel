package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import dto.User;

/*
 * @author Eman
 */

public class Logincheck {
	Connection conn = Connector.connect();

	/**
	 * this method used to login.
	 * @author Eman
	 * @param username
	 * @param password
	 * @return User
	 */
	public User login(String username, String password) {
		Connection conn = Connector.connect();
		String dbpass, dbusername;
		User user = new User();
		String query = "SELECT ID,Name,Username,Password,Email FROM `taskpanel`.`user` WHERE Username =? and Password=?";
		try {
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1, username);
			pst.setString(2, password);
			boolean check=false;
		//	System.out.println(pst);
			ResultSet result = pst.executeQuery();
			
			while (result.next()) {
				check = true;
				
			//	System.out.println(result + "while");
				dbpass = result.getString("Password");
				dbusername = result.getString("Username");
			/*	System.out.println(dbusername);
				System.out.println(dbpass);
				System.out.println(password);
				System.out.println(username);*/
					if (dbpass.equals(password) && dbusername.equals(username)) {
						//System.out.println(result + "pass");
						user.setID(result.getInt("ID"));
						user.setName(result.getString("Name"));
						user.setUsername(username);
						user.setPassword(dbpass);
						user.setEmail(result.getString("Email"));
	
					}
	
					else {
						user = null;
	
					}
				
			}

			if(!check)
			{
				
				//	System.out.println(result+"else");
					user = null;
				
			}
			
			
		

			result.close();
			pst.close();
			conn.close();

			return user;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("error");
	
			return null;
		}

	}
	
	
	
}
