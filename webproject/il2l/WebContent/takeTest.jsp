
<%@page import="java.io.OutputStreamWriter"%>
<%@page import="java.net.URLConnection"%>
<%@page import="java.net.URL"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.awt.Image"%>
<%@page import="java.awt.Toolkit"%>
<%@page import="javax.imageio.ImageIO"%>
<%@page import="java.awt.image.BufferedImage"%>
<%@page import="java.io.IOException"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.BufferedOutputStream"%>
<%@page import="java.io.BufferedInputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="com.manteam.iwant2learn.vo.ExamQuestionsVO"%>
<%@page import="com.manteam.iwant2learn.vo.QuestionSearchVO"%>
<%@page import="java.util.Arrays"%>
<%@page import="com.manteam.iwant2learn.vo.QuestionReturnVO"%>
<%@page import="com.manteam.iwant2learn.controller.TrainingController"%>
<%@page import="com.manteam.iwant2learn.subject.vo.ModuleVO"%>
<%@page import="com.manteam.iwant2learn.subject.vo.SubjectVO"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE">
<title>Insert title here</title>
<style type="text/css">
/* ~~ this fixed width container surrounds the other divs ~~ */
.container {
	width: 800px;
	background: #FFF;
	margin: 10 px;
	/* the auto value on the sides, coupled with the width, centers the layout */
}

/* ~~ the header is not given a width. It will extend the full width of your layout. It contains an image placeholder that should be replaced with your own linked logo ~~ */
.header {
	background: #ADB96E;
}

/* ~~ This is the layout information. ~~ 

1) Padding is only placed on the top and/or bottom of the div. The elements within this div have padding on their sides. This saves you from any "box model math". Keep in mind, if you add any side padding or border to the div itself, it will be added to the width you define to create the *total* width. You may also choose to remove the padding on the element in the div and place a second div within it with no width and the padding necessary for your design.

*/
.content {
	padding: 10px 0;
}

/* ~~ The footer ~~ */
.footer {
	padding: 10px 0;
	background: #CCC49F;
}

.hidden {
	visibility: hidden;
}

/* ~~ miscellaneous float/clear classes ~~ */
.fltrt {
	/* this class can be used to float an element right in your page. The floated element must precede the element it should be next to on the page. */
	float: right;
	margin-left: 8px;
}

.fltlft {
	/* this class can be used to float an element left in your page. The floated element must precede the element it should be next to on the page. */
	float: left;
	margin-right: 8px;
}

.clearfloat {
	/* this class can be placed on a <br /> or empty div as the final element following the last floated div (within the #container) if the #footer is removed or taken out of the #container */
	clear: both;
	height: 0;
	font-size: 1px;
	line-height: 0px;
}
-->
</style>



</script>
</head>
<body>
	<%
		String url = request.getQueryString();
		System.out.println(url);
		String queryString = request.getParameter("selection");
		if (queryString == null || queryString.equalsIgnoreCase("")) {
			out.println("Select subjects/sub modules and start training");
		} else {
			System.out.println(queryString);
			String subject = null;
			String[] queryArray = null;
			Collection<String> modCollection = new ArrayList<String>();
			Collection<String> submodCollection = new ArrayList<String>();
			//SubjectVO subjectVO = new SubjectVO();
			QuestionSearchVO questionSearchVO = new QuestionSearchVO();
			//ModuleVO moduleVO = null;
			int index = 0;
			if (queryString != null || !queryString.equalsIgnoreCase("")) {
				queryArray = queryString.split(",");

			}
			System.out.println(Arrays.toString(queryArray));
			for (String i : queryArray) {
				if (i.startsWith("SUB_")) {
					subject = i.substring((i.lastIndexOf('_') + 1),
							i.length());
					//subjectVO.setSubjectName(subject);
					//subjectVO.setModules(new ArrayList<ModuleVO>(2));
					questionSearchVO.setSubjectName(subject);
					questionSearchVO
							.setSubmodules(new ArrayList<String>(2));
					//System.out.println("Subject VO"+subjectVO);
				} else if (i.startsWith("MOD_")) {
					String mod = i.substring((i.lastIndexOf('_') + 1),
							i.length());
					modCollection.add(mod);
					//moduleVO = new ModuleVO();
					//moduleVO.setModuleName(mod);
					//subjectVO.getModules().add(moduleVO);
					//moduleVO.setSubmodules(new ArrayList<String>(2));
					//System.out.println("Subject VO"+subjectVO);
				} else if (i.startsWith("SUBMOD_")) {
					String submod = i.substring((i.lastIndexOf('_') + 1),
							i.length());
					submodCollection.add(submod);
					//moduleVO.getSubmodules().add(submod);
					questionSearchVO.getSubmodules().add(submod);
					//System.out.println("Subject VO"+subjectVO);
				}
			}

			TrainingController controller = new TrainingController();
			QuestionReturnVO questionRet = controller
					.retrieveQuestions(questionSearchVO);
			if (questionRet != null) {
				System.out.println("this is ret :" + questionRet);
				Collection<ExamQuestionsVO> questions = questionRet
						.getExamQuestionVOs();
				int noOfQuestions = questions.size();

				System.out.println(noOfQuestions);
				ArrayList<ExamQuestionsVO> questionsArray = new ArrayList<ExamQuestionsVO>(
						questions);
				ExamQuestionsVO question = null;
				int location;
				String questionString = request.getParameter("question");
				System.out.println("Location = " + questionString);
				if (questionString == null
						|| questionString.equalsIgnoreCase("")) {
					questionString = "0";
				}
				location = Integer.parseInt(questionString);
				System.out.println("LOCATION : " + location);
				if (location < noOfQuestions) {
					question = questionsArray.get(location);
				} else if (location >= noOfQuestions) {

					question = questionsArray.get(location - 2);
	%>
	<script type="text/javascript">
     parent.fnDisable("nextButton");
    </script>
	<%
		} else if (location < 0) {
					question = questionsArray.get(0);
	%>
	<script type="text/javascript">
     document.getElementById("prevButton").disabled=true;
    </script>
	<%
		}
	%>

	<div id="container" class="container">
		<div id="submodDesc" class="header">
			<h3>Sub Module Details</h3>
			<hr />
			<%=question.getSubmoduleDescription()%>
			<br /> <br /> <b><em>Keywords</em> </b> : <a href="#">displacement</a>&nbsp;&nbsp;&nbsp;<a
				href="#">speed</a>&nbsp;&nbsp;&nbsp;<a href="#">velocity</a>

		</div>
		<div id="question" class="content">
			<h3>Question</h3>
			<hr />
			<%=question.getQuestion()%>
			<%
				byte[] array = question.getQuestionImageByteArray();
						if (array == null || array.length == 0) {
			%><br />
			<%
				} else {
			%>
			<p id="questionImage">
				<br /> <img alt="QuestionImage"
					src="getImage?imageId=<%=question.getQuestionId()%>" width="300"
					height="400">
			</p>
			<%
				}
			%>
			<br />
			<%
				System.out
								.println("Before call, location is : " + location);
			%>
			<input type="button" id="prevButton" value="Previous Question"
				align="left" style="float: left;"
				onclick="parent.fnGetPrevQn(<%=location%>);" /> <input
				type="button" id="nextButton" value="Next Question" align="right"
				style="float: right;" name="nextButton"
				onclick="parent.fnGetNextQn(<%=location%>,<%=noOfQuestions%>);" />
			<br /> <br />
		</div>
		<div id="answerDesc" class="footer">
			<h3>Answer</h3>
			<hr />
			<input type="button" value="Show Answer" onclick="parent.fnHide();" />
			<br />
			<div id="answer" class="hidden">
				<p id="answerDesc">
					<%=question.getAnswer()%>
				</p>
			</div>
			<%
				} else {
						out.println("No questions available for the selected submodules");
					}
				}
			%>
		</div>
	</div>
</body>
</html>