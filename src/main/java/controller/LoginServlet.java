package controller;

import java.io.IOException;

import dao.UserDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException{
		// Read the login data
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		
		// calling DAO
		
		UserDAO dao = new UserDAO();
		User user=dao.loginUser(email, pass);
		
		//if login succeeds
		if(user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("userId",user.getId());
			session.setAttribute("userName",user.getName());
			response.sendRedirect("index.jsp");
			
		}else {
			response.getWriter().println("Invalid Email or password.");
		}
	}
}
