<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%
    String userName =
    (String) session.getAttribute("userName");
%>


<!DOCTYPE html>
<html>
    <head>
        <title>Student Productivity Portal</title>
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <header>
            <h1>GrazeNex</h1>
            <p>Manage your Daily Notes Here! </p>
        </header>
            <nav>
        <a href="index.jsp">Home</a>
        <a href="reports.jsp">Reports</a>

        <% if(userName == null){ %>

            <a href="signup.jsp" id="signupLink">Sign Up</a>

            <a href="login.jsp" id="loginLink">Login</a>

        <% } else { %>

            <a href="addAnimals.jsp">Lost Animals</a>

            <a href="logout">Logout</a>

        <% } %>

    </nav>
        <section class = "register-section">
            <div class="button-container">

            <br><br>
        <a href="cattle.jsp">
            <button class="big-btn">
                Cattle Storage
            </button>
        </a><br><br>

        <a href="expense.jsp">
            <button class="big-btn">
                Expenditure
            </button>
        </a><br><br>

        <a href="income.jsp">
            <button class="big-btn">
                Profit / Income
            </button>
        </a>

    </div>
        </section>

        <br><br><br><br><br><br><br><br><br>
        <footer>
        <p>&copy; 2026 Student Productivity Portal | All Rights Reserved</p>
        <p>Email: support@studentportal.com | Phone: +91 80733 18562</p>
        </footer>
        <script src="script.js"></script>
    </body>
</html>