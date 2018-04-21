package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Task;
import dto.Status;
import dto.User;
import model.StatusDAO;




/**
 * Servlet implementation class ReceivedTasks
 */
@WebServlet(name = "receivedtasks", urlPatterns = { "/receivedtasks" })
public class ReceivedTasks extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReceivedTasks() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session= request.getSession(); 
			User receiver =(User) session.getAttribute("user");
			if(receiver !=null)
			{
				ArrayList<Task> al = model.ReceivedTasks.importReceivedTasks(receiver.getID());
				request.setAttribute("tasks", al);
				
				StatusDAO statusdao = new StatusDAO();
				ArrayList<Status> sl = statusdao.getStatusbyCheck(2);
				request.setAttribute("status", sl);
				RequestDispatcher rd = request.getRequestDispatcher("ReceivedTasks.jsp");
				rd.forward(request,response);
			}
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
				rd.forward(request,response);
			}
		
			
		}
		  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
            
	}

	

}
