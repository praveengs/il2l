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
			<p>
		        <i>i</i>
		        -like2Learn is a system that facilitates and enables the training of students for A-Level subjects based on previous years question paper. This
		        learning system is driven by keywords and categorization of pervious years questions to the underlined subject. This would help students understand the
		        important topics and the frequency of questions on a particular topic in the previous year question papers.
		        <p>
		        </p>
		    </p>
		    <p>
		    </p>
		    <p>
		        The system is designed to be used by the students and the faculties. The students can select the subject and specify their interest of study. Once in
		        the system the students are enlightened by flurry of questions under the section of their choice. Every question specifies the important keywords
		        associated and enables students a chance to learn more about a particular topic by the underlined links to the keywords.
		        <p>
		        </p>
		    </p>
		    <p>
		        On the other hand with administrative privilege, the faculties can enter questions specifying the category and highlighting the important keywords.
		        Also the faculties can enter further description relating to the keywords associated with a question. Here the faculties specify the year of occurrence
		        of the question in previous year question papers which drives the frequency of each question and lets student understand the importance of the
		        question.
		    </p>
		    <br/>
			

			<!-- end .content -->
		</div>
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
