package controller.ticket_office.transaction;

import model.Ticket;
import java.util.ArrayList;

public interface TransactionProcess {
    void registerTransaction(Transaction transaction); //Taquilla c), d),
    ArrayList<Ticket> generateTickets(); //Taquilla e)
    void cancelTicketByConditions(String conditionType, String ticketId, String customerName); //Taquilla m), n)
}
