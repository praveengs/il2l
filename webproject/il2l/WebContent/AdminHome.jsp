<%@ page language="java" session="true" %>
<%@ page errorPage="errorPage.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Admin Home Page</title>
<link href="adminPage.css" rel="stylesheet" type="text/css"></link>
<link href="addQForm.css" rel="stylesheet" type="text/css"></link>
<style type="text/css">
.hide {
	display: None;
	background-color: #C7FECA;
}
</style>
</head>

<body>

	<div class="container">
		<div class="header">
			<table cellpadding="10px" cellspacing="10">
				<tr>
					<td><br />
					</td>
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
		<%
			if (null==session.getAttribute("userRoleSession")||null==session.getAttribute("userName")) {				
		%>
		<jsp:forward page="index.jsp">
			<jsp:param value="Kindly login first!" name="FailReason" />
		</jsp:forward>
		<%
			} else {
				if (session.getAttribute("userRoleSession").equals("A")) {
		%>
		<div id="leftcolumn">

			<a href="AdminHome.jsp">Admin Home</a>  <a href="addKeywordForm.jsp">Add Keyword</a> <a href="addQuestionForm.jsp">Add
				Question</a> <a href="addUserForm.jsp">Add User</a> <a
				href="takeTestHome.jsp">Take Test</a><a href="logOff.jsp">Log Off</a>

			<!-- end .sidebar1 -->
		</div>
		
		<div id="rightcolumn">
			<h1>Welcome Admin</h1>
			<p>The admin would get the following privileges.The admin would
				get the following privileges.The admin would get the following
				privileges.The admin would get the following privileges.The admin
				would get the following privileges.The admin would get the following
				privileges.The admin would get the following privileges.The admin
				would get the following privileges.The admin would get the following
				privileges.The admin would get the following privileges.The admin
				would get the following privileges.The admin would get the following
				privileges.The admin would get the following privileges.</p>
			<p>The admin would get the following privileges.The admin would
				get the following privileges.The admin would get the following
				privileges.The admin would get the following privileges.The admin
				would get the following privileges.The admin would get the following
				privileges.The admin would get the following privileges.The admin
				would get the following privileges.The admin would get the following
				privileges.The admin would get the following privileges.The admin
				would get the following privileges.The admin would get the following
				privileges.The admin would get the following privileges.</p>
			<p>The admin would get the following privileges.The admin would
				get the following privileges.The admin would get the following
				privileges.The admin would get the following privileges.The admin
				would get the following privileges.The admin would get the following
				privileges.The admin would get the following privileges.The admin
				would get the following privileges.The admin would get the following
				privileges.The admin would get the following privileges.The admin
				would get the following privileges.The admin would get the following
				privileges.The admin would get the following privileges.</p>
			<p>The admin would get the following privileges.The admin would
				get the following privileges.The admin would get the following
				privileges.The admin would get the following privileges.The admin
				would get the following privileges.The admin would get the following
				privileges.The admin would get the following privileges.The admin
				would get the following privileges.The admin would get the following
				privileges.The admin would get the following privileges.The admin
				would get the following privileges.The admin would get the following
				privileges.The admin would get the following privileges.</p>

			<p>The admin would get the following privileges.The admin would
				get the following privileges.The admin would get the following
				privileges.The admin would get the following privileges.The admin
				would get the following privileges.The admin would get the following
				privileges.The admin would get the following privileges.The admin
				would get the following privileges.The admin would get the following
				privileges.The admin would get the following privileges.The admin
				would get the following privileges.The admin would get the following
				privileges.The admin would get the following privileges.</p>

			<br /> <br />
			<!-- end .content -->
		</div>
		<%
				}
				else{
					%>
					<jsp:forward page="index.jsp">
						<jsp:param value="Kindly login first as Administrator to view this page" name="FailReason" />
					</jsp:forward>
					<%
				}
			} 
		%>
		<div class="footer" align="center">

			<i style="color: #999; font-size: 15px"><b>@ManTeam</b> </i> <br />
			<b style="color: #999; font-size: 15px">The University of
				Manchester</b>

			<!-- end .footer -->
		</div>
		<!-- end .container -->
	</div>
</body>
</html>