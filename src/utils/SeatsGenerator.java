package utils;

import controller.ConstantsApp;
import model.Seat;

import java.util.ArrayList;

public class SeatsGenerator {
    public static final int TOTAL_SEATS_DIAMOND = 24;
    public static final int TOTAL_SEATS_GOLD = 8;
    public static final int TOTAL_SEATS_SILVER = 24;
    public static final int TOTAL_SEATS_BRONZE = 24;
    public static final int TOTAL_SEATS_LATA = 72;


    public static ArrayList<Seat> generateSeats(String showId){
        ArrayList<Seat> seats = new ArrayList<>();
        int seatNumber = 1;

        for(int i=0; i<TOTAL_SEATS_DIAMOND; i++){
            seats.add(new Seat("0",String.valueOf(seatNumber++),Seat.AVAILABLE_STATE,
                    ConstantsApp.Seat.DIAMOND, showId));
        }

        for(int i=0; i<TOTAL_SEATS_GOLD; i++){
            seats.add(new Seat("0",String.valueOf(seatNumber++),Seat.AVAILABLE_STATE,
                    ConstantsApp.Seat.GOLD, showId));
        }

        for(int i=0; i<TOTAL_SEATS_SILVER; i++){
            seats.add(new Seat("0",String.valueOf(seatNumber++),Seat.AVAILABLE_STATE,
                    ConstantsApp.Seat.SILVER, showId));
        }

        for(int i=0; i<TOTAL_SEATS_BRONZE; i++){
            seats.add(new Seat("0",String.valueOf(seatNumber++),Seat.AVAILABLE_STATE,
                    ConstantsApp.Seat.BRONZE, showId));
        }

        for(int i=0; i<TOTAL_SEATS_LATA; i++){
            seats.add(new Seat("0",String.valueOf(seatNumber++),Seat.AVAILABLE_STATE,
                    ConstantsApp.Seat.LATA, showId));
        }

        return seats;
    }
}
