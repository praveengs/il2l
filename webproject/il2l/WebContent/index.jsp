<%-- 
    Document   : index
    Created on : Jun 25, 2011, 12:59:47 AM
    Author     : Narayanan
--%>

<%@ page language="java" session="true"%>
<%@ page errorPage="errorPage.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Home</title>
<link href="styleIndex.css" rel="stylesheet" type="text/css"></link>
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
		</div>

		<div class="sidebar1">
			<form action="AuthenticateUserPage.jsp" method="post">
				<table align="center" cellpadding="10px" cellspacing="5px">
					<tr>
						<td colspan="2"><br /> <br /></td>
					</tr>
					<tr>
						<td colspan="2" align="center"><b style="color: #FFF">
								LOGIN</b></td>
					</tr>
					<tr>
						<td style="color: #FFF">User Name</td>
						<td><input type="text" name="userName" /></td>
					</tr>
					<tr>
						<td style="color: #FFF">Password</td>
						<td><input type="password" name="password" /></td>
					</tr>
					<tr>
						<td colspan="2" align="center">
						<input type="submit" value="Submit" style="height: 25px; width: 100px" /> 
						<input type="reset" value="Reset" style="height: 25px; width: 100px" />
						</td>
					</tr>
					<%
					if(session.getAttribute("userName")!=null){
						session.invalidate();
					}
					String reason=request.getParameter("FailReason");
					if(reason==null||reason.equalsIgnoreCase("")){
					}else{
					%>
					<tr><td colspan="2" align="center"><font color="aqua"><%=reason %></font></td></tr>
					<%} %>
				</table>

			</form>
			<!-- end .sidebar1 -->
		</div>

		<div class="content">
			<marquee loop="infinite">
			<h1>
				Welcome to <i style="color: red">i</i>-like2Learn
			</h1>
			</marquee>
			<p>The admin would get the following privileges.The admin would
				get the following privileges.The admin would get the following
				privileges.The admin would get the following privileges.The admin
				would get the following privileges.The admin would get the following
				privileges.The admin would get the following privileges.The admin
				would get the following privileges.The admin would get the following
				privileges.The admin would get the following privileges.The admin
				would get the following privileges.The admin would get the following
				privileges.</p>
			<p>The admin would get the following privileges.The admin would
				get the following privileges.The admin would get the following
				privileges.The admin would get the following privileges.The admin
				would get the following privileges.The admin would get the following
				privileges.The admin would get the following privileges.The admin
				would get the following privileges.The admin would get the following
				privileges.The admin would get the following privileges.The admin
				would get the following privileges.The admin would get the following
				privileges.</p>
			

			<!-- end .content -->
		</div>
		<div class="footer">
			<center>
				
					<i style="color: #999; font-size: 15px"><b>@ManTeam</b> </i> <br />
					<b style="color: #999; font-size: 15px">The University of
						Manchester</b>
				
			</center>
			<!-- end .footer -->
		</div>
		<!-- end .container -->
	</div>
</body>
</html>
