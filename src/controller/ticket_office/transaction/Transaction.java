package controller.ticket_office.transaction;

import model.Ticket;
import model.persistence.Transactions;
import model.persistence.dao.TransactionDaoImpl;
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

        String customerName = transaction.getTickets().get(0).getCustomerName();
        TransactionDaoImpl dao = new TransactionDaoImpl();
        Transactions daoModel = new Transactions();

        daoModel.setClientName(customerName);
        daoModel.setDate(transaction.getDate());
        daoModel.setTicketsQty(transaction.getTickets().size());
        daoModel.setUser_ID(Integer.valueOf(transaction.getEmployee().getEmployeeId()));
        daoModel.setTypeTransaction(1);
        daoModel.setTotal((int)transaction.getTotalCost());
        daoModel.setFuncion_ID(Integer.valueOf(transaction.getShow().getId()));

        try {
            dao.register(daoModel);
            return new MessageBack("Success","Success", MessageBack.SUCCESS, getClass());
        } catch (Exception e) {
            e.printStackTrace();
            return new MessageBack("Error","Error", MessageBack.ERROR, getClass());
        }

        //registerIncomingMoneyByTransaction();
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
