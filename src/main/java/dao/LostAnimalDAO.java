package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.LostAnimal;
import utility.DBConnection;

public class LostAnimalDAO {

    public boolean addLostAnimal(LostAnimal animal){

        boolean status = false;

        try {

            Connection con =
            DBConnection.getConnection();

            String query =
            "INSERT INTO lost_animals(user_id,animal_name,category,reward,location,recognition) VALUES(?,?,?,?,?,?)";

            PreparedStatement ps =
            con.prepareStatement(query);

            ps.setInt(1, animal.getUserId());

            ps.setString(2, animal.getAnimalName());

            ps.setString(3, animal.getCategory());

            ps.setDouble(4, animal.getReward());

            ps.setString(5, animal.getLocation());

            ps.setString(6, animal.getRecognition());

            int rows = ps.executeUpdate();

            if(rows > 0){

                status = true;

            }

        } catch(Exception e){

            e.printStackTrace();

        }

        return status;
    }
}