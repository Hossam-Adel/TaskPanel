package services;
import java.sql.SQLException;

import javax.ws.rs.FormParam;
import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.UserDAO;

import com.google.gson.Gson;

import dto.User;
@Path("/profile")
public class Profile {
	@POST
	@Path("/myprofile")
	
   public String profile (@FormParam("id") int id) throws SQLException{
		User user = new User();
		UserDAO userdao = new UserDAO();
		System.out.println(id);
		user= userdao.getUSerbyID(id);
		Gson gson = new Gson() ;
		String gsonuser= gson.toJson(user);
		return gsonuser;
	}
	
	
}
