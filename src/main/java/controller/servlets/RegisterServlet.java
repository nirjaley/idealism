package controller.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.database.DatabaseController;
import model.UserModel;
import util.StringUtils;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/Register" })
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final DatabaseController dbController;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		this.dbController = new DatabaseController();
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

		// Extract student information from request parameters
		String firstName = request.getParameter(StringUtils.FIRST_NAME);
		String lastName = request.getParameter(StringUtils.LAST_NAME);
		String phoneNumber = request.getParameter(StringUtils.PHONE_NUMBER);
		String address=request.getParameter(StringUtils.ADDRESS);
		String email=request.getParameter(StringUtils.EMAIL);
		String password = request.getParameter(StringUtils.PASSWORD);


		UserModel user = new UserModel(firstName, lastName, phoneNumber, address, email, password);

		// Call DBController to register the student
		int result = dbController.registerUser(user);
	}
}
