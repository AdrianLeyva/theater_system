package controller.ticket_office;

import controller.ticket_office.contracts.SessionManager;
import model.Employee;
import utils.MessageBack;

public class Logger implements SessionManager{

    @Override
    public MessageBack loginEmployeeSesion(Employee employee) {
        String id = employee.getEmployeeId();
        String email = employee.getEmail();
        String password = employee.getPassword();

        if(existEmployee(id)) {
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
        else {
            /*
               Query in postgresql...
             */

            return new MessageBack("Employee doesn't exist",
                    "Employee wasn't found into database", MessageBack.NULL,
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

    private boolean existEmployee(String employeeId){

        return true;
    }

    private boolean authenticateEmployee(String email, String password){

        return true;
    }

    private boolean isLogged(String employeeId){
        /*
           Query in postgresql...
        */

        return true;
    }
}
