<%@ page language="java" contentType="text/html; charset=utf-8"
	import="java.util.*" pageEncoding="utf-8"%>
<% String path= request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style type="text/css">
A {
	text-decoration: none;
	color: black;
	font-family: 楷体;
}

A:link {
	color: black
}

A:visited {
	color: black
}

A:active {
	color: black
}

A:hover {
	color: green;
	font-family: 楷体;
	font-size: 20
}
</style>
</head>
<body>
	<font color="blue" size="3">当前用户： <%= session.getAttribute("userName") %><a
		href="logout.jsp" target="_parent">注销</a>
	</font>
	<hr>
	<font color="red" size="4" style="font-family: simhei">前台系统</font>
	<hr>
	<a href=viewBook.jsp target=user>浏览图书</a>
	<br>
	<br>
	<a href=search.jsp target=user>查询图书</a>
	<br>
	<br>

</body>
</html>