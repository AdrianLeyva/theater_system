package controller.ticket_office.reservation;


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
    public void cancelReservation(String folioReservation) {

    }

    @Override
    public void showReservation(String folioReservation) {

    }

    @Override
    public void registerSaleByReservation(String folioReservation) {

    }

    public double calculateSeatsCost(ArrayList<Seat> seats){
        double totalCost = 0;

        for (Seat i : seats){
            switch (i.getZone()){
                case "DIAMANTE":
                    totalCost += 2000; //It's going to change.. [ASSIGN NEW VALUE].
                    break;
                case "ORO":
                    totalCost += 1000; //It's going to change.. [ASSIGN NEW VALUE].
                    break;
                case "PLATA":
                    totalCost += 500; //It's going to change.. [ASSIGN NEW VALUE].
                    break;
                case "BRONCE":
                    totalCost += 250; //It's going to change.. [ASSIGN NEW VALUE].
                    break;
                case "LATA":
                    totalCost += 100; //It's going to change.. [ASSIGN NEW VALUE].
                    break;
                default:
                    break;
            }
        }

        return totalCost;
    }

    public boolean isDataOk(ArrayList<Seat> seats){
        boolean isOk = true;

        for (Seat i : seats){
            switch (i.getZone()){
                case "DIAMANTE":
                    isOk = true;
                    break;
                case "ORO":
                    isOk = true;
                    break;
                case "PLATA":
                    isOk = true;
                    break;
                case "BRONCE":
                    isOk = true;
                    break;
                case "LATA":
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
