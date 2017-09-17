package model;

public class User {
    private String userId;
    private boolean isAdmin;
    private String email;
    private String password;

    public User() {
    }

    public User(String userId, boolean isAdmin, String email, String password) {
        this.userId = userId;
        this.isAdmin = isAdmin;
        this.email = email;
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
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
