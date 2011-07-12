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
		<div id="leftcolumn">

			<a href="AdminHome.jsp">Admin Home</a> 
			<a href="addQuestionForm.jsp">Add Question</a> 
			<a href="addUserForm.jsp">Add User</a> 
			<a href="takeTestHome.jsp">Take Test</a>

			<!-- end .sidebar1 -->
		</div>
		<%! Collection<String> getSubmodules(String[] split) {
  Collection<String> submodules = new ArrayList<String>(split.length);
  for (String submodule : split) {
   submodules.add(submodule);
  }
  return submodules;
 } %>

		<%
                    String subject = "";
                   
                    String[] submod;
                    String checkVal = "";
                    String date = "";
                    String questionString = "";
                    String answerString = "";

                    MultipartRequest req = new MultipartRequest(request, "../");
                    subject = req.getParameter("subject");
                    submod = req.getParameterValues("submodule");
                    System.out.println(Arrays.toString(submod));
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
                    }
                    if (ansIm != null && ansIm.isFile()) {
                        answerImage = new FileInputStream(ansIm);
                    }

                    LogonAttributesVO logonAttributesVO = new LogonAttributesVO();
                    logonAttributesVO.setUserName("WebUser");
                    logonAttributesVO.setUserRole("Faculty");
                    
                    QuestionSaveVO question = new QuestionSaveVO();

                    //ExamQuestionsVO question = new ExamQuestionsVO();
                    question.setSubjectName(subject);
                    //question.setModuleName(module);
                    //question.setSubmoduleName(submod);
                    question.setSubmodules(getSubmodules(submod));
                    question.setQuestion(questionString);
                    question.setQuestionImage(questImage);
                    question.setAnswer(answerString);
                    question.setAnswerImageStream(answerImage);
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
//                     ExamQuestionsVO question = new ExamQuestionsVO();
//                     question.setSubjectName(subject);
                    
                   // question.setSubmoduleName(submod);
//                     question.setQuestion(questionString);
//                     question.setQuestionImage(questImage);
//                     question.setAnswer(answerString);
//                     question.setAnswerImageStream(answerImage);
//                     question.setQuestionYearMarkString(date);

                    //TrainingController training = new TrainingController();
//                     try {
//                         boolean ret = training.saveQuestion(question);
//                     } catch (SystemException se) {
//                         out.println("<h2 color='red'>Encountered an exception.</h2><h3>Details : SystemException</h3>");
//                         out.println(se.getMessage());

//                     } catch (MaintainQuestionsException mqe) {
//                         out.println("<h2 color='red'>Encountered an exception.</h2><h3>Details : MaintainQuestionsException</h3>");
//                         out.println(mqe.getStackTrace().toString());
//                     }
        %>
		<div id="rightcolumn">
			<h1>
				The question is uploaded. Click here to add the next question : <a
					href="addQuestionForm.jsp">Add Question</a>
			</h1>
		</div>
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
