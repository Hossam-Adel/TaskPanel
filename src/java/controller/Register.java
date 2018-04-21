package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import org.apache.jasper.tagplugins.jstl.core.Out;

import com.mysql.jdbc.Connection;

import dto.User;

/**
 * Servlet implementation class Register
 */
@WebServlet(name = "register", urlPatterns = { "/register" })
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public Connection con;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Register() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher rr = request.getRequestDispatcher("Register.jsp");
		rr.forward(request, response);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		user.setName(request.getParameter("name"));
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		user.setEmail(request.getParameter("email"));

		if (!name.equals("") || !username.equals("") || !password.equals("")
				|| !email.equals(""))

		{
			model.Register newUser = new model.Register();
			int retrn;
			retrn = newUser.register(user);
			if (retrn > 0) {
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				RequestDispatcher goToProfile = request
						.getRequestDispatcher("Profile.jsp");
				goToProfile.forward(request, response);

			} else {
				RequestDispatcher goToProfile = request
						.getRequestDispatcher("error.jsp");
				goToProfile.forward(request, response);
			}
		}
	}

} // TODO Auto-generated method stub

