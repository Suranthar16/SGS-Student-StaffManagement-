

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.SgsStaffDAO;
import DTO.SgsDTO;

/**
 * Servlet implementation class AdminRegisterServlet
 */
@WebServlet("/AdminRegisterServlet")
public class AdminRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminRegisterServlet() {
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
		
		String adminstaffid=request.getParameter("staffid");
		String adminpassword=request.getParameter("password");
		String adminmobile=request.getParameter("mobile");
		String access=request.getParameter("access");
		
		dto.setAdminstaffid(adminstaffid);
		dto.setAdminpassword(adminpassword);
		dto.setAdminmobile(adminmobile);
		dto.setAccess(access);
		
		System.out.println("adminstaffid="+adminstaffid);
		System.out.println("adminpassword="+adminpassword);
		System.out.println("adminmobile="+adminmobile);
		System.out.println("access="+access);
		
		SgsStaffDAO staffdao=new SgsStaffDAO();
		
		staffdao.insertadmin(dto);
		
		
		
		response.sendRedirect("SgsHome.jsp");
	}

}
