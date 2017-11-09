package view.reports;

import controller.ConstantsApp;
import model.Employee;
import utils.ViewHandler;
import view.main_manager.MainManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reports {
    private JFrame frame;
    private JPanel panel1;
    private JButton calendarButton;
    private JButton incomesButton;
    private JButton goBackButton;

    private Employee currentEmployee;

    public Reports(Object object, JFrame frame) {
        this.frame = frame;
        currentEmployee = (Employee) object;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        calendarButton = new JButton("Display calendar");
        incomesButton = new JButton("Display incomes");
        goBackButton = new JButton("Go back");

        calendarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CalendarViewer mCalendar = new CalendarViewer(currentEmployee, frame);
                ViewHandler.sendTo(frame, mCalendar.getPanel1(),"Calendar view");
            }
        });

        incomesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IncomesViewer mIncomes = new IncomesViewer(currentEmployee, frame);
                ViewHandler.sendTo(frame, mIncomes.getPanel1(), "Incomes view");
            }
        });

        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainManager mManager = new MainManager(currentEmployee, frame);
                ViewHandler.sendTo(frame, mManager.getjPanel(), ConstantsApp.ViewTitles.MAIN_VIEW);
            }
        });
    }

    public JPanel getPanel1() {
        return panel1;
    }
}
