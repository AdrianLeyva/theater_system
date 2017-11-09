package model;

public class Ticket {
    private String id;
    private String seatNumber;
    private String  obraId;
    private String customerName;

    public Ticket() {
    }

    public Ticket(String id, String seatNumber, String obraId, String customerName) {
        this.id = id;
        this.seatNumber = seatNumber;
        this.obraId = obraId;
        this.customerName = customerName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getObra() {
        return obraId;
    }

    public void setObra(String obraId) {
        this.obraId = obraId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
