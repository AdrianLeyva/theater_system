package view.reports;

import model.Employee;
import model.Show;
import model.Seat;
import model.persistence.Shows;
import model.persistence.dao.ShowDaoImpl;
import model.persistence.dao.contracts.ShowDao;
import utils.DateParser;
import utils.ViewHandler;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.List;


public class CalendarViewer {
    private JFrame frame;
    private JPanel panel1;
    private JTextField beginDateTextField;
    private JTextField endDateTextField;
    private JButton searchButton;
    private JTable showsTable;
    private DefaultTableModel model;
    private JButton goBackButton;

    private Employee currentEmployee;


    private ArrayList<Shows> showsList;

    public CalendarViewer(Object object, JFrame frame) {
        this.frame = frame;
        currentEmployee = (Employee) object;

    }

    private void createUIComponents() {
        final Object[] columnNames = {"Date", "Time", "Show"};
        showsList = new ArrayList<>();
        showsTable = new JTable();
        model = new DefaultTableModel();

        model.setColumnIdentifiers(columnNames);
        showsTable.setModel(model);

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

    private ArrayList<Show> doSearch(String  beginDate, String endDate){
        //TODO: Do query in database to get table's results
        ShowDaoImpl dao = new ShowDaoImpl();
        try{
            List<Shows> shows = dao.listShows();
            ArrayList<Shows> allShows = new ArrayList<>(shows);

            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH);
            Date formatedBeginDate = dateFormat.parse(beginDate);
            Date formatedEndDate = dateFormat.parse(endDate);
            for(int i=0; i < allShows.size(); i++) {
                Date result = allShows.get(i).getDate();
                if( result.after(formatedBeginDate)
                        && result.before(formatedEndDate) ) {
                    /* Pruebas en terminal
                    System.out.println(allShows.get(i).getShow_ID());
                    System.out.println(allShows.get(i).getDate());
                    System.out.println(allShows.get(i).getSchedule());
                    System.out.println(allShows.get(i).getStatus());
                    System.out.printf("\n---------------------\n");
                    */
                    showsList.add(allShows.get(i));
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
