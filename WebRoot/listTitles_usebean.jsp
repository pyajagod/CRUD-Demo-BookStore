<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*,bean.*"%>
<jsp:useBean id="dbcon" class="bean.DBcon" scope="request" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>图书列表</title>
</head>
<body>
	<table bgcolor=lightgrey>
		<tr>
			<td>ISBN</td>
			<td>书名</td>
			<td>版本</td>
			<td>出版时间</td>
			<td>价格</td>
		</tr>
		<%
Connection dbCon =dbcon.getConnection();
Statement stmt =dbCon.createStatement();
ResultSet rs=stmt.executeQuery("select * from titles");
while(rs.next()){
%>
		<tr bgcolor=cyan>
			<td><%=rs.getString(1) %></td>
			<td><%=rs.getInt("editionNumber") %></td>
			<td><%=rs.getInt(4) %></td>
			<td><%=rs.getDouble("price") %></td>
		</tr>
		<%    
}
rs.close();
stmt.close();
dbCon.close();
%>
	</table>
</body>
</html>
