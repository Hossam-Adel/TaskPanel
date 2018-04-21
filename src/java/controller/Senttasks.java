package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.StatusDAO;
import dto.Status;
import dto.Task;
import dto.User;

/**
 * Servlet implementation class Senttasks
 * @author Eman Ahmad
 */
@WebServlet(name = "senttasks", urlPatterns = { "/senttasks" })
public class Senttasks extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Senttasks() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * @author Eman Ahmad
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		User user = new User();
		 user=(User)session.getAttribute("user");
		if(user!= null)
		{
			
			PrintWriter out = response.getWriter();
			ArrayList<Task> tasks = new ArrayList<Task>();
			ArrayList<Status> status = new ArrayList<Status>();
			
			model.Senttasks task = new model.Senttasks();
			try {
				tasks=task.taskDetails(user.getID());
				if(tasks == null)
				{
					//out.println("tasks are null");
					RequestDispatcher rd= request.getRequestDispatcher("SentTasks.jsp");
					rd.forward(request, response);
				}
				else
				{
					
					StatusDAO statusdata = new StatusDAO();
					status=statusdata.getStatusbyCheck(1);
					request.setAttribute("TaskList", tasks);
					request.setAttribute("StatusList", status);
					RequestDispatcher rd= request.getRequestDispatcher("SentTasks.jsp");
					rd.forward(request, response);
				}
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
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
