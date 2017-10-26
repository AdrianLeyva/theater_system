package controller.ticket_office.login;

import model.Employee;
import utils.MessageBack;

/**
 * This class handles all login requests of ticket office.
 * @author Adrián Leyva Sánchez
 */
public class Logger implements SessionManager{
    public static final String LOGIN = "LOGIN";
    public static final String LOGOUT = "LOGOUT";

    @Override
    public MessageBack loginEmployeeSesion(Employee employee) {
        String email = employee.getEmail();
        String password = employee.getPassword();


        if(authenticateEmployee(email, password)){
            /*
                Query in postgresql...
             */

            return new MessageBack("Authorized",
                    "The employee's credentials are valid", MessageBack.AUTHORIZED,
                    getClass());
        }
        else {
            /*
                Query in postgresql...
             */

            return new MessageBack("Unauthorized",
                    "The employee's credentials are invalid", MessageBack.UNAUTHORIZED,
                    getClass());
        }
    }

    @Override
    public MessageBack logoutEmployeeSesion(Employee employee) {
        if (isLogged(employee.getEmployeeId())){
            /*
                Query in postgresql...
             */

            return new MessageBack("Success", "The employee's session: " +
                    employee.getEmployeeId() + "is logout", MessageBack.SUCCESS, getClass());
        }
        else{
            return new MessageBack("Error", "Employee is already logout",
                    MessageBack.ERROR, getClass());
        }
    }


    private boolean authenticateEmployee(String email, String password){

        return true;
    }

    private boolean isLogged(String employeeId){
        /*
           Query in postgresql...
        */

        return false;
    }
}
