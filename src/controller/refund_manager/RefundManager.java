package controller.refund_manager;

import controller.BaseController;
import model.Show;
import model.Ticket;

import java.util.ArrayList;

public class RefundManager extends BaseController implements RefundManagerContract{
    @Override
    protected void setupDependencies() {
        
    }

    @Override
    public void refundByShowCancellation(Show show) {

    }

    @Override
    public void refundByCustomerCancellation(ArrayList<Ticket> tickets, int typeOfCondition) {

    }
}
