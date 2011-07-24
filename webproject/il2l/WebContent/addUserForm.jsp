<%@ page language="java" session="true"%>
<%@ page errorPage="errorPage.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
.mandatory {
	color: red;
}
</style>
<link href="adminPage.css" rel="stylesheet" type="text/css"></link>
<link href="addQForm.css" rel="stylesheet" type="text/css"></link>

<style type="text/css">
.hide {
	display: None;
	background-color: #C7FECA;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add User Form</title>
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
		
		if (request==null || request.getSession(false) == null || session.getAttribute("userRoleSession")==null) {
			System.out.println("Hey if");
			out.println("<h2><span class='mandatory'>Please login !!</span></h2>");
	%>
		<jsp:forward page="HomePage.html"></jsp:forward>
		<%
		}else{
			
				if (session.getAttribute("userRoleSession").equals("A")) {
					System.out.println("Add user Admin");
		%>
		<div id="leftcolumn">

			<a href="AdminHome.jsp">Admin Home</a> <a href="addQuestionForm.jsp">Add
				Question</a> <a href="addUserForm.jsp">Add User</a> <a
				href="takeTestHome.jsp">Take Test</a>

			<!-- end .sidebar1 -->
		</div>
		<%
			}else if (session.getAttribute("userRoleSession").equals("F")) {
				System.out.println("Add user Faculty");
		%>
		<div id="leftcolumn">

			<a href="facultyHome.jsp">Faculty Home</a> <a
				href="addQuestionForm.jsp">Add Question</a> <a
				href="takeTestHome.jsp">Take Test</a>

			<!-- end .sidebar1 -->
		</div>
		<%
			} else if (session.getAttribute("userRoleSession").equals("S")) {
		%>
		<div id="leftcolumn">

			<a href="takeTestHome.jsp">Take Test</a>

			<!-- end .sidebar1 -->
		</div>
		<%
			}
			} %>
		<div id="rightcolumn">


			<form action="addUser.jsp" id="AddUser" method="post">
				<table align="center" cellpadding="10" cellspacing="10">
					<tr>
						<td>User Name <span class="mandatory"> * </span></td>
						<td><input type="text" name="userName"></td>
					</tr>
					<tr>
						<td>User Role <span class="mandatory"> * </span></td>
						<td><select name="userRole">
								<option selected="selected">Select</option>
								<option value="A">Admin</option>
								<option value="F">Faculty</option>
								<option value="S">Student</option>
						</select></td>
					</tr>
					<tr>
						<td>Password<span class="mandatory"> * </span></td>
						<td><input type="password" name="password"></td>
					</tr>
					<tr>
						<td>E-Mail<span class="mandatory"> * </span></td>
						<td><input type="text" name="emailId"></td>
					</tr>

					<tr>
						<td>Phone Number</td>
						<td><input type="text" name="phoneNumber"></td>
					</tr>
					<tr>
						<td>Address</td>
						<td><input type="text" name="address"></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="text" name="address1"></td>
					</tr>
					<tr>
						<td align="center"><input type="submit" value="SUBMIT">
						</td>
						<td align="center"><input type="reset" name="RESET"
							style="width: 70px"></td>
					</tr>

				</table>

			</form>
		</div>
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