package view.show_manager.reschedule;

import controller.ConstantsApp;
import controller.show_manager.ShowManager;
import model.Employee;
import model.Obra;
import model.persistence.Shows;
import model.persistence.dao.ShowDaoImpl;
import utils.DateParser;

import utils.ViewHandler;
import view.show_manager.cancellation.Reader;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class RescheduleManager {
    private JFrame frame;
    private JPanel panel;
    private JButton rescheduleButton;
    private JButton goBackButton;
    private JTable showsTable;
    private DefaultTableModel model;
    private JTextField showNameTextField;
    private JButton searchButton;

    private ShowManager showManager;
    private Employee currentEmployee;
    private ArrayList<Shows> showsList;

    public RescheduleManager(Object object, JFrame frame) {
        currentEmployee = (Employee) object;
        this.frame = frame;
        this.showsList = new ArrayList();
        this.showManager = new ShowManager();
    }

    private void createUIComponents(){
        rescheduleButton = new JButton("Do reschedule");
        goBackButton = new JButton("Go back");
        searchButton = new JButton("Search");

        this.showsTable = new JTable();
        this.showsList = new ArrayList<>();
        final Object[] columnNames = {"Name", "Date", "Time"};

        showsTable.setDefaultRenderer(Object.class, new Reader());
        model = new DefaultTableModel(){
            public boolean isCellEditable(int row, int column){
                if(column == 0)
                    return false;
                else
                    return true;
            }
        };
        model.setColumnIdentifiers(columnNames);
        showsTable.setModel(model);


        searchButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getAllShows();
            }
        });

        rescheduleButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doReschedule();
            }
        });

        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.show_manager.ShowManager showManager = new view.show_manager.ShowManager(currentEmployee, frame);
                ViewHandler.sendTo(frame, showManager.getPanel(),
                        ConstantsApp.ViewTitles.SHOW_MANAGER_VIEW);
            }
        });
    }


    public JPanel getPanel() {
        return panel;
    }


    private void getAllShows(){
        String obraName = showNameTextField.getText();
        ShowDaoImpl dao = new ShowDaoImpl();

        Obra currentObra = dao.findShowByPlayName(obraName);
        for (Shows shows: currentObra.getShowsList()){
            model.addRow(new Object[]{
                    currentObra.getName(),
                    DateParser.parseDateTimeFormat(DateParser.DATE_PATTERN, shows.getDate()),
                    shows.getSchedule()
                    });
        }
        showsList = currentObra.getShowsList();
    }

    private void doReschedule(){
        ShowDaoImpl dao = new ShowDaoImpl();

        for(int i = 0; i < model.getRowCount(); i++){
            java.util.Date date = new java.util.Date();
            String showDate = model.getValueAt(i,1).toString();
            String[] splitsDate = showDate.split("/");

            System.out.println(showDate);
            date = new GregorianCalendar(Integer.valueOf(splitsDate[0]), Integer.valueOf(splitsDate[1]),
                    Integer.valueOf(splitsDate[2])).getTime();

            showsList.get(i).setDate(date);
            showsList.get(i).setSchedule(model.getValueAt(i,2).toString());

            try {
                dao.modify(showsList.get(i));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
