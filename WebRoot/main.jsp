<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>网上书店项目实训</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<center>
		<%
String uname=(String)session.getAttribute("userName");
if(uname.equals("admin")){
%>
		<table align="center">
			<div id="container" align="center">
				<div id="header">
					<img src="images/top.jpg"></img>
				</div>
				<div class="nav">.</div>
				<div class="left_main">
					<iframe width=180px height=425px src=left.jsp></iframe>
				</div>
				<div class="right_main">
					<iframe name="main" width=620px height=425px src=right.jsp></iframe>
				</div>
			</div>
		</table>
		<%} else{%>
		<script type="text/javascript">alert("请先登录");
window. location.href="index.html";
</script>
		<%} %>
	</center>
</body>
</html>
