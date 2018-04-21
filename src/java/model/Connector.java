	
package model;

import java.sql.Connection;
import java.sql.DriverManager;


public class Connector {

	/**
	 * this method opens connection with database server
	 * @author Hossam
	 *returns connection object
	 */
	public static Connection connect() {
		try {

			Class.forName("com.mysql.jdbc.Driver"); // step 1
													// com.mysql.jdbc.Driver
			final Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/taskpanel?", "root", "");
			return con;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}