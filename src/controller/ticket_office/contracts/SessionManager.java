package controller.ticket_office.contracts;

import model.Employee;
import utils.MessageBack;

public interface SessionManager {

    MessageBack loginEmployeeSesion(Employee employee); //Taquilla q
    MessageBack logoutEmployeeSesion(Employee employee); //Taquilla q

    interface Viewer{
        void doLogin();
    }
}
