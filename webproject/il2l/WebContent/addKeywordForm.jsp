<%@ page language="java" session="true"%>
<%@ page errorPage="errorPage.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="java.util.Collection"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.manteam.iwant2learn.controller.TrainingController"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="multipart/form-data; charset=iso-8859-1" />
<title>Add Keyword Form</title>
<link href="adminPage.css" rel="stylesheet" type="text/css"></link>
<style type="text/css">
.hide {
	display: None;
	background-color: #C7FECA;
}
/* ~~ The footer ~~ */
.footer {
	padding: 0;
	height: 40px;
	position: fixed;
	bottom: 0px;
	left: 0px;
	width: 100%;
	clear: both;
	/* this clear property forces the .container to understand where the columns end and contain them */
	background-image: url(images/bg2.gif);
}
</style>
<script language="JavaScript">
	function showhide(val) {
		var checkbox = "chk" + val;
		var d = "div" + val;
		if (document.getElementById(checkbox).checked == true) {
			document.getElementById(d).style.display = "block";
		} else {
			document.getElementById(d).style.display = "none";
		}
	}
</script>
<link href="addQForm.css" rel="stylesheet" type="text/css" />


</head>
<%
	TrainingController controller = new TrainingController();
			HashMap<String, ArrayList<String>> subjectsnSubmodulesMap = controller
			.retrieveAllSubjectsnSubmodules();
	Set<String> subjects = subjectsnSubmodulesMap.keySet();
	Object[] subjectArray = subjects.toArray();
	Collection<String> submodules = new ArrayList<String>(2);	
	String currentSubject = "";
%>
<body>
	<script type="text/javascript">
function populateSubmodulesCombo(key) {
	var submodulesArray = new Array();	
	var singleSubjectSubmodulesArray = new Array();
	var i = 0;
	  //Here goes the tricky part, we populate a two-dimensional javascript array with values from the map
	<%for (int i = 0; i < subjectArray.length; i++) {
				String subject = (String) subjectArray[i];				
				submodules = subjectsnSubmodulesMap
						.get(subjectArray[i]);%>			
	        singleSubjectSubmodulesArray = new Array();	        
	<%int j = 0;
				for (String submodule : submodules) {%>         
	 singleSubjectSubmodulesArray[<%=j%>] = "<%=submodule%>";	 
	<%j++;
				}%>
		submodulesArray[
	<%=i%>
		] = singleSubjectSubmodulesArray;
			
	<%}%>
		var submodulesList = document.getElementById("submodulesList");
			//Empty the second combo
			while (submodulesList.hasChildNodes()) {
				submodulesList.removeChild(submodulesList.childNodes[0]);
			}
			
			if (key == -1) {
				submodulesList.options[0] = new Option("-SELECT-", "-SELECT-");
			} else {
				//Populate the second combo with new values
				submodulesList.options[0] = new Option("-SELECT-", "-SELECT-");
				for (i = 1; i < submodulesArray[key].length + 1; i++) {
					submodulesList.options[i] = new Option(
							submodulesArray[key][i - 1],
							submodulesArray[key][i - 1]);
				}
			}
		}
		
	</script>
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

					<a href="facultyHome.jsp">Faculty Home</a> <a href="addKeywordForm.jsp">Add Keyword</a><a href="addQuestionForm.jsp">Add
						Question</a> <a href="takeTestHome.jsp">Take Test</a><a href="logOff.jsp">Log Off</a>

					<!-- end .sidebar1 -->
				</div>
				<%
			}
		%>


		<div id="rightcolumn">
			<form id="keywordForm" action="addKeyword.jsp" enctype="multipart/form-data" method="post">
				<table>
					<tr>
						<td>Subject Name</td>
						<td><select
							onchange="populateSubmodulesCombo(this.options[this.selectedIndex].index-1);"
							id="subjectList" name="subject">

								<option value="">-SELECT-</option>
								<%
									for (String subject : subjects) {
								%>
								<option value="<%=subject%>"><%=subject%></option>
								<%
									}
								%>
						</select></td>
					</tr>
					<tr>
						<td>Sub-Module Name</td>
						<td><select id="submodulesList" name="submodule">
								<option value="">-SELECT-</option>

						</select></td>
					</tr>
					<tr>
						<td>Keywords</td>
						<td><input type="text" name="keyword" /></td>
					</tr>

					<tr>
						<td>Keyword Description</td>
						<td><textarea name="keywordDescription"></textarea></td>
					</tr>
					<tr>
						<td>Keyword Image</td>
						<td><input type="file" name="keywordUploadImage" /></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="Add Keyword" />
							&nbsp;&nbsp;&nbsp; <input type="reset" /></td>
					</tr>
				</table>
			</form>
		</div>
		<%
				}
				if((!session.getAttribute("userRoleSession").equals("F"))&&(!session.getAttribute("userRoleSession").equals("A"))){
					%>
					<jsp:forward page="index.jsp">
						<jsp:param value="Kindly login first as Administrator/Faculty to view this page" name="FailReason" />
					</jsp:forward>
					<%
				}

		%>
		<div class="footer" align="center">

			<i style="color: #999; font-size: 15px"><b>@ManTeam</b> </i> <br />
			<!-- <b style="color: #999; font-size: 15px">The University of
				Manchester</b> -->

			<!-- end .footer -->
		</div>
		<!-- end .container -->
	</div>
</body>
</html>