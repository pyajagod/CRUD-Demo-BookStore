<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="title" class="bean.Title" scope="page"></jsp:useBean>
	<h1>JSP使用javaBean测试</h1>
	<hr>
	<%title.setIsbn("98780011");
	title.setTitle("JSP web原理");
	%>
	<h3>
		图书编号:<%=title.getIsbn() %><br> 图书名称:<%=title.getTitle() %></h3>
</body>
</html>