package controller.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.StringUtils;

/**
 * Servlet implementation class Logout
 */
@WebServlet(asyncSupported = true, urlPatterns = StringUtils.SERVLET_URL_LOGOUT)
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		// Clearing cookies
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
		}
		
		
		//If user session exits, invalidating user's session
		
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		
		// Redirecting to home page.
		response.sendRedirect("pages/home.jsp");
	}


}
