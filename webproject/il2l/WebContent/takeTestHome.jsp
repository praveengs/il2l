<%@ page language="java" session="true"%>
<%@ page errorPage="errorPage.jsp"%>
<%@page import="java.util.Collection"%>
<%@page import="com.manteam.iwant2learn.controller.TrainingController"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Take Test Home</title>
<link href="adminPage.css" rel="stylesheet" type="text/css"></link>
<link href="addQForm.css" rel="stylesheet" type="text/css"></link>
<script>
	function fnOpen(subjectName) {
	window.open(href = 'training.jsp?subject=' + subjectName,'Start_Training',
						'scrollbars=yes, toolbar=no, menubar=no, addressbar=no, type=fullWindow,fullscreen');
		//}
	}
</script>
</head>
<body>
	<%
		TrainingController trainingController = new TrainingController();
		Collection<String> subjects = trainingController.retrieveAllSubjects();
	%>


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
			} else if (session.getAttribute("userRoleSession").equals("F")) {
				%>

		<div id="leftcolumn">

			<a href="facultyHome.jsp">Faculty Home</a> <a
				href="addKeywordForm.jsp">Add Keyword</a><a
				href="addQuestionForm.jsp">Add Question</a> <a
				href="takeTestHome.jsp">Take Test</a><a href="logOff.jsp">Log Off</a>

			<!-- end .sidebar1 -->
		</div>
		<%
			} else if (session.getAttribute("userRoleSession").equals("S")) {
		%>
		<div id="leftcolumn">

			<a href="#">Take Test</a><a href="logOff.jsp">Log Off</a>

			<!-- end .sidebar1 -->
		</div>
		<%
			}
		%>
		<form name='subjectform' action="training.jsp" method="GET">

			<div id="rightcolumn">
				<center>
					<h1>SELECT SUBJECT</h1>
					<select name="subjectName" id="subject">
						<option value="">SELECT</option>
						<%
							for (String subject : subjects) {
						%>
						<option value=<%=subject%>><%=subject%></option>
						<%
							}
						%>
						<!-- <option value="Physics">Physics</option>
						<option value="Chemistry">Chemistry</option> -->
					</select> <br /> <br /> <input type="button" value="Start the Subject"
						onclick="javascript:fnOpen(document.subjectform.subjectName.options[document.subjectform.subjectName.selectedIndex].value);" />
				</center>
			</div>

		</form>
		<%
				}
				if((!session.getAttribute("userRoleSession").equals("F"))&&(!session.getAttribute("userRoleSession").equals("A"))&&(!session.getAttribute("userRoleSession").equals("S"))){
					%>
		<jsp:forward page="index.jsp">
			<jsp:param
				value="Kindly login first as Administrator/Faculty/Student to view this page"
				name="FailReason" />
		</jsp:forward>
		<%
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
	</div>
</body>
</html>