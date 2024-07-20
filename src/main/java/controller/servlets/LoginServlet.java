package controller.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.database.DatabaseController;
import model.LoginModel;
import util.StringUtils;


@WebServlet(asyncSupported = true, urlPatterns = { "/Login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final DatabaseController DatabaseController;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
    	  this.DatabaseController = new DatabaseController();
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
		// Extract username and password from the request parameters
		String email = request.getParameter(StringUtils.EMAIL);
		String password = request.getParameter(StringUtils.PASSWORD);

		// Create a LoginModel object to hold user credentials
		LoginModel loginModel = new LoginModel(email, password);

		// Call DatabaseController to validate login credentials
		int loginResult = DatabaseController.getStudentLoginInfo(loginModel);

		// Handle login results with appropriate messages and redirects
		if (loginResult == 1) {
			// Login successful
			HttpSession userSession = request.getSession();
			userSession.setAttribute("UserEmail", email);
			userSession.setMaxInactiveInterval(30*60);

			Cookie userCookie= new Cookie(StringUtils.USER, email);
			userCookie.setMaxAge(30*60);
			response.addCookie(userCookie);

			request.setAttribute(StringUtils.MESSAGE_SUCCESS, StringUtils.MESSAGE_SUCCESS_LOGIN);
			
		 boolean isAdmin = controller.database.DatabaseController.isAdmin(email);
			if (isAdmin) {
					        	response.sendRedirect(request.getContextPath() + "/pages/adminDashboard.jsp");
					        } else {
					        	response.sendRedirect(request.getContextPath() + "/pages/home.jsp");
					        }
			
		} else if (loginResult == 0) {
			// Username or password mismatch
			request.setAttribute(StringUtils.MESSAGE_ERROR, StringUtils.MESSAGE_ERROR_LOGIN);
			request.setAttribute("UserEmail", email);
			request.getRequestDispatcher(StringUtils.PAGE_URL_LOGIN).forward(request, response);
		} else if (loginResult == -1) {
			// Username not found
			request.setAttribute(StringUtils.MESSAGE_ERROR, StringUtils.MESSAGE_ERROR_CREATE_ACCOUNT);
			request.setAttribute("UserEmail", email);
			request.getRequestDispatcher(StringUtils.PAGE_URL_LOGIN).forward(request, response);
		} else {
			// Internal server error
			request.setAttribute(StringUtils.MESSAGE_ERROR, StringUtils.MESSAGE_ERROR_SERVER);
			request.setAttribute("UserEmail", email);
			request.getRequestDispatcher(StringUtils.PAGE_URL_LOGIN).forward(request, response);
		}
	}

}

