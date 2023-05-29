

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DTO.SgsDTO;
import DAO.SgsStudentDAO;
import DAO.SgsStaffDAO;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
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
		
		String student=request.getParameter("student");
		String staff=request.getParameter("staff");
		
		System.out.println("student="+student);
		System.out.println("staff="+staff);

		
		
		  SgsDTO dto=new SgsDTO();
		  
		  if(student!=null) {
		  
		  SgsStudentDAO studentdao=new SgsStudentDAO();
		  
		  ArrayList<SgsDTO> list=studentdao.studentinfo();
		  if(list!=null)System.out.println("list size---"+list.size());
		  
		  HttpSession session=request.getSession();
		  
		  session.setAttribute("studentinfo", list);
		  
		  response.sendRedirect("StudentTable.jsp");
		  }
		  
		  if(staff!=null) {
			  
			  SgsStaffDAO staffdao=new SgsStaffDAO();
			  
			  ArrayList<SgsDTO> list=staffdao.staffinfo();
			  if(list!=null)System.out.println("list size---"+list.size());
			  
			  HttpSession session=request.getSession();
			  
			  session.setAttribute("staffinfo", list);
			  
			  
			  response.sendRedirect("StaffTable.jsp");
		  }
		 
		
	}

}
