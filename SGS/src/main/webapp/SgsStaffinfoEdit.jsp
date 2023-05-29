<%@page import="DTO.SgsDTO"%>
<%@ page import ="java.util.*"%>
<%@ page import ="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% ArrayList<SgsDTO> list= (ArrayList<SgsDTO>)session.getAttribute("staffinfo");%>
<% String userstaffid = (String)request.getSession().getAttribute("staffid"); %>
<%

 
if(userstaffid==null){


}
SgsDTO dto1=new SgsDTO();
if(list!=null){

	for(int i=0;i<list.size();i++){
	 SgsDTO dto= list.get(i);
	 String dd=dto.getStudentid();
     if(userstaffid!=null&&dto.getStaffid() !=null&&dto.getStaffid().equals(userstaffid)) { 
			
              dto1=dto;
          }
}
	}
                        

     %>


<h1>Staff Information Edit Form</h1>

<form id="staffregister" name="staffregister">
  <label for="name">Staff Name:</label>
  <input type="text" id="staffname" name="staffname" value="<%=dto1.getStaffname()%>" placeholder="Full Name" required><br>
  
  <label for="staffid">Staff ID:</label>
  <input type="text" id="staffid" name="staffid" value="<%=dto1.getStaffid()%>" placeholder="55001" required><br>
  
  <label for="address">Staff Address :</label>
  <input type="text" id="staffaddress" name="staffaddress" value="<%=dto1.getStaffaddress()%>" placeholder="Full address" required><br>
  
  <label for="phone">Mobile:</label>
  <input type="tel" id="mobile" name="mobile" value="<%=dto1.getMobile()%>" placeholder="000-000-0000" required><br>
  
  <label for="status">Status:</label>
  <input type="text" id="status" name="status" value="<%=dto1.getStatus()%>" placeholder="Created/Notcreated" required><br>
  
  <label for="month">For Month:</label>
  <input type="month" id="month" name="month" value="<%=dto1.getMonth()%>" placeholder="Pick month" required><br>
  
  <label for="monthsalary">Monthly Salary:</label>
  <input type="text" id="monthsalary" name="monthsalary" value="<%=dto1.getMonthsalary()%>" placeholder="Enter amount" required><br>
  
  <input type="reset" value="Clear">
  <input type="button" id="subbmit" name="subbmit" value="Submit" onclick="subfn(<%=dto1.getStaffid()%>)">
</form>

</body>
<script type="text/javascript">
	function subfn(staffid){
		var staffname=document.getElementById("staffname").value;
		var staffid=document.getElementById("staffid").value;
		var staffaddress=document.getElementById("staffaddress").value;
		var mobile=document.getElementById("mobile").value;
		var status=document.getElementById("status").value;
		var month=document.getElementById("month").value;
		var monthsalary=document.getElementById("monthsalary").value;
		var lettersReg = /^[A-Za-z]+$/;
		var phonenoReg = /^\d{10}$/;
		
		
		if( staffname==="") {
	         alert( "Please provide your staffname!" );
	         return false;
	      }else if(!lettersReg.test(staffname)){
				 alert( "Only Alphabets allowed inside Name!" );
	         return false;
			 }

		if(staffid===""){
			alert( "Please provide your staffid!" );
			return false;
		}
		if(staffaddress===""){
			alert( "Please provide your staffaddress!" );
			return false;
		}
		
		if( mobile === "" ) {
	        alert( "Please provide your mobile number!" );
	        return false;
		}
		if( status === "" ) {
	        alert( "Please provide Salary Status !" );
	        return false;
		}
		if( month === "" ) {
	        alert( "Please provide  month!" );
	        return false;
		}
		if( monthsalary === "" ) {
	        alert( "Please provide  Monthsalary!" );
	        return false;
		}
	  
	    else{
	    	document.getElementById("staffregister").action="StudentDeleteEditServlet?editstaffid="+staffid;
			document.getElementById("staffregister").method="post";
			document.getElementById("staffregister").submit();
	    }
		
	}

</script>
</html>