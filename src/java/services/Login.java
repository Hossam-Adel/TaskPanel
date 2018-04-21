package services;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import javax.ws.rs.FormParam;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import dto.User;

@Path("/login")
public class Login {
@POST
@Path("/logincheck")
@Produces("text/html")
public String login (@FormParam("username") String username,@FormParam("password") String password)
{
	//System.out.println(username +","+ password);
	String ID=null;
	User found = new User();
	
	model.Logincheck user = new model.Logincheck();
	found = user.login(username,password);
	System.out.println(username+password);
	if (found==null)
	{
		System.out.println("Incorrect Username or Password");
		
	}
	else
	{
		ID=Integer.toString(found.getID());
		// RequestDispatcher rd = request.getRequestDispatcher("Profile.jsp");
		// rd.forward(request, response);
	
   }
	return ID;
	
}
}
