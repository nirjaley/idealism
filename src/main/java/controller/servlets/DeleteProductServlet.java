package controller.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.database.DatabaseController;
import model.ProductModel;

/**
 * Servlet implementation class DeleteProductServlet
 */
@WebServlet("/DeleteProductServlet")
public class DeleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	DatabaseController dbController = new DatabaseController();
    ArrayList<ProductModel> productList = new ArrayList<>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteProductServlet() {
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
		String productdeleteId = request.getParameter("productIdDel");
		if(productdeleteId != null && !productdeleteId.isEmpty()){
			doDelete(request,response);
		}
		
	}
	
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("delete triggered");
		doGet(req, resp);
		String deleteIdString = req.getParameter("productIdDel");
		int deleteId = Integer.parseInt(deleteIdString);
		if (dbController.ProductInfoDelete(deleteId) == 1) {
//			req.setAttribute("");
			resp.sendRedirect("pages/productManagement.jsp?msg=deleted");
		} else {
			resp.sendRedirect("pages/productManagement.jsp?msg=deleted");
//			req.setAttribute(StringUtils.MESSAGE_ERROR, StringUtils.MESSAGE_ERROR_DELETE);
//			resp.sendRedirect(req.getContextPath() + StringUtils.URL_INDEX);
		}

}
	}
