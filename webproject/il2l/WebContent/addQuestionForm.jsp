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
<%
	TrainingController controller = new TrainingController();
	/* HashMap<String, ArrayList<String>> subjectsnSubmodules = controller
			.retrieveAllSubjectsnSubmodules(); */
	HashMap<String, HashMap<String, ArrayList<String>>> subjectsnSubmodulesnKeywordsMap = controller
			.retrieveAllSubjectDetailsForAddQuestion();
	/* subjectsnSubmodulesnKeywordsMap.put("Chemistry", new HashMap<String, ArrayList<String>>(2));
	ArrayList<String> testKeyWords = new ArrayList<String>(2);
	testKeyWords.add("Test Keyword");
	testKeyWords.add("Test Keyword");
	subjectsnSubmodulesnKeywordsMap.get("Chemistry").put("TestSubmodule", testKeyWords); */
	//Set<String> subjects = subjectsnSubmodules.keySet();
	Set<String> subjects = subjectsnSubmodulesnKeywordsMap.keySet();
	Object[] subjectArray = subjects.toArray();
	//System.out.println("Subject selected is"+subjectArray[0].toString());
	/* Collection<String> submodules = subjectsnSubmodules
			.get(subjectArray[0]); */
	Collection<String> submodules = new ArrayList<String>(2);
	Collection<String> keyWords = new ArrayList<String>(2);
	String currentSubject = "";

	//System.out.println("Submodules are"+submodules);
%>
<body>
	<script type="text/javascript">
	
	var currSubjectKey;
	var submodulesArrayForKeyword;
	//var singleSubjctArrayForKeyword;
	//var keyWordsArray;
function populateSubmodulesCombo(key) {
	
	var submodulesArray = new Array();	
	var singleSubjectSubmodulesArray = new Array();
	var singleSubjctArrayForKeyword = new Array();
	//var submodulesArrayForKeyword = new Array();
	var keyWordsArray = new Array();
	submodulesArrayForKeyword = new Array();
	var i = 0;
	currSubjectKey = key;
	  //var currentSubject = (String)subjectArray[key];

	 // alert(key);
	  //Here goes the tricky part, we populate a two-dimensional javascript array with values from the map
	<%for (int i = 0; i < subjectArray.length; i++) {
				/* submodules = (ArrayList<String>) subjectsnSubmodules
						.get(subjectArray[i]); */
				String subject = (String) subjectArray[i];
				HashMap<String, ArrayList<String>> submoduleKeyWordMap = subjectsnSubmodulesnKeywordsMap
						.get(subjectArray[i]);
				submodules = submoduleKeyWordMap.keySet();%>			
	        singleSubjectSubmodulesArray = new Array();
	        singleSubjctArrayForKeyword = new Array();
	<%int j = 0;
				for (String submodule : submodules) {%>         
	 singleSubjectSubmodulesArray[<%=j%>] = "<%=submodule%>";
	 <%keyWords = submoduleKeyWordMap.get(submodule);
					int k = 0;
					//System.out.println("Got keywords "+keyWords+" for submodule "+submodule);%>
	 keyWordsArray = new Array();
	 <%for (String keyWord : keyWords) {%>
		 keyWordsArray[<%=k%>] = "<%=keyWord%>";
	<%k++;
					}%>
		singleSubjctArrayForKeyword[
	<%=j%>
		] = keyWordsArray;
	<%j++;
				}%>
		submodulesArray[
	<%=i%>
		] = singleSubjectSubmodulesArray;
			submodulesArrayForKeyword[
	<%=i%>
		] = singleSubjctArrayForKeyword;
	<%}%>
		var submodulesList = document.getElementById("submodulesList");

			//alert(submodulesList);
			//Empty the second combo
			while (submodulesList.hasChildNodes()) {
				submodulesList.removeChild(submodulesList.childNodes[0]);
			}

			var keywordsList = document.getElementById("keywordsList");
			while (keywordsList.hasChildNodes()) {
				keywordsList.removeChild(keywordsList.childNodes[0]);
			}
			keywordsList.options[0] = new Option("-SELECT-", "-SELECT-");

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

		function populateKeyWordsCombo(submoduleKey) {
			//alert("Submodule Key"+submoduleKey);
			//alert("Subject Key: "+currSubjectKey);
			var keywordsList = document.getElementById("keywordsList");
			while (keywordsList.hasChildNodes()) {
				keywordsList.removeChild(keywordsList.childNodes[0]);
			}
			var i = 0;
			if (submoduleKey == -1) {
				keywordsList.options[0] = new Option("-SELECT-", "-SELECT-");
			} else {
				//alert("In here");
				//alert("Current Subject Array"+submodulesArrayForKeyword[currSubjectKey][submoduleKey]);
				//alert((submodulesArrayForKeyword[currSubjectKey][submoduleKey]).length);
				if ((submodulesArrayForKeyword[currSubjectKey][submoduleKey]).length > 0
						&& (submodulesArrayForKeyword[currSubjectKey][submoduleKey][0]) != "null") {
					for (i = 0; i < (submodulesArrayForKeyword[currSubjectKey][submoduleKey]).length; i++) {
						keywordsList.options[i] = new Option(
								submodulesArrayForKeyword[currSubjectKey][submoduleKey][i],
								submodulesArrayForKeyword[currSubjectKey][submoduleKey][i]);
					}
				}
			}
		}
	</script>
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
			if (request == null || request.getSession(false) == null
					|| session.getAttribute("userRoleSession") == null) {
				System.out.println("Hey if");
				out.println("<h2><span class='mandatory'>Please login !!</span></h2>");
		%>
		<jsp:forward page="HomePage.html"></jsp:forward>
		<%
			} else {
				if (session.getAttribute("userRoleSession").equals("A")) {
		%>
		<div id="leftcolumn">

			<a href="AdminHome.jsp">Admin Home</a> <a href="addQuestionForm.jsp">Add
				Question</a> <a href="addUserForm.jsp">Add User</a> <a
				href="takeTestHome.jsp">Take Test</a>

			<!-- end .sidebar1 -->
		</div>
		<%
			} else if (session.getAttribute("userRoleSession").equals("F")) {
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

			}
		%>


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
						</select>
						</td>
					</tr>
					<tr>
						<td>Sub-Module Name</td>
						<td><select
							onchange="populateKeyWordsCombo(this.options[this.selectedIndex].index-1);"
							id="submodulesList" name="submodule">
								<option value="">-SELECT-</option>
						</select>
						</td>
					</tr>
					<tr>
						<td>Keywords</td>
						<td><select id="keywordsList" name="keywords"
							multiple="multiple">
								<option value="">-SELECT-</option>
						</select>
						</td>
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
												size="5" maxlength="4" /> <br /> Marks : <input
												type="text" name="marks3" size="3" maxlength="2" />
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
													size="5" maxlength="4" /> <br /> Marks : <input
													type="text" name="marks4" size="3" maxlength="2" />
											</div>
						</td>
					</tr>
					<tr>
						<td>Question</td>
						<td><textarea style="width: 350px; height: 150px"
								name="question"></textarea>
						</td>
					</tr>
					<tr>
						<td>Question Image</td>
						<td><input type="file" name="quesUpload" />
						</td>
					</tr>
					<tr>
						<td>Answer</td>
						<td><textarea style="width: 350px; height: 150px"
								name="answer"></textarea>
						</td>
					</tr>
					<tr>
						<td>Answer Image</td>
						<td><input type="file" name="ansUpload" />
						</td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="Upload Question" />
							&nbsp;&nbsp;&nbsp; <input type="reset" />
						</td>
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