package controller.ticket_office.reservation;

import model.Reservation;
import utils.MessageBack;

public interface ReservationProcess {

    MessageBack reserveSeats(Reservation reservation); //Taquilla f), g), h)
    MessageBack cancelReservation(String folioReservation); //Taquilla i)
    void showReservation(String folioReservation ); //Taquilla k)
    void registerSaleByReservation(String folioReservation); //Taquilla l
    boolean isReservationDue(String folioId);
}
