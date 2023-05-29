

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

/**
 * Servlet implementation class StudentFeesServlet
 */
@WebServlet("/StudentFeesServlet")
public class StudentFeesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentFeesServlet() {
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
		
		SgsDTO dto=new SgsDTO();
		
		int standard=Integer.parseInt(request.getParameter("standard"));
		int fees=Integer.parseInt(request.getParameter("fees"));
		
		dto.setStandard(standard);
		dto.setFees(fees);
		
		System.out.println("standard="+standard);
		System.out.println("fees="+fees);
		
		SgsStudentDAO studentdao=new SgsStudentDAO();
		
		 studentdao.feeupdate(standard,fees); 
		
		
		
		/*
		 * ArrayList<SgsDTO> feeslist=studentdao.studentfees();
		 * if(feeslist!=null)System.out.println("feeslist size---"+feeslist.size());
		 * 
		 * HttpSession session=request.getSession();
		 * 
		 * session.setAttribute("studentfees", feeslist);
		 */
		
		
		response.sendRedirect("SgsHome.jsp");
	}

}
