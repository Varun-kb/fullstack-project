package model;

public class Income {

    private int id;

    private int user_id;

    private String incomeSource;

    private double amount;

    public Income() {

    }

    public Income(int id,
                  int user_id,
                  String incomeSource,
                  double amount) {

        this.id = id;
        this.user_id = user_id;
        this.incomeSource = incomeSource;
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

    public String getIncomeSource() {
        return incomeSource;
    }

    public void setIncomeSource(String incomeSource) {
        this.incomeSource = incomeSource;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}