package controller.ticket_office.background_tasks;

public interface BackgroundProcesses {
    void cancelCaducatedReservations(String showId); //Taquilla j)
    void setfreeSeatsByCancelation(); //Taquilla o)
    void registerPaymentType(); //Taquilla r)
}
