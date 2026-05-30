<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="UTF-8">

    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>GrazeNex Login</title>

    <link rel="stylesheet" href="style.css">

</head>

<body>

<%
    String userName = (String) session.getAttribute("userName");
    String errorMessage = (String) request.getAttribute("errorMessage");
%>

    <header>

        <h1>Login Here</h1>

        <p id="slogan">Access your GrazeNex Account</p>

    </header>

    <nav>

        <a href="index.jsp">Home</a>
        
        <a href="reports.jsp">Reports</a>
        <% if(userName == null){ %>
            <a href="signup.jsp" id="signupLink">Sign Up</a>
            <a href="login.jsp" id="loginLink">Login</a>

        <% } else { %>
            <a href="logout">Logout</a>
        <% } %>

    </nav><br><br>
    <section class="register-section">

        <form class="register-form" action="login" method="post">
            <% if(errorMessage != null){ %>

                <p style="color:red;">
                    <%= errorMessage %>
                </p>

            <% } %>

            <div class="input-group">

                <label>Email</label>

                <input type="email"
                       id="email"
                       name="email"
                       placeholder="Enter your email"
                       required>
            </div>
            <div class="input-group">

                <label>Password</label>

                <input type="password"
                       id="password"
                       name="pass"
                       placeholder="Enter your password"
                       required>
            </div>
            <button type="submit">
                Login
            </button>
        </form>

    </section>

    <footer>

        <p>&copy; 2026 GrazeNex | All Rights Reserved</p>

        <p>Email: support@grazenex.com | Phone: +91 80733 18562</p>

    </footer>

    <script src="script.js"></script>

</body>

</html>