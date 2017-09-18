package controller.ticket_office.contracts;

import model.Employee;

public interface SessionManager {

    void loginEmployeeSesion(Employee employee); //Taquilla q
    void logoutEmployeeSesion(Employee employee); //Taquilla q

    interface Viewer{
        void doLogin();
    }
}
