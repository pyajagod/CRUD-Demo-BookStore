<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<%
	session.removeAttribute("userName");//remove 清除页面
	//response.sendRedirect("index.html");//跳转方法 response
	
%>
	<jsp:forward page="index.html"></jsp:forward>
</body>
</html>
