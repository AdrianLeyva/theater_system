package controller.ticket_office;

import controller.BaseController;
import controller.ticket_office.login.Logger;
import controller.ticket_office.reservation.Reservation;
import controller.ticket_office.transaction.Transaction;
import model.*;
import utils.FolioGenerator;
import utils.MessageBack;
import utils.PrinterManager;

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
            i.setId(FolioGenerator.generateFolio());
        }

        //Do transaction in database.
        MessageBack messageBackTransaction = transaction.registerTransaction(currentTransaction);
        if(messageBackTransaction.getTypeOfMessage().equals(MessageBack.SUCCESS)){
            //Send tickets to printer.
            PrinterManager.printTickets(boughtTickets);
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

        //Check if each seat has a zone assigned.
        if(reservation.isDataOk(seats)){
            currentReservation.setTotalCost(reservation.calculateSeatsCost(seats, currentReservation.getShow().getCost()));
        }
        else{
            return new MessageBack("Zone unidentified", "Seat hasn't a zone assigned",
                    MessageBack.ERROR, getClass());
        }

        currentReservation.setCustomer(new Customer(customerName, customerPhone, customerEmail));
        currentReservation.setEmployee(employee);
        //Reservation ID has to be set until Reservation object is built (All its attributes).
        currentReservation.setId(FolioGenerator.generateFolio());

        //Calling to reservation method
        MessageBack messageBackReservation = reservation.reserveSeats(currentReservation);
        if(messageBackReservation.getTypeOfMessage().equals(MessageBack.SUCCESS)){
            PrinterManager.printFolioReservation(currentReservation);
            return messageBackReservation;
        }
        else{
            return messageBackReservation;
        }
    }


    /**
     * Receives reservation's identifier and do query into database to cancel
     * done reservation by customer, finally, database is upgraded.
     * @param folioId It's identifier of done reservation by customer.
     * @return message back with query status.
     */
    public MessageBack doCancellationByReservation(String folioId){
        return reservation.cancelReservation(folioId);
    }


    /**
     * Checks if reservation has expired, doing a query in database.
     * @param folioId It's identifier of done reservation by customer.
     * @return true or false, depending of reservation's status.
     */
    public boolean isReservationOnTime(String folioId){
        return reservation.isReservationDue(folioId);
    }




    /**
     * It cancels all tickets selected by customer, just if that tickets belong him.
     * @param ticketIds List of tickets selected by customer for cancellation.
     * @param typeOfCancellation There are four types of cancellation.
     * @param customerName Current customer who is doing cancellation.
     * @return A message back to notify the status of the cancellation process.
     */
    public MessageBack doTicketsCancellation(ArrayList<String> ticketIds, TypeOfCancellation typeOfCancellation,
                                             String customerName){
        ArrayList<Ticket> tickets = null;
        /*
            tickets = Insert postgresql query to get all customer's tickets.
         */

        for(Ticket i : tickets){
            if(!i.getCustomerName().equals(customerName)){
                return new MessageBack("Error with customer's name", "Tickets doesn't belong to current customer",
                        MessageBack.ERROR, getClass());
            }
        }

        if(typeOfCancellation.equals(TypeOfCancellation.FORTYEIGHT_HOURS_BEFORE)){
            /*
                Insert postgresql query to cancel tickets
             */

            return new MessageBack("Ticket cancelled", "Ticket was cancelled sucesfully",
                    MessageBack.SUCCESS, getClass());
        } else if(typeOfCancellation.equals(TypeOfCancellation.TWENTYFOUR_HOURS_BEFORE)){
            /*
                Insert postgresql query to cancel tickets
             */

            return new MessageBack("Ticket cancelled", "Ticket was cancelled sucesfully",
                    MessageBack.SUCCESS, getClass());
        } else if(typeOfCancellation.equals(TypeOfCancellation.TWELVE_HOURS_BEFORE)){
            /*
                Insert postgresql query to cancel tickets
             */

            return new MessageBack("Ticket cancelled", "Ticket was cancelled sucesfully",
                    MessageBack.SUCCESS, getClass());
        } else if(typeOfCancellation.equals(TypeOfCancellation.FOUR_HOURS_BEFORE)){
            /*
                Insert postgresql query to cancel tickets
             */

            return new MessageBack("Ticket cancelled", "Ticket was cancelled sucesfully",
                    MessageBack.SUCCESS, getClass());
        }
        else{
            return new MessageBack("Type undefined", "TypeOfCancellation is invalid",
                    MessageBack.UNIDENTIFIED, getClass());
        }
    }

    @Override
    protected void setupDependencies() {
        //Initialize all TicketOffice dependencies here.

        sessionManager = new Logger();
        transaction = new Transaction();
        reservation = new Reservation();
    }
}
