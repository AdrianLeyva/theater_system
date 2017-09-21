package controller.ticket_office.transaction;

import model.Ticket;
import model.Transaction;
import utils.MessageBack;

import java.util.ArrayList;

public interface TransactionProcess {
    MessageBack registerTransaction(Transaction transaction); //Taquilla c), d),
    ArrayList<Ticket> generateTickets(); //Taquilla e)
    void cancelTicketByConditions(String conditionType, String ticketId, String customerName); //Taquilla m), n)
}
