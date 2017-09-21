package controller.ticket_office;

import controller.BaseController;
import controller.ticket_office.login.Logger;
import controller.ticket_office.transaction.Transaction;
import model.Employee;
import model.Ticket;
import utils.FolioGenerator;
import utils.MessageBack;

import java.util.ArrayList;


/**
 * This class handle all ticket office modules.
 * @author Adrián Leyva Sánchez
 */
public class TicketOfficeManager extends BaseController {
    private Logger sessionManager;
    private Transaction transaction;

    public TicketOfficeManager() {
        setupDependencies();
    }


    /**
     * This method call to Logger by user request, doing login or logout.
     * @param request User request, it can be "Login" or "Logout".
     * @param employee Employee data to process in Logger.
     */
    public MessageBack callToLoginManager(String request, Employee employee){
        if(request.equals(Logger.LOGIN)){
            return sessionManager.loginEmployeeSesion(employee);
        }
        else if(request.equals(Logger.LOGOUT)){
            return sessionManager.logoutEmployeeSesion(employee);
        }
        else{
            return new MessageBack("Request error", "The request can't be identified",
                    MessageBack.ERROR, getClass());
        }
    }




    /**
     * This method handles all transaction process.
     * @param currentTransaction It contents all data of current transaction.
     * @return MessageBack object that contents the result of executed method.
     */
    public MessageBack doTransaction(model.Transaction currentTransaction, String customerName){
        ArrayList<Ticket> boughtTickets = currentTransaction.getTickets();

        //Set customer's name in every bought ticket by him.
        for(Ticket i : boughtTickets ){
            i.setCustomerName(customerName);
        }

        //Do transaction in database.
        MessageBack messageBackTransaction = transaction.registerTransaction(currentTransaction);
        if(messageBackTransaction.getTypeOfMessage().equals(MessageBack.SUCCESS)){
            printTickets(boughtTickets); //Send tickets to printer.
            return messageBackTransaction;
        }
        else{
            return messageBackTransaction;
        }
    }


    /**
     * This method handles all reservation process.
     * @param currentTransaction It contents all data of current transaction.
     * @return MessageBack object that contents the result of executed method.
     */
    public MessageBack doReservation(model.Transaction currentTransaction){
        
        return new MessageBack();
    }


    @Override
    protected void setupDependencies() {
        //Initialize all TicketOffice dependencies here.

        sessionManager = new Logger();
        transaction = new Transaction();
    }

    private void printTickets(ArrayList<Ticket> tickets){
        //Set ticket's identifier.
        for(Ticket i : tickets){
            i.setId(FolioGenerator.generateFolio(i));
        }
        //Call to printer and print tickets... [INSERT CODE]
    }
}
