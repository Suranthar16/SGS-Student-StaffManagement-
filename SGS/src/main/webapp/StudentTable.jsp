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
<form id="studenttable" name="studenttable">
<table  border="1">
<% ArrayList<SgsDTO> list= (ArrayList<SgsDTO>)session.getAttribute("studentinfo");%>

<h1>Student Table</h1>
<input type="search" id="search" name="search" value="Search"><br>


<tr>
	<th>studentname</th>
	<th>Standard</th>
	<th>Studentid</th>
	<th>StudentAddress</th>
	<th>Phone</th>
	<th>Fathername</th>
	<th>Mothername</th>
	<th>Bloodgroup</th>
	<th>annualfees</th>
	<th>fees</th>
	<th>Edit</th>
	<th>Delete</th>
</tr>	

<% if(list!=null){
	for(int i=0;i<list.size();i++){
		SgsDTO dto=list.get(i);
		
	%>
	
	<tr>
		<td><%=dto.getStudentname()%></td>
		<td><%=dto.getStandard() %></td>
		<td><%=dto.getStudentid() %></td>
		<td><%=dto.getStudentaddress() %></td>
		<td><%=dto.getPhone() %></td>
		<td><%=dto.getFathername() %></td>
		<td><%=dto.getMothername()%></td>
		<td><%=dto.getBloodgroup()%></td>
		<td><%=dto.getAnnualfees()%></td>
		<td><%=dto.getFees()%></td>
		<td><input type="button" id="edit" name="edit" value="Edit" onclick="editfn(<%=dto.getStudentid()%>)"></td>
		<td><input type="button" id="delete" name="delete" value="Delete" onclick="deletefn(<%=dto.getStudentid()%>)"></td>
</tr>
<%}} %>


</table>
<div>
  <p>For new Registration </p>
  <input type="button" id="register" name="register" value="Register" onclick="registerfn()">

</div>
</form>
</body>
<script type="text/javascript">
	function registerfn() {
	/* 	window.location='SgsStudentRegister.jsp'; */
		document.getElementById("studenttable").action="SgsStudentRegister.jsp";
		document.getElementById("studenttable").method="post";
		document.getElementById("studenttable").submit();
	
	}
</script>
<script type="text/javascript">
	function editfn(studentid) {
	/* 	window.location='SgsStudentRegister.jsp'; */
		document.getElementById("studenttable").action="StudenteditServlet?studentid="+studentid;
		document.getElementById("studenttable").method="post";
		document.getElementById("studenttable").submit();
	
	}
</script>

<script type="text/javascript">
	function deletefn(studentid) {
	/* 	window.location='SgsStudentRegister.jsp'; */
		document.getElementById("studenttable").action="StudentDeleteEditServlet?deletestudentid="+studentid;
		document.getElementById("studenttable").method="post";
		document.getElementById("studenttable").submit();
	
	}
</script>

</html>