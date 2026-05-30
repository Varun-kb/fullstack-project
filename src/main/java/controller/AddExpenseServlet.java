package controller;

import java.io.IOException;

import dao.ExpenseDAO;

import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.http.HttpServlet;

import jakarta.servlet.http.HttpServletRequest;

import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.http.HttpSession;

import model.Expense;

@WebServlet("/addExpense")

public class AddExpenseServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
                          throws IOException {

        String expenseName =
        request.getParameter("expenseName");

        double amount =
        Double.parseDouble(
        request.getParameter("amount"));

        HttpSession session =
        request.getSession();

        int userId =
        (int) session.getAttribute("userId");

        Expense expense = new Expense();

        expense.setUserId(userId);

        expense.setExpenseName(expenseName);

        expense.setAmount(amount);

        ExpenseDAO dao = new ExpenseDAO();

        boolean status =
        dao.addExpense(expense);

        if(status){

            response.sendRedirect("expense.jsp");

        } else {

            response.getWriter()
                    .println("Failed to Add Expense");

        }
    }
}