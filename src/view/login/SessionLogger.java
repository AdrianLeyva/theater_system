package view.login;


import controller.ConstantsApp;
import controller.ticket_office.login.Logger;
import controller.ticket_office.login.SessionManager;
import model.Employee;
import utils.DialogViewer;
import utils.MessageBack;
import view.main_manager.MainManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ResourceBundle;

public class SessionLogger implements SessionManager.Viewer{

    private JFrame frame;
    private JTextField headerTextField;
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

            frame.setTitle(ConstantsApp.ViewTitles.MAIN_VIEW);
            frame.setContentPane(mManager.getjPanel());
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
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
