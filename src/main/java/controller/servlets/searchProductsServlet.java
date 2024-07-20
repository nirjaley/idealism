package controller.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.database.DatabaseController;
import model.Product;

/**
 * Servlet implementation class searchProducts
 */
@WebServlet("/search-products")
public class searchProductsServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String query = request.getParameter("query");

        // Call DatabaseController to search products based on the query
        List<Product> searchResults = null;
		try {
			searchResults = DatabaseController.searchProducts(query);
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("search_error", "Search failed! Please try again.");
		}

        request.setAttribute("search_results", searchResults);
        response.sendRedirect("pages/search-results.jsp");
    }
}

