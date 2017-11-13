package model.persistence;

import java.util.Date;

public class Shows {
    private Integer show_ID;
    private Integer play_ID;
    private String schedule;
    private Date date;
    private String status;


    public Integer getShow_ID() {
        return show_ID;
    }

    public void setShow_ID(Integer show_ID) {
        this.show_ID = show_ID;
    }

    public Integer getPlay_ID() {
        return play_ID;
    }

    public void setPlay_ID(Integer play_ID) {
        this.play_ID = play_ID;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
