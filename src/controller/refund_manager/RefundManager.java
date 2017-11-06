package controller.refund_manager;

import controller.BaseController;
import model.Show;
import model.Ticket;
import utils.MessageBack;

import java.util.ArrayList;
/**
 * This class handles refund processes registering into database every change.
 * @author Adrián Leyva Sánchez
 */

public class RefundManager extends BaseController implements RefundManagerContract{
    public static final int FIRST_CONDITION = 1;
    public static final int SECOND_CONDITION = 2;
    public static final int THIRD_CONDITION = 3;

    @Override
    protected void setupDependencies() {

    }

    @Override
    public MessageBack refundByShowCancellation(Show show) {
        /*
         * Insert postgresql query
         */
        return new MessageBack();
    }

    @Override
    public MessageBack refundByCustomerCancellation(ArrayList<Ticket> tickets, int typeOfCondition) {
        switch (typeOfCondition){
            case FIRST_CONDITION:
                break;
            case SECOND_CONDITION:
                break;
            case THIRD_CONDITION:
                break;
            default:
                break;
        }
        return new MessageBack();
    }
}
