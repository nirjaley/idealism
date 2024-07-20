package controller.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import java.sql.*;

import javax.servlet.annotation.WebServlet;
import util.StringUtils;
import controller.database.DatabaseController;
import model.ProductModel;

import javax.servlet.annotation.MultipartConfig;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

/**
 * Servlet implementation class addProduct
 */
//@WebServlet("/AddProductServlet")
@MultipartConfig(
	    location = "/tmp",
	    fileSizeThreshold = 1024 * 1024,  // 1MB
	    maxFileSize = 1024 * 1024 * 20,   // 20MB
	    maxRequestSize = 1024 * 1024 * 40 )// 40MB

public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	DatabaseController dbController = new DatabaseController();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String productID = request.getParameter("productID");
		int productIDInt = Integer.parseInt(productID);
		String productName = request.getParameter("productName");
		String unitPrice = request.getParameter("unitPrice");
//		int unitPriceInt = Integer.parseInt(unitPrice);
		String category = request.getParameter("category");
		
		String stock = request.getParameter("stock");
//		int stockInt = Integer.parseInt(stock);
		
		Part imagePart = request.getPart("image");
		
		if (productID == null || productName == null || unitPrice == null || category == null || stock == null || imagePart == null||
	            productID.isEmpty() || productName.isEmpty() || unitPrice.isEmpty() || category.isEmpty() || stock.isEmpty() || imagePart.getSize()==0 ) {
	            response.sendRedirect("pages/productManagement.jsp?msg=missing");
	            return;
	        }
		try {
			int stockInt = Integer.parseInt(stock);
			int unitPriceInt = Integer.parseInt(unitPrice);
			ProductModel product = new ProductModel(productIDInt,productName,unitPriceInt,category,stockInt,imagePart);
			
			int result = dbController.addProduct(product);
			
			if (result == 1) {
				
				// Get the image file name from the student object (assuming it was extracted earlier)
				String fileName = product.getImagePath();
				// Check if a filename exists (not empty or null)
				if (!fileName.isEmpty() && fileName != null) {
					String savePath = StringUtils.IMAGE_PRODUCT_DIR;
					System.out.println(savePath);
				  imagePart.write(savePath + fileName);  // Save the uploaded image to the specified path
				  response.sendRedirect("pages/productManagement.jsp?msg=done");
				}if(result == 0){
					response.sendRedirect("pages/productManagement.jsp?msg=wrong");
//					request.getRequestDispatcher(StringUtils.PAGE_ADD_PRODUCT).forward(request, response);
					
				}
				}
		}catch(NumberFormatException e){
			
				response.sendRedirect("pages/productManagement.jsp?msg=invalid");
//				request.getRequestDispatcher(StringUtils.PAGE_ADD_PRODUCT).forward(request, response);
			
			
		}
		
		
		
		
			
		
//		WORKING CODE
//		try { 
//			Connection con = DatabaseController.getConnection();
//			PreparedStatement ps = con.prepareStatement(StringUtils.INSERT_PRODUCT);
//			ps.setInt(1,productIDInt);
//			ps.setString(2,productName);
//			ps.setInt(3,unitPriceInt);
//			ps.setString(4,category);
//			ps.setInt(5,stockInt);
//			int result = ps.executeUpdate();
//			if(result > 0) {
//		  		response.sendRedirect("pages/productManagement.jsp?msg=done");
//			}
//			if(result == 0) {
//				response.sendRedirect("pages/productManagement.jsp?msg=wrong");
//			}
//			
//		}
//		catch(Exception e) {
////			e.printStackTrace();
////			System.out.print("Exception");
//			response.sendRedirect("pages/productManagement.jsp?msg=exception");
//		}
//		finally {
//            // Close resources in a finally block to ensure they are always closed
//            if (ps != null) {
//                try {
//                    ps.close();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//            if (con != null) {
//                try {
//                    con.close();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }
	}

}
