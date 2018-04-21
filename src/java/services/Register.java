package services;

import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import model.UserDAO;
import dto.User;

@Path("/register")
public class Register {
	@POST
	@Path("/registercheck")
	@Produces("text/html")
	public String register(@FormParam("name") String name,
			@FormParam("username") String username,
			@FormParam("password") String password,
			@FormParam("email") String email) {
			String ID=null;
			User user =new User();
			user.setName(name);
			user.setUsername(username);
			user.setPassword(password);
			user.setEmail(email);
			UserDAO getuser = new UserDAO();
			
		if (!name.equals("") || !username.equals("") || !password.equals("")
				|| !email.equals(""))

		{
			model.Register newUser = new model.Register();
			int retrn;
			retrn = newUser.register(user);
			if (retrn > 0) {
				try {
					user=getuser.getUSerbyUsername(username);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ID = Integer.toString(user.getID());
			} else {
			
				System.out.println("Not Rgeister");
			}
		
		}

		return ID;

	}
}
	
