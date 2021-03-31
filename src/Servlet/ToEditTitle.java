package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.*;
/**
 * Servlet implementation class ToEditTitle
 */
@WebServlet("/ToEditTitle")
public class ToEditTitle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToEditTitle() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void destroy(){
    	super.destroy();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
		TitleDao titleDao = new TitleDaoimp();
		Title title = titleDao.findByIsbn(isbn);
		request.setAttribute("title", title);
		request.getRequestDispatcher("editTitle.jsp").forward(request, response);
	}
public void  init() throws ServletException{
	
}
}
