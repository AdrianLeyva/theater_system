package model;

public class Employee extends Person{
    private String employeeId;
    private boolean isAdmin;
    private String password;

    public Employee() {
    }

    public Employee(String employeeId, boolean isAdmin, String email, String password) {
        this.employeeId = employeeId;
        this.isAdmin = isAdmin;
        super.setEmail(email);
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
        return super.getEmail();
    }

    public void setEmail(String email) {
        super.setEmail(email);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
