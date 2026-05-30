<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="UTF-8">

    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>GrazeNex Signup</title>

    <link rel="stylesheet" href="style.css">

</head>

<body>

<%
    String userName = (String) session.getAttribute("userName");

    String successMessage = (String) request.getAttribute("successMessage");

    String errorMessage = (String) request.getAttribute("errorMessage");
%>

    <header>

        <h1>Create Your Account</h1>

        <p id="slogan">Register to GrazeNex</p>

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

    </nav>
<br><br>
    <section class="register-section">

        <form class="register-form"
              action="signup"
              method="post">

            
            <% if(successMessage != null){ %>

                <p style="color:green;">
                    <%= successMessage %>
                </p>

            <% } %>

            <% if(errorMessage != null){ %>

                <p style="color:red;">
                    <%= errorMessage %>
                </p>

            <% } %>

            <div class="input-group">

                <label>Full Name</label>

                <input type="text"
                       id="name"
                       name="name"
                       placeholder="Enter your full name"
                       required>

            </div>

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

                Register

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