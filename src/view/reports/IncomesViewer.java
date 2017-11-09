package view.reports;

import model.Employee;
import model.Show;
import utils.ViewHandler;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class IncomesViewer {
    private JFrame frame;
    private JPanel panel1;
    private JTextField beginDateTextField;
    private JTextField endDateTextField;
    private JButton searchButton;
    private JTable incomesTable;
    private DefaultTableModel model;
    private JButton goBackButton;

    private Employee currentEmployee;


    public IncomesViewer(Object object, JFrame frame) {
        this.frame = frame;
        currentEmployee = (Employee) object;
    }

    private void createUIComponents() {
        final Object[] columnNames = {"ID", "Date", "Time", "Total", "Employee"};
        incomesTable = new JTable();
        model = new DefaultTableModel();

        model.setColumnIdentifiers(columnNames);
        incomesTable.setModel(model);

        searchButton = new JButton("Search");
        goBackButton = new JButton("Go back");

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doSearch(beginDateTextField.getText(), endDateTextField.getText());
            }
        });

        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Reports mReports = new Reports(currentEmployee, frame);
                ViewHandler.sendTo(frame, mReports.getPanel1(), "Reports");
            }
        });
    }

    private ArrayList<Show> doSearch(String beginDate, String endDate){
        //TODO: Do query in database to get table's results
        return null;
    }

    public JPanel getPanel1() {
        return panel1;
    }
}
