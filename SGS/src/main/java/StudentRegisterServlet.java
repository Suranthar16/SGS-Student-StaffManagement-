

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.SgsStudentDAO;
import DTO.SgsDTO;
/**
 * Servlet implementation class StudentRegisterServlet
 */
@WebServlet("/StudentRegisterServlet")
public class StudentRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentRegisterServlet() {
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
		
		String studentname=request.getParameter("studentname");
		int standard=Integer.parseInt(request.getParameter("standard"));
		String studentid=request.getParameter("studentid");
		String studentaddress=request.getParameter("studentaddress");
		String phone=request.getParameter("phone");
		String fathername=request.getParameter("fathername");
		String mothername=request.getParameter("mothername");
		String bloodgroup=request.getParameter("bloodgroup");
		String annualfees=request.getParameter("annualfees");
		
		dto.setStudentname(studentname);
		dto.setStandard(standard);
		dto.setStudentid(studentid);
		dto.setStudentaddress(studentaddress);
		dto.setPhone(phone);
		dto.setFathername(fathername);
		dto.setMothername(mothername);
		dto.setBloodgroup(bloodgroup);
		dto.setAnnualfees(annualfees);
	
		System.out.println("studentname="+studentname);
		System.out.println("standard="+standard);
		System.out.println("studentid="+studentid);
		System.out.println("studentaddress="+studentaddress);
		System.out.println("phone="+phone);
		System.out.println("fathername="+fathername);
		System.out.println("mothername="+mothername);
		System.out.println("bloodgroup="+bloodgroup);
		System.out.println("annualfees="+annualfees);

		SgsStudentDAO studentdao=new SgsStudentDAO();
		
		studentdao.Sgs(dto);
		
		  ArrayList<SgsDTO> list=studentdao.studentinfo();
		  if(list!=null)System.out.println("list size---"+list.size());
		  
		  HttpSession session=request.getSession();
		  
		  session.setAttribute("studentinfo", list);
		
		response.sendRedirect("SgsHome.jsp");
	}

}
