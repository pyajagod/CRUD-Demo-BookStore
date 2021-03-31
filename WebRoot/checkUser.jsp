<%@ page language="java" import="java.sql.*"
	contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<jsp:useBean id="db" class="bean.DBcon" scope="request" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>验证页面</title>
</head>
<body>
	<%  request. setCharacterEncoding("GBK");
	  String name=request.getParameter("loginName");
      String password=request.getParameter("password");
      String checkcode=request.getParameter("checkcode");
      String piccode=session.getAttribute("piccode").toString();
      %>

	你输入的用户名是:
	<%=name %><br>
	<br>
	<% 
      Connection con =db.getConnection();
     // Statement stmt = con. createStatement();
      String sql="select * from userinfo where loginname=? and password=?";
      PreparedStatement pstmt=con.prepareStatement(sql);
      pstmt.setString(1, name);
      pstmt.setString(2, password);
      ResultSet rs = pstmt.executeQuery();

      if (checkcode.equals(piccode)&&rs.next()) 
      {
    	  session. setAttribute("userName",name);
    	  if(name.equals("admin")){
    	  response . sendRedirect( "main.jsp");}
    	  else{
    		  response.sendRedirect("user.jsp");
    	  }
      }

      else {

      out. print("登录失败 <br><br>");
      out. print("<a href=' index . html ' >重新登录<//a>");
      }
%>
</body>
</html>