package view;

import controller.ConstantsApp;
import view.login.SessionLogger;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame(ConstantsApp.ViewTitles.LOGIN_VIEW);
        SessionLogger mSession = new SessionLogger(frame);

        frame.setContentPane(mSession.getjPanel());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
