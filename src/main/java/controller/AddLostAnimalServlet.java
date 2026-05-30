package controller;

import java.io.IOException;

import dao.LostAnimalDAO;

import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.http.HttpServlet;

import jakarta.servlet.http.HttpServletRequest;

import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.http.HttpSession;

import model.LostAnimal;

@WebServlet("/addLostAnimal")

public class AddLostAnimalServlet
extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
                          throws IOException {

        String animalName =
        request.getParameter("animalName");

        String category =
        request.getParameter("category");

        double reward =
        Double.parseDouble(
        request.getParameter("reward"));

        String location =
        request.getParameter("location");

        String recognition =
        request.getParameter("recognition");

        HttpSession session =
        request.getSession();

        int userId =
        (int) session.getAttribute("userId");

        LostAnimal animal =
        new LostAnimal();

        animal.setUserId(userId);

        animal.setAnimalName(animalName);

        animal.setCategory(category);

        animal.setReward(reward);

        animal.setLocation(location);

        animal.setRecognition(recognition);

        LostAnimalDAO dao =
        new LostAnimalDAO();

        boolean status =
        dao.addLostAnimal(animal);

        if(status){

            response.sendRedirect("index.jsp");

        } else {

            response.getWriter()
                    .println("Failed to Submit");

        }
    }
}