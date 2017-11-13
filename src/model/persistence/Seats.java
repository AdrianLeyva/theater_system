package model.persistence;

public class Seats {
    private Integer seat_ID;
    private Integer seatNo;
    private String zone;
    private Integer show_ID;
    private String status;


    public Integer getSeat_ID() {
        return seat_ID;
    }

    public void setSeat_ID(Integer seat_ID) {
        this.seat_ID = seat_ID;
    }

    public Integer getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(Integer seatNo) {
        this.seatNo = seatNo;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public Integer getShow_ID() {
        return show_ID;
    }

    public void setShow_ID(Integer show_ID) {
        this.show_ID = show_ID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
