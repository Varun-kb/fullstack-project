package controller;

import java.io.IOException;

import dao.CattleDAO;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.http.HttpServlet;

import jakarta.servlet.http.HttpServletRequest;

import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deleteCattle")

public class DeleteCattleServlet extends HttpServlet {

    @Override

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
                         throws ServletException, IOException {

        int cattleId =
        Integer.parseInt(request.getParameter("id"));

        CattleDAO dao = new CattleDAO();

        boolean status =
        dao.deleteCattle(cattleId);

        if(status) {

            response.sendRedirect("cattle.jsp");

        } else {

            response.getWriter()
                    .println("Cattle deletion failed");

        }
    }
}