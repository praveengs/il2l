<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@page import="java.io.FileWriter"%>
<%@page import="java.io.BufferedWriter"%>
<%@page import="java.io.File"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.manteam.iwant2learn.controller.TrainingController"%>
<link rel="stylesheet" type="text/css" href="final.css" />
<link href="adminPage.css" rel="stylesheet" type="text/css"></link>
<link href="addQForm.css" rel="stylesheet" type="text/css"></link>
<title>Training</title>
<script type="text/javascript">
/***********************************************
* Dynamic Ajax Content- © Dynamic Drive DHTML code library (www.dynamicdrive.com)
* This notice MUST stay intact for legal use
* Visit Dynamic Drive at http://www.dynamicdrive.com/ for full source code
***********************************************/
var finalURL;
var finalRet;
var loadedobjects=""
var rootdomain="http://"+window.location.hostname

function ajaxpage(url, containerid,ret){
 finalURL=url;
 finalRet=ret;
start="SUB_Physics";
url=url+'?selection='+start+','+ret;
document.getElementById("trainingFrame").src=url;
window.frames[1].document.getElementById("prevButton").disabled=true;
}

function ajaxTree(val){
	treeURL=document.getElementById("treeViewFrame").src;
	temporaryURL=treeURL.substring(0,treeURL.indexOf('?'));
	if(temporaryURL==''){
		treeURL=treeURL+'?keywords='+val;
	}else{
		treeURL=temporaryURL+'?keywords='+val;
	}
	document.getElementById("treeViewFrame").src=treeURL;
	if(val=='all'){
		document.getElementsByName('searchKeyword')[0].value=document.getElementsByName('searchKeyword')[0].defaultValue;
	}
}

function loadpage(page_request, containerid){
if (page_request.readyState == 4 && (page_request.status==200 || window.location.href.indexOf("http")==-1))
document.getElementById(containerid).innerHTML=page_request.responseText
}

function loadobjs(){
if (!document.getElementById)
return
for (i=0; i<arguments.length; i++){
var file=arguments[i]
var fileref=""
if (loadedobjects.indexOf(file)==-1){ //Check to see if this object has not already been added to page before proceeding
if (file.indexOf(".js")!=-1){ //If object is a js file
fileref=document.createElement('script')
fileref.setAttribute("type","text/javascript");
fileref.setAttribute("src", file);
}
else if (file.indexOf(".css")!=-1){ //If object is a css file
fileref=document.createElement("link")
fileref.setAttribute("rel", "stylesheet");
fileref.setAttribute("type", "text/css");
fileref.setAttribute("href", file);
}
}
if (fileref!=""){
document.getElementsByTagName("head").item(0).appendChild(fileref)
loadedobjects+=file+" " //Remember this object as being already added to page
}
}
}

function toggleLayer(whichLayer) {
 alert(document.getElementById(whichLayer).style.visibility); 
}

</script>
<script type="text/javascript">
function fnGetNextQn(location,max){
	
 currentUrl=null;
 location=location+1;
 currentUrl=document.getElementById("trainingFrame").src;
 
 tempUrl=currentUrl.substring(0,currentUrl.indexOf('&'))
 
 if(tempUrl==''){
  modifiedUrl=currentUrl+'&question='+location;
 }else{
  modifiedUrl=tempUrl+'&question='+location;
 }
 if(location>=(max-1)){
	 window.frames[1].document.getElementById("nextButton").disabled=true;
 }else{
 document.getElementById("trainingFrame").src=modifiedUrl; 
 }
 
}

function fnGetPrevQn(location){
 currentUrl=null;
 location=location-1;
 currentUrl=document.getElementById("trainingFrame").src;
 
 tempUrl=currentUrl.substring(0,currentUrl.indexOf('&'))
 
 if(tempUrl==''){
  modifiedUrl=currentUrl+'&question='+location;
 }else{
  modifiedUrl=tempUrl+'&question='+location;
 }
 if(location<0){
	 window.frames[1].document.getElementById("prevButton").disabled=true;
 }else{
 document.getElementById("trainingFrame").src=modifiedUrl; 
 }
}

function fnHide(){
	if(window.frames[1].document.getElementById('answer').style.visibility=='hidden'){
		window.frames[1].document.getElementById('answer').style.visibility='visible';
	}
	else{
		window.frames[1].document.getElementById('answer').style.visibility='hidden';
		}
}
</script>
<style type="text/css">
.iframepadding {
	padding: 0px;
	margin: 0px;
	border:0px;
}
</style>
<style type="text/css">
.pageSidebar1 {
	float: left;
	width: 320px;
	height: 800px;
	background: #D5E0FF;
	padding-bottom: 10px;
	height: 800px;
	/*border: 3px solid black;*/
	padding: 5px;
	padding-left: 8px;
	overflow: auto;
}

.pageContent {
	padding: 0px 0;
	width: 800px;
	height: 800px;
	float: left;
	/*border: 3px solid black;*/
	margin-left: 0px;
	padding: 5px;
	padding-bottom: 8px;
	overflow: auto;
}

.pageSidebar2 {
	float: left;
	background: #D5E0FF;
	padding: 0px 0;
	height: 800px;
	width: 180px;
	/*border: 3px solid black;*/
	margin-left: 0px;
	padding: 5px;
	padding-bottom: 8px;
	overflow: auto;
}
</style>
<!-- Keyword tag cloud animation script starts -->
<script src="jquery-1.6.2.js" type="text/javascript"></script>
<script type="text/javascript" src="jquery.easing.1.3.js"></script>
<script type="text/javascript" src="jquery.tagcloud.min.js"></script>
<style type="text/css">
a {
	text-decoration: none;
}

a:hover {
	background-color: #0000FF;
	color: #FFFFFF;
}

#tag-cloud {
	position: relative;
	top: 10px;
	left: 10px;
	height: 500px;
	width: 150px;
	border: 1px solid blue;
	overflow: hidden;
	margin-bottom: 40px;
}
</style>
<script type="text/javascript">
	$(function() {
		$("#tag-cloud").tagCloud({"direction":"vertical", "easein":"easeOutBack", "speed":5000});
	});
</script>
<!-- Keyword cloud animation script ends -->
</head>
<style>
body {
	font-size: 12px
}

.{
font-family:arial;
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
		<%!String sub;%>
		<%
			sub = request.getParameter("subject");
			if (sub == null || sub.equalsIgnoreCase("")) {
		%>
		<div class="pageSidebar1"></div>
		<div class="pageContent" style="width: 800px; height: 765px">
			<h2 style="color: red;">Please select a subject before
				attempting to take test</h2>
			<h3>
				<a href="takeTestHome.jsp">Click here to return to selection
					page</a>
			</h3>
		</div>
		<div class="pageSidebar2"></div>
		<%
			} else {
				session.setAttribute("subject", sub);
		%>
		<div class="pageSidebar1">
			<iframe src="treeView.jsp" id="treeViewFrame" width="320px" height="800px" class="iframepadding"></iframe>
		</div>
		<div class="pageContent">
			<iframe src="takeTest.jsp" width="800px" height="800px"
				id="trainingFrame" class="iframepadding"></iframe>
		</div>
		<div class="pageSidebar2">
			<h3>Keyword Search</h3>
			
				<input type="text"
					value="type a keyword from below list to search"
					name="searchKeyword"
					onfocus="if(this.value == this.defaultValue) this.value=''" /> <input
					type="submit" value="Search" onclick="javascript:ajaxTree(document.getElementsByName('searchKeyword')[0].value);"/> &nbsp;&nbsp;&nbsp;<input
					type="reset" value="Get all questions" onclick="javascript:ajaxTree('all');"/>
			
			<br /> <br />

			<%
				System.out.println(sub);
					TrainingController controller = new TrainingController();
					Collection<String> keys = controller
							.retrieveKeyWordsForSubject(sub);
					if (keys == null || keys.isEmpty()) {
			%>
		</div>
		<%
			} else {
		%>
		<h4>Select from the following keywords</h4>
		<ul id="tag-cloud">
			<%
				Iterator<String> it = keys.iterator();
						while (it.hasNext()) {
			%>
			<li><%=it.next()%></li>
			<%
				}
			%>
		</ul>
		<%
			}
		%>
	</div>
	<div style="clear: left; margin-bottom: 1em"></div>
	<%
		}
	%>
	<div class="footer" align="center">

		<i style="color: #999; font-size: 15px"><b>@ManTeam</b> </i> <br /> <b
			style="color: #999; font-size: 15px">The University of Manchester</b>

		<!-- end .footer -->
	</div>
	<!-- end .container -->
	</div>
</body>
</html>