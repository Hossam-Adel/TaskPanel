package model;
import java.sql.Connection;
import java.sql.PreparedStatement;

//import javax.servlet.RequestDispatcher;


import dto.User;

public class Register {
	

	public int register (User user) {
		Connection con = Connector.connect();
		int found = 0;
		  String query = ("insert into user(Name,Username,Password,Email) values(?,?,?,?)");
		try {

			PreparedStatement ps = con.prepareStatement(query);
					
			ps.setString(1, user.getName());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getEmail());
			found= ps.executeUpdate();
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return found;
	}
}
