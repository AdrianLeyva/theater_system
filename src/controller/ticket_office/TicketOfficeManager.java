package controller.ticket_office;

import controller.BaseController;
import controller.ticket_office.login.Logger;
import controller.ticket_office.transaction.Transaction;
import model.Employee;
import utils.MessageBack;


/**
 * This class handle all ticket office modules.
 * @author Adrián Leyva Sánchez
 */
public class TicketOfficeManager extends BaseController {
    private Logger sessionManager;
    private Transaction transaction;

    public TicketOfficeManager() {
        setupDependences();
    }


    /**
     * This method call to Logger by user request, doing login or logout.
     * @param request User request, it can be "Login" or "Logout".
     * @param employee Employee data to process in Logger.
     */
    public MessageBack callToLoginManager(String request, Employee employee){
        if(request.equals(Logger.LOGIN)){
            return sessionManager.loginEmployeeSesion(employee);
        }
        else if(request.equals(Logger.LOGOUT)){
            return sessionManager.logoutEmployeeSesion(employee);
        }
        else{
            return new MessageBack("Request error", "The request can't be identified",
                    MessageBack.ERROR, getClass());
        }
    }


    /**
     * Initialize all TicketOffice dependencies here.
     */
    @Override
    protected void setupDependences() {
        sessionManager = new Logger();
        transaction = new Transaction();
    }
}
