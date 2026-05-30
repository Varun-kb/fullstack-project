package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Income;
import utility.DBConnection;

public class IncomeDAO {

    public boolean addIncome(Income income) {

        boolean status = false;

        try {

            Connection con =
            DBConnection.getConnection();

            String query =
            "INSERT INTO income(user_id,income_source,amount) VALUES(?,?,?)";

            PreparedStatement ps =
            con.prepareStatement(query);

            ps.setInt(1, income.getUserId());

            ps.setString(2, income.getIncomeSource());

            ps.setDouble(3, income.getAmount());

            int rows = ps.executeUpdate();

            if(rows > 0) {
                status = true;
            }

        } catch(Exception e) {

            e.printStackTrace();

        }

        return status;
    }

    public List<Income> getIncomeByUserId(int userId){

        List<Income> incomeList = new ArrayList<>();

        try {

            Connection con =
            DBConnection.getConnection();

            String query =
            "SELECT * FROM income WHERE user_id=?";

            PreparedStatement ps =
            con.prepareStatement(query);

            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {

                Income income = new Income();

                income.setId(rs.getInt("id"));

                income.setUserId(rs.getInt("user_id"));

                income.setIncomeSource(
                rs.getString("income_source"));

                income.setAmount(
                rs.getDouble("amount"));

                incomeList.add(income);
            }

        } catch(Exception e) {

            e.printStackTrace();

        }

        return incomeList;
    }

    public boolean deleteIncome(int incomeId){

        boolean status = false;

        try {

            Connection con =
            DBConnection.getConnection();

            String query =
            "DELETE FROM income WHERE id=?";

            PreparedStatement ps =
            con.prepareStatement(query);

            ps.setInt(1, incomeId);

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