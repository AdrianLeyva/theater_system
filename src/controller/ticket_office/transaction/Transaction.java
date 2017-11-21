package controller.ticket_office.transaction;

import controller.ticket_office.TicketOfficeManager;
import model.Seat;
import model.Show;
import model.Ticket;
import model.persistence.Seats;
import model.persistence.Tickets;
import model.persistence.Transactions;
import model.persistence.dao.SeatDaoImpl;
import model.persistence.dao.TicketDaoImpl;
import model.persistence.dao.TransactionDaoImpl;
import utils.MessageBack;

import java.util.ArrayList;

/**
 * This class handles all transaction processes of ticket office module
 * @author Adrián Leyva Sánchez
 */
public class Transaction implements TransactionProcess {

    @Override
    public MessageBack registerTransaction(model.Transaction transaction, TicketOfficeManager view) {
        String customerName = transaction.getTickets().get(0).getCustomerName();
        TransactionDaoImpl dao = new TransactionDaoImpl(view);
        Transactions daoModel = new Transactions();

        daoModel.setClientName(customerName);
        daoModel.setDate(transaction.getDate());
        daoModel.setTicketsQty(transaction.getTickets().size());
        daoModel.setUser_ID(Integer.valueOf(transaction.getEmployee().getEmployeeId()));
        daoModel.setTypeTransaction(transaction.getTransactionType());
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
    public ArrayList<Ticket> generateTickets(model.Transaction currentTransaction, String folio) {
        TicketDaoImpl dao = new TicketDaoImpl();

        Tickets daoModel = new Tickets();
        daoModel.setSeat_ID(Integer.valueOf(folio));
        daoModel.setTranssaction_ID(Integer.valueOf(currentTransaction.getId()));
        try {
            dao.register(daoModel);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return currentTransaction.getTickets();
    }

    @Override
    public void cancelTicketByConditions(String conditionType, String ticketId, String customerName) {

    }

    private void registerIncomingMoneyByTransaction(){
        /*
            Insert postgresql query....
         */
    }

    public void generateSeats(ArrayList<Seat> selectedSeats, TicketOfficeManager mView){
        SeatDaoImpl dao = new SeatDaoImpl(mView);

        for(Seat seat : selectedSeats){
            Seats daoModel = new Seats();
            daoModel.setSeatNo(Integer.valueOf(seat.getNumber()));
            daoModel.setShow_ID(Integer.valueOf(seat.getShowId()));
            daoModel.setStatus(seat.getStatus());
            daoModel.setZone(seat.getZone());

            try {
                dao.register(daoModel);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
