package controller;

import java.io.IOException;

import dao.UserDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		//Reading the data from signup.html
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
	
		
		//Create User class object to get an empty user (Bag)
		User user = new User();
		user.setName(name); // filling name to that user
		user.setEmail(email); // filling name to that user
		user.setPassword(pass); // filling name to that user
		
		//Calling DAO
		UserDAO dao = new UserDAO();
		boolean status = dao.registerUser(user); // passing that user object to DAO
		
		
		if(status) {
			response.sendRedirect("login.jsp");
		}else {
			response.getWriter().println("SignUp Failed!");
		}
		 
	}
}
