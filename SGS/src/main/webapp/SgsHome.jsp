<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SGS</title>
</head>
<script type="text/javascript">
 <% String result=request.getParameter("result");%>
 
 console.log("<%=result%>");



</script>
<body>
<h1>SGS</h1>
<h3>Choose the imformation you need</h3>
	<div>
		<input type="submit" id="student" name="student" value="Student" onclick="student()"><br>
		<input type="submit" id="staff" name="staff" value="Staff" onclick="staff()"><br>
		<input type="submit" id="fees" name="fees" value="FeesUpdate" onclick="fees()"><br>
		<!-- <input type="submit" id="salary" name="salary" value="SalaryUpdate" onclick="salary()"><br> -->
		<input type="submit" id="applyleave" name="applyleave" value="ApplyLeave" onclick="applyleavefn()"><br>
	<% String Yes="Yes";
	if(result!=null && result.equals(Yes)){ %>
		<input type="submit" id="addadmin" name="addadmin" value="Add Admin" onclick="addadmin()">
		<%} %>
	</div>

</body>
<script type="text/javascript">
	function student() {
		   
			 window.location = 'HomeServlet?student='+"student"; 
	}
</script>
<script type="text/javascript">
	function staff() {
		window.location='HomeServlet?staff='+"staff";
	}
</script>
<script type="text/javascript">
	function fees() {
		window.location='SgsStudentfees.jsp';
	}
</script>
<!-- <script type="text/javascript">
	function salary() {
		window.location='SgsStaffsalary.jsp';
	}
</script> -->
<script type="text/javascript">
	function addadmin() {
	
		window.location='SgsAdminregister.jsp';

	}
</script>
<script type="text/javascript">
	function applyleavefn() {
	
		window.location='SgsLeave.jsp';

	}
</script>
</html>