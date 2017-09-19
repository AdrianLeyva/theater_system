package model;

public class Employee {
    private String employeeId;
    private boolean isAdmin;
    private String email;
    private String password;

    public Employee() {
    }

    public Employee(String employeeId, boolean isAdmin, String email, String password) {
        this.employeeId = employeeId;
        this.isAdmin = isAdmin;
        this.email = email;
        this.password = password;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
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
