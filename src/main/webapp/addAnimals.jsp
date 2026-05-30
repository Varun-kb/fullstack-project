<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
    Integer userId =
    (Integer) session.getAttribute("userId");

    if(userId == null){

        response.sendRedirect("login.jsp");

        return;
    }
%>

<!DOCTYPE html>

<html>

<head>

    <meta charset="UTF-8">

    <title>Lost Animal Report</title>

    <link rel="stylesheet" href="style.css">

</head>

<body>

    <header>

        <h1>GrazeNex</h1>

        <p id="slogan">

            Lost Animal Reporting Portal

        </p>

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

        <form class="register-form"
              action="addLostAnimal"
              method="post">

            <h2 id="form-head">

                Lost Animal Details

            </h2>

            <div class="input-group">

                <label>Animal Name</label>

                <input type="text"
                       name="animalName"
                       placeholder="Enter Animal Name"
                       required>

            </div>

            <div class="input-group">

                <label>Category</label>

                <select name="category">

                    <option value="Cow">Cow</option>

                    <option value="Ox">Ox</option>

                    <option value="Sheep">Sheep</option>

                    <option value="Goat">Goat</option>

                </select>

            </div>

            <div class="input-group">

                <label>Reward Amount</label>

                <input type="number"
                       name="reward"
                       placeholder="Reward Amount"
                       required>

            </div>

            <div class="input-group">

                <label>Shed Location</label>

                <textarea name="location"
                          rows="4"
                          placeholder="Enter Shed Location"
                          required></textarea>

            </div>

            <div class="input-group">

                <label>Recognition / Identification</label>

                <textarea name="recognition"
                          rows="4"
                          placeholder="Color, marks, horn details etc."
                          required></textarea>

            </div>

            <button type="submit">

                Submit Report

            </button>

        </form>

    </section>

    <footer>

        <p>&copy; 2026 GrazeNex | All Rights Reserved</p>

        <p>Email: support@grazenex.com</p>

    </footer>

</body>

</html>