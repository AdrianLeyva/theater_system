package controller.ticket_office.transaction;

import model.Ticket;

import java.util.ArrayList;

public class Transaction implements TransactionProcess {
    @Override
    public void registerTransaction(Transaction transaction) {

    }

    @Override
    public ArrayList<Ticket> generateTickets() {
        return null;
    }

    @Override
    public void cancelTicketByConditions(String conditionType, String ticketId, String customerName) {

    }
}
