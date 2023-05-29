

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.SgsStaffDAO;
import DTO.SgsDTO;

/**
 * Servlet implementation class StaffRegisterServlet
 */
@WebServlet("/StaffRegisterServlet")
public class StaffRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StaffRegisterServlet() {
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

	

		SgsStaffDAO staffdao=new SgsStaffDAO();
		staffdao.Sgs(dto);
		
		
		response.sendRedirect("SgsHome.jsp");

		
	}

}
