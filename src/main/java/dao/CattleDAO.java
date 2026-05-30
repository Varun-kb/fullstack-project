package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Cattle;
import utility.DBConnection;

public class CattleDAO {

    public boolean addCattle(Cattle cattle) {

        boolean status = false;

        try {

            Connection con = DBConnection.getConnection();

            String query =
            "INSERT INTO cattle(user_id,cattle_name,breed) VALUES(?,?,?)";

            PreparedStatement ps =
            con.prepareStatement(query);

            ps.setInt(1, cattle.getUserId());

            ps.setString(2, cattle.getCattleName());

            ps.setString(3, cattle.getBreed());

            int rows = ps.executeUpdate();

            if(rows > 0) {

                status = true;

            }

        } catch(Exception e) {

            e.printStackTrace();

        }

        return status;
    }

    public List<Cattle> getCattleByUserId(int userId){

        List<Cattle> cattleList = new ArrayList<>();

        try {

            Connection con = DBConnection.getConnection();

            String query =
            "SELECT * FROM cattle WHERE user_id=?";

            PreparedStatement ps =
            con.prepareStatement(query);

            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {

                Cattle cattle = new Cattle();

                cattle.setId(rs.getInt("id"));

                cattle.setUserId(rs.getInt("user_id"));

                cattle.setCattleName(
                rs.getString("cattle_name"));

                cattle.setBreed(
                rs.getString("breed"));

                cattleList.add(cattle);
            }

        } catch(Exception e) {

            e.printStackTrace();

        }

        return cattleList;
    }

    public boolean deleteCattle(int cattleId) {

        boolean status = false;

        try {

            Connection con = DBConnection.getConnection();

            String query =
            "DELETE FROM cattle WHERE id=?";

            PreparedStatement ps =
            con.prepareStatement(query);

            ps.setInt(1, cattleId);

            int rows = ps.executeUpdate();

            if(rows > 0) {

                status = true;

            }

        } catch(Exception e) {

            e.printStackTrace();

        }

        return status;
    }
}