package Servlet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.TitleDao;
import bean.TitleDaoimp;
import bean.Title;
@WebServlet("/DoAddTitle")
public class DoAddTitle extends HttpServlet{
public DoAddTitle(){
super();
}
public void destroy(){
super.destroy();
}
public void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
doPost(request,response);
}
public void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
request.setCharacterEncoding("UTF-8");
response.setContentType("text/html;charset=UTF-8");
//获取表单传来的新增的图书属性参数
String isbn= request.getParameter("isbn"); //ISBN
String booktitle = request.getParameter("title"); //书名
//booktitle = new String(booktitle.getBytes("ISO- 8859 - 1"),"GBK" );
String copyright=request.getParameter("copyright"); //版权
String imageFile=request.getParameter("imageFile"); //封面图像文件名称
int editionNumber=Integer.parseInt(request.getParameter("editionNumber")); //版本
int publisherId= Integer.parseInt(request.getParameter("publisherId"));
float price = Float. parseFloat(request. getParameter("price"));
//价格
//将数据添加进封装类中
Title titlebean = new Title();
titlebean.setIsbn(isbn);
titlebean.setCopyright(copyright);
titlebean.setEditionNumber(editionNumber);
//title.setImageFile(imageFile);
titlebean.setImageFile(isbn+".jpg");
titlebean.setPrice(price);
titlebean.setPublisherId(publisherId);
titlebean.setTitle(booktitle);
//调用数据库操作类执行插人操作
TitleDao titleDao=new TitleDaoimp();
int n = titleDao.add(titlebean);
if(n>0)
response. sendRedirect("listBook.jsp");
else
response.sendRedirect("error.jsp");
}
public void init() throws ServletException {
}
}
