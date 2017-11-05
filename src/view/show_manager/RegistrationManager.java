package view.show_manager;

import controller.ConstantsApp;
import controller.show_manager.ShowManager;
import model.Employee;
import model.Obra;
import model.ObraManager;
import model.Show;
import utils.*;
import view.main_manager.MainManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class RegistrationManager implements RegistrationManagerContract {
    private JFrame frame;
    private JPanel jPanel;
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
    private ArrayList<Show> showsList;
    private Obra obra;
    private ShowManager showManager;

    public RegistrationManager() {
    }

    public RegistrationManager(Object object, JFrame frame) {
        currentEmployee = (Employee) object;
        this.frame = frame;
        this.obra = new Obra();
        this.showManager = new ShowManager();
    }

    private void createUIComponents(){
        addShowButton = new JButton("Add show");
        goBackButton = new JButton("Go back");
        doRegisterButton = new JButton("Do register");
        this.showsTable = new JTable();
        this.showsList = new ArrayList<>();
        final String[] columnNames = {"Date", "Time"};

        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        showsTable.setModel(model);



        addShowButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!showDate.getText().isEmpty() && !showTime.getText().isEmpty()){
                    Show show = new Show();
                    show.setId(FolioGenerator.generateFolio());
                    show.setHour(showTime.getText());
                    show.setDate(showDate.getText());
                    show.setStatus(Obra.STATUS_AVAILABLE);
                    show.setSeats(SeatsGenerator.generateSeats(show.getId()));

                    showsList.add(show);
                    String[] row = {show.getDate(), show.getHour()};
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
                    if(showManager.registration.isAvailableShowDate(showsList)){
                        ObraManager obraManager = new ObraManager();
                        obraManager.setPhone(managerPhone.getText());
                        obraManager.setBackupPhone(managerAltPhone.getText());
                        obraManager.setEmail(managerEmail.getText());

                        obra.setName(obraName.getText());
                        obra.setDescription(obraDescription.getText());
                        obra.setStatus(Obra.STATUS_AVAILABLE);
                        obra.setManager(obraManager);
                        obra.setShowsList(showsList);
                        /*
                        * Register Obra in database
                        */

                        DialogViewer.showMessageDialog(getjPanel(), "Obra saved successfully",
                                "Saved", MessageBack.SUCCESS);
                    }
                    else{
                        DialogViewer.showMessageDialog(getjPanel(), "Some date and time is already occupied",
                                "Alert", MessageBack.ERROR);
                    }
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

    @Override
    public boolean isValidDateFormat() {
        return true;
    }

    @Override
    public boolean isValidTimeFormat() {
        return true;
    }

}
