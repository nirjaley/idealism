package controller.servlets;

import java.io.IOException;

import model.ProductModel;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import controller.database.*;

/**
 * Servlet implementation class UpdataProductServlet
 */
@WebServlet("/UpdateProductServlet")
@MultipartConfig(
	    location = "/tmp",
	    fileSizeThreshold = 1024 * 1024,  // 1MB
	    maxFileSize = 1024 * 1024 * 20,   // 20MB
	    maxRequestSize = 1024 * 1024 * 40 )// 40MB
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	DatabaseController dbController = new DatabaseController();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			// TODO Auto-generated method stub
			String productID = request.getParameter("productIdUpdate");

			DatabaseController dbController = new DatabaseController();

			ProductModel product = dbController.updateProduct(productID);

			request.setAttribute("updateProductInfo", product);

			request.getRequestDispatcher("pages/UpdateProduct.jsp").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		
		try {
		String productUpdateId = request.getParameter("productIdUpdate");
		if(productUpdateId != null && !productUpdateId.isEmpty()){
			
		
//		String productID = request.getParameter("productID");
		
		String productID = productUpdateId;
		int productIDInt = Integer.parseInt(productID);
		String productName = request.getParameter("productNameUpdate");
		String unitPrice = request.getParameter("unit_priceUpdate");
		String category = request.getParameter("categoryUpdate");
		
		String stock = request.getParameter("stockUpdate");
		
		Part imagePart = request.getPart("image");
//		String oldImage = request.getParameter("oldImage");

		
//		if (productID == null || productName == null || unitPrice == null || category == null || stock == null || 
//	            productID.isEmpty() || productName.isEmpty() || unitPrice.isEmpty() || category.isEmpty() || stock.isEmpty() ) {
//	            response.sendRedirect("pages/productManagement.jsp?msg=missing");
//	            return;
//	        }
//		int stockInt = Integer.parseInt(stock);
		int stockInt = 1;
		int unitPriceInt = 2;
//		int unitPriceInt = Integer.parseInt(unitPrice);
	
		System.out.println(productID);
		System.out.println(productID);
		System.out.println(productID);
		System.out.println(productID);
		System.out.println(productID);
		
		ProductModel product = new ProductModel(productIDInt,productName,unitPriceInt,category,stockInt,imagePart);
		DatabaseController con = new DatabaseController();
		int result = con.updateprd(product);
		
		if(result>0) {
			response.sendRedirect(request.getContextPath()+ "/pages/productManagement.jsp");
		}
		else if(result == -1){
			response.sendRedirect(request.getContextPath() + "/pages/aboutManagement.jsp");
		}
		else if(result == 0){
			response.sendRedirect(request.getContextPath() + "/pages/atManagement.jsp");
		}
		}
		}catch (Exception e) {
	        // Handle the exception here
	        e.printStackTrace(); // Or any other appropriate handling
	        response.sendRedirect(request.getContextPath() + "pages/cart.jsp"); // Redirect to an error page
	    }
	}

}
