package model;

public class ObraManager extends Person{
    private String id;
    private String backupPhone;

    public ObraManager() {
    }

    public ObraManager(String id, String name, String email, String phone,
                       String backupPhone) {
        this.id = id;
        super.setName(name);
        super.setEmail(email);
        super.setPhone(phone);
        this.backupPhone = backupPhone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return super.getName();
    }

    public void setName(String name) {
        super.setName(name);
    }

    public String getEmail() {
        return super.getEmail();
    }

    public void setEmail(String email) {
        super.setEmail(email);
    }

    public String getPhone() {
        return super.getPhone();
    }

    public void setPhone(String phone) {
        super.setPhone(phone);
    }

    public String getBackupPhone() {
        return backupPhone;
    }

    public void setBackupPhone(String backupPhone) {
        this.backupPhone = backupPhone;
    }
}
