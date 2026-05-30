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
<%@ page import="dao.IncomeDAO" %>
<%@ page import="model.Income" %>

<%
    IncomeDAO dao = new IncomeDAO();

    List<Income> incomeList =
    dao.getIncomeByUserId(userId);

    String userName =
    (String) session.getAttribute("userName");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>GrazeNex Income</title>
    <link rel="stylesheet" href="style.css">

</head>

<body>

    <header>

        <h1>GrazeNex</h1>

        <p>Manage your income here!</p>

    </header>

    <nav>

        <a href="index.jsp">Home</a>

        <a href="cattle.jsp">Cattle</a>

        <a href="reports.jsp">Reports</a>

        <a href="expense.jsp">Expense</a>

        <a href="income.jsp">Income</a>

        <a href="logout">Logout</a>

    </nav>

    <section class="register-section">

        <div class="register-form">

            <h2 id="form-head">

                Profit / Income

            </h2>

            <form action="addIncome"
                  method="post">

                <div class="input-group">

                    <label>Income Source</label>

                    <input type="text"
                           name="incomeSource"
                           placeholder="Income Source"
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

                    Add Income

                </button>

            </form>

            <br><br>

            <table border="1">

                <thead>

                    <tr>

                        <th>Source</th>

                        <th>Amount</th>

                        <th>Action</th>

                    </tr>

                </thead>

                <tbody>

                <% for(Income income : incomeList){ %>

                    <tr>

                        <td>

                            <%= income.getIncomeSource() %>

                        </td>

                        <td>

                            ₹ <%= income.getAmount() %>

                        </td>

                        <td>

                            <a href="deleteIncome?id=<%= income.getId() %>">

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