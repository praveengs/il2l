<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Add Question Form</title>
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
				`
				<!-- end .header -->
			</table>
			<!-- end .header -->
		</div>
		<%
			if (request == null || request.getSession(false) == null
					|| session.getAttribute("userRoleSession") == null) {
				System.out.println("Hey if");
				System.out.println("<h2><span class='mandatory'>Please login !!</span></h2>");
		%>
		<jsp:forward page="HomePage.html"></jsp:forward>
		
		<%
			}else{
				out.println("logged out!!");
				session.invalidate();
				
			}%>
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