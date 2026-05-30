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
<%@ page import="dao.CattleDAO" %>
<%@ page import="model.Cattle" %>

<%
    CattleDAO dao = new CattleDAO();
    List<Cattle> cattleList = dao.getCattleByUserId(userId);
    String userName = (String) session.getAttribute("userName");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>GrazeNex</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <header>
        <h1>GrazeNex</h1>
        <p id="slogan">
            Intelligent Livestock Management System
        </p>
    </header>
    <nav>

        <a href="index.jsp">Home</a>
        <a href="reports.jsp">Reports</a>
        <a href="expense.jsp">Expense</a>
        <a href="income.jsp">Income</a>
        <a href="logout">Logout</a>
    </nav>

    <section class="register-section">
        <div class="register-form">
            <h2 id="form-head">
                Cattle Storage
            </h2>
            <form action="addCattle" method="post">
                <div class="input-group">
                    <label>Cattle Name</label>
                    <input type="text"
                           name="cattleName"
                           placeholder="Enter Cattle Name"
                           required>
                </div>
                <div class="input-group">
                    <label>Breed</label>
                    <select name="breed">
                        <option value="Cow">Cow</option>
                        <option value="Goat">Goat</option>
                        <option value="Sheep">Sheep</option>
                        <option value="Ox">Ox</option>
                    </select>
                </div>
                <button type="submit">
                    Add Cattle
                </button>
            </form>
            <br><br>
            <table border="1">
                <thead>
                    <tr>
                        <th>Cattle Name</th>
                        <th>Breed</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                <% for(Cattle cattle : cattleList){ %>
                    <tr>
                        <td>
                            <%= cattle.getCattleName() %>
                        </td>
                        <td>
                            <%= cattle.getBreed() %>
                        </td>
                        <td>
                            <a href="deleteCattle?id=<%= cattle.getId() %>">
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