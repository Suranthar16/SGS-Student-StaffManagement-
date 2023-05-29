<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SGS</title>
</head>
<body>
<h1>Leave Apply Form</h1>

<form id="leaveapply" name="leaveapply">
  
  
  <label for="staffid">Staff ID:</label>
  <input type="text" id="staffid" name="staffid" value="" placeholder="1001" required><br>
  
  <label for="staffname">Staff Name:</label>
  <input type="text" id="staffname" name="staffname" value="" placeholder="Full Name" required><br>
  
  <label for="date">Date :</label>
  <input type="date" id="date" name="date" value="" placeholder="" required><br>
  
  <label for="time">Time:</label>
  <select id="time" name="time" value=""  required>
  	<option value="">-Select-</option> 
  	<option value="Halfday">Halfday</option>
  	<option value="Fullday">Fullday</option>
   </select><br>
   
  <input type="reset" value="Clear">
  <input type="button" id="subbmit" name="subbmit" value="Submit" onclick="subfn()">
</form>


</body>
<script type="text/javascript">
	function subfn() {
		var staffid=document.getElementById("staffid").value;
		var staffname=document.getElementById("staffname").value;
		var date=document.getElementById("date").value;
		var time=document.getElementById("time").value;
		

		if(staffid===""){
			alert( "Please provide your staffid!" );
			return false;
		}
		
		if( staffname==="") {
	         alert( "Please provide your staffname!" );
	         return false;
	      }
		
		if(date===""){
			alert( "Please provide leave date!" );
			return false;
		}
		
		 if(time===""){
				alert( "Please provide valid time!" );
				return false;
				}	  
	    else{
	    	document.getElementById("leaveapply").action="LeaveapplyServlet";
			document.getElementById("leaveapply").method="post";
			document.getElementById("leaveapply").submit();
	    }
		
		
	}

</script>
</html>