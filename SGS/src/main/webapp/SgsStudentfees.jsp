<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SGS</title>
</head>
<body>
<h1>Student Fees Detials.</h1>
<form id="studentfees" name="studentfees">
<table border="1">
	<tr>
	<th>Standard</th>
	<td><input type="text" id="standard" name="standard" value="" placeholder="00"></td>
	</tr>
	<tr>
	<th>Fees</th>
	<td><input type="text" id="fees" name="fees" value="" placeholder="Enter Amount"></td>
	</tr>
	
	<tr>
	<td></td>
	<td><input type="button" id=sub name="sub" value="Submit" onclick="subfun()"></td>
	
	</tr>
	
</table>
</form>
</body>
<script type="text/javascript">
	function subfun() {
		var standard=document.getElementById("standard").value;
		var fees=document.getElementById("fees").value;
		
		document.getElementById("studentfees").action="StudentFeesServlet";
		document.getElementById("studentfees").method="post";
		document.getElementById("studentfees").submit();
		
	}

</script>
</html>