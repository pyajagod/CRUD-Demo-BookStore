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
@WebServlet("/ToAddDBcon")
public class ToAddDBcon extends HttpServlet{
public ToAddDBcon(){
super();
}
public void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
doPost(request,response);
}
public void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
request.setCharacterEncoding("UTF-8");
response.setContentType("text/html;charset=UTF-8");
String isbn= request.getParameter("isbn"); //ISBN
String booktitle = request.getParameter("title"); 
//booktitle = new String(booktitle.getBytes("ISO- 8859 - 1"),"GBK" );
String copyright=request.getParameter("copyright"); 
String imageFile=request.getParameter("imageFile");
int editionNumber=Integer.parseInt(request.getParameter("editionNumber")); 
int publisherId= Integer.parseInt(request.getParameter("publisherId"));
float price = Float. parseFloat(request. getParameter("price"));
Title titlebean = new Title();
titlebean.setIsbn(isbn);
titlebean.setCopyright(copyright);
titlebean.setEditionNumber(editionNumber);
//title.setImageFile(imageFile);
titlebean.setImageFile(isbn+".jpg");
titlebean.setPrice(price);
titlebean.setPublisherId(publisherId);
titlebean.setTitle(booktitle);
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