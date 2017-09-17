package model;

import java.util.ArrayList;
import java.util.Date;

public class Transaction {
    private String id;
    private Date date;
    private ArrayList<Ticket> tickets;
    private Show show;
    private double totalCost;
    private String transactionType;
    private User employee;

    public Transaction() {
    }

    public Transaction(String id, Date date, ArrayList<Ticket> tickets, Show show,
                       double totalCost, String transactionType, User employee) {
        this.id = id;
        this.date = date;
        this.tickets = tickets;
        this.show = show;
        this.totalCost = totalCost;
        this.transactionType = transactionType;
        this.employee = employee;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(ArrayList<Ticket> tickets) {
        this.tickets = tickets;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public User getEmployee() {
        return employee;
    }

    public void setEmployee(User employee) {
        this.employee = employee;
    }
}
