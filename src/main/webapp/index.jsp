<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>GrazeNex</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<%
    String userName = (String) session.getAttribute("userName");
%>
    <header>
        <h1>GrazeNex</h1>
        <p id="slogan">Intelligent Livestock Management System</p>
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

    <section>

        <h1 id="welcomeMessage">

            <% if(userName != null){ %>

                Welcome <%= userName %> to GrazeNex Portal

            <% } else { %>

                Welcome to GrazeNex Livestock Management Portal

            <% } %>

        </h1>

        <div class="box">

            <p>
                GrazeNex helps farmers and livestock owners manage animal
                records, health monitoring, feeding schedules, and farm
                productivity in one smart platform.
            </p>

            <h2>Features Available</h2>

            <ul>
                <li>Register and manage livestock details</li>
                <li>Track animal health and vaccination records</li>
                <li>Monitor feeding schedules and nutrition plans</li>
             <li>Maintain breeding and milk production records</li>
                <li>Generate farm reports and productivity analysis</li>
              <li>Access livestock information anytime, anywhere</li>
            </ul>

            <h2>Why Choose GrazeNex?</h2>

            <p>
                GrazeNex simplifies livestock management by helping farmers
                organize animal data efficiently, improve farm productivity,
                reduce manual work, and ensure better animal care through
                digital monitoring and smart record keeping.
            </p>

        </div>

    </section>

    <footer>

        <p>&copy; 2026 GrazeNex | All Rights Reserved</p>
        <p>Email: support@grazenex.com | Phone: +91 80733 18562</p>

    </footer>

    <script src="script.js"></script>

</body>

</html>