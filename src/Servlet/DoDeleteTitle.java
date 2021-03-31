package Servlet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.TitleDao;
import bean.TitleDaoimp;
@WebServlet("/DoDeleteTitle")
public class DoDeleteTitle extends HttpServlet {
public DoDeleteTitle(){
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
response.setContentType("text/html");
String isbn= request.getParameter("isbn");
TitleDao titleDao= new TitleDaoimp();
int n= titleDao.delete(isbn);
if(n>0) response.sendRedirect("listBook.jsp");
else response.sendRedirect("error.jsp");
}
public void init() throws ServletException { }
}
