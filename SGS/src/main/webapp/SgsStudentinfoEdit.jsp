<%@page import="DTO.SgsDTO"%>
<%@ page import ="java.util.*"%>
<%@ page import ="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SGS</title>
</head>
<body>

<% ArrayList<SgsDTO> list= (ArrayList<SgsDTO>)session.getAttribute("studentinfo");%>
<% String userstudentid = (String)request.getSession().getAttribute("studentid"); %>
<%

 
if(userstudentid==null){


}
SgsDTO dto1=new SgsDTO();
if(list!=null){

	for(int i=0;i<list.size();i++){
	 SgsDTO dto= list.get(i);
	 String dd=dto.getStudentid();
     if(userstudentid!=null&&dto.getStudentid() !=null&&dto.getStudentid().equals(userstudentid)) { 
			
              dto1=dto;
          }
}
	}
                        

     %>
     
     
     <div><h1>SGS</h1></div>
<div><h3>Student Information Edit Form</div>

<form id="studentregister" name="studentregister">
  <label for="name">Student Name:</label>
  <input type="text" id="studentname" name="studentname" value="<%=dto1.getStudentname()%>" placeholder="Full Name" required><br>
  
  <label for="standard">Standard:</label>
  <input type="number" id="standard" name="standard" value="<%=dto1.getStandard()%>" placeholder="00" required><br>
  
  <label for="studentid">Student ID:</label>
  <input type="text" id="studentid" name="studentid" value="<%=dto1.getStudentid()%>" placeholder="1001" required><br>
  
  <label for="address">Student Address :</label>
  <input type="text" id="studentaddress" name="studentaddress" value="<%=dto1.getStudentaddress()%>" placeholder="Full address" required><br>
  
  <label for="phone">Phone:</label>
  <input type="tel" id="phone" name="phone" value="<%=dto1.getPhone()%>" placeholder="000-000-0000" required><br>
  
  <label for="fathername">Father Name:</label>
  <input type="text" id="fathername" name="fathername" value="<%=dto1.getFathername()%>" placeholder="FullName" required><br>
  
  <label for="mothername">Mother Name:</label>
  <input type="text" id="mothername" name="mothername" value="<%=dto1.getMothername()%>" placeholder="FullName" required><br>
  
  <label for="bloodgroup">BloodGroup:</label>
  <input type="text" id="bloodgroup" name="bloodgroup" value="<%=dto1.getBloodgroup()%>" placeholder="eg.O+" required><br>
  
  <label for="annualfees">Annual Fees:</label>
  <input type="text" id="annualfees" name="annualfees" value="<%=dto1.getAnnualfees()%>" placeholder="Payed/NotPayed"><br>
  
  <input type="reset" value="Clear">
  <input type="button" id="subbmit" name="subbmit" value="Submit" onclick="subfn(<%=dto1.getStudentid()%>)">
</form>

</body>
<script type="text/javascript">
	function subfn(studentid){
		var studentname=document.getElementById("studentname").value;
		var standard=document.getElementById("standard").value;
		var studentid=document.getElementById("studentid").value;
		var studentaddress=document.getElementById("studentaddress").value;
		var phone=document.getElementById("phone").value;
		var fathername=document.getElementById("fathername").value;
		var mothername=document.getElementById("mothername").value;
		var bloodgroup=document.getElementById("bloodgroup").value;
		var annualfees=document.getElementById("annualfees").value;
		var lettersReg = /^[A-Za-z]+$/;
		var phonenoReg = /^\d{10}$/;
		
		
		if( studentname==="") {
	         alert( "Please provide your name!" );
	         return false;
	      }else if(!lettersReg.test(studentname)){
				 alert( "Only Alphabets allowed inside Name!" );
	         return false;
			 }
		
		if(standard===""){
			alert( "Please provide your standard!" );
			return false;
		}

		if(studentid===""){
			alert( "Please provide your studentid!" );
			return false;
		}
		if(studentaddress===""){
			alert( "Please provide your studentaddress!" );
			return false;
		}
		
		if( phone === "" ) {
	        alert( "Please provide your phone number!" );
	        return false;
	     }else if(!phonenoReg.test(phone)){
			 alert("Please provide valid Number!");
		 }
		
		
		if( fathername==="") {
	         alert( "Please provide your fathername!" );
	         return false;
	      }else if(!lettersReg.test(fathername)){
				 alert( "Only Alphabets allowed inside Name!" );
	         return false;
			 }
		
		if( mothername==="") {
	         alert( "Please provide your mothername!" );
	         return false;
	      }else if(!lettersReg.test(mothername)){
				 alert( "Only Alphabets allowed inside Name!" );
	         return false;
			 }
		
		
		if(bloodgroup===""){
			alert( "Please provide your bloodgroup!" );
			return false;
		}
		
		else{
			document.getElementById("studentregister").action="StudentDeleteEditServlet?editstudentid="+studentid;
			document.getElementById("studentregister").method="post";
			document.getElementById("studentregister").submit();
			
		}

		
	}
</script>
</html>