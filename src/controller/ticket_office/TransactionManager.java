package controller.ticket_office;

import controller.ticket_office.contracts.SalesProcess;
import model.Seat;
import model.Ticket;

import java.util.ArrayList;

public class TransactionManager extends BackgroundTasks implements SalesProcess.Transaction {

    @Override
    public void registerTransaction(SalesProcess.Transaction transaction) {

    }

    @Override
    public ArrayList<Ticket> generateTickets() {
        return null;
    }

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

    @Override
    public void cancelTicketByConditions(String conditionType, String ticketId, String customerName) {

    }
}
