package model.persistence;

public class Users {
    private Integer user_ID;
    private Integer typeUser_ID;
    private String email;
    private String password;


    public Integer getUser_ID() {
        return user_ID;
    }

    public void setUser_ID(Integer user_ID) {
        this.user_ID = user_ID;
    }

    public Integer getTypeUser_ID() {
        return typeUser_ID;
    }

    public void setTypeUser_ID(Integer typeUser_ID) {
        this.typeUser_ID = typeUser_ID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
