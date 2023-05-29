

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.SgsDTO;
import DAO.SgsStaffDAO;

/**
 * Servlet implementation class StaffSalaryinfoServlet
 */
@WebServlet("/StaffSalaryinfoServlet")
public class StaffSalaryinfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StaffSalaryinfoServlet() {
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
		
		/*
		 * SgsDTO dto=new SgsDTO();
		 * 
		 * String Staffid=request.getParameter("Staffid"); String perdaysalary=
		 * request.getParameter("perdaysalary"); String
		 * status=request.getParameter("status"); String
		 * workingday=request.getParameter("workingday"); String
		 * noleave=request.getParameter("noleave");
		 * 
		 * dto.setStaffid(Staffid); dto.setPerdaysalary(perdaysalary);
		 * dto.setStatus(status); dto.setWorkingday(workingday);
		 * dto.setNoleave(noleave);
		 * 
		 * System.out.println("Staffid="+Staffid);
		 * System.out.println("perdaysalary="+perdaysalary);
		 * System.out.println("status="+status);
		 * System.out.println("workingday="+workingday);
		 * System.out.println("noleave="+noleave);
		 * 
		 * 
		 * SgsStaffDAO staffdao=new SgsStaffDAO();
		 */
		
		
	}

}
