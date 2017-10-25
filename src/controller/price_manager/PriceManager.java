package controller.price_manager;

import controller.BaseController;
import controller.ConstantsApp;
import model.Seat;
import utils.DateParser;

import java.util.ArrayList;

/**
 * This class handles discount processes, calculating and establishing prices.
 * @author Adrián Leyva Sánchez
 */
public class PriceManager extends BaseController implements PriceManagerContract{
    private static final String MON = "MON";
    private static final String TUE = "TUE";
    private static final String WED = "WED";
    private static final String THU = "THU";
    private static final String FRI = "FRI";
    private static final String SAT = "SAT";

    public static final int FIRST_CONDITION = 1;
    public static final int SECOND_CONDITION = 2;
    public static final int THIRD_CONDITION = 3;


    @Override
    protected void setupDependencies() {

    }

    /**
     * This method calculate the total cost, depending of seat zone and the weekday of purchase.
     * @param seatsList, seats chosen by the customer.
     * @param showCost, base cost of the chosen show.
     * @return total cost with discount already applied.
     */
    @Override
    public double calculateSeatsCost(ArrayList<Seat> seatsList, double showCost) {
        double totalCost = 0;

        for (Seat i : seatsList){
            switch (i.getZone()){
                case ConstantsApp.Seat.DIAMOND:
                    totalCost += showCost;
                    calculateSeatsCostByDate(totalCost);
                    break;
                case ConstantsApp.Seat.GOLD:
                    totalCost += showCost * 0.9; // 90% discount
                    calculateSeatsCostByDate(totalCost);
                    break;
                case ConstantsApp.Seat.SILVER:
                    totalCost += showCost * 0.75; // 75% discount
                    calculateSeatsCostByDate(totalCost);
                    break;
                case ConstantsApp.Seat.BRONZE:
                    totalCost += showCost * 0.60; // 60% discount
                    calculateSeatsCostByDate(totalCost);
                    break;
                case ConstantsApp.Seat.LATA:
                    totalCost += showCost * 0.50; // 50% discount
                    calculateSeatsCostByDate(totalCost);
                    break;
                default:
                    break;
            }
        }

        return totalCost;
    }

    /**
     * This method apply discount to show cost depending of the weekday.
     * @param cost, current show cost.
     * @return cost with discount applied.
     */
    private double calculateSeatsCostByDate(double cost){
        /*
         * Get the weekday.
         */
        String date = DateParser.parseCurrentDateTimeFormat(DateParser.DATE_PATTERN_V2);
        String[] dateSplit = date.split(",");
        String today = dateSplit[0];

        /*
         * Get the current hour.
         */
        String time = DateParser.parseCurrentDateTimeFormat(DateParser.TIME_PATTERN);
        String[] timeSplit = time.split(":");
        int hour = Integer.valueOf(timeSplit[0]);


        /*
         * Get established discount for Monday, Thursday, Wednesday, Tuesday.
         */
        if(today.equals(MON) || today.equals(THU) || today.equals(WED) || today.equals(TUE)){
            return cost * getDiscount(FIRST_CONDITION);
        }

        /*
         * Get established discount for Friday and Saturday before 17:00 hrs.
         */
        if((today.equals(FRI) || today.equals(SAT)) && hour < 17){
            return cost * getDiscount(SECOND_CONDITION);
        }

        /*
         * Get established discount for Friday and Saturday from 17:00 hrs.
         */
        if((today.equals(FRI) || today.equals(SAT)) && hour >= 17){
            return cost * getDiscount(THIRD_CONDITION);
        }

        //No discount in Sunday
        return cost;
    }

    /**
     * Query to database to get discounts established by the obra manager.
     * @param condition, type of discount, it depends of the weekday.
     * @return percentage of discount to be applied.
     */
    private double getDiscount(int condition){
        /*
         * Query to postgresql database.
         */
        return 0; //It has to be implemented
    }

    /**
     * This method establish discounts defined by the obra manager, inserting into database.
     * @param condition, type of discount.
     * @param discount, percentage of discount to be applied.
     */
    @Override
    public void establishDiscountByCondition(int condition, double discount){
        switch (condition){
            case FIRST_CONDITION:
                /*
                 * Insert to postgresql database
                 */
                break;
            case SECOND_CONDITION:
                /*
                 * Insert to postgresql database
                 */
                break;
            case THIRD_CONDITION:
                /*
                 * Insert to postgresql database
                 */
                break;
            default:
                break;
        }
    }
}
