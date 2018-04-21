package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
//import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import model.UserDAO;
import dto.Task;
import dto.User;

/**
 * Servlet implementation class NewTask
 * 
 * @author @abdullah
 */
@WebServlet(name = "newTask", urlPatterns = { "/newTask" })
public class NewTask extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NewTask() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.getAttribute("user");
		if (session.getAttribute("user") != null) {
			RequestDispatcher rr = request.getRequestDispatcher("NewTask.jsp");
			rr.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		Task newTask = new Task();
		// User user = new User ();
		UserDAO userDAO = new UserDAO();

		String title = request.getParameter("title");
		if(title==null){
			
		}
		String description = request.getParameter("description");
		String deadlineDate = request.getParameter("deadline");
		System.out.println(deadlineDate);
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = dateFormat.parse(deadlineDate);
			long deadline_date = date.getTime();
			System.out.println("long " + deadline_date);

			// String assignDate = request.getParameter("assignDate");
			String username = request.getParameter("reciever");
			User receiver = new User();
			try {
				receiver = userDAO.getUSerbyUsername(username);
				System.out.println(username);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println(deadlineDate);

			Date assignUtilDate = new Date(); // date for nom
			Date deadLineUtilDate = null;
			try {
				deadLineUtilDate = new SimpleDateFormat("dd-MM-yyyy")
						.parse(deadlineDate);
				System.out.println(deadLineUtilDate.toString());

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			newTask.setTitle(title);
			newTask.setReceiver(receiver);
			newTask.setDescription(description);
			newTask.setDeadline_date(deadline_date);
			newTask.setAssign_date(assignUtilDate.getTime());
			newTask.setCreator((User) session.getAttribute("user"));

			model.NewTask newTask2 = new model.NewTask();

			int found = newTask2.addTask(newTask);
			if (found == 1) {
				RequestDispatcher rd = request
						.getRequestDispatcher("senttasks");
				request.setAttribute("message","Done");

				rd.forward(request, response);
//			} else {
//				RequestDispatcher rd = request
//						.getRequestDispatcher("Profile.jsp");
////				JOptionPane.showMessageDialog(null,
////						"Create your task again please");
//				request.setAttribute("message", "create your task agin ");
//				rd.forward(request, response);
//
		}

		} catch (ParseException e2) {
			e2.printStackTrace();
		}

	}
}
// System.out.println(datee );
// DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
// Date deadLine;

// deadLine = new Date(df.parse(deadlineDate).getTime()) ;
// DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
// String datee = dateFormat.format(deadlineDate);
// get current date time with Date()
