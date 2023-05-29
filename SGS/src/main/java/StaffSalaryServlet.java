

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import java.util.Calendar;
import java.util.Date;

import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.SgsStaffDAO;
import DTO.SgsDTO;

/**
 * Servlet implementation class StaffSalary
 */
@WebServlet("/StaffSalaryServlet")
public class StaffSalaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StaffSalaryServlet() {
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
		SgsStaffDAO staffdao=new SgsStaffDAO();
		
		String staffid=request.getParameter("staffid");
		double monthsalary=Double.parseDouble(request.getParameter("monthsalary"));
		String month=request.getParameter("month");
		
		System.out.println("staffid="+staffid);
		System.out.println("monthsalary="+monthsalary);
		System.out.println("month="+month);
	 
		 double totaldays=0.0;
		 double reducleave=0.0;
		 double xnoleave=0.0;
		 double totalleave=0.0;
		 double perdaysalary=0.0;
		 double finalsalary=0.0;
		 double reducsalary=0.0;
		
		
		SimpleDateFormat sf=new  SimpleDateFormat("yyyy-MM");
		   Date dte;
		try {
				dte = sf.parse(month);
		 
				System.out.println(dte);
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(dte);
				System.out.println(calendar.getTime());
			 
		       totaldays = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		      System.out.println(totaldays);
		}
		      catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		

		
		
		 staffdao.staffleave(staffid);
		 ArrayList<SgsDTO> list=staffdao.staffleave(staffid);
		  if(list!=null)System.out.println("leavelist size---"+list.size());
		  
		 
		  if(list!=null){
				for(int i=0;i<list.size();i++){
					SgsDTO dto1=list.get(i);
					xnoleave=dto1.getTime();
			        if(xnoleave!=0.0) {
					totalleave=totalleave+xnoleave;
			        } 
				} System.out.println("totalleave="+totalleave);
		     }
		  perdaysalary=monthsalary/totaldays;
		  System.out.println("perdaysalary="+perdaysalary);
		  
		  
		  HttpSession session=request.getSession();
		  
		  session.setAttribute("staffleave", list);
		  
		  
		  if(totalleave<2.0) {
			  finalsalary=monthsalary;
		  }else if(totalleave>2.0){
			  reducleave=totalleave-2.0;
			  reducsalary=reducleave*perdaysalary;
			  finalsalary=monthsalary-reducsalary;
		  }
		  
		
		 response.sendRedirect("SgsStaffsalary.jsp?staffid="+staffid +"&"+"totalleave="+totalleave+"&"+"finalsalary="+finalsalary);

	}

}