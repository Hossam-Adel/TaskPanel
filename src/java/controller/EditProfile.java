package controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.User;

/**
 * @a
 * 
 * Servlet implementation class EditProfile
 */
@WebServlet(name = "editprofile", urlPatterns = { "/editprofile" })
public class EditProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public EditProfile() {
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session=request.getSession();
		if(session.getAttribute("user")!= null)
		{
			RequestDispatcher rr = request.getRequestDispatcher("Editprofile.jsp");
			rr.forward(request, response);
		}
		else
		{
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.forward(request,response);
		}
	    
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		User userdata = (User) session.getAttribute("user");
		String name, password;
		name = request.getParameter("namefield");
		password = request.getParameter("passwordfield");
		

		User user = new User();
		user.setName(name);
		user.setPassword(password);
		String oldusername = userdata.getUsername();
		model.Editprofilesql updateinfo = new model.Editprofilesql();
		
		try {
			user=updateinfo.update(user,oldusername);
			
			if(user == null)
			{
				System.out.println("something wrong in query");
			}
			else
			{
				//session.invalidate();
				//session = request.getSession(false);
				 session.setAttribute("user", user);
				 RequestDispatcher dd= request.getRequestDispatcher("Profile.jsp");
				 dd.forward(request,response);		 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
