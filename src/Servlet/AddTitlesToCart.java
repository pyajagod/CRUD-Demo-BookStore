package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import bean.*;
import java.util.*;

/**
 * Servlet implementation class AddTitlesToCart
 */
@WebServlet("/AddTitlesToCart")
public class AddTitlesToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTitlesToCart() {
        super();
        // TODO Auto-generated constructor stub
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
		HttpSession session = request.getSession(false);
		RequestDispatcher dispatcher;
		if(session==null){
			dispatcher=request.getRequestDispatcher("/viewBook.jsp");
			dispatcher.forward(request, response);
		}
		Map cart =(Map) session.getAttribute("cart");
		Title titles=(Title) session.getAttribute("titles");
		if(cart==null){
			cart= new HashMap();
			session.setAttribute("cart", cart);
		}
		CartItem cartItem=(CartItem) cart.get(titles.getIsbn());
		if(cartItem != null){
			cartItem.setQuantity(cartItem.getQuantity()+1);
		}
		else{
			CartItem cartItem1= new CartItem();
			cartItem1.setTitles(titles);
			cartItem1.setQuantity(1);
			cart.put(titles.getIsbn(), cartItem1);
		}
		dispatcher=request.getRequestDispatcher("/viewCart.jsp");
		dispatcher.forward(request, response);
		}
	}


