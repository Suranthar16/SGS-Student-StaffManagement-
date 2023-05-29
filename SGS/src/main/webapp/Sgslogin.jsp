<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<script type="text/javascript">
 <% String error=request.getParameter("error");
 if(error!=null)
  {%>
	  alert(" <%=error%> ");
  <% }%>

</script>
<body>
<form id="sgslogin" name="sgslogin" method="Post" >
<div><h1>SGS</h1></div>



<div><h3>Login</h3></div>
	
	
	
	<div>
		<h4>Staff ID:</h4>
		<input type="text" id="staffid" name="staffid" value="" placeholder="Full ID" required  >
	</div>
	<div>
		<h4> Password:</h4>
		<input type="password" id="password" name="password" value="" placeholder="Full Name" required  >
	</div>
	
	
		<input type="button" id="login" name="login" value="Login" onclick="loginfun()" >
		
</form>
</body>
<script type="text/javascript">
function loginfun() {
	console.log("into");
	
	var staffid=document.getElementById("staffid").value;
	var password=document.getElementById("password").value;

	
	
	if(staffid===""){
		alert("Please enter staffid!");
	}
	if(password===""){
		alert("Please enter password!");
	}else if(password.length <6){
  	  alert( "Please provide valid password!" );
    }
	
	else{
		 document.getElementById("sgslogin").method="post";
		 document.getElementById("sgslogin").action="SgsLoginServlet";
		 document.getElementById("sgslogin").submit();

	}
}

</script>
</html>