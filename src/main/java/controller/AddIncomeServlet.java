package controller;

import java.io.IOException;

import dao.IncomeDAO;

import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.http.HttpServlet;

import jakarta.servlet.http.HttpServletRequest;

import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.http.HttpSession;

import model.Income;

@WebServlet("/addIncome")

public class AddIncomeServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
                          throws IOException {

        String incomeSource =
        request.getParameter("incomeSource");

        double amount =
        Double.parseDouble(
        request.getParameter("amount"));

        HttpSession session =
        request.getSession();

        int userId =
        (int) session.getAttribute("userId");

        Income income = new Income();

        income.setUserId(userId);

        income.setIncomeSource(incomeSource);

        income.setAmount(amount);

        IncomeDAO dao = new IncomeDAO();

        boolean status =
        dao.addIncome(income);

        if(status){

            response.sendRedirect("income.jsp");

        } else {

            response.getWriter()
                    .println("Failed to Add Income");

        }
    }
}