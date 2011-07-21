<%@page import="com.manteam.iwant2learn.user.vo.LogonAttributesVO"%>
<%@page import="com.manteam.iwant2learn.user.vo.LoginVO"%>
<%@page import="com.manteam.iwant2learn.controller.TrainingController"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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

<%String userName = request.getParameter("userName");
  String password = request.getParameter("password");

  out.println(userName);
  out.println(password);
  LoginVO loginDetails = new LoginVO();
  loginDetails.setUserName(userName);
  loginDetails.setUserPassword(password);
  TrainingController controller = new TrainingController();
  LogonAttributesVO loginAttributes = new LogonAttributesVO();
  loginAttributes = controller.authenticateUser(loginDetails);
  String userRole = loginAttributes.getUserRole();
  out.println(userRole);
  
  %>
 
  
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