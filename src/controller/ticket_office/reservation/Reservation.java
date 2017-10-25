package controller.ticket_office.reservation;


import controller.ConstantsApp;
import model.Seat;
import utils.MessageBack;

import java.util.ArrayList;

/**
 * This class handles all reservation processes of ticket office module.
 * @author Adrián Leyva Sánchez
 */
public class Reservation implements ReservationProcess {
    @Override
    public MessageBack reserveSeats(model.Reservation reservation) {
         /*
            Insert postgresql query....
         */


        return new MessageBack();
    }

    @Override
    public MessageBack cancelReservation(String folioReservation) {
        /*
            Insert postgresql query....
         */

        return new MessageBack();
    }

    @Override
    public void showReservation(String folioReservation) {

    }

    @Override
    public void registerSaleByReservation(String folioReservation) {

    }

    @Override
    public boolean isReservationDue(String folioId) {
        boolean isDue = true;
        /*
            Insert postgresql query here...
         */

        return isDue;
    }

    public boolean isDataOk(ArrayList<Seat> seats){
        boolean isOk = true;

        for (Seat i : seats){
            switch (i.getZone()){
                case ConstantsApp.Seat.DIAMOND:
                    isOk = true;
                    break;
                case ConstantsApp.Seat.GOLD:
                    isOk = true;
                    break;
                case ConstantsApp.Seat.SILVER:
                    isOk = true;
                    break;
                case ConstantsApp.Seat.BRONZE:
                    isOk = true;
                    break;
                case ConstantsApp.Seat.LATA:
                    isOk = true;
                    break;
                default:
                    isOk = false;
                    return  isOk;
            }
        }

        return isOk;
    }
}
