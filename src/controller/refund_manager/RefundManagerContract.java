package controller.refund_manager;

import model.Show;
import model.Ticket;
import utils.MessageBack;

import java.util.ArrayList;

public interface RefundManagerContract {
    MessageBack refundByShowCancellation(Show show);
    MessageBack refundByCustomerCancellation(ArrayList<Ticket> tickets, int typeOfCondition);
}
