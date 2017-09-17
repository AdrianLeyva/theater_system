package model;

public class Ticket {
    private String id;
    private String seatNumber;
    private Obra obra;
    private String customerName;

    public Ticket() {
    }

    public Ticket(String id, String seatNumber, Obra obra, String customerName) {
        this.id = id;
        this.seatNumber = seatNumber;
        this.obra = obra;
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

    public Obra getObra() {
        return obra;
    }

    public void setObra(Obra obra) {
        this.obra = obra;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
