package controller.servlets;

import javax.servlet.http.HttpSession;

import controller.database.DatabaseController;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cart;
import model.Product;
import util.StringUtils;

/**
 * Servlet implementation class addToCartServlet
 */
@WebServlet("/add-to-cart")
public class addToCartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void setDbConnection(DatabaseController dbConnection) {
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            ArrayList<Cart> cartList = new ArrayList<>();

            int product_id = Integer.parseInt(request.getParameter("product_id"));

            HttpSession session = request.getSession(); 
            if (session.getAttribute("UserEmail") == null) {
                out.println("<h3 style='color:crimson; text-align: center'>Please Login to Add Items to Cart. <a href='pages/login.jsp'>Login Here</a></h3>");
                return;
            }

                Connection connection = null;
                Product product = null;
                try {
                    connection = DatabaseController.getConnection();
                    product = getProductDetails(connection, product_id);
                } catch (SQLException e) {
                    e.printStackTrace();
                    out.println("<h3 style='color:crimson; text-align: center'>Database Error.</h3>");
                    return;
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } finally {
                    if (connection != null) {
                        try {
                            connection.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }

                // Handle product not found

                if (product == null) {
                    out.println("<h3 style='color:crimson; text-align: center'>Product Not Found.</h3>");
                    return;
                }

                Cart cm = new Cart(product.getProduct_id(), product.getProduct_name(), product.getUnit_price());
                cm.setQuantity(1); // Assuming the initial quantity is 1

                @SuppressWarnings("unchecked")
                ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");

                if (cart_list == null) {
                    cartList.add(cm); // Add cm here even if cart is null (new cart)
                    session.setAttribute("cart-list", cartList);
                    response.sendRedirect("pages/cart.jsp");
                } else {
                    cartList = cart_list;

                    boolean exist = false;
                    for (Cart c : cart_list) {
                        if (c.getProduct_id() == product_id) {
                            exist = true;
                            out.println("<h3 style='color:crimson; text-align: center'>Item Already in Cart. <a href='pages/cart.jsp'>Go to Cart Page</a></h3>");
                        }
                    }

                    if (!exist) {
                        cartList.add(cm); // Add cm here for new item in existing cart
                        response.sendRedirect("pages/cart.jsp");
                    }
                }
            }
        }
	private Product getProductDetails(Connection connection, int product_id) throws SQLException {
		String query = StringUtils.SELECT_PRODUCT;
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, product_id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			String name = rs.getString("product_name");
			int price = rs.getInt("unit_price");
			return new Product(product_id, name, price);
		} else {
			return null;
		}
	}
}