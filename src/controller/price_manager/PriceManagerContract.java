package controller.price_manager;

import model.Seat;

import java.util.ArrayList;

 public interface PriceManagerContract {
     double calculateSeatsCost(ArrayList<Seat> seatsList, double showCost);
     void establishDiscountByCondition(int condition, double discount);
}
