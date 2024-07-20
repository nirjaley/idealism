package controller.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cart;

@WebServlet("/remove-from-cart")
public class removeFromCartServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	    HttpSession session = request.getSession();
	    ArrayList<Cart> cartList = (ArrayList<Cart>) session.getAttribute("cart-list");

	    // Get product ID from hidden input
	    int productId = Integer.parseInt(request.getParameter("id")); // Change this line

	    if (cartList != null) {
	        for (int i = 0; i < cartList.size(); i++) {
	            Cart cartItem = cartList.get(i);
	            if (cartItem.getProduct_id() == productId) {
	                cartList.remove(i);
	                break; // Stop iterating after removing the item
	            }
	        }
	        session.setAttribute("cart-list", cartList);
	    }

	    // Redirect back to cart page
	    response.sendRedirect("pages/cart.jsp");
	}
}