package controller.ticket_office;

import model.Ticket;

import java.util.ArrayList;

public interface TicketOfficeViewer {

    void showTicketsByTransaction(ArrayList<Ticket> tickets);
    void visualizeShowSeats(); //Taquilla a)
    void selectSeats(); //Taquilla b)
    void showDialog(String message);
    void doDevolution();
    void doTransaction();
    String getReferenceDataByPayment(); //Taquilla s)
}
