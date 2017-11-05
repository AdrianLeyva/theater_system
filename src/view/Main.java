package view;

import controller.ConstantsApp;
import utils.ViewHandler;
import view.cancellation.Cancellation;
import view.login.SessionLogger;

import javax.swing.*;

/**
 * This class initialize the program. Run from here!
 * @author Adrián Leyva Sánchez
 */
public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame(ConstantsApp.ViewTitles.LOGIN_VIEW);
        //SessionLogger mSession = new SessionLogger(frame);
        Cancellation mCancel = new Cancellation(frame);
        ViewHandler.sendTo(frame, mCancel.getjPanel(), ConstantsApp.ViewTitles.LOGIN_VIEW);
    }
}
