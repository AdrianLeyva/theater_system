package controller.ticket_office;

import controller.BaseController;
import controller.ticket_office.login.Logger;
import controller.ticket_office.reservation.Reservation;
import controller.ticket_office.transaction.Transaction;
import model.*;
import utils.FolioGenerator;
import utils.MessageBack;

import java.util.ArrayList;
import java.util.Date;


/**
 * This class handles all ticket office modules.
 * @author Adrián Leyva Sánchez
 */
public class TicketOfficeManager extends BaseController {
    private Logger sessionManager;
    private Transaction transaction;
    private Reservation reservation;

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

        //Set customer's name and Folio ID in every bought ticket by him.
        for(Ticket i : boughtTickets ){
            i.setCustomerName(customerName);
            i.setId(FolioGenerator.generateFolio(i));
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
     * @param seats List of selected seats by customer.
     * @param customerName Name of customer who is doing reservation.
     * @param customerPhone Number phone of customer who is doing reservation.
     * @param customerEmail Email of customer who is doing reservation.
     * @return MessageBack object that contents the result of executed method.
     */
    public MessageBack doReservation(ArrayList<Seat> seats, String customerName,
                                     String customerPhone, String customerEmail,
                                     Show show, Employee employee){


        //Building current reservation.
        model.Reservation currentReservation = new model.Reservation();

        Date reservationDate = new Date();
        currentReservation.setReservationDate(reservationDate);

        Date dueDate = new Date();
        dueDate.setHours(dueDate.getHours() - 2);
        currentReservation.setDueDate(dueDate);

        currentReservation.setShow(show);
        currentReservation.setSeats(seats);

        if(reservation.isDataOk(seats)){
            currentReservation.setTotalCost(reservation.calculateSeatsCost(seats));
        }
        else{
            return new MessageBack("Zone unidentified", "Seat hasn't a zone assigned",
                    MessageBack.ERROR, getClass());
        }

        currentReservation.setCustomer(new Customer(customerName, customerPhone, customerEmail));
        currentReservation.setEmployee(employee);
        currentReservation.setId(FolioGenerator.generateFolio(currentReservation));

        //Calling to reservation method
        MessageBack messageBackReservation = reservation.reserveSeats(currentReservation);
        if(messageBackReservation.getTypeOfMessage().equals(MessageBack.SUCCESS)){
            printFolioReservation(currentReservation);
            return messageBackReservation;
        }
        else{
            return messageBackReservation;
        }
    }


    @Override
    protected void setupDependencies() {
        //Initialize all TicketOffice dependencies here.

        sessionManager = new Logger();
        transaction = new Transaction();
        reservation = new Reservation();
    }

    private void printTickets(ArrayList<Ticket> tickets){
        //Call to printer and print tickets... [INSERT CODE]
    }

    private void printFolioReservation(model.Reservation reservation){
        //Call to viewer and show reservation ID, reservation date and due date of that reservation.
    }
}
