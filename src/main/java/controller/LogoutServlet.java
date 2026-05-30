package controller;

import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		// check if the session exits or not if not return null don't create  one 
		HttpSession session = request.getSession(false);
		
		if(session != null) {
			session.invalidate(); // destroy the current session 
			//this deletes that userId and userName from session
		}
		
		response.sendRedirect("index.jsp");
		
	}
}
