package controller;

import java.io.IOException;

import dao.CattleDAO;

import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.http.HttpServlet;

import jakarta.servlet.http.HttpServletRequest;

import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.http.HttpSession;

import model.Cattle;

@WebServlet("/addCattle")

public class AddCattleServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
                          throws IOException {
        String cattleName =
        request.getParameter("cattleName");
        String breed =
        request.getParameter("breed");
        HttpSession session =
        request.getSession();
        int userId =(int) session.getAttribute("userId");
        
        Cattle cattle = new Cattle();
        cattle.setUserId(userId);
        cattle.setCattleName(cattleName);
        cattle.setBreed(breed);
        
        CattleDAO dao = new CattleDAO();
        boolean status = dao.addCattle(cattle);

        if(status) {
            response.sendRedirect("cattle.jsp");
        } else {

            response.getWriter()
                    .println("Failed to Add Cattle");

        }
    }
}