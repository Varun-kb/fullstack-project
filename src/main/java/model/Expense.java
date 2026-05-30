package model;

public class Expense {

    private int id;

    private int user_id;

    private String expenseName;

    private double amount;

    public Expense() {

    }

    public Expense(int id,
                   int user_id,
                   String expenseName,
                   double amount) {

        this.id = id;
        this.user_id = user_id;
        this.expenseName = expenseName;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return user_id;
    }

    public void setUserId(int user_id) {
        this.user_id = user_id;
    }

    public String getExpenseName() {
        return expenseName;
    }

    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}