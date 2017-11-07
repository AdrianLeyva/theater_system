package view.show_manager.reschedule;

import controller.ConstantsApp;
import controller.show_manager.ShowManager;
import model.Employee;
import model.Show;
import utils.DialogViewer;
import utils.MessageBack;
import utils.ViewHandler;
import view.show_manager.cancellation.Reader;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class RescheduleManager {
    private JFrame frame;
    private JPanel panel;
    private JButton rescheduleButton;
    private JButton goBackButton;
    private JTable showsTable;
    private JTextField showIdTextField;
    private JButton searchButton;

    private ShowManager showManager;
    private Employee currentEmployee;
    private ArrayList showsList;

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
        final Object[] columnNames = {"ID", "Date", "Time"};

        showsTable.setDefaultRenderer(Object.class, new Reader());
        DefaultTableModel model = new DefaultTableModel(){
            public boolean isCellEditable(int row, int column){
                return true;
            }
        };
        model.setColumnIdentifiers(columnNames);
        showsTable.setModel(model);
        getAllFunctions();


        searchButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        rescheduleButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

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


    private void getAllFunctions(){
        Object[] row = {"01", "Date", "Time"};
        DefaultTableModel model = (DefaultTableModel) showsTable.getModel();
        model.addRow(row);
    }
}
