package view.show_manager;

import controller.ConstantsApp;
import model.Employee;
import model.Obra;
import model.Show;
import utils.ViewHandler;
import view.main_manager.MainManager;

import javax.swing.*;
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

    public RegistrationManager() {
    }

    public RegistrationManager(Object object, JFrame frame) {
        currentEmployee = (Employee) object;
        this.frame = frame;
    }

    private void createUIComponents(){
        addShowButton = new JButton("Add show");
        goBackButton = new JButton("Go back");
        doRegisterButton = new JButton("Do register");

        addShowButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        goBackButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainManager mMainManager = new MainManager(currentEmployee, frame);
                ViewHandler.sendTo(frame, mMainManager.getjPanel(), ConstantsApp.ViewTitles.MAIN_VIEW);
            }
        });

        doRegisterButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

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
