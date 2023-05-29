package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.SgsDTO;
import DB.SgsDB;

public class SgsStudentDAO {
	
	public boolean Sgs(SgsDTO dto) {
		
		System.out.println("dto studentname="+dto.getStudentname());
		System.out.println("dto Standard="+dto.getStandard());
		System.out.println("dto Studentid="+dto.getStudentid());
		System.out.println("dto StudentAddress="+dto.getStudentaddress());
		System.out.println("dto Phone="+dto.getPhone());
		System.out.println("dto Fathername="+dto.getFathername());
		System.out.println("dto Mothername="+dto.getMothername());
		System.out.println("dto Bloodgroup="+dto.getBloodgroup());
		System.out.println("dto annualfees="+dto.getAnnualfees());
		
		System.out.println("dto fees="+dto.getFees());

		
		
		SgsDB db=new SgsDB();
		Connection conn= db.getConnection();
		boolean result1=false;
		
		String sql1="INSERT INTO test1.sgsstudent(studentname,Standard,Studentid,StudentAddress,Phone,Fathername,Mothername,Bloodgroup,annualfees)VALUES(?,?,?,?,?,?,?,?,?);";
		PreparedStatement ps1=null;
		try {
			ps1=conn.prepareStatement(sql1);
			ps1.setString(1, dto.getStudentname());
			ps1.setInt(2, dto.getStandard());
			ps1.setString(3, dto.getStudentid());
			ps1.setString(4, dto.getStudentaddress());
			ps1.setString(5, dto.getPhone());
			ps1.setString(6, dto.getFathername());
			ps1.setString(7, dto.getMothername());
			ps1.setString(8, dto.getBloodgroup());
			ps1.setString(9, dto.getAnnualfees());
			
			
			double result=0;
			result=ps1.executeUpdate();
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
	
	 public ArrayList<SgsDTO> studentinfo() {
			
		    SgsDB db=new SgsDB();
			Connection conn= db.getConnection();
			
			ArrayList<SgsDTO> list=new ArrayList<SgsDTO>();
			System.out.println(conn);
			ResultSet rs=null;
			PreparedStatement ps=null;
			
			String sql="select sgsstudent.*,sgsstudentfees.fees from test1.sgsstudent LEFT JOIN test1.sgsstudentfees ON sgsstudent.standard=sgsstudentfees.standard;";
			
			try {
				ps=conn.prepareStatement(sql);
				rs=ps.executeQuery();
				System.out.println(rs);
				
				while(rs.next())
				{
				
					SgsDTO dto1=new SgsDTO();
					String studentname=rs.getString("studentname");
					System.out.println("studentname-->"+studentname);
					dto1.setStudentname(studentname);
					
					int Standard=rs.getInt("Standard");
					System.out.println("Standard---->"+Standard);
					dto1.setStandard(Standard);
					
					String Studentid=rs.getString("Studentid");
					System.out.println("Studentid---->"+Studentid);
					dto1.setStudentid(Studentid);
					
					String StudentAddress=rs.getString("StudentAddress");
					System.out.println("StudentAddress---->"+StudentAddress);
					dto1.setStudentaddress(StudentAddress);
					
					String Phone=rs.getString("Phone");
					System.out.println("Phone---->"+Phone);
					dto1.setPhone(Phone);
					
					String Fathername=rs.getString("Fathername");
					System.out.println("Fathername---->"+Fathername);
					dto1.setFathername(Fathername);
					
					String Mothername=rs.getString("Mothername");
					System.out.println("Mothername---->"+Mothername);
					dto1.setMothername(Mothername);
					
					String Bloodgroup=rs.getString("Bloodgroup");
					System.out.println("Bloodgroup---->"+Bloodgroup);
					dto1.setBloodgroup(Bloodgroup);
					
					String annualfees=rs.getString("annualfees");
					System.out.println("annualfees---->"+annualfees);
					dto1.setAnnualfees(annualfees);
					
					int fees=rs.getInt("fees");
					System.out.println("fees---->"+fees);
					dto1.setFees(fees);
					
					
					list.add(dto1);
				}
				
			} catch (Exception e) {
			System.out.println(e);
			}
			
			
			return list;		
	 }
	 
	 public boolean feeupdate(int standard,int fees) {
		 
		SgsDB db=new SgsDB();
		Connection conn= db.getConnection();
		boolean result1=false;
		
		
		ResultSet rs=null;
		PreparedStatement ps2 = null; /* UPDATE table_nameSET column1 = value1, column2 = value2, ...WHERE condition; */
										 
		
		String sql="UPDATE sgsstudentfees SET fees=?  WHERE standard=? ;";
		
		 try {
	           ps2=conn.prepareStatement(sql);
			   ps2.setInt(1, fees);
			   ps2.setInt(2, standard);
			   
			   double result=0;
				result=ps2.executeUpdate();
				System.out.println(result);
					if(result>0) 
					{
						result1=true;
						System.out.println("Update success!");
					}
			   
		 }
		catch (Exception e) {
		System.out.println(e);
		}
		 
		return result1;
		 
	 }
	 
		
	 
	 public boolean StudentDelete(String stdid ) {

		 SgsDB db=new SgsDB();
		 Connection conn= db.getConnection();
		 boolean result1=false;

		 String sql="Delete From test1.sgsstudent Where studentid=?";
		 PreparedStatement ps=null;
		 PreparedStatement ps1=null;
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
