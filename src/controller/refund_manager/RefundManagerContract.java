package controller.refund_manager;

import model.Show;
import model.Ticket;

import java.util.ArrayList;

public interface RefundManagerContract {
    void refundByShowCancellation(Show show);
    void refundByCustomerCancellation(ArrayList<Ticket> tickets, int typeOfCondition);
}
