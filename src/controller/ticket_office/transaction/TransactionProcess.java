package controller.ticket_office.transaction;

import controller.ticket_office.TicketOfficeManager;
import model.Ticket;
import model.Transaction;
import utils.MessageBack;

import java.util.ArrayList;

public interface TransactionProcess {
    MessageBack registerTransaction(Transaction transaction, TicketOfficeManager view); //Taquilla c), d),
    void cancelTicketByConditions(String conditionType, String ticketId, String customerName); //Taquilla m), n)
    ArrayList<Ticket> generateTickets(Transaction transaction, String folio);
}
