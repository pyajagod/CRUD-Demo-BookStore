<%@ page contentType="text/html; charset=GB2312" import="java.io.*" %>
<html>
<head>
	<title>文件目录</title>
</head>
<body>
<font size=4 color=red>已上传的图书封面文件</font><br>
<font size=3 color=blue>
<%
  String path = request.getRealPath("images");
	File fl = new File(path);
	File lst[] = fl.listFiles();
	out.println("服务器上传文件保存路径："+path+"<br><br>"); 
	out.println("封面图形文件名："+request.getParameter("isbn")+".jpg<br>");
    out.println("<img width='80' height='120' src=images\\"+request.getParameter("isbn")+".jpg><br><br>");
%>
</font><br>
<a href="listBook.jsp">返回图书信息编辑页面</a>
</body>
</html>

