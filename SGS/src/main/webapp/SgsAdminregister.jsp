<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Admin Register Form</h1>

<form id="adminregister" name="adminregister">
  
  
  <label for="staffid">Staff ID:</label>
  <input type="text" id="staffid" name="staffid" value="" placeholder="55001" required><br>
  
  <label for="password">Password:</label>
  <input type="password" id="password" name="password" value="" placeholder="6-Char" required><br>
  
  <label for="cpassword">Conform Password :</label>
  <input type="password" id="cpassword" name="cpassword" value="" placeholder="6-Char" required><br>
  
  <label for="mobile">Mobile:</label>
  <input type="tel" id="mobile" name="mobile" value="" placeholder="000-000-0000" required><br>
  
  <label for="access">Access:</label>
  <input type="text" id="access" name="access" value="" placeholder="Yes/No" required><br>
   
  <input type="reset" value="Clear">
  <input type="button" id="subbmit" name="subbmit" value="Submit" onclick="subfn()">
</form>

</body>
<script type="text/javascript">
	function subfn(){
		var staffid=document.getElementById("staffid").value;
		var password=document.getElementById("password").value;
		var cpassword=document.getElementById("cpassword").value;
		var mobile=document.getElementById("mobile").value;
		var access=document.getElementById("access").value;
		var phonenoReg = /^\d{10}$/;
		

		if(staffid===""){
			alert( "Please provide your staffid!" );
			return false;
		}
		
		if( password==="") {
	         alert( "Please provide your password!" );
	         return false;
	      }
		
		if(cpassword===""){
			alert( "Please provide your cpassword!" );
			return false;
		}
		
		 if(password!==cpassword){
				alert( "Please provide valid Password!" );
				return false;
				}
		
		if( mobile === "" ) {
	        alert( "Please provide your mobile number!" );
	        return false;
		}
		if( access === "" ) {
	        alert( "Please provide  access!" );
	        return false;
		}
	  
	    else{
	    	document.getElementById("adminregister").action="AdminRegisterServlet";
			document.getElementById("adminregister").method="post";
			document.getElementById("adminregister").submit();
	    }
		
	}

</script>
</html>