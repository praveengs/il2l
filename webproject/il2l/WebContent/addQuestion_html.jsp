<!--
To change this template, choose Tools | Templates
and open the template in the editor.
-->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page import="java.util.Collection"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.manteam.iwant2learn.controller.TrainingController;"%>
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
	height: 800px;
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
	height: 800px;
	border: 3px solid black;
	margin-left: 10px;
	padding: 5px;
	padding-bottom: 8px;
	overflow: scroll;
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
font-size


:


12
px
;




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

</head>
<%
	TrainingController controller = new TrainingController();
	HashMap<String, ArrayList<String>> subjectsnSubmodules = controller
			.retrieveAllSubjectsnSubmodules();
	Set<String> subjects = subjectsnSubmodules.keySet();
	Object[] subjectArray = subjects.toArray();
	//System.out.println("Subject selected is"+subjectArray[0].toString());
	/* Collection<String> submodules = subjectsnSubmodules
			.get(subjectArray[0]); */
	Collection<String> submodules = new ArrayList<String>(2);
	//System.out.println("Submodules are"+submodules);
%>
<body>
	<script type="text/javascript">
function populateSubmodulesCombo(key) {
	
	  var submodulesArray = new Array();
	  var singleSubjectSubmodulesArray = new Array();
	  var i = 0;

	 // alert(key);
	  //Here goes the tricky part, we populate a two-dimensional javascript array with values from the map
	<%for (int i = 0; i < subjectArray.length; i++) {

				submodules = (ArrayList<String>) subjectsnSubmodules
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

			//alert(submodulesList);
			//Empty the second combo
			while (submodulesList.hasChildNodes()) {
				submodulesList.removeChild(submodulesList.childNodes[0]);
			}

			//Populate the second combo with new values
			for (i = 0; i < submodulesArray[key].length; i++) {
				submodulesList.options[i] = new Option(submodulesArray[key][i],
						submodulesArray[key][i]);
			}
		}
	</script>
	<div id="leftcolumn">
		<a href="addQuestion_html.jsp">Add Question</a>
	</div>
	<div id="rightcolumn">
		<form id="feedbackform" action="addQuestion.jsp"
			enctype="multipart/form-data" method="post">
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
					<td><select id="submodulesList" name="keywords"
						multiple="multiple">
							<option value="">-SELECT-</option>
							<option>displacement</option>
							<option>speed</option>
							<option>velocity</option>
							<option>acceleration</option>
							<option>Velocity-time graph</option>
							<option>Displacement-time graph</option>
							<option>slope</option>
							<option>uniformly</option>
							<option>air resistance</option>
							<option>weight</option>
							<option>free fall</option>
					</select></td>
				</tr>
				<tr>
					<td>Appearance</td>
					<td><input type="checkbox" name="chk1" id="chk1"
						onClick="showhide(1);" value="1"> Appearance 1 <br />
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
							</select>&nbsp;&nbsp; <input type="text" name="year1" value="2001"
								size="5" maxlength="4" /> <br /> Marks : <input type="text"
								name="marks1" size="3" maxlength="2" />
						</div> <input type="checkbox" name="chk2" id="chk2"
						onClick="showhide(2);" value="2"> Appearance 2 <br />
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
							</select>&nbsp;&nbsp; <input type="text" name="year2" value="2001"
								size="5" maxlength="4" /> <br /> Marks : <input type="text"
								name="marks2" size="3" maxlength="2" />
						</div> <input type="checkbox" name="chk3" id="chk3"
						onClick="showhide(3);" value="3"> Appearance 3 <br />
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
							</select>&nbsp;&nbsp; <input type="text" name="year3" value="2001"
								size="5" maxlength="4" /> <br /> Marks : <input type="text"
								name="marks3" size="3" maxlength="2" />
						</div> <input type="checkbox" name="chk4" id="chk4"
						onClick="showhide(4);" value="4"> Appearance 4 <br />
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
							</select>&nbsp;&nbsp; <input type="text" name="year4" value="2001"
								size="5" maxlength="4" /> <br /> Marks : <input type="text"
								name="marks4" size="3" maxlength="2" />
						</div></td>
				</tr>
				<tr>
					<td>Question</td>
					<td><textarea style="width: 350px; height: 150px"
							name="question"></textarea></td>
				</tr>
				<tr>
					<td>Question Image</td>
					<td><input type="file" name="quesUpload" /></td>
				</tr>
				<tr>
					<td>Answer</td>
					<td><textarea style="width: 350px; height: 150px"
							name="answer"></textarea></td>
				</tr>
				<tr>
					<td>Answer Image</td>
					<td><input type="file" name="ansUpload" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Upload Question" />
						&nbsp;&nbsp;&nbsp; <input type="reset" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
