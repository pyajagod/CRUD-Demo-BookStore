package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.BookOrder;
import bean.OrderOperation;

/**
 * Servlet implementation class DoOrder
 */
@WebServlet("/DoOrder")
public class DoOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
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
		BookOrder bookorderbean = new BookOrder();
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		bookorderbean.setUsername(request.getParameter("username"));
		bookorderbean.setname(request.getParameter("name"));
		bookorderbean.setPhone(request.getParameter("phone"));
		bookorderbean.setaddress(request.getParameter("address"));
		bookorderbean.setTotal(((Double)session.getAttribute("total")).doubleValue());
		
		session.setAttribute("order",bookorderbean);
		OrderOperation op = new OrderOperation();
		op.saveOrder(bookorderbean);
		request.getRequestDispatcher("last.jsp").forward(request, response);
	}

}
