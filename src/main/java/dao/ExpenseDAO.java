package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Expense;
import utility.DBConnection;

public class ExpenseDAO {

    public boolean addExpense(Expense expense) {

        boolean status = false;

        try {

            Connection con =
            DBConnection.getConnection();

            String query =
            "INSERT INTO expense(user_id,expense_name,amount) VALUES(?,?,?)";

            PreparedStatement ps =
            con.prepareStatement(query);

            ps.setInt(1, expense.getUserId());

            ps.setString(2, expense.getExpenseName());

            ps.setDouble(3, expense.getAmount());

            int rows = ps.executeUpdate();

            if(rows > 0){
                status = true;
            }

        } catch(Exception e){

            e.printStackTrace();

        }

        return status;
    }

    public List<Expense> getExpenseByUserId(int userId){

        List<Expense> expenseList = new ArrayList<>();

        try {

            Connection con =
            DBConnection.getConnection();

            String query =
            "SELECT * FROM expense WHERE user_id=?";

            PreparedStatement ps =
            con.prepareStatement(query);

            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                Expense expense = new Expense();

                expense.setId(rs.getInt("id"));

                expense.setUserId(rs.getInt("user_id"));

                expense.setExpenseName(
                rs.getString("expense_name"));

                expense.setAmount(
                rs.getDouble("amount"));

                expenseList.add(expense);
            }

        } catch(Exception e){

            e.printStackTrace();

        }

        return expenseList;
    }

    public boolean deleteExpense(int expenseId){

        boolean status = false;

        try {

            Connection con =
            DBConnection.getConnection();

            String query =
            "DELETE FROM expense WHERE id=?";

            PreparedStatement ps =
            con.prepareStatement(query);

            ps.setInt(1, expenseId);

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