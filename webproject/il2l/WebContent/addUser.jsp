<%@ page language="java" session="true"%>
<%@ page isErrorPage="true"%>
<%@page import="com.manteam.iwant2learn.controller.TrainingController"%>
<%@page import="com.manteam.iwant2learn.user.vo.LogonAttributesVO"%>
<%@page import="com.manteam.iwant2learn.user.sql.MaintainUserSql"%>
<%@page import="com.manteam.iwant2learn.user.vo.UserSaveVO"%>
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

			<a href="AdminHome.jsp">Admin Home</a><a href="addKeywordForm.jsp">Add
				Keyword</a> <a href="addQuestionForm.jsp">Add Question</a> <a
				href="addUserForm.jsp">Add User</a> <a href="takeTestHome.jsp">Take
				Test</a><a href="logOff.jsp">Log Off</a>

			<!-- end .sidebar1 -->
		</div>
		<% 
			String userName = request.getParameter("userName");
			String userRole = request.getParameter("userRole");
			String password = request.getParameter("password");
			String phoneNumber = request.getParameter("phoneNumber");
			String emailId = request.getParameter("emailId");
			String addressLine1 = request.getParameter("address");
			String addressLine2 = request.getParameter("address1");

			UserSaveVO saveUser = new UserSaveVO();
			saveUser.setUserName(userName);
			saveUser.setUserRole(userRole);
			saveUser.setPassword(password);
			saveUser.setEmailId(emailId);
			saveUser.setPhoneNumber(phoneNumber);
			saveUser.setAddressField1(addressLine1);
			saveUser.setAddressField2(addressLine2);

			LogonAttributesVO loginAttributes = new LogonAttributesVO();
			loginAttributes.setUserName(userName);
			loginAttributes.setUserRole(userRole);

			TrainingController controller = new TrainingController();
			boolean result = controller.addUser(loginAttributes, saveUser);

			if (result == false) {
		%>
		<div id="rightcolumn">
			<h1>
				The user addition failed. Click here to try again !! : <a
					href="addUserForm.jsp">Add User</a>
			</h1>
		</div>

		<%
			} else {
		%>


		<div id="rightcolumn">
			<h1>
				The user is added successfully. Click here to add the next user : <a
					href="addUserForm.jsp">Add User</a>
			</h1>
		</div>

		<%
			}
		%>
		<%
				}
				else{
					%>
		<jsp:forward page="index.jsp">
			<jsp:param
				value="Kindly login first as Administrator to view this page"
				name="FailReason" />
		</jsp:forward>
		<%
				}
			} 
		%>
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