package utils;

import model.Employee;
import model.Show;
import view.ticket_office.SeatsHandler;
import view.ticket_office.TheatreRoomController;

import javax.swing.*;

/**
 * This class handles the projection of views, binding panels into main JFrame.
 * @author Adrián Leyva Sánchez
 */
public class ViewHandler {

    /**
     * Send to specific view.
     * @param frame, parent frame where the panel is going to be showed.
     * @param panel, view that is going to be showed into fragment.
     * @param title
     */
    public static void sendTo(JFrame frame, JPanel panel, String title){
        frame.setTitle(title);
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void showTicketOfficeView(Employee employee, Show show){
        SeatsHandler test = new SeatsHandler(employee, show);
        TheatreRoomController testView = new TheatreRoomController(employee, show);
        testView.setSeats(test.getSeats());
    }


}
