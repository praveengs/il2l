<%@page import="javax.naming.InitialContext"%>
<%@page import="com.manteam.iwant2learn.keywords.vo.KeyWordSaveVO"%>
<%@ page language="java" session="true"%>
<%@ page isErrorPage="true"%>
<%--
    Document   : addQuestion
    Created on : Jul 3, 2011, 8:07:16 PM
    Author     : Narayanan
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Collection"%>
<%@page import="com.manteam.iwant2learn.questions.vo.QuestionSaveVO"%>
<%@page import="com.manteam.iwant2learn.user.vo.LogonAttributesVO"%>
<%@page import="java.util.Arrays"%>
<%@page
	import="com.manteam.iwant2learn.keywords.exceptions.MaintainKeyWordsException"%>
<%@page import="com.manteam.framework.exceptions.SystemException"%>
<%@page import="com.manteam.iwant2learn.controller.TrainingController"%>
<%@page import="com.manteam.iwant2learn.vo.ExamQuestionsVO"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="java.io.IOException"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.List"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Keyword Result</title>
<link href="adminPage.css" rel="stylesheet" type="text/css"></link>
<link href="addQForm.css" rel="stylesheet" type="text/css"></link>

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
				Test</a><a href="logOff.jsp">Log Out</a>

			<!-- end .sidebar1 -->
		</div>
		<%
			} else if (session.getAttribute("userRoleSession").equals("F")) {
				%>

		<div id="leftcolumn">

			<a href="facultyHome.jsp">Faculty Home</a> <a
				href="addKeywordForm.jsp">Add Keyword</a><a
				href="addQuestionForm.jsp">Add Question</a> <a
				href="takeTestHome.jsp">Take Test</a><a href="logOff.jsp">Log Out</a>

			<!-- end .sidebar1 -->
		</div>
		<%
			}
		%>
		<%! Collection<String> getCollection(String[] split) {
			  Collection<String> collection = new ArrayList<String>(split.length);
			  for (String splitString : split) {
				  collection.add(splitString);
			  }
			  return collection;
 			} %>

		<%
                    String subject = "";
                   
					//String[] submod;
			        String submod = "";
			        
                   // String checkVal = "";
                    //String date = "";
                    String keyword = "";
                    String keywordDescription = "";
                    int keywordImageLength = 0;
                    //int answerImageLength = 0;
                    InitialContext initialContext = new javax.naming.InitialContext();  
                    String path = (String) initialContext.lookup("java:comp/env/tempFilePath");

                    MultipartRequest req = new MultipartRequest(request, path, "UTF-8");
                    subject = req.getParameter("subject");
                    //submod = req.getParameterValues("submodule");
                    submod = req.getParameter("submodule");
                    //System.out.println(Arrays.toString(submod));
                    keyword = req.getParameter("keyword");
                    keywordDescription = req.getParameter("keywordDescription");
                    File keywordIm = req.getFile("keywordUploadImage");
                    InputStream keywordImage = null;
                     if (keywordIm != null && keywordIm.isFile()) {
                    	 keywordImage = new FileInputStream(keywordIm);
                        keywordImageLength = (int)keywordIm.length();
                    }
                    

                    LogonAttributesVO logonAttributesVO = new LogonAttributesVO();
                    logonAttributesVO.setUserName((String)session.getAttribute("userName"));
                    logonAttributesVO.setUserRole((String)session.getAttribute("userRoleSession"));
                    
                    
                    KeyWordSaveVO keywordVO = new KeyWordSaveVO();
					keywordVO.setSubjectName(subject);
					keywordVO.setSubmoduleName(submod);
					keywordVO.setKeywordName(keyword);
					keywordVO.setKeyWordDescription(keywordDescription);
					keywordVO.setKeyWordImageLength(keywordImageLength);
					keywordVO.setKeywordImageStream(keywordImage);
				     TrainingController training = new TrainingController();
                        int ret = training.saveKeyword(logonAttributesVO, keywordVO);
                         %>
		<div id="rightcolumn">
			<h1>
				The keyword is uploaded. Click here to add the next keyword : <a
					href="addKeywordForm.jsp">Add Keyword</a>
			</h1>
		</div>
		<%
				}
				if((!session.getAttribute("userRoleSession").equals("F"))&&(!session.getAttribute("userRoleSession").equals("A"))){
					%>
		<jsp:forward page="index.jsp">
			<jsp:param
				value="Kindly login first as Administrator/Faculty to view this page"
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
