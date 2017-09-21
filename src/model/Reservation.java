package model;

import java.util.ArrayList;
import java.util.Date;

public class Reservation {
    private String id;
    private Date reservationDate;
    private Date dueDate;
    private Show show;
    private ArrayList<Seat> seats;
    private double totalCost;
    private Customer customer;
    private Employee employee;

    public Reservation() {
    }

    public Reservation(String id, Date reservationDate, Date dueDate, Show show,
                       ArrayList<Seat> seats, double totalCost, Customer customer,
                       Employee employee) {
        this.id = id;
        this.reservationDate = reservationDate;
        this.dueDate = dueDate;
        this.show = show;
        this.seats = seats;
        this.totalCost = totalCost;
        this.customer = customer;
        this.employee = employee;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public ArrayList<Seat> getSeats() {
        return seats;
    }

    public void setSeats(ArrayList<Seat> seats) {
        this.seats = seats;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
