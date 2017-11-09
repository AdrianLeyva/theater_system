package model;

public class Seat {
    private String id;
    private String number;
    private String status;
    private String zone;
    private String showId;

    public static final String AVAILABLE_STATE = "AVAILABLE_STATE";
    public static final String OCCUPIED_STATE = "OCCUPIED_STATE";

    public Seat() {
    }

    public Seat(String id, String  number, String status, String zone, String showId) {
        this.id = id;
        this.number = number;
        this.status = status;
        this.zone = zone;
        this.showId = showId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getShowId() {
        return showId;
    }

    public void setShowId(String showId) {
        this.showId = showId;
    }
}
