package view.main_manager;



import model.Employee;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class MainManager implements MainManagerProcesses{
    private JFrame frame;
    private JPanel jPanel;
    private JLabel employeeName;
    private JButton buyButton;
    private JButton reservationButton;
    private JButton cancelationButton;
    private JButton isOnTimeButton;

    public MainManager() {
    }

    public MainManager(Object object, JFrame frame) {
        Employee currentEmployee = (Employee) object;
        this.employeeName.setText("Employee: " + currentEmployee.getEmail());
        this.frame = frame;
    }

    private void createUIComponents() {
        buyButton = new JButton("Buy");
        reservationButton = new JButton("Reservation");
        cancelationButton = new JButton("Cancel reservation/tickets");
        isOnTimeButton = new JButton("Check if reservation is on time");
        activeButtonListeners();

    }

    @Override
    public void doTransaction() {

    }

    @Override
    public void doReservation() {

    }

    @Override
    public void doCancellation() {

    }

    @Override
    public void isOnTimeReservation() {

    }

    private void activeButtonListeners(){
        buyButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*
                 * Show buy viewer...
                 */
            }
        });

        reservationButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*
                 * Show reservation viewer...
                 */
            }
        });

        cancelationButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*
                 * Show cancellation viewer...
                 */
            }
        });

        isOnTimeButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*
                 * Show isOnTime viewer...
                 */
            }
        });
    }

    public JPanel getjPanel() {
        return jPanel;
    }
}
