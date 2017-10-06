package view;


import controller.ticket_office.login.Logger;
import controller.ticket_office.login.SessionManager;
import model.Employee;
import utils.DialogViewer;
import utils.MessageBack;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class SessionLogger implements SessionManager.Viewer{

    private JTextField headerTextField;
    private JTextField emailTextField;
    private JPasswordField passwordTextField;
    private JButton loginButton;
    private JPanel jPanel;

    private Logger loggerController;

    public static void main(String[] args) {
        SessionLogger mSession = new SessionLogger();
        JFrame frame = new JFrame("theater system");

        frame.setContentPane(mSession.jPanel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
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
            /*
             * Throw new administration window...
            */
        }
        else{
            DialogViewer.showMessageDialog(this.jPanel, messageBack.getContent(), messageBack.getSubject(),
                    messageBack.getTypeOfMessage());
        }
    }
}
