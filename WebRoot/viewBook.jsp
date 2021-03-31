<%@ page language="java" contentType="text/html; charset=utf-8"
	import="bean.*,java.util.*" pageEncoding="utf-8"%>
<jsp:useBean id="dao" class="bean.TitleDaoimp" scope="request" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>浏览图书</title>
</head>
<body>
	<h1 align="center">浏览图书</h1>
	<table align="center" bgcolor=lightgrey>
		<tr>
			<td>ISBN</td>
			<td>书名</td>
			<td>版本</td>
			<td>发布时间</td>
			<td>价格</td>
		</tr>
		<%
	List list=dao.getTitles();
	Title titles=null;
	for(int i=0;i<list.size();i++){
		titles=(Title)list.get(i);
%>
		<tr bgcolor=cyan>
			<td><a href="ToViewTitle?isbn=<%= titles.getIsbn() %>"><%= titles.getIsbn() %></a></td>
			
			<td><%=titles.getTitle() %></td>
			<td><%=titles.getEditionNumber() %></td>
			<td><%=titles.getCopyright() %></td>
			<td><%=titles.getPrice() %></td>
		</tr>
		<%
	}
%>

	</table>
</body>
</html>