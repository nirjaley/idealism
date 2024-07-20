package controller.servlets;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.database.DatabaseController;
import model.UserModel;
import util.StringUtils;

/**
 * Servlet implementation class UserProfileServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/UserProfileServlet" })
public class UserProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final DatabaseController DatabaseController = new DatabaseController();
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//get current session of the user
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("UserEmail");
	
	// Get user details form the database;
	UserModel userProfile = DatabaseController.getUserProfile(email);
	
	
	
	
	if (userProfile != null) {
		request.setAttribute("userProfile", userProfile);
	 	request.getRequestDispatcher(StringUtils.PAGE_URL_USER_PROFILE).forward(request, response);
	}
	else {
		response.sendRedirect(request.getContextPath() + StringUtils.PAGE_URL_HOME);
	}
}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
			// Get parameters using getParameter
			String address = request.getParameter(StringUtils.ADDRESS);
			String phoneNumber = request.getParameter(StringUtils.PHONE_NUMBER);
			String password = request.getParameter(StringUtils.PASSWORD);
			
			HttpSession session = request.getSession();
			String email = (String) session.getAttribute("UserEmail");
			
			// Get user's current data before modifying
			UserModel userProfile = DatabaseController.getUserProfile(email);
			
			
			// Creating a new user model to store the user's updated details
			UserModel updatedUser = new UserModel();
			updatedUser.setEmail(email);
			
			
			// To check if the address is empty
			if (address != null && !address.isEmpty()) {
				updatedUser.setAddress(address);
			}
			else {
				// If user does not change the address, this will get the address from database  
				updatedUser.setAddress(userProfile.getAddress());
			}
			
			// To check if the phoneNumber is empty
			if (phoneNumber != null && !phoneNumber.isEmpty()) {
				updatedUser.setPhoneNumber(phoneNumber);
				}
			else {
				// If user does not change the phoneNumber, this will get the address from database  
				updatedUser.setPhoneNumber(userProfile.getPhoneNumber());
				}
			
			// To check if the password is empty
			if (password != null && !password.isEmpty()) {
				updatedUser.setPassword(password);
				}
			else {
				// If user does not change the password, this will get the address from database  
				updatedUser.setPassword(userProfile.getPassword());
				}
			
			// to update user in database
			boolean update = DatabaseController.updateUserProfile(updatedUser);
			
			
			if(!update) {
				session.setAttribute(StringUtils.USER_PROFILE_ATTRIBUTE, updatedUser);
				response.sendRedirect(StringUtils.PAGE_URL_HOME);
			
			}
		}
		
		
		
		

	}


