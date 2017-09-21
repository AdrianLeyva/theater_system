package controller.ticket_office.transaction;

import model.Ticket;
import utils.MessageBack;

import java.util.ArrayList;

/**
 * This class handles all transaction processes of ticket office module
 * @author Adrián Leyva Sánchez
 */
public class Transaction implements TransactionProcess {

    @Override
    public MessageBack registerTransaction(model.Transaction transaction) {
        /*
            Insert postgresql query....
         */
        registerIncomingMoneyByTransaction();
        return new MessageBack();
    }

    @Override
    public ArrayList<Ticket> generateTickets() {
        return null;
    }

    @Override
    public void cancelTicketByConditions(String conditionType, String ticketId, String customerName) {

    }

    private void registerIncomingMoneyByTransaction(){
        /*
            Insert postgresql query....
         */
    }
}
