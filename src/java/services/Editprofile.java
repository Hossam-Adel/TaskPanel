package services;

import java.sql.SQLException;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import model.Editprofilesql;

import com.google.gson.Gson;

@Path("/editprofile")
public class Editprofile {
	
	@POST
	@Path("/edit")
	@Produces("text/html")
	
	public String edit(@FormParam("id") int id, @FormParam("name") String name,
			@FormParam("password") String password) throws SQLException {
		Editprofilesql edit = new Editprofilesql();
		return String.valueOf(edit.updatebyID(id, name, password));

	}

}
