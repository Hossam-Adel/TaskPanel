package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Task;
import model.TaskDAO;

/**
 * Servlet implementation class ReceivedTaskDetails
 */
@WebServlet(name = "receivedtaskdetails", urlPatterns = { "/receivedtaskdetails" })
public class ReceivedTaskDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReceivedTaskDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		if(session.getAttribute("user")!= null)
		{
			Task viewTask = new Task();
			TaskDAO taskdao = new TaskDAO();
			int task_id = Integer.parseInt(request.getParameter("id"));
			
			try {
				viewTask=taskdao.TaskDetails(task_id);
				
				System.out.println(viewTask.getTitle());
				System.out.println(viewTask.getDescription());
				System.out.println(viewTask.getID());
				System.out.println(viewTask.getCreator().getName());
				System.out.println(viewTask.getStatus().getName());
				
				request.setAttribute("task to be viewed", viewTask);
				RequestDispatcher rs= request.getRequestDispatcher("ReceivedTaskDetails.jsp");
				rs.forward(request, response);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.forward(request,response);
		}
	    
		
		
		
		
	}

}
