<%@ page language="java" import="java.util.*,bean.*"
	pageEncoding="utf-8"%>
<html>
<head>
<title>书籍信息</title>
<% 
	 
	Title titles = (Title) session.getAttribute("titles"); 
%>
</head>
<body>
	<TABLE style="TEXT-ALIGN: center" cellSpacing="0" cellPadding="0"
		width="590" border="0">
		<tr height="100">
			<td colspan="3"><h2><%=titles.getTitle() %></h2></td>
		</tr>
		<tr>
			<td rowspan="5"><img style="border: thin solid black" width="80"
				height="120" src="images/<%=titles.getIsbn() %>.jpg"
				alt="<%= titles.getTitle() %>:<%=titles.getIsbn() %>.jpg" /></td>
			<td class="bold" align="left">图书编号</td>
			<td align="left"><%=titles.getIsbn() %></td>
		</tr>
		<tr align="left">
			<td class="bold" align="left">价格</td>
			<td align="left"><%=titles.getPrice() %></td>
		</tr>
		<tr align="left">
			<td class="bold">版本号</td>
			<td><%=titles.getEditionNumber() %></td>
		</tr>
		<tr align="left">
			<td class="bold">版权</td>
			<td><%=titles.getCopyright() %></td>
		</tr>
		<tr align="left">
			<td>
				<form method="post" action="./AddTitlesToCart">
					<p>
						<input type="submit" value="加入购物车" />
					</p>
				</form>
			</td>
			<td>
				<form method="get" action="viewCart.jsp">
					<p>
						<input type="submit" value="查看购物车" />
					</p>
				</form>
			</td>
		</tr>
	</table>
</body>
</html>



