package model;

public class Cattle {

    private int id;

    private int user_id;

    private String cattleName;

    private String breed;

    public Cattle() {

    }

    public Cattle(int id,
                  int user_id,
                  String cattleName,
                  String breed) {

        this.id = id;
        this.user_id = user_id;
        this.cattleName = cattleName;
        this.breed = breed;
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

    public String getCattleName() {
        return cattleName;
    }

    public void setCattleName(String cattleName) {
        this.cattleName = cattleName;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
}