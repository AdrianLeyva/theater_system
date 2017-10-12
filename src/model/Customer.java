package model;

public class Customer extends Person{
    public Customer() {
    }

    public Customer(String name, String numberPhone, String email) {
       super(name, numberPhone, email);
    }

    public String getName() {
        return super.getName();
    }

    public void setName(String name) {
        super.setName(name);
    }

    public String getNumberPhone() {
        return super.getPhone();
    }

    public void setNumberPhone(String numberPhone) {
        super.setPhone(numberPhone);
    }

    public String getEmail() {
        return super.getEmail();
    }

    public void setEmail(String email) {
        super.setEmail(email);
    }
}
