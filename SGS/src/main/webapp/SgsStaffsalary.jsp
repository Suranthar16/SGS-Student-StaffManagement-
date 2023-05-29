<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SGS</title>
</head>
<body>

<% String staffid=request.getParameter("staffid");
	double totalleave=Double.parseDouble(request.getParameter("totalleave"));
	double finalsalary=Double.parseDouble(request.getParameter("finalsalary"));%>


<h1>Staff Salary Detials.</h1>

<table>

<tr>
	<th>Staff ID:</th>
	<td><%=staffid %></td>
</tr>
<tr>
	<th>No Leave:</th>
	<td><%=totalleave %></td>
</tr>
<tr>
	<th>Final Salary:</th>
	<td><%=finalsalary %></td>
</tr>
<tr>
	<th></th>
	<td><input type="button" id="home" name="home" value="Home" onclick="homefn()"></td>
</tr>


</table>
</body>
<script type="text/javascript">
function homefn() {
	
	window.location='SgsHome.jsp';
	
}

</script>
</html>