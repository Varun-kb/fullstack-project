package controller;

import java.io.IOException;

import dao.IncomeDAO;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.http.HttpServlet;

import jakarta.servlet.http.HttpServletRequest;

import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deleteIncome")

public class DeleteIncomeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
                         throws ServletException, IOException {

        int incomeId =
        Integer.parseInt(request.getParameter("id"));

        IncomeDAO dao = new IncomeDAO();

        boolean status =
        dao.deleteIncome(incomeId);

        if(status){

            response.sendRedirect("income.jsp");

        } else {

            response.getWriter()
                    .println("Income deletion failed");

        }
    }
}