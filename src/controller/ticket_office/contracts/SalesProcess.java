package controller.ticket_office.contracts;

import model.Seat;
import model.Ticket;

import java.util.ArrayList;

public interface SalesProcess {

    interface SeatSelector{
        void getAvailableSeats(String showId);
        void getReservedSeats(String showId);
        void getSoldSeats(String showId);
    }

    interface Transaction{
        void registerTransaction(Transaction transaction); //Taquilla c), d),
        ArrayList<Ticket> generateTickets(); //Taquilla e)
        String reserveSeats(ArrayList<Seat> seats, String customerName, String customerPhone,
                          String customerEmail); //Taquilla f), g), h)
        void cancelReservation(String folioReservation); //Taquilla i)
        void showReservation(String folioReservation ); //Taquilla k)
        void registerSaleByReservation(String folioReservation); //Taquilla l
        void cancelTicketByConditions(String conditionType, String ticketId, String customerName); //Taquilla m), n)
    }

    interface Viewer{
        void showTicketsByTransaction(ArrayList<Ticket> tickets);
        void visualizeShowSeats(); //Taquilla a)
        void selectSeats(); //Taquilla b)
        void showDialog(String message);
        void doDevolution();
        void doTransaction();
        String getReferenceDataByPayment(); //Taquilla s)
    }

    interface BackgroundTasks{
        void cancelCaducatedReservations(String showId); //Taquilla j)
        void setfreeSeatsByCancelation(); //Taquilla o)
        void registerPaymentType(); //Taquilla r)
    }


}
