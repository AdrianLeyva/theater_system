package view;

import controller.ConstantsApp;
import model.Employee;
import model.Show;
import utils.ViewHandler;
import view.main_manager.MainManager;
import view.show_manager.cancellation.Reader;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class ShowFinder {
    private JFrame frame;
    private JPanel panel1;
    private JTextField obraNameTextField;
    private JButton searchButton;
    private JTable showsTable;
    private DefaultTableModel model;
    private JButton goBackButton;

    private Employee currentEmployee;
    private ArrayList<Show> showsList;

    public ShowFinder(Object object, JFrame frame) {
        this.frame = frame;
        this.currentEmployee = (Employee)object;
    }

    private void createUIComponents() {
        showsList = new ArrayList<>();
        Object[] columns = {"Date", "Time", "Show", "Select"};
        searchButton = new JButton("Search");
        goBackButton = new JButton("Go back");
        showsTable = new JTable();
        showsTable.setDefaultRenderer(Object.class, new Reader());
        model = new DefaultTableModel(){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        model.setColumnIdentifiers(columns);
        showsTable.setPreferredScrollableViewportSize(showsTable.getPreferredSize());
        showsTable.setModel(model);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doSearch(obraNameTextField.getText());
            }
        });

        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainManager mMainManager = new MainManager(currentEmployee, frame);
                ViewHandler.sendTo(frame, mMainManager.getjPanel(), ConstantsApp.ViewTitles.MAIN_VIEW);
            }
        });

        setMouseClick(showsTable, model);
    }

    private void doSearch(String obraName){
        model.addRow(new Object[]{"08-11-2017", "21:03", "Construccion", new JButton("Select")});
    }

    private void setMouseClick(JTable tbl, final DefaultTableModel model){
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                TableFunctionMouseClicked(e, model);
            }
        });
    }

    private void TableFunctionMouseClicked(java.awt.event.MouseEvent evt, DefaultTableModel model) {//GEN-FIRST:event_TableAlarmsMouseClicked

        int column = showsTable.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY()/showsTable.getRowHeight();
        System.out.println("entre2");

        if(row < showsTable.getRowCount() && row >= 0 && column < showsTable.getColumnCount() && column >= 0){
            Object value = showsTable.getValueAt(row, column);
            if(value instanceof JButton){
                ((JButton)value).doClick();
                JButton boton = (JButton) value;

                showsList.add(new Show());
                ViewHandler.showTicketOfficeView(currentEmployee, showsList.get(row));
                //ViewHandler.showTicketOfficeView(currentEmployee, new Show());
            }
            if(value instanceof JCheckBox){
                //((JCheckBox)value).doClick();
                JCheckBox ch = (JCheckBox)value;
                if(ch.isSelected()==true){
                    ch.setSelected(false);
                }
                if(ch.isSelected()==false){
                    ch.setSelected(true);
                }

            }
        }

    }

    public JPanel getPanel1() {
        return panel1;
    }
}
