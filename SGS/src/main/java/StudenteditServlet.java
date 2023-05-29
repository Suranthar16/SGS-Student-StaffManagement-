

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class StudenteditServlet
 */
@WebServlet("/StudenteditServlet")
public class StudenteditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudenteditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String studentid=request.getParameter("studentid");
		String staffid=request.getParameter("staffid");
		System.out.println("studentid="+studentid);
		System.out.println("staffid="+staffid);
		
		HttpSession session =request.getSession();
		
		  if(studentid!=null) {
		  session.setAttribute("studentid",studentid);
		
		response.sendRedirect("SgsStudentinfoEdit.jsp");
		  }
		  else if(staffid!=null) {
			  session.setAttribute("staffid",staffid);
				
				response.sendRedirect("SgsStaffinfoEdit.jsp");
				  }
		  
		  
	}

}
