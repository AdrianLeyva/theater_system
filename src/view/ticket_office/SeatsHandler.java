package view.ticket_office;


public class SeatsHandler {

    private final Seat[][] seats;

    public SeatsHandler() {
        // 20 columns and 8 rows
        seats = new Seat[20][8];
        this.seatZoneBroad();
        this.seatZoneCopper();
        this.seatZoneDiamond();
        this.seatZoneGold();
        this.seatZoneSilver();
    }

    //Este main es el de pruebas para las vistas de las sillas perrrroooooos
    public static void main(String[] args) {
        SeatsHandler test = new SeatsHandler();
        
        for (int i=0;i<8;i++){
            for(int s=0;s<20;s++){
//                System.out.print(test.getSeats()[s][i].getIdSeat());
//                System.out.println(test.getSeats()[s][i].getZone().getZoneType()+" "+test.getSeats()[s][i].getStatus());
            }
        }
        
        TheatreRoomController testView = new TheatreRoomController();
        testView.setSeats(test.getSeats());
    }

    public Seat[][] getSeats() {
        return seats;
    }
    
    private void seatZoneSilver() {
        //first silver zone 
        for (int column = 0; column < 6; column++) {
            for (int row = 5; row < 8; row++) {
                seats[column][row] = new Seat("Silver", row, column, "Available",java.awt.Color.BLUE);
            }
        }
        //second silver zone
        for (int column = 14; column < 20; column++) {
            for (int row = 5; row < 8; row++) {
                seats[column][row] = new Seat("Silver", row, column, "Available",java.awt.Color.BLUE);
            }
        }
    }

    private void seatZoneBroad() {
        //first broad zone 
        for (int column = 0; column < 6; column++) {
            for (int row = 0; row < 6; row++) {
                seats[column][row] = new Seat("Broad", row, column, "Available",java.awt.Color.lightGray);
            }
        }
        //second broad zone
        for (int column = 14; column < 20; column++) {
            for (int row = 0; row < 6; row++) {
                seats[column][row] = new Seat("Broad", row, column, "Available",java.awt.Color.lightGray);
            }
        }
    }

    private void seatZoneCopper() {
        for (int column = 6; column < 14; column++) {
            for (int row = 0; row < 3; row++) {
                seats[column][row] = new Seat("Copper", row, column, "Available", java.awt.Color.pink);
            }
        }
    }
    
    private void seatZoneGold() {
        for (int column = 6; column < 14; column++) {
            for (int row = 6; row < 8; row++) {
                seats[column][row] = new Seat("Gold", row, column, "Available",java.awt.Color.YELLOW);
            }
        }
    }
    
    private void seatZoneDiamond() {
        for (int column = 6; column < 14; column++) {
            for (int row = 3; row < 6; row++) {
                seats[column][row] = new Seat("Diamond", row, column, "Available",java.awt.Color.GREEN);
            }
        }
    }


}
