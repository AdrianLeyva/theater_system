package model.persistence;

public class Plays {
    private Integer play_ID;
    private Integer playManager_ID;
    private String name;
    private String calssification;
    private String status;
    private String description;


    public Integer getPlay_ID() {
        return play_ID;
    }

    public void setPlay_ID(Integer play_ID) {
        this.play_ID = play_ID;
    }

    public Integer getPlayManager_ID() {
        return playManager_ID;
    }

    public void setPlayManager_ID(Integer playManager_ID) {
        this.playManager_ID = playManager_ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCalssification() {
        return calssification;
    }

    public void setCalssification(String calssification) {
        this.calssification = calssification;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
