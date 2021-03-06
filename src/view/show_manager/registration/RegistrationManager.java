package view.show_manager.registration;

import controller.ConstantsApp;
import controller.show_manager.ShowManager;
import model.Employee;
import model.Obra;
import model.ObraManager;
import model.Show;
import model.persistence.Plays;
import model.persistence.Shows;
import model.persistence.dao.PlaysDaoImpl;
import model.persistence.dao.ShowDaoImpl;
import utils.*;
import view.show_manager.cancellation.Reader;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class RegistrationManager implements RegistrationManagerContract {
    private JFrame frame;
    private JPanel jPanel;
    private DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
    private JLabel jLabelRegistration;
    private JTextField obraName;
    private JTextArea obraDescription;
    private JLabel jLabelContactData;
    private JTextField managerPhone;
    private JTextField managerAltPhone;
    private JTextField managerEmail;
    private JLabel jLabelShows;
    private JTextField showDate;
    private JTextField showTime;
    private JButton addShowButton;
    private JTable showsTable;
    private JButton doRegisterButton;
    private JButton goBackButton;

    private Employee currentEmployee;
    private ArrayList<Shows> showsList;
    private Obra obra;
    private ShowManager showManager;
    private PlaysDaoImpl playsDao;
    private ShowDaoImpl showDao;

    public RegistrationManager() {
    }

    public RegistrationManager(Object object, JFrame frame) {
        currentEmployee = (Employee) object;
        this.frame = frame;
        this.obra = new Obra();
        this.showManager = new ShowManager();
        this.playsDao = new PlaysDaoImpl();
        this.showDao =new ShowDaoImpl();
    }

    private void createUIComponents(){
        addShowButton = new JButton("Add show");
        goBackButton = new JButton("Go back");
        doRegisterButton = new JButton("Do register");
        this.showsTable = new JTable();
        this.showsList = new ArrayList<>();
        final Object[] columnNames = {"Date", "Time", "Delete"};


        showsTable.setDefaultRenderer(Object.class, new Reader());
        DefaultTableModel model = new DefaultTableModel(){
            public boolean isCellEditable(int row, int column){
                return true;
            }
        };
        model.setColumnIdentifiers(columnNames);
        showsTable.setModel(model);
        setMouseClick(showsTable, model);



        addShowButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!showDate.getText().isEmpty() && !showTime.getText().isEmpty()){
                    Shows show = new Shows();
                    show.setSchedule(showTime.getText());
                    java.util.Date date = new java.util.Date();
                    String showDateFormat = showDate.getText();
                    String[] splitsDate = showDateFormat.split("/");

                    System.out.println(showDateFormat);
                    date = new GregorianCalendar(Integer.valueOf(splitsDate[0]), Integer.valueOf(splitsDate[1]),
                            Integer.valueOf(splitsDate[2])).getTime();
                    show.setDate(date);
                    show.setStatus(Obra.STATUS_AVAILABLE);

                    JButton btn2 = new JButton("Delete");
                    btn2.setName("delete");

                    showsList.add(show);
                    Object[] row = {show.getDate(), show.getSchedule(), btn2};
                    DefaultTableModel model = (DefaultTableModel) showsTable.getModel();
                    model.addRow(row);
                }
                else{
                    DialogViewer.showMessageDialog(getjPanel(), "Date and Time fields are empty!",
                            "Alert", MessageBack.ERROR);
                }
            }
        });

        doRegisterButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(validateFields()){

                        ObraManager obraManager = new ObraManager();
                        obraManager.setPhone(managerPhone.getText());
                        obraManager.setBackupPhone(managerAltPhone.getText());
                        obraManager.setEmail(managerEmail.getText());

                        obra.setName(obraName.getText());
                        obra.setDescription(obraDescription.getText());
                        obra.setStatus(Obra.STATUS_AVAILABLE);
                        obra.setManager(obraManager);
                        Plays play = new Plays();
                        play.setName(obra.getName());
                        play.setDescription(obra.getDescription());
                        play.setStatus(obra.getStatus());
                        play.setPlayManager_ID(1);
                        play.setClassification("E");
                        int idPlay = 0;
                        try {
                          idPlay = playsDao.register(play);
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                        for (Shows show: showsList){
                            try {
                                show.setPlay_ID(idPlay);
                                showDao.register(show);
                            } catch (Exception e1) {
                                e1.printStackTrace();
                            }

                        }

                        //obra.setShowsList(showsList);
                        /*
                        * Register Obra in database
                        */

                        DialogViewer.showMessageDialog(getjPanel(), "Obra saved successfully",
                                "Saved", MessageBack.SUCCESS);

                }else{
                    DialogViewer.showMessageDialog(getjPanel(), "Some fields are empties!",
                            "Alert", MessageBack.ERROR);
                }

            }
        });

        goBackButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.show_manager.ShowManager showManager = new view.show_manager.ShowManager(currentEmployee, frame);
                ViewHandler.sendTo(frame, showManager.getPanel(), ConstantsApp.ViewTitles.SHOW_MANAGER_VIEW);
            }
        });
    }

    public JPanel getjPanel() {
        return jPanel;
    }

    @Override
    public boolean validateFields() {
        if(obraName.getText().isEmpty())
            return false;
        if(obraDescription.getText().isEmpty())
            return false;
        if(managerPhone.getText().isEmpty())
            return false;
        if(managerAltPhone.getText().isEmpty())
            return false;
        if(managerEmail.getText().isEmpty())
            return false;
        if(showsList.isEmpty())
            return false;


        return true;
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

                System.out.println("entre1");

                if(boton.getName().equals("modifi")){
                    System.out.println("Click en el boton modificar");
                    //EVENTOS MODIFICAR
                }
                if(boton.getName().equals("delete")){
                    JOptionPane.showConfirmDialog(null, "Desea eliminar este registro", "Confirmar", JOptionPane.OK_CANCEL_OPTION);
                    System.out.println("Click en el boton eliminar" + row);
                    model.removeRow(row);
                    //deleteFunction(row);
                    //t.deleteAlarm(row);
                    //EVENTOS ELIMINAR
                }
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

    @Override
    public boolean isValidDateFormat() {
        return true;
    }

    @Override
    public boolean isValidTimeFormat() {
        return true;
    }

}
