package controller.ticket_office;

import model.Ticket;

import java.util.ArrayList;

public interface SalesProcess {

    interface SeatSelector{
        void getAvailableSeats(String showId);
        void getReservedSeats(String showId);
        void getSoldSeats(String showId);
    }

    interface Transaction{
        void registerTransaction(Transaction transaction);
        ArrayList<Ticket> generateTickets();
    }


}
