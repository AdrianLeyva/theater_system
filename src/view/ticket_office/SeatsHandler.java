package view.ticket_office;


import controller.ConstantsApp;
import model.Employee;
import model.Show;

public class SeatsHandler {

    private final Seat[][] seats;
    private Employee currentEmployee;
    private Show currentShow;


    public SeatsHandler(Object object, Show show) {
        // 20 columns and 8 rows
        seats = new Seat[20][8];
        this.seatZoneBroad();
        this.seatZoneCopper();
        this.seatZoneDiamond();
        this.seatZoneGold();
        this.seatZoneSilver();

        currentEmployee = (Employee)object;
        currentShow = show;
    }


    public Seat[][] getSeats() {
        return seats;
    }
    
    private void seatZoneSilver() {
        //first silver zone 
        for (int column = 0; column < 6; column++) {
            for (int row = 5; row < 8; row++) {
                seats[column][row] = new Seat(ConstantsApp.Seat.SILVER, row, column, model.Seat.AVAILABLE_STATE,
                        java.awt.Color.BLUE);
            }
        }
        //second silver zone
        for (int column = 14; column < 20; column++) {
            for (int row = 5; row < 8; row++) {
                seats[column][row] = new Seat(ConstantsApp.Seat.SILVER, row, column, model.Seat.AVAILABLE_STATE,
                        java.awt.Color.BLUE);
            }
        }
    }

    private void seatZoneBroad() {
        //first broad zone 
        for (int column = 0; column < 6; column++) {
            for (int row = 0; row < 6; row++) {
                seats[column][row] = new Seat(ConstantsApp.Seat.LATA, row, column, model.Seat.AVAILABLE_STATE,
                        java.awt.Color.lightGray);
            }
        }
        //second broad zone
        for (int column = 14; column < 20; column++) {
            for (int row = 0; row < 6; row++) {
                seats[column][row] = new Seat(ConstantsApp.Seat.LATA, row, column, model.Seat.AVAILABLE_STATE,
                        java.awt.Color.lightGray);
            }
        }
    }

    private void seatZoneCopper() {
        for (int column = 6; column < 14; column++) {
            for (int row = 0; row < 3; row++) {
                seats[column][row] = new Seat(ConstantsApp.Seat.BRONZE, row, column, model.Seat.AVAILABLE_STATE,
                        java.awt.Color.pink);
            }
        }
    }
    
    private void seatZoneGold() {
        for (int column = 6; column < 14; column++) {
            for (int row = 6; row < 8; row++) {
                seats[column][row] = new Seat(ConstantsApp.Seat.GOLD, row, column, model.Seat.AVAILABLE_STATE,
                        java.awt.Color.YELLOW);
            }
        }
    }
    
    private void seatZoneDiamond() {
        for (int column = 6; column < 14; column++) {
            for (int row = 3; row < 6; row++) {
                seats[column][row] = new Seat(ConstantsApp.Seat.DIAMOND, row, column, model.Seat.AVAILABLE_STATE,
                        java.awt.Color.GREEN);
            }
        }
    }


}
