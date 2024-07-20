package controller.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.database.DatabaseController;
import model.Cart;
import util.StringUtils;

/**
 * Servlet implementation class CheckoutServlet
 */
@WebServlet("/checkout-servlet")
public class CheckoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            @SuppressWarnings("unchecked")
            ArrayList<Cart> cartList = (ArrayList<Cart>) session.getAttribute("cart-list");

            // Handle empty cart scenario
            if (cartList == null || cartList.isEmpty()) {
                out.println("<h3 style='color:crimson; text-align: center'>Your cart is empty!</h3>");
                return;
            }

            Connection connection = null;
            try {
                connection = DatabaseController.getConnection();

                // Order creation logic
                for (Cart cartItem : cartList) {
                    int product_id = cartItem.getProduct_id();
                    int quantity = cartItem.getQuantity();
                    String productName = cartItem.getProduct_name(); // Assuming product_name is available in Cart object
                    int unitPrice = cartItem.getUnit_price(); // Assuming unit_price is available in Cart object
                    int totalPrice = quantity * unitPrice; // Calculate total price

                    // Insert order record
                    String insertOrder = StringUtils.INSERT_ORDERS;
                    PreparedStatement psOrder = connection.prepareStatement(insertOrder);
                    psOrder.setInt(1, product_id);
                    psOrder.setString(2, productName);
                    psOrder.setInt(3, quantity);
                    psOrder.setInt(4, unitPrice);
                    psOrder.setInt(5, totalPrice);
                    psOrder.executeUpdate();
                    

                    // Update product inventory (assuming a separate 'stock' field)
                    String updateStock = StringUtils.UPDATE_PRODUCT;
                    PreparedStatement psStock = connection.prepareStatement(updateStock);
                    psStock.setInt(1, quantity);
                    psStock.setInt(2, product_id);
                    psStock.executeUpdate();
                }

                // Informing user about successful checkout
                out.println("<h3 style='color: green; text-align: center'>Your Order has been placed!</h3>");
                session.removeAttribute("cart-list"); // Clear cart after checkout
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace(out); // Log the error for now (improve later)
                out.println("<h3 style='color:crimson; text-align: center'>Checkout Failed!</h3>");
            } finally {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
