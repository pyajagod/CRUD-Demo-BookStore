<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>   
  <body>
  <font size=3>
    <h1 align="center" ><font color = "black" face = 楷体>欢迎来到网上书店系统</font></h1><br>
    <h2 align="center" ><font color = "black" face = 楷体>新书推荐</font></h2><br>
   </font><center>
   <table style="TEXT-ALIGN: center" cellSpacing="0" cellPadding="0"
		width="590" border="0">
		<tr height="100">
			
		</tr>
		<tr>
			<td rowspan="5"><img style="border: thin solid black" width="80"
				height="120" src="images/wnagsicong.jpg"
				alt="images/wnagsicong.jpg" /></td>
			<td class="bold" align="left">图书编号</td>
			<td align="left"><%="9787815062691"%></td>
		</tr>
		<tr align="left">
			<td class="bold" align="left">价格</td>
			<td align="left"><%=99.9 %></td>
		</tr>
		<tr align="left">
			<td class="bold">版本号</td>
			<td><%=1%></td>
		</tr>
		<tr align="left">
			<td class="bold">版权</td>
			<td><%=2018%></td>
		</tr>
		<tr align="left">
			<td>
				<form method="post" action="./AddTitlesToCart">
					</form></td></tr></table>
				
   </center>
  </body>
</html>