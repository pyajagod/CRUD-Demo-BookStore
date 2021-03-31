<%@ page language="java" import="bean.*,java.util.*,java.text.*"
	contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<jsp:useBean id="db" class="bean.DBcon" scope="request" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录验证页面</title>
</head>
<body>
	<% 
		Map cart = (Map) session.getAttribute("cart"); 
			if (cart == null || cart.size() == 0) {
				out.println("<p>购物车当前为空.</p>"); 
			}
		    else{%>
    	  <jsp:forward page="order.html"></jsp:forward>
    	  <%} %>
   	  <a href="viewBook.jsp">继续购物</a>
</body>
</html>
