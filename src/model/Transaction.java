package model;

import view.ticket_office.Seat;

import java.util.ArrayList;
import java.util.Date;

public class Transaction {
    private String id;
    private Date date;
    private ArrayList<Ticket> tickets;
    private Show show;
    private double totalCost;
    private String paymentType;
    private Employee employee;
    private ArrayList<model.Seat> selectedSeats;
    private int transactionType;
    private String customerName;

    public static final int PAYMENT_TYPE = 1;
    public static final int RESERVATION_TYPE = 2;
    public static final int CANCELLATION_TYPE = 3;


    public Transaction() {
    }

    public Transaction(String id, Date date, ArrayList<Ticket> tickets, Show show, double totalCost,
                       String paymentType, Employee employee, ArrayList<model.Seat> selectedSeats,
                       int transactionType, String customerName) {
        this.id = id;
        this.date = date;
        this.tickets = tickets;
        this.show = show;
        this.totalCost = totalCost;
        this.paymentType = paymentType;
        this.employee = employee;
        this.selectedSeats = selectedSeats;
        this.transactionType = transactionType;
        this.customerName = customerName;
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

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public ArrayList<model.Seat> getSelectedSeats() {
        return selectedSeats;
    }

    public void setSelectedSeats(ArrayList<model.Seat> selectedSeats) {
        this.selectedSeats = selectedSeats;
    }

    public int getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(int transactionType) {
        this.transactionType = transactionType;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
