package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.User;
import model.TaskDAO;

/**
 * Servlet implementation class TaskCount
 */
@WebServlet(name = "taskcount", urlPatterns = { "/taskcount" })
public class TaskCount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TaskCount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		TaskDAO c = new TaskDAO();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		int count = c.gettaskscount(user.getID());
		out.print(count);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		TaskDAO c = new TaskDAO();
		System.out.println("before");
		int oldcount = Integer.parseInt(request.getParameter("Oldcount"));
		System.out.println("after");
		System.out.println(oldcount);
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		int newcount = c.gettaskscount(user.getID());
		System.out.println(newcount);
		int diff = newcount-oldcount;
		System.out.println(diff);
		out.print(diff);
	}

}
