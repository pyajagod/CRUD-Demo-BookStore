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
/**
 * Servlet implementation class DoSaveEditTitle
 */
@WebServlet("/DoSaveEditTitle")
public class DoSaveEditTitle extends HttpServlet {
    public DoSaveEditTitle() {
        super();
       
    }

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		super.destroy();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");		
		response.setContentType("text/html;charset=UTF-8");
		String isbn = request.getParameter("isbn");
		String title = request.getParameter("title");
		String copyright = request.getParameter("copyright");
		String imageFile = request.getParameter("imageFile");
		int editionNumber = Integer.parseInt(request.getParameter("editionNumber"));
		int publisherId = Integer.parseInt(request.getParameter("publisherId"));
		float price = Float.parseFloat(request.getParameter("price"));
		Title titlebean = new Title();
		titlebean.setIsbn(isbn);
		titlebean.setCopyright(copyright);
		titlebean.setEditionNumber(editionNumber);
		titlebean.setImageFile(imageFile);
		titlebean.setPrice(price);
		titlebean.setPublisherId(publisherId);
		titlebean.setTitle(title);
		TitleDao titleDao = new TitleDaoimp();
		int n = titleDao.update(titlebean);
		if(n>0){
			response.sendRedirect("listBook.jsp");
			
		}
		else
			response.sendRedirect("error.jsp");
	}
public void init() throws ServletException{
	
}
}
