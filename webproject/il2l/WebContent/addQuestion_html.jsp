<!--
To change this template, choose Tools | Templates
and open the template in the editor.
-->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page import="java.util.Arrays"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.manteam.iwant2learn.controller.TrainingController"%>
<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<style type="text/css">
.hide {
	display: None;
	background-color: #C7FECA;
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
<style type="text/css">
#leftcolumn {
	float: left;
	width: 300px;
	height: 600px;
	border: 3px solid black;
	padding: 5px;
	padding-left: 8px;
}

#leftcolumn a {
	padding: 3px 1px;
	display: block;
	width: 100%;
	text-decoration: none;
	font-weight: bold;
	border-bottom: 1px solid gray;
}

#leftcolumn a:hover {
	background-color: #FFFF80;
}

#rightcolumn {
	float: left;
	width: 550px;
	min-height: 400px;
	border: 3px solid black;
	margin-left: 10px;
	padding: 5px;
	padding-bottom: 8px;
}

* html #rightcolumn { /*IE only style*/
	height: 400px;
}
</style>
</head>
<style>
body {
	font-size: 12px
}

.{
font-family








:arial








;
font-size:12px
}
h1 {
	cursor: hand;
	font-size: 16px;
	margin-left: 10px;
	line-height: 10px
}

xmp {
	color: green;
	font-size: 12px;
	margin: 0px;
	font-family: courier;
	background-color: #e6e6fa;
	padding: 2px
}
</style>

<script type="text/javascript">
	function fnGetSubModules(passValue) {
		url = "addQuestion_html.jsp?subject=" + passValue;
		document.location.href = url;
	}
</script>
</head>
<body>
	<div id="leftcolumn">
		<a href="addQuestion_html.jsp">Add Question</a>
	</div>
	<div id="rightcolumn">
		<form id="feedbackform" action="addQuestion.jsp"
			enctype="multipart/form-data" method="post">
			<div>
				Subject Name : <br /> <select name="subject"
					onchange="fnGetSubModules(this.document.forms[0].subject.value);">
					<option value="">-SELECT-</option>
					<%
						String sub = request.getParameter("subject");
						TrainingController controller = new TrainingController();
						HashMap<String, ArrayList<String>> ret = controller
								.retrieveAllSubjectsnSubmodules();
						Set<String> subs = ret.keySet();
						System.out.println(sub);
						if (sub == null || sub.equals("")) {

							Iterator<String> it = subs.iterator();
							while (it.hasNext()) {
								String temp = it.next();
					%>
					<option value="<%=temp%>"><%=temp%></option>
					<%
						}
					%>
				</select><br /> Sub-Module Name : <br /> <select name="submodule">
				<option value="">-SELECT-</option>
					<%
						} else {
							Iterator<String> it = subs.iterator();
							while (it.hasNext()) {
								String temp = it.next();
					%>
					<option value="<%=temp%>" selected="selected"><%=temp%></option>
					<%
						}
					%>
				</select><br /> Sub-Module Name : <br /> <select name="submodule" multiple="multiple">
					<%
						ArrayList<String> submods = ret.get(sub);
							for (String tempSubmod : submods) {
					%>
					<option value="<%=tempSubmod%>"><%=tempSubmod%></option>
					<%
						}
						}
					%>
				</select><br />
			</div>



			Appearance : <br /> <input type="checkbox" name="chk1" id="chk1"
				onClick="showhide(1);" value="1"> Appearance 1<br />
			<div id="div1" class="hide">
				Month & Year: <select name="month1">
					<option value="Jan">Jan</option>
					<option value="Feb">Feb</option>
					<option value="Mar">Mar</option>
					<option value="Apr">Apr</option>
					<option value="May">May</option>
					<option value="Jun">Jun</option>
					<option value="Jul">Jul</option>
					<option value="Aug">Aug</option>
					<option value="Sep">Sep</option>
					<option value="Oct">Oct</option>
					<option value="Nov">Nov</option>
					<option value="Dec">Dec</option>
				</select>&nbsp;&nbsp; <input type="text" name="year1" value="2001" size="5"
					maxlength="4" /> <br /> Marks : <input type="text" name="marks1"
					size="3" maxlength="2" />
			</div>
			<input type="checkbox" name="chk2" id="chk2" onClick="showhide(2);"
				value="2"> Appearance 2<br />
			<div id="div2" class="hide">
				Month & Year: <select name="month2">
					<option value="Jan">Jan</option>
					<option value="Feb">Feb</option>
					<option value="Mar">Mar</option>
					<option value="Apr">Apr</option>
					<option value="May">May</option>
					<option value="Jun">Jun</option>
					<option value="Jul">Jul</option>
					<option value="Aug">Aug</option>
					<option value="Sep">Sep</option>
					<option value="Oct">Oct</option>
					<option value="Nov">Nov</option>
					<option value="Dec">Dec</option>
				</select>&nbsp;&nbsp; <input type="text" name="year2" value="2001" size="5"
					maxlength="4" /> <br /> Marks : <input type="text" name="marks2"
					size="3" maxlength="2" />
			</div>
			<input type="checkbox" name="chk3" id="chk3" onClick="showhide(3);"
				value="3"> Appearance 3<br />
			<div id="div3" class="hide">
				Month & Year: <select name="month3">
					<option value="Jan">Jan</option>
					<option value="Feb">Feb</option>
					<option value="Mar">Mar</option>
					<option value="Apr">Apr</option>
					<option value="May">May</option>
					<option value="Jun">Jun</option>
					<option value="Jul">Jul</option>
					<option value="Aug">Aug</option>
					<option value="Sep">Sep</option>
					<option value="Oct">Oct</option>
					<option value="Nov">Nov</option>
					<option value="Dec">Dec</option>
				</select>&nbsp;&nbsp; <input type="text" name="year3" value="2001" size="5"
					maxlength="4" /> <br /> Marks : <input type="text" name="marks3"
					size="3" maxlength="2" />
			</div>
			<input type="checkbox" name="chk4" id="chk4" onClick="showhide(4);"
				value="4"> Appearance 4<br />
			<div id="div4" class="hide">
				Month & Year: <select name="month4">
					<option value="Jan">Jan</option>
					<option value="Feb">Feb</option>
					<option value="Mar">Mar</option>
					<option value="Apr">Apr</option>
					<option value="May">May</option>
					<option value="Jun">Jun</option>
					<option value="Jul">Jul</option>
					<option value="Aug">Aug</option>
					<option value="Sep">Sep</option>
					<option value="Oct">Oct</option>
					<option value="Nov">Nov</option>
					<option value="Dec">Dec</option>
				</select>&nbsp;&nbsp; <input type="text" name="year4" value="2001" size="5"
					maxlength="4" /> <br /> Marks : <input type="text" name="marks4"
					size="3" maxlength="2" />
			</div>
			<br /> Question : <br />
			<textarea style="width: 350px; height: 150px" name="question"></textarea>
			<br /> Question Image : <br /> <input type="file" name="quesUpload" />


			Answer : <br />
			<textarea style="width: 350px; height: 150px" name="answer"></textarea>
			<br /> Answer Image : <br /> <input type="file" name="ansUpload" /><br />
			<br /> <input type="submit" value="Upload Question" />
			&nbsp;&nbsp;&nbsp; <input type="reset" />


		</form>
	</div>
</body>
</html>
