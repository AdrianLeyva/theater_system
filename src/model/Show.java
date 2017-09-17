package model;

import java.util.ArrayList;

public class Show {
    private String id;
    private String hour;
    private String date;
    private double cost;
    private String status;
    private String obraId;
    private ArrayList<Seat> seats;

    public Show() {
    }

    public Show(String id, String hour, String date, double cost, String status,
                String obraId, ArrayList<Seat> seats) {
        this.id = id;
        this.hour = hour;
        this.date = date;
        this.cost = cost;
        this.status = status;
        this.obraId = obraId;
        this.seats = seats;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getObraId() {
        return obraId;
    }

    public void setObraId(String obraId) {
        this.obraId = obraId;
    }

    public ArrayList<Seat> getSeats() {
        return seats;
    }

    public void setSeats(ArrayList<Seat> seats) {
        this.seats = seats;
    }
}
