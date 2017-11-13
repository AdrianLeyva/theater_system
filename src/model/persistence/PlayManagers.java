package model.persistence;

public class PlayManagers {
    private Integer playManager_ID;
    private String email;
    private Integer telephone;
    private String name;
    private Integer altTelephone;


    public Integer getPlayManager_ID() {
        return playManager_ID;
    }

    public void setPlayManager_ID(Integer playManager_ID) {
        this.playManager_ID = playManager_ID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getTelephone() {
        return telephone;
    }

    public void setTelephone(Integer telephone) {
        this.telephone = telephone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAltTelephone() {
        return altTelephone;
    }

    public void setAltTelephone(Integer altTelephone) {
        this.altTelephone = altTelephone;
    }
}
