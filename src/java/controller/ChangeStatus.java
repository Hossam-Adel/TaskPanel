package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Status;
import model.StatusDAO;

/**
 * Servlet implementation class ChangeStatus
 */
@WebServlet(name = "changestatus", urlPatterns = { "/changestatus" })
public class ChangeStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeStatus() {
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
			StatusDAO changestatus = new StatusDAO();
			Status newstatus = new Status();
			boolean done=false;
			PrintWriter out = response.getWriter();
			int taskid= Integer.parseInt(request.getParameter("Tid"));
			int statusid= Integer.parseInt(request.getParameter("Sid"));
			if(statusid == 4)
			{
				Date startdate = new Date();
				long lstartdate;
				lstartdate = startdate.getTime();
				try {
					done=changestatus.changeStartDate(lstartdate, taskid);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			try {
				newstatus = changestatus.ChangeStatus(statusid, taskid);
				out.print(newstatus.getName());
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
