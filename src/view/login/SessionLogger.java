package view.login;


import controller.ConstantsApp;
import controller.ticket_office.login.Logger;
import controller.ticket_office.login.SessionManager;
import model.Employee;
import utils.DialogViewer;
import utils.MessageBack;
import utils.ViewHandler;
import view.main_manager.MainManager;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * This class handles the Login view.
 * @author Adrián Leyva Sánchez
 */
public class SessionLogger implements SessionManager.Viewer{

    private JFrame frame;
    private JTextField emailTextField;
    private JPasswordField passwordTextField;
    private JButton loginButton;
    private JPanel jPanel;

    private Logger loggerController;

    public SessionLogger() {
    }

    public SessionLogger(JFrame frame) {
        this.frame = frame;
    }


    private void createUIComponents() {
        this.loggerController = new Logger();

        //Adding click listener to login button
        loginButton = new JButton("Ingresar");
        loginButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doLogin();
            }
        });
    }

    @Override
    public void doLogin() {
        Employee employee = new Employee();
        employee.setEmail(emailTextField.getText());
        employee.setPassword(passwordTextField.getText());

        MessageBack messageBack;
        messageBack = loggerController.loginEmployeeSesion(employee);

        if(messageBack.getTypeOfMessage().equals(MessageBack.AUTHORIZED)){
            MainManager mManager = new MainManager(employee, frame);
            ViewHandler.sendTo(frame, mManager.getjPanel(), ConstantsApp.ViewTitles.MAIN_VIEW);
        }
        else{
            DialogViewer.showMessageDialog(this.jPanel, messageBack.getContent(), messageBack.getSubject(),
                    messageBack.getTypeOfMessage());
        }
    }

    public JPanel getjPanel() {
        return jPanel;
    }
}
