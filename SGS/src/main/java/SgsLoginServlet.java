

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.SgsStaffDAO;
import DTO.SgsDTO;

/**
 * Servlet implementation class SgsServlet
 */
@WebServlet("/SgsLoginServlet")
public class SgsLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SgsLoginServlet() {
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
		
		SgsDTO dto=new SgsDTO();
		
		String userstaffid=request.getParameter("staffid");
		String userpassword= request.getParameter("password");
		
		
		System.out.println("userstaffid="+userstaffid);
		System.out.println("userpassword="+userpassword);
		
		
		SgsStaffDAO staffdao=new SgsStaffDAO();
		/* staffdao.Sgs(dto); */
		
		
		
		String result = staffdao.validate(userstaffid,userpassword);
		System.out.println("result="+result);
		
		String Yes="Yes";
		
		  if(result!=null && (result.equals(Yes))) {
			  response.sendRedirect("SgsHome.jsp?result="+result);
		  }
		  else {
			  response.sendRedirect("Sgslogin.jsp?error="+"Your have no Access!") ;
		  }
		
		
	}

}
