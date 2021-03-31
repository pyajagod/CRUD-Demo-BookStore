<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8" import="bean.* , java.sql.*,java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="dao" class="bean.TitleDaoimp"></jsp:useBean>
<html>
<head>
<title>书架维护</title>
</head>
<body>
	<h1 align="center">书架维护</h1>
	<table bgcolor=lightgrey align="center">
		<tr>
			<td>ISBN</td>
			<td>书名</td>
			<td>版本</td>
			<td>发布时间</td>
			<td>价格</td>
		</tr>
		<%		List list = dao.getTitles();
		Title book = null;
		for(int i = 0 ; i < list.size(); i++){
			book=(Title)list.get(i);
%>
		<tr bgcolor=cyan>
			<td><a href="ToEditTitle?isbn=<%= book.getIsbn() %>"><%= book.getIsbn() %></a></td>
			<td><%= book.getTitle() %></td>
			<td><%= book.getEditionNumber() %></td>
			<td><%= book.getCopyright() %></td>
			<td><%= book.getPrice() %></td>
			<td><a href="./DoDeleteTitle?isbn=<%= book.getIsbn() %>">删除</a></td>
		</tr>
		<% } %>
	</table>
	<br>
	<a href="addTitle.jsp">添加图书</a>
</body>
</html>
