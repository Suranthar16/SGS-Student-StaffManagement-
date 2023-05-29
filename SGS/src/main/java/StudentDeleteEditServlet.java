

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.SgsDTO;
import DAO.SgsStaffDAO;
import DAO.SgsStudentDAO;

/**
 * Servlet implementation class StudentDeleteEditServlet
 */
@WebServlet("/StudentDeleteEditServlet")
public class StudentDeleteEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentDeleteEditServlet() {
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
		
		
		
		String editstudentid=request.getParameter("editstudentid");
		String deletestudentid=request.getParameter("deletestudentid");
		String editstaffid=request.getParameter("editstaffid");
		String deletestaffid=request.getParameter("deletestaffid");
		
		System.out.println("editstudentid="+editstudentid);
		System.out.println("deletestudentid="+deletestudentid);
		System.out.println("editstaffid="+editstaffid);
		System.out.println("deletestaffid="+deletestaffid);
		
		
		
		SgsStudentDAO studentdao=new SgsStudentDAO();
		
		
		String stdid=null;
		
		if(editstudentid!=null) {
			
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
			
			boolean Deleted=false;
			stdid=editstudentid;
				SgsStudentDAO dao1=new SgsStudentDAO();
				
				 Deleted=dao1.StudentDelete(stdid);
				 System.out.println("studentid email"+stdid);
				 System.out.println("deleted the oldinfo");
			
				 boolean Insert=false;
				 SgsStudentDAO dao=new SgsStudentDAO(); 
				if(Deleted) {
				
				 Insert=studentdao.Sgs(dto);
				}
			
		}
		
		
		
		
		if(deletestudentid!=null) {
			
			boolean Deleted=false;
			stdid=deletestudentid;
			 SgsStudentDAO dao1=new SgsStudentDAO(); 
				
				 Deleted=dao1.StudentDelete(stdid);
				 System.out.println("deletestudentid ="+stdid);
				 System.out.println("deleted the info");
		}
		
		
		
		
		if(editstaffid!=null) {
			
			String staffname=request.getParameter("staffname");
			String staffid= request.getParameter("staffid");
			String staffaddress=request.getParameter("staffaddress");
			String mobile=request.getParameter("mobile");
			String status=request.getParameter("status");
			String month=request.getParameter("month");
			String monthsalary=request.getParameter("monthsalary");
			
			
			
			dto.setStaffname(staffname);
			dto.setStaffid(staffid);
			dto.setStaffaddress(staffaddress);
			dto.setMobile(mobile);
			dto.setStatus(status);
			dto.setMonth(month);
			dto.setMonthsalary(monthsalary);
		
			System.out.println("staffname="+staffname); 
			System.out.println("staffid="+staffid);
			System.out.println("staffaddress="+staffaddress);
			System.out.println("mobile="+mobile);
			System.out.println("status="+status);
			System.out.println("month="+month);
			System.out.println("monthsalary="+monthsalary);
			
			boolean Deleted=false;
			stdid=editstaffid;
				SgsStaffDAO staffdao1=new SgsStaffDAO();
				
				 Deleted=staffdao1.StaffDelete(stdid);
				 System.out.println("studentid email"+stdid);
				 System.out.println("deleted the oldinfo");
			
				 boolean Insert=false;
				 SgsStaffDAO staffdao=new SgsStaffDAO(); 
				if(Deleted) {
				
				 Insert=staffdao.Sgs(dto);
				}
		}
		
		
		
		
		if(deletestaffid!=null) {
			
			boolean Deleted=false;
			stdid=deletestaffid;
			 SgsStaffDAO staffdao1=new SgsStaffDAO(); 
				
				 Deleted=staffdao1.StaffDelete(stdid);
				 System.out.println("deletestaffid ="+stdid);
				 System.out.println("deleted the info");
			
		}
		
		response.sendRedirect("SgsHome.jsp");

	}
	
}
