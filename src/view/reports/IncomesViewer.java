package view.reports;

import model.Employee;
import model.Transaction;
import model.persistence.Transactions;
import model.persistence.dao.TransactionDaoImpl;
import utils.ViewHandler;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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

    private ArrayList<Transactions> transactionsList;


    public IncomesViewer(Object object, JFrame frame) {
        this.frame = frame;
        currentEmployee = (Employee) object;
    }

    private void createUIComponents() {
        final Object[] columnNames = {"ID", "Date", "Time", "Total", "Employee"};
        transactionsList = new ArrayList<>();
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

    private ArrayList<Transaction> doSearch(String beginDate, String endDate){
        //TODO: Do query in database to get table's results
        TransactionDaoImpl dao = new TransactionDaoImpl();
        try {
            List<Transactions>  transactions = dao.listTransactions();
            ArrayList<Transactions> allTransactions = new ArrayList<>(transactions);
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH);
            Date formatedBeginDate = dateFormat.parse(beginDate);
            Date formatedEndDate = dateFormat.parse(endDate);
            for(int i = 0; i < allTransactions.size(); i++) {
                Date result = allTransactions.get(i).getDate();
                if( result.after(formatedBeginDate)
                        && result.before(formatedEndDate) ) {
                    transactionsList.add(allTransactions.get(i));
                }
            }



        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public JPanel getPanel1() {
        return panel1;
    }
}
