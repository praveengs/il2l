<%@page
	import="com.manteam.iwant2learn.user.exceptions.MaintainUserException"%>
<%@ page language="java" session="true"%>
<%@ page errorPage="errorPage.jsp"%>
<%@page import="com.manteam.iwant2learn.user.vo.LogonAttributesVO"%>
<%@page import="com.manteam.iwant2learn.user.vo.LoginVO"%>
<%@page import="com.manteam.iwant2learn.controller.TrainingController"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Authentication Success!</title>
<link href="styleIndex.css" rel="stylesheet" type="text/css"></link>
</head>
<body>
	<%
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		if(null!=password&&null!=userName){
			LoginVO loginDetails = new LoginVO();
			loginDetails.setUserName(userName);
			loginDetails.setUserPassword(password);
			TrainingController controller = new TrainingController();
			LogonAttributesVO loginAttributes = new LogonAttributesVO();
			try{
				loginAttributes = controller.authenticateUser(loginDetails);
				session.setAttribute("userRoleSession", loginAttributes.getUserRole());
				session.setAttribute("userName",loginAttributes.getUserName());
	%>
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
		<jsp:forward page="AdminHome.jsp"></jsp:forward>
		<%
			} else if (session.getAttribute("userRoleSession").equals("F")) {
		%>
		<jsp:forward page="facultyHome.jsp"></jsp:forward>
		<%
			} else if (session.getAttribute("userRoleSession").equals("S")) {
		%>
		<jsp:forward page="takeTestHome.jsp"></jsp:forward>

		<%
			}
			}
			}catch(MaintainUserException invalid)
			{
				%>
		<jsp:forward page="index.jsp">
			<jsp:param value="Login failed! Kindly retry." name="FailReason" />
		</jsp:forward>
		<%
			}
		}else {
			%>
		<jsp:forward page="index.jsp">
			<jsp:param value="Kindly login first!" name="FailReason" />
		</jsp:forward>
		<%
		}
		%>
		<div class="footer">
			<center>

				<i style="color: #999; font-size: 15px"><b>@ManTeam</b> </i> <br />
				<!-- <b style="color: #999; font-size: 15px">The University of
					Manchester</b> -->

			</center>
			<!-- end .footer -->
		</div>
		<!-- end .container -->
	</div>

</body>
</html>