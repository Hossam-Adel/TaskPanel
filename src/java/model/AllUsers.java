package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;

import dto.User;

public class AllUsers {

	public static ArrayList<User> getAllUser() throws SQLException {
		Connection con = Connector.connect();

		Statement stmt = con.createStatement();
		
		ArrayList<User> users = new ArrayList<User>(); // creating arraylist
		String query = "select ID,Name,Username,Email from user";
		ResultSet allUserNamesResultSet = stmt.executeQuery(query);
		while (allUserNamesResultSet.next()) {
			User user = new User();
			user.setUsername(allUserNamesResultSet.getString("Username"));
			user.setName(allUserNamesResultSet.getString("Name"));
			user.setEmail(allUserNamesResultSet.getString("Email"));
			users.add(user);

		}
		
		allUserNamesResultSet.close();
		stmt.close();
		con.close();
		
		return users;
	}
}
