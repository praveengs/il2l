<%@ page isErrorPage="true"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ERROR!</title>
</head>
<body>
	<h2>Your application has generated an error</h2>
	<h3>Please inform the error given below to the administrators</h3>
	<b>Exception:</b>
	<font color="red"><%=exception%></font><br/><br/><br>
	<%exception.printStackTrace(); %>
	<a href="index.jsp">Click here</a> to go to the homepage
</body>
</html>