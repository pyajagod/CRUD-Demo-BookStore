<%@ page contentType="text/html; charset=GB2312" import="java.io.*" %>
<html>
<head>
	<title>�ļ�Ŀ¼</title>
</head>
<body>
<font size=4 color=red>���ϴ���ͼ������ļ�</font><br>
<font size=3 color=blue>
<%
  String path = request.getRealPath("images");
	File fl = new File(path);
	File lst[] = fl.listFiles();
	out.println("�������ϴ��ļ�����·����"+path+"<br><br>"); 
	out.println("����ͼ���ļ�����"+request.getParameter("isbn")+".jpg<br>");
    out.println("<img width='80' height='120' src=images\\"+request.getParameter("isbn")+".jpg><br><br>");
%>
</font><br>
<a href="listBook.jsp">����ͼ����Ϣ�༭ҳ��</a>
</body>
</html>

