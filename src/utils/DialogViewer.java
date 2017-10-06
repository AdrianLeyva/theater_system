package utils;

import javax.swing.*;
import java.awt.*;

public class DialogViewer {

    public static void showMessageDialog(Component frame, String content, String title,
                                         String typeOfMessage){

        if(typeOfMessage.equals(MessageBack.SUCCESS) || typeOfMessage.equals(MessageBack.AUTHORIZED)){
            JOptionPane.showMessageDialog(frame, content, title, JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(frame, content, title, JOptionPane.ERROR_MESSAGE);
        }
    }
}
