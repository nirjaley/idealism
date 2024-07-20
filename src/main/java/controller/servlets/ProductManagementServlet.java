package controller.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.database.DatabaseController;
import model.ProductModel;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import model.ProductModel;


/**
 * Servlet implementation class ProductManagementServlet
 */
@WebServlet("/ProductManagementServlet")
public class ProductManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	DatabaseController dbController = new DatabaseController();
//    ArrayList<ProductModel> productList = new ArrayList<>();
    /**
     
     * @see HttpServlet#HttpServlet()
     */
    public ProductManagementServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ArrayList<ProductModel> productList = dbController.getProductInfo();
            System.out.println(productList);
            request.setAttribute("productList", productList);
            request.getRequestDispatcher("/pages/productManagement.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception appropriately, such as displaying an error page
        }
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		}
		

}
