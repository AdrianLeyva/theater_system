package view.ticket_office;

import java.awt.Color;

public class Seat {
    private String idSeat;
    private String status; //Three status : Reserved, Available, Selled
    private final Zone zone;
    private final int row;
    private final int column;
    private final Color color;

    public Color getColor() {
        return color;
    }
    
    public Seat(String zoneType, int row, int column, String status, Color color){
        zone = new Zone(zoneType);
        this.row = row;
        this.column = column;
        this.status = status;
        this.idSeat = (char)(row+65)+""+(column+1);
        this.color = color;
    }
    
    public Zone getZone() {
        return zone;
    }

    public String getIdSeat() {
        return idSeat;
    }

    public String getStatus() {
        return status;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
