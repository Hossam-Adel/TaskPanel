package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
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
 * Servlet implementation class Login
 */
/*
 * @author Eman
 */

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Login() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User found = new User();
		//String Name=null,Email=null;
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		model.Logincheck user = new model.Logincheck();
		found = user.login(name,password);
		if (found==null)
		{
			out.println("Incorrect Username or Password");
			
		}
		else
		{
			 HttpSession session=request.getSession(); 
			 session.setAttribute("user", found);
			// out.println("Logged in successfully");
			 RequestDispatcher rd = request.getRequestDispatcher("Profile.jsp");
			 rd.forward(request, response);
		
	}

	}
	}
