<%@ page language="java" session="true"%>
<%@ page errorPage="errorPage.jsp"%>
<%@page import="com.manteam.iwant2learn.interfaces.CommonInterfaceConstants"%>
<%@page import="com.sun.corba.se.impl.oa.poa.ActiveObjectMap.Key"%>
<%@page import="com.manteam.iwant2learn.subject.vo.KeyWordVO"%>
<%@page import="com.manteam.iwant2learn.controller.TrainingController"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Keyword Information</title>

</head>
<body bgcolor="#CCFFCC">
	<%
		String keywordId = request.getParameter("id");
		if (keywordId == null || keywordId.equalsIgnoreCase("")) {
			%><h2>
		<font color="red">Please enter a keyword</font>
	</h2>
	<%
		}else{
			TrainingController controller=new TrainingController();
			KeyWordVO keywordInfo=controller.retrieveKeywordInfo(Integer.parseInt(keywordId));
			%>

	<b>Keyword Name : </b><%=keywordInfo.getKeywordName() %><br />
	<b>Keyword Description  : </b><%=keywordInfo.getKeyWordDescription() %> <br/>
	<%
				byte[] array = keywordInfo.getKeyWordImageByteArray();
						if (array == null || array.length == 0) {
			%><br />
	<%
				} else {
			%>
	<p id="keywordImage">
		<br /> <img alt="Keyword Image"
			src="getImage?imageId=<%=CommonInterfaceConstants.KEYWORD_IMG+CommonInterfaceConstants.SEPARATOR+keywordInfo.getKeyWordId()%>" width="300"
			height="400">
	</p>
	<%
				}
	%>
	<br />
	<%	}
	%>
</body>
</html>