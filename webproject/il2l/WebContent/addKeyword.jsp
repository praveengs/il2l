<%@page import="com.manteam.iwant2learn.keywords.vo.KeyWordSaveVO"%>
<%@ page language="java" session="true" %>
<%@ page isErrorPage="true" %>
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

			<a href="AdminHome.jsp">Admin Home</a><a href="addKeyword.jsp">Add
				Keyword</a>  <a href="addQuestionForm.jsp">Add
				Question</a> <a href="addUserForm.jsp">Add User</a> <a href="takeTestHome.jsp">Take
				Test</a>

			<!-- end .sidebar1 -->
		</div>
		<%
			}else if (session.getAttribute("userRoleSession").equals("F")) {
		%>
		<div id="leftcolumn">

			<a href="facultyHome.jsp">Faculty Home</a><a href="addKeyword.jsp">Add
				Keyword</a>  <a
				href="addQuestionFoem.jsp">Add Question</a> <a
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

                    MultipartRequest req = new MultipartRequest(request, "/", "UTF-8");
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
                    logonAttributesVO.setUserName("WebUser");
                    logonAttributesVO.setUserRole("Faculty");
                    
                    
                    KeyWordSaveVO keywordVO = new KeyWordSaveVO();
					keywordVO.setSubjectName(subject);
					keywordVO.setSubmoduleName(submod);
					keywordVO.setKeywordName(keyword);
					keywordVO.setKeyWordDescription(keywordDescription);
					keywordVO.setKeyWordImageLength(keywordImageLength);
					keywordVO.setKeywordImageStream(keywordImage);
					
                    //ExamQuestionsVO question = new ExamQuestionsVO();
                    
                  
                    TrainingController training = new TrainingController();
                    try {
                        int ret = training.saveKeyword(logonAttributesVO, keywordVO);
                    } catch (SystemException se) {
                        out.println("<h2 color='red'>Encountered an exception.</h2><h3>Details : SystemException</h3>");
                        out.println(se.getMessage());

                    } catch (MaintainKeyWordsException mke) {
                        out.println("<h2 color='red'>Encountered an exception.</h2><h3>Details : MaintainQuestionsException</h3>");
                        out.println(mke.getStackTrace().toString());
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
				The keyword is uploaded. Click here to add the next keyword : <a
					href="addKeywordForm.jsp">Add Keyword</a>
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
