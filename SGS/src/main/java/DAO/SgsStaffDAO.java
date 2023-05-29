package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DB.SgsDB;
import DTO.SgsDTO;

public class SgsStaffDAO {
	public boolean Sgs(SgsDTO dto) {
		
		
		System.out.println("dto staffname="+dto.getStaffname());
		System.out.println("dto staffid="+dto.getStaffid());
		System.out.println("dto staffaddress="+dto.getStaffaddress());
		System.out.println("dto mobile="+dto.getMobile());
		
	
		
		
		
		
		SgsDB db=new SgsDB();
		Connection conn= db.getConnection();
		boolean result1=false;
		
		String sql="INSERT INTO test1.sgsstaff(staffname,staffid,staffaddress,mobile,status,month,monthsalary)VALUES(?,?,?,?,?,?,?);";
		PreparedStatement ps=null;
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, dto.getStaffname());
			ps.setString(2, dto.getStaffid());
			ps.setString(3, dto.getStaffaddress());
			ps.setString(4, dto.getMobile());
			ps.setString(5, dto.getStatus());
			ps.setString(6, dto.getMonth());
			ps.setString(7, dto.getMonthsalary());
		
			
			double result=0;
			result=ps.executeUpdate();
			System.out.println(result);
				if(result>0) 
				{
					result1=true;
					System.out.println("insert success!");
				}
		    } catch (Exception e) {
		    	System.out.println(e);
		    }
		
		
		
		System.out.println(conn);
		return result1;
		
	}
	
	public ArrayList<SgsDTO> staffinfo() {
		
	    SgsDB db=new SgsDB();
		Connection conn= db.getConnection();
		
		ArrayList<SgsDTO> stafflist=new ArrayList<SgsDTO>();
		System.out.println(conn);
		ResultSet rs=null;
		PreparedStatement ps = null;    /*
										 * SELECT column_name(s) FROM table1 FULL OUTER JOIN table2 ON
										 * table1.column_name = table2.column_name WHERE condition;
										 */
		
		String sql="select * from test1.sgsstaff;";
		
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			System.out.println(rs);
			
			while(rs.next())
			{
			
				SgsDTO dto1=new SgsDTO();
				String staffname=rs.getString("staffname");
				System.out.println("staffname-->"+staffname);
				dto1.setStaffname(staffname);
				
				String staffid=rs.getString("staffid");
				System.out.println("staffid---->"+staffid);
				dto1.setStaffid(staffid);
				
				String staffaddress=rs.getString("staffaddress");
				System.out.println("staffaddress---->"+staffaddress);
				dto1.setStaffaddress(staffaddress);
				
				String mobile=rs.getString("mobile");
				System.out.println("mobile---->"+mobile);
				dto1.setMobile(mobile);
				
				String status=rs.getString("status");
				System.out.println("status---->"+status);
				dto1.setStatus(status);
				
				String month=rs.getString("month");
				System.out.println("month---->"+month);
				dto1.setMonth(month);
				
				String monthsalary=rs.getString("monthsalary");
				System.out.println("monthsalary---->"+monthsalary);
				dto1.setMonthsalary(monthsalary);
				
				
				stafflist.add(dto1);
			}
			
		} catch (Exception e) {
		System.out.println(e);
		}
		
		
		return stafflist;		
 }
	
	public boolean insertadmin(SgsDTO dto) {
		
		
		SgsDB db=new SgsDB();
		Connection conn= db.getConnection();
		boolean result1=false;
		
		String sql="INSERT INTO test1.sgslogin(staffid,password,mobile,Access)VALUES(?,?,?,?);";
		PreparedStatement ps=null;
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, dto.getAdminstaffid());
			ps.setString(2, dto.getAdminpassword());
			ps.setString(3, dto.getAdminmobile());
			ps.setString(4, dto.getAccess());
			
			double result=0;
			result=ps.executeUpdate();
			System.out.println(result);
				if(result>0) 
				{
					result1=true;
					System.out.println("insert success!");
				}
		    } catch (Exception e) {
		    	System.out.println(e);
		    }
		
		
		
		System.out.println(conn);
		return result1;
		
	}
	
	public String validate(String userstaffid, String userpassword) {
		
	     
		 SgsDB db=new SgsDB();
		 Connection conn= db.getConnection();
		 String logaccess="";
		 ResultSet rs=null;
		 PreparedStatement ps=null;
		 
		  String sql= "SELECT  staffid,password,Access FROM test1.sgslogin Where staffid=?";
		 try {
	           ps=conn.prepareStatement(sql);
			   ps.setString(1, userstaffid);
			   
			   rs=ps.executeQuery();
	          
	           
			   while (rs.next())
	            {
	            String staffid = rs.getString("staffid");
	            String password = rs.getString("password");
	            String access = rs.getString("Access");              
	               if (userstaffid!=null&&userpassword!=null&&(userstaffid.equals(staffid)) && (userpassword.equals(password))) {

	                  System.out.println("You have Access"); 
	                  logaccess=access;
	            }else {

	             System.out.println("You dont have Access ");
	            }
	            }}  
	         catch (Exception e) {

	            System.out.println(e);
	        }
		return logaccess;

	 }
	
		/*
		 * public boolean staffstatus(SgsDTO dto) {
		 * 
		 * 
		 * SgsDB db=new SgsDB(); Connection conn= db.getConnection(); boolean
		 * result1=false;
		 * 
		 * String
		 * sql="INSERT INTO test1.sgsstaffsalary(staffid,perdaysalary,status,workingday,noleave)VALUES(?,?,?,?,?);"
		 * ; PreparedStatement ps=null; try { ps=conn.prepareStatement(sql);
		 * ps.setString(1, dto.getStaffid()); ps.setString(2, dto.getPerdaysalary());
		 * ps.setString(3, dto.getStatus()); ps.setString(4, dto.getWorkingday());
		 * ps.setString(4, dto.getNoleave());
		 * 
		 * double result=0; result=ps.executeUpdate(); System.out.println(result);
		 * if(result>0) { result1=true; System.out.println("insert success!"); } } catch
		 * (Exception e) { System.out.println(e); }
		 * 
		 * 
		 * 
		 * System.out.println(conn); return result1;
		 * 
		 * }
		 */

	public boolean leaveupdate(SgsDTO dto) {
	
	
	SgsDB db=new SgsDB();
	Connection conn= db.getConnection();
	boolean result1=false;
	
	String sql="INSERT INTO test1.sgsstaffleave(staffid,staffname,date,time)VALUES(?,?,?,?);";
	PreparedStatement ps=null;
	try {
		ps=conn.prepareStatement(sql);
		ps.setString(1, dto.getStaffid());
		ps.setString(2, dto.getStaffname());
		ps.setString(3, dto.getDate());
		ps.setDouble(4, dto.getTime());
		
		double result=0;
		result=ps.executeUpdate();
		System.out.println(result);
			if(result>0) 
			{
				result1=true;
				System.out.println("insert success!");
			}
	    } catch (Exception e) {
	    	System.out.println(e);
	    }
	
	
	
	System.out.println(conn);
	return result1;
	
}
	
	public ArrayList<SgsDTO> staffleave(String staffid) {
		
	    SgsDB db=new SgsDB();
		Connection conn= db.getConnection();
		
		ArrayList<SgsDTO> leavelist=new ArrayList<SgsDTO>();
		System.out.println(conn);
		ResultSet rs=null;
		PreparedStatement ps=null;
		
		String sql="select date,time from sgsstaffleave where staffid=?;";
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, staffid);
			rs=ps.executeQuery();
			
			System.out.println(rs);
			
			while(rs.next())
			{
			
				SgsDTO dto1=new SgsDTO();
				String date=rs.getString("date");
				System.out.println("date-->"+date);
				dto1.setDate(date);
				
				Double time=rs.getDouble("time");
				System.out.println("time---->"+time);
				dto1.setTime(time);
				
				
				leavelist.add(dto1);
			}
			
		} catch (Exception e) {
		System.out.println(e);
		}
		
		
		return leavelist;		
 }
	
	 public boolean StaffDelete(String stdid ) {

		 SgsDB db=new SgsDB();
		 Connection conn= db.getConnection();
		 boolean result1=false;

		 String sql="Delete From test1.sgsstaff Where staffid=?";
		 PreparedStatement ps=null;
		 try {
		 	ps=conn.prepareStatement(sql);
		 	ps.setString(1, stdid);
		 	
		 	
		 	double result=0;
		 	result=ps.executeUpdate();
		 	System.out.println(result);
		 		if(result>0) 
		 		{
		 			result1=true;
		 			System.out.println("Delete success!");
		 		}
		     } catch (Exception e) {
		     	System.out.println(e);
		     }

		 	System.out.println(conn);
		 	return result1;
		   }


}
