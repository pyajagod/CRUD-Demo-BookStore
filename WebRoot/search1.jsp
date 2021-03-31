<%@ page language="java" contentType="text/html; charset=utf-8"
	import="java.sql.* ,bean.*,java.util.List" pageEncoding="utf-8"%>
<jsp:useBean id="db" class="bean.DBcon" scope="request" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<%  request. setCharacterEncoding("utf-8");
	  String book1=(String)request.getParameter("book1");
	  Connection dbCon =db.getConnection();
	  Statement stmt =dbCon.createStatement();
	  ResultSet rs=stmt.executeQuery("select * from titles where isbn="+book1);

	  if(rs.next()){
	response . sendRedirect( "detail.jsp");
	%>
	<%}else {
	%>
	<tr>
		查无此书！3秒后跳转，请重新查找<%response.setHeader("Refresh", "3;search.jsp ");}%>
	</tr>

</body>
</html>