
<%@ page language="java" session="true" pageEncoding="utf-8"%>
<%@ page import="bean.*,java.util.*,java.text.*"%>
<html>
<body>
	购物车商品
	<% 
		Map cart = (Map) session.getAttribute("cart"); 
		double total = 0; 
		if (cart == null || cart.size() == 0) 
			out.println("<p>购物车当前为空.</p>"); 
		else { 
			Set cartItems = cart.keySet(); 
			Object[] isbn = cartItems.toArray(); 
			Title book; 
			CartItem cartItem; 
			int quantity; 
			double price, subtotal; 
	%>
	<table cellSpacing=0 cellPadding=0 width=490 border=1>
		<thead>
			<tr align="center">
				<th>书籍名称</th>
				<th>数量</th>
				<th>价格</th>
				<th>小计</th>
			</tr>
		</thead>
		<% 
				int i = 0; 
					while (i < isbn.length) {  
						cartItem = (CartItem) cart.get((String) isbn[i]); 
						book = cartItem.getTitles(); 
						quantity = cartItem.getQuantity(); 
						price = book.getPrice(); 
						subtotal = quantity * price; 
						total += subtotal; 
						i++; 
			%>
		<tr>
			<td><%=book.getTitle()%></td>
			<td align="center"><%=quantity%></td>
			<td class="right"><%=new DecimalFormat("0.00").format(price)%></td>
			<td class="bold right"><%=new DecimalFormat("0.00").format(subtotal)%>
			</td>
		</tr>
		<% 
				} 
			%>
		<tr>
			<td colspan="4" class="bold right"><b>总计： </b><%=new DecimalFormat("0.00").format(total)%>
			</td>
		</tr>
	</table>
	<% 
			session.setAttribute("total", new Double(total)); 
			} 
		%>
	<a href="viewBook.jsp">继续购物</a>
	<a href="CleanCart.jsp">清空购物车</a>
	<form method="get" action="check.jsp">
		<input type="submit" value="结   账" />
	</form>
</BODY>
</HTML>
