<%@ page language="java" import="bean.*" pageEncoding="UTF-8"%>
<html>
  <head>
    <title>修改图书页面</title>
    <%
    	//从request对象中取出属性title的值 
        Title title=(Title)request.getAttribute("title");
    %>
  </head>
  <body>
    <h1>修改图书</h1>
    <form method="post" action=".\DoSaveEditTitle" >
    <table>
   	 <tr><td>Isbn号</td>
        <td><input type="text" name="isbn" readOnly="true" 
   	         value="<%=title.getIsbn() %>"/></td>
     </tr>
     <tr><td>书名</td><td><input type="text" name="title" 
     value="<%=title.getTitle()%>"/></td></tr>
     <tr><td>封面图像文件名称</td><td><input type="text" name="imageFile" 
     value="<%=title.getImageFile() %>"/></td></tr>
     <tr><td>版本号</td><td><input type="text" name="editionNumber"
     value="<%=title.getEditionNumber() %>"/></td></tr>
     <tr><td>出版商ID</td><td><input type="text" name="publisherId" readOnly="true" 
     value="<%=title.getPublisherId() %>"/></td></tr>
     <tr><td>价格</td><td><input type="text" name="price" 
     value="<%=title.getPrice()%>"/></td></tr>
     <tr><td>版权</td><td><input type="text" name="copyright" 
     value="<%=title.getCopyright() %>"/></td></tr>
     <tr><td><input type="submit" value="保存"/></td></tr>
    </table>
    </form><br>
    <a href="uploadfile.jsp?isbn=<%=title.getIsbn()%>">上传图书封面图片文件</a> <br> <br>   
    <a href="uploadfile_show.jsp?isbn=<%=title.getIsbn()%>">查看图书封面图片文件</a>
  </body>
</html>
	