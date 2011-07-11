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

<title>Insert title here</title>

</head>
<body>

	<%
		
		String queryString = request.getParameter("selection");
		System.out.println(queryString);
		String subject=null;
		String[] queryArray = null;
		Collection<String> modCollection=new ArrayList<String>();
		Collection<String> submodCollection=new ArrayList<String>();
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
				subject=i.substring((i.lastIndexOf('_')+1), i.length());
				//subjectVO.setSubjectName(subject);
				//subjectVO.setModules(new ArrayList<ModuleVO>(2));
				questionSearchVO.setSubjectName(subject);
				questionSearchVO.setSubmodules(new ArrayList<String>(2));
				//System.out.println("Subject VO"+subjectVO);
			}			
			else if(i.startsWith("MOD_")){
				String mod=i.substring((i.lastIndexOf('_')+1),i.length());
				modCollection.add(mod);
				//moduleVO = new ModuleVO();
				//moduleVO.setModuleName(mod);
				//subjectVO.getModules().add(moduleVO);
				//moduleVO.setSubmodules(new ArrayList<String>(2));
				//System.out.println("Subject VO"+subjectVO);
			}
			else if(i.startsWith("SUBMOD_")){
				String submod=i.substring((i.lastIndexOf('_')+1),i.length());
				submodCollection.add(submod);
				//moduleVO.getSubmodules().add(submod);
				questionSearchVO.getSubmodules().add(submod);
				//System.out.println("Subject VO"+subjectVO);
			}
		}
	
		TrainingController controller = new TrainingController();
		QuestionReturnVO questionRet=controller.retrieveQuestions(questionSearchVO);
		System.out.println("this is ret :"+questionRet);
		Collection<ExamQuestionsVO> questions=questionRet.getExamQuestionVOs();
		int noOfQuestions=questions.size();
		if(Integer.parseInt(request.getParameter("question"))==0){
			
		}
		
		
	%>
	<div id="abcd">asdasd</div>
</body>
</html>