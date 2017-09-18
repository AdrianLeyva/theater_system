package controller.ticket_office;

import controller.ticket_office.contracts.SalesProcess;

public class BackgroundTasks implements SalesProcess.BackgroundTasks{
    @Override
    public void cancelCaducatedReservations(String showId) {

    }

    @Override
    public void setfreeSeatsByCancelation() {

    }

    @Override
    public void registerPaymentType() {

    }
}
