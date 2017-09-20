package controller.ticket_office.reservation;

import model.Seat;

import java.util.ArrayList;

public class Reservation implements ReservationProcess {
    @Override
    public String reserveSeats(ArrayList<Seat> seats, String customerName, String customerPhone, String customerEmail) {
        return null;
    }

    @Override
    public void cancelReservation(String folioReservation) {

    }

    @Override
    public void showReservation(String folioReservation) {

    }

    @Override
    public void registerSaleByReservation(String folioReservation) {

    }
}
