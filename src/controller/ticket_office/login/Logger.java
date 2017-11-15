package controller.ticket_office.login;

import model.Employee;
import model.persistence.Users;
import model.persistence.dao.UsersDaoImpl;
import utils.MessageBack;

import java.util.List;

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
        boolean flag = false;
        UsersDaoImpl dao = new UsersDaoImpl();
        System.out.println("P: " + password + ", E: " + email);
        try {
            List<Users> users = dao.listUsers();
            for (Users user: users){
                if(user.getEmail().equals(email) && user.getPassword().equals(password)){
                    flag = true;
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    private boolean isLogged(String employeeId){
        /*
           Query in postgresql...
        */

        return true;
    }
}
