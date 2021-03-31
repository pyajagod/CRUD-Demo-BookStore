package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Register;
import bean.RegisterDao;
import bean.RegisterDaoImpl;

/**
 * Servlet implementation class DoAdduser
 */
@WebServlet("/DoAdduser")
public class DoAdduser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoAdduser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String loginname= request.getParameter("loginname");
		String password = request.getParameter("password"); 
		//booktitle = new String(booktitle.getBytes("ISO- 8859 - 1"),"GBK" );
		
		Register registerbean = new Register();
		registerbean.setloginname(loginname);
		registerbean.setpassword(password);
		
		//调用数据库操作类执行插人操作
		RegisterDao registerDao=new RegisterDaoImpl();
		int n = registerDao.add(registerbean);
		
		response. sendRedirect("index.html");
		

}
}
