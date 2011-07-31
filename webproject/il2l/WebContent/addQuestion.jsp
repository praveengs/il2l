<%@page import="javax.naming.InitialContext"%>
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
	import="com.manteam.iwant2learn.questions.exceptions.MaintainQuestionsException"%>
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
<title>Add Question Result</title>
<link href="adminPage.css" rel="stylesheet" type="text/css"></link>
<link href="addQForm.css" rel="stylesheet" type="text/css"></link>

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
				Test</a>

			<!-- end .sidebar1 -->
		</div>
		<%
			} else if (session.getAttribute("userRoleSession").equals("F")) {
				%>

		<div id="leftcolumn">

			<a href="facultyHome.jsp">Faculty Home</a> <a
				href="addKeywordForm.jsp">Add Keyword</a><a
				href="addQuestionForm.jsp">Add Question</a> <a
				href="takeTestHome.jsp">Take Test</a>

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

		<%      String subject = "";
                  String submod = "";
			        String[] keyWords;
                    String checkVal = "";
                    String date = "";
                    String questionString = "";
                    String answerString = "";
                    int questionImageLength = 0;
                    int answerImageLength = 0;

                    InitialContext initialContext = new javax.naming.InitialContext();  
                    String path = (String) initialContext.lookup("java:comp/env/tempFilePath");
                    MultipartRequest req = new MultipartRequest(request, path, "UTF-8");
                    subject = req.getParameter("subject");
                    submod = req.getParameter("submodule");
                    keyWords = req.getParameterValues("keywords");
                    System.out.println(Arrays.toString(keyWords));
                    checkVal = null;
                    date = "";

                    for (int i = 1; i <= 10; i++) {
                        checkVal = req.getParameter("chk" + i);
                        if (checkVal != null) {
                            date += req.getParameter("month" + i) + "-" + req.getParameter("year" + i) + "-" + req.getParameter("marks" + i) + ";";
                        }
                    }

                    questionString = req.getParameter("question");
                    answerString = req.getParameter("answer");

                    File quesIm = req.getFile("quesUpload");
                    File ansIm = req.getFile("ansUpload");
                    InputStream questImage = null;
                    InputStream answerImage = null;
                    if (quesIm != null && quesIm.isFile()) {
                        questImage = new FileInputStream(quesIm);
                        questionImageLength = (int)quesIm.length();
                    }
                    if (ansIm != null && ansIm.isFile()) {
                        answerImage = new FileInputStream(ansIm);
                        answerImageLength = (int)ansIm.length();
                    }

                    LogonAttributesVO logonAttributesVO = new LogonAttributesVO();
                    logonAttributesVO.setUserName((String)session.getAttribute("userName"));
                    logonAttributesVO.setUserRole((String)session.getAttribute("userRoleSession"));
                    
                    QuestionSaveVO question = new QuestionSaveVO();
                    question.setSubjectName(subject);
                    question.setSubmodule(submod);
                    if (keyWords != null) {
                    	question.setKeywords(getCollection(keyWords));
                    } else {
                    	question.setKeywords(null);
                    }
                    question.setQuestion(questionString);
                    question.setQuestionImage(questImage);
                    question.setQuestionImageLength(questionImageLength);
                    question.setAnswer(answerString);
                    question.setAnswerImageStream(answerImage);
                    question.setAnswerImageLength(answerImageLength);
                    question.setQuestionYearMarkString(date);

                    TrainingController training = new TrainingController();
                    try {
                        boolean ret = training.saveQuestionForSubmodules(logonAttributesVO, question);
                    } catch (SystemException se) {
                        out.println("<h2 color='red'>Encountered an exception.</h2><h3>Details : SystemException</h3>");
                        out.println(se.getMessage());

                    } catch (MaintainQuestionsException mqe) {
                        out.println("<h2 color='red'>Encountered an exception.</h2><h3>Details : MaintainQuestionsException</h3>");
                        out.println(mqe.getStackTrace().toString());
                    }
        %>
		<div id="rightcolumn">
			<h1>
				The question is uploaded. Click here to add the next question : <a
					href="addQuestionForm.jsp">Add Question</a>
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
</body>
</html>
