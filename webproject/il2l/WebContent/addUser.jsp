<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add User Result</title>
<link href="adminPage.css" rel="stylesheet" type="text/css"></link>
<link href="addQForm.css" rel="stylesheet" type="text/css"></link>

</head>
<body>
<div class="container">
		<div class="header">
			<table cellpadding="10px" cellspacing="10">
				<tr>
					<td><br /></td>
				</tr>
				<tr>
					<td style="font-size: 25px; color: red"><i>i</i>-like</td>
					<td rowspan="2" style="font-size: 50px; color: red;"
						align="justify">2</td>
				</tr>
				<tr>
					<td style="font-size: 25px; color: red;">learn</td>
				</tr>

				<!-- end .header -->
			</table>
			<!-- end .header -->
		</div>
		<div id="leftcolumn">

			<a href="AdminHome.jsp">Admin Home</a> 
			<a href="addQuestionForm.jsp">Add Question</a> 
			<a href="addUserForm.jsp">Add User</a> 
			<a href="takeTestHome.jsp">Take Test</a>

			<!-- end .sidebar1 -->
		</div>
		<%
		
		/*JAVA SCRIPT TO BE WRITTEN HERE  */


		%>
		
		<div id="rightcolumn">
			<h1>
				The user is added successfully. Click here to add the next user : <a
					href="addUserForm.jsp">Add User</a>
			</h1>
		</div>
		<div class="footer">
			<center>
				
					<i style="color: #999; font-size: 15px"><b>@ManTeam</b> </i> <br />
					<b style="color: #999; font-size: 15px">The University of
						Manchester</b>
				
			</center>
			<!-- end .footer -->
		</div>

</body>
</html>