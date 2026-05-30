<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
    Integer userId = (Integer) session.getAttribute("userId");

    if(userId == null){

        response.sendRedirect("login.jsp");

        return;
    }
%>

<%@ page import="java.util.List" %>
<%@ page import="dao.ExpenseDAO" %>
<%@ page import="model.Expense" %>

<%
    ExpenseDAO dao = new ExpenseDAO();

    List<Expense> expenseList =
    dao.getExpenseByUserId(userId);

    String userName =
    (String) session.getAttribute("userName");
%>

<!DOCTYPE html>

<html>

<head>

    <meta charset="UTF-8">

    <title>GrazeNex Expense</title>

    <link rel="stylesheet" href="style.css">

</head>

<body>

    <header>

        <h1>GrazeNex</h1>

        <p>Livestock Expense Management</p>

    </header>

    <nav>

        <a href="index.jsp">Home</a>

        <a href="cattle.jsp">Cattle</a>

        <a href="income.jsp">Income</a>

        <a href="expense.jsp">Expense</a>

        <a href="reports.jsp">Reports</a>

        <a href="logout">Logout</a>

    </nav>

    <section class="register-section">

        <div class="register-form">

            <h2 id="form-head">

                Expenditure Management

            </h2>

            <form action="addExpense"
                  method="post">

                <div class="input-group">

                    <label>Expense Item</label>

                    <input type="text"
                           name="expenseName"
                           placeholder="Expense Item"
                           required>

                </div>

                <div class="input-group">

                    <label>Amount</label>

                    <input type="number"
                           name="amount"
                           placeholder="Amount"
                           required>

                </div>

                <button type="submit">

                    Add Expense

                </button>

            </form>

            <br><br>

            <table border="1">

                <thead>

                    <tr>

                        <th>Item</th>

                        <th>Amount</th>

                        <th>Action</th>

                    </tr>

                </thead>

                <tbody>

                <% for(Expense expense : expenseList){ %>

                    <tr>

                        <td>

                            <%= expense.getExpenseName() %>

                        </td>

                        <td>

                            ₹ <%= expense.getAmount() %>

                        </td>

                        <td>

                            <a href="deleteExpense?id=<%= expense.getId() %>">

                                Delete

                            </a>

                        </td>

                    </tr>

                <% } %>

                </tbody>

            </table>

        </div>

    </section>

    <footer>

        <p>&copy; 2026 GrazeNex | All Rights Reserved</p>

        <p>Email: support@grazenex.com | Phone: +91 80733 18562</p>

    </footer>

    <script src="script.js"></script>

</body>

</html>