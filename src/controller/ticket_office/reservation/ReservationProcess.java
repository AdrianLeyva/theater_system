package controller.ticket_office.reservation;

import model.Seat;

import java.util.ArrayList;

public interface ReservationProcess {

    String reserveSeats(ArrayList<Seat> seats, String customerName, String customerPhone,
                        String customerEmail); //Taquilla f), g), h)
    void cancelReservation(String folioReservation); //Taquilla i)
    void showReservation(String folioReservation ); //Taquilla k)
    void registerSaleByReservation(String folioReservation); //Taquilla l
}
