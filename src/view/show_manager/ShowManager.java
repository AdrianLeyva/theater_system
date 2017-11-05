package view.show_manager;

import controller.ConstantsApp;
import model.Employee;
import utils.ViewHandler;
import view.main_manager.MainManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShowManager {
    private JFrame frame;
    private JPanel panel;
    private JButton registrationButton;
    private JButton cancellationButton;
    private JButton rescheduleButton;
    private JButton goBackButton;

    private Employee currentEmployee;

    public ShowManager(JFrame frame) {
        this.frame = frame;
    }

    public ShowManager(Employee currentEmployee, JFrame frame) {
        this.frame = frame;
        this.currentEmployee = currentEmployee;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        registrationButton = new JButton("Go to registration view");
        cancellationButton = new JButton("Go to cancellation view");
        rescheduleButton = new JButton("Go to reschedule view");
        goBackButton = new JButton("Go back");

        registrationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegistrationManager registrationManager = new RegistrationManager(currentEmployee, frame);
                ViewHandler.sendTo(frame, registrationManager.getjPanel(),
                        ConstantsApp.ViewTitles.SHOW_REGISTRATION_VIEW);
            }
        });

        cancellationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*
                 * Insert code
                 */
            }
        });

        rescheduleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RescheduleManager rescheduleManager = new RescheduleManager(currentEmployee, frame);
                ViewHandler.sendTo(frame, rescheduleManager.getPanel(),
                        ConstantsApp.ViewTitles.SHOW_REGISTRATION_VIEW);
            }
        });

        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainManager mainManager = new MainManager(currentEmployee, frame);
                ViewHandler.sendTo(frame, mainManager.getjPanel(),
                        ConstantsApp.ViewTitles.MAIN_VIEW);
            }
        });
    }

    public JPanel getPanel() {
        return panel;
    }
}
