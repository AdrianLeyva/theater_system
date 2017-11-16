package view.main_manager;



import controller.ConstantsApp;
import controller.ticket_office.login.Logger;
import model.Employee;
import utils.DialogViewer;
import utils.MessageBack;
import utils.ViewHandler;
import view.ShowFinder;
import view.login.SessionLogger;
import view.reports.Reports;
import view.show_manager.ShowManager;
import view.show_manager.ticketCancellation;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * This class handles the Menu view.
 * @author Adrián Leyva Sánchez
 */
public class MainManager implements MainManagerProcesses{
    private JFrame frame;
    private JPanel jPanel;
    private JLabel employeeName;
    private JButton buyButton;
    private JButton cancelationButton;
    private JButton isOnTimeButton;
    private JButton reportsButton;
    private JButton logoutButton;
    private JButton showManagerButton;

    private Employee currentEmployee;

    public MainManager() {
    }

    public MainManager(Object object, JFrame frame) {
        currentEmployee = (Employee) object;

        if(currentEmployee != null)
            this.employeeName.setText("Employee: " + currentEmployee.getEmail());

        this.frame = frame;
    }

    private void createUIComponents() {
        buyButton = new JButton("Buy / Reservation");
        cancelationButton = new JButton("Cancel reservation/tickets");
        isOnTimeButton = new JButton("Check if reservation is on time");
        reportsButton = new JButton("CalendarViewer");
        showManagerButton = new JButton("Manages shows");
        logoutButton = new JButton("Logout");
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
                ShowFinder mShowFinder = new ShowFinder(currentEmployee , frame);
                ViewHandler.sendTo(frame, mShowFinder.getPanel1(), "Show finder");
            }
        });


        cancelationButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ticketCancellation mTicketCancellation = new ticketCancellation(frame);
                ViewHandler.sendTo(frame, mTicketCancellation.getPanel1(), "Cancellation Ticket");
            }
        });

        isOnTimeButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
               String folio = DialogViewer.showInputDialog("Type reservation's folio");
               if(folio != null){
                   DialogViewer.showSimpleMessage(frame, "TODO: Query to database",
                           "Validator");
               }
            }
        });

        reportsButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Reports mReports = new Reports(currentEmployee, frame);
                ViewHandler.sendTo(frame, mReports.getPanel1(), "Reports");
            }
        });

        showManagerButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShowManager showManager = new ShowManager(currentEmployee, frame);
                ViewHandler.sendTo(frame,showManager.getPanel(),
                        ConstantsApp.ViewTitles.SHOW_REGISTRATION_VIEW);
            }
        });

        logoutButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MessageBack messageBack;
                messageBack = new Logger().logoutEmployeeSesion(currentEmployee);

                if(messageBack.getTypeOfMessage().equals(MessageBack.SUCCESS)){
                    SessionLogger mSession = new SessionLogger(frame);
                    ViewHandler.sendTo(frame, mSession.getjPanel(), ConstantsApp.ViewTitles.LOGIN_VIEW);
                }
                else{
                    DialogViewer.showMessageDialog(frame, messageBack.getContent(), messageBack.getSubject(),
                            messageBack.getTypeOfMessage());
                }
            }
        });
    }

    public JPanel getjPanel() {
        return jPanel;
    }
}
