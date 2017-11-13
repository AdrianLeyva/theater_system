package model.persistence;

public class Tickets {
    private Integer ticket_ID;
    private Integer transsaction_ID;
    private Integer seat_ID;


    public Integer getTicket_ID() {
        return ticket_ID;
    }

    public void setTicket_ID(Integer ticket_ID) {
        this.ticket_ID = ticket_ID;
    }

    public Integer getTranssaction_ID() {
        return transsaction_ID;
    }

    public void setTranssaction_ID(Integer transsaction_ID) {
        this.transsaction_ID = transsaction_ID;
    }

    public Integer getSeat_ID() {
        return seat_ID;
    }

    public void setSeat_ID(Integer seat_ID) {
        this.seat_ID = seat_ID;
    }
}
