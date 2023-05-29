

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.SgsStaffDAO;
import DTO.SgsDTO;

/**
 * Servlet implementation class LeaveapplyServlet
 */
@WebServlet("/LeaveapplyServlet")
public class LeaveapplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LeaveapplyServlet() {
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
		
		String staffid= request.getParameter("staffid");
		String staffname= request.getParameter("staffname");
		String date= request.getParameter("date");
		String time= request.getParameter("time");
		
		dto.setStaffid(staffid);
		dto.setStaffname(staffname);
		dto.setDate(date);
		
		String Halfday="Halfday";
		String Fullday="Fullday";
		if(time!=null && time.equals(Halfday)) {
			dto.setTime(0.5);
		}else if(time!=null && time.equals(Fullday)) {
			dto.setTime(1.0);
		}
		
		System.out.println("staffid="+staffid);
		System.out.println("staffname="+staffname);
		System.out.println("date="+date);
		System.out.println("time="+time);
		
		SgsStaffDAO staffdao=new SgsStaffDAO();
		staffdao.leaveupdate(dto);
		
		
		response.sendRedirect("SgsHome.jsp");
	}

}
