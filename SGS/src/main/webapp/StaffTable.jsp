<%@ page import ="java.util.ArrayList"%>
<%@ page import="DTO.SgsDTO" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SGS</title>
</head>
<body>
<h1>Student Table</h1>
<input type="search" id="search" name="search" value="Search"><br>
<form id="stafftable" name="stafftable" >
<table border="1">
<% ArrayList<SgsDTO> list= (ArrayList<SgsDTO>)session.getAttribute("staffinfo");%>

<tr>
	<th>staffname</th>
	<th>staffid</th>
	<th>staffaddress</th>
	<th>mobile</th>
	<th>status</th>
	<th>month</th>
	<th>monthly salary</th>
	<th>Salary</th>
	<th>Edit</th>
	<th>Delete</th>
</tr>	

<% if(list!=null){
	for(int i=0;i<list.size();i++){
		SgsDTO dto=list.get(i);
		
	%>
	
	<tr>
		<td><%=dto.getStaffname() %></td>
		<td><%=dto.getStaffid() %></td>
		<td><%=dto.getStaffaddress() %></td>
		<td><%=dto.getMobile() %></td>
		<td><%=dto.getStatus() %></td>
		<td><%=dto.getMonth() %></td>
		<td><%=dto.getMonthsalary()%></td>
		<td><input type="button" id="salary" name="salary" value="salary" onclick="salaryfn('<%=dto.getStaffid()%>','<%=dto.getMonthsalary()%>','<%=dto.getMonth()%>')"></td>
		<td><input type="button" id="edit" name="edit" value="Edit" onclick="editfn('<%=dto.getStaffid()%>')"></td>
		<td><input type="button" id="delete" name="delete" value="Delete" onclick="deletefn('<%=dto.getStaffid()%>')"></td>
</tr>
<%}} %>


</table>
<div>
  <p>For new Registration </p>
  <input type="button" id="register" name="register" value="Register" onclick="register()">

</div>
</form>
</body>
<script type="text/javascript">
	function register() {
		window.location='SgsStaffRegister.jsp';
		
	}
</script>
<script type="text/javascript">
	function editfn(staffid) {
		document.getElementById("stafftable").action="StudenteditServlet?staffid="+staffid;
		document.getElementById("stafftable").method="post";
		document.getElementById("stafftable").submit();
		
	}
</script>
<script type="text/javascript">
	function deletefn(staffid) {
		document.getElementById("stafftable").action="StudentDeleteEditServlet?deletestaffid="+staffid;
		document.getElementById("stafftable").method="post";
		document.getElementById("stafftable").submit();
		
	}
</script>
<script type="text/javascript">
	function salaryfn(staffid,monthsalary,mon ) {  
		
		console.log("into salary function");
		
		document.getElementById("stafftable").action="StaffSalaryServlet?staffid="+staffid +"&"+"monthsalary="+monthsalary+"&"+"month="+mon ;
		document.getElementById("stafftable").method="post";
		document.getElementById("stafftable").submit();
		
	}
</script>
</html>