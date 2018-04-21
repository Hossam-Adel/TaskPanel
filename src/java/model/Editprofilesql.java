/**
 * 
 */
/**
 * @author admin
 *
 */
package model;

//import Connector;


import java.sql.SQLException;
import java.sql.Statement;

import java.sql.Connection;

import dto.User;

public class Editprofilesql {
	
	
	public User update(User user,String oldusername) throws SQLException {
		Connector f = new Connector();
		User updateduser = new User();
		Connection conn = f.connect();
		Statement stmt = conn.createStatement();
        
		
		
		String name_sql = "update user set Name='" + user.getName()
				+ "' where Username='"+oldusername+"' ";
		String password_sql = "update user set Password='" + user.getPassword()
				+ "' where Username='"+oldusername+"'";

		
		int rowsAffected1=stmt.executeUpdate(name_sql);
		
		int rowsAffected3=stmt.executeUpdate(password_sql);
		if(rowsAffected1 <0 && rowsAffected3 <0)
		{
			return updateduser;
		}
		else{
			updateduser=user;
		}
		conn.close();
		return updateduser;
		
	}
	public int updatebyID(int id,String name,String password) throws SQLException {
		Connector f = new Connector();
		User updateduser = new User();
		Connection conn = f.connect();
		Statement stmt = conn.createStatement();
        
		
		
		String name_sql = "update user set Name='" + name
				+ "' where ID='"+id+"' ";
		String password_sql = "update user set Password='" + password
				+ "' where ID='"+id+"'";

		
		int rowsAffected1=stmt.executeUpdate(name_sql);
		
		int rowsAffected3=stmt.executeUpdate(password_sql);
		if(rowsAffected1 <0 && rowsAffected3 <0)
		{
			return 0;
		}
		else{
			conn.close();
			return 1;
			
		}
		
		
		
	}
}