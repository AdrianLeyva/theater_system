package view.main_manager;



import javax.swing.*;
import java.awt.event.ActionEvent;

public class MainManager implements MainManagerProcesses{
    private JPanel jPanel;
    private JLabel employeeName;
    private JButton buyButton;
    private JButton reservationButton;
    private JButton cancelationButton;
    private JButton isOnTimeButton;


    private void createUIComponents() {
        buyButton = new JButton("Buy");
        reservationButton = new JButton("Reservation");
        cancelationButton = new JButton("Cancel reservation/tickets");
        isOnTimeButton = new JButton("Check if reservation is on time");

        activeButtonListeners();

    }

    public static void main(String[] args) {
        MainManager mManager = new MainManager();
        JFrame frame = new JFrame("theater system");

        frame.setContentPane(mManager.jPanel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
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
}
