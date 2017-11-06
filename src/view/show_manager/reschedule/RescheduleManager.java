package view.show_manager.reschedule;

import controller.ConstantsApp;
import controller.show_manager.ShowManager;
import model.Employee;
import model.Show;
import utils.DialogViewer;
import utils.MessageBack;
import utils.ViewHandler;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RescheduleManager {
    private JFrame frame;
    private JPanel panel;
    private JTextField showIdTextField;
    private JTextField dateTextField;
    private JTextField timeTextField;
    private JButton rescheduleButton;
    private JButton goBackButton;

    private ShowManager showManager;
    private Employee currentEmployee;

    public RescheduleManager(Object object, JFrame frame) {
        currentEmployee = (Employee) object;
        this.frame = frame;
        this.showManager = new ShowManager();
    }

    private void createUIComponents(){
        rescheduleButton = new JButton("Do reschedule");
        goBackButton = new JButton("Go back");

        rescheduleButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(validateFields()){
                    Show show = new Show();
                    show.setId(showIdTextField.getText());
                    show.setDate(dateTextField.getText());
                    show.setHour(timeTextField.getText());

                    if(showManager.reschedule.isAvailableShowDate(show)){
                        showManager.reschedule.rescheduleShow(show);
                    }
                    else{
                        DialogViewer.showMessageDialog(getPanel(), "Date / Time is already occupied",
                                "Alert", MessageBack.ERROR);
                    }
                }
                else {
                    DialogViewer.showMessageDialog(getPanel(), "Some fields are empties",
                            "Alert", MessageBack.ERROR);
                }
            }
        });

        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.show_manager.ShowManager showManager = new view.show_manager.ShowManager(currentEmployee, frame);
                ViewHandler.sendTo(frame, showManager.getPanel(),
                        ConstantsApp.ViewTitles.SHOW_MANAGER_VIEW);
            }
        });
    }

    private boolean validateFields(){
        if(showIdTextField.getText().isEmpty())
            return false;
        if(dateTextField.getText().isEmpty())
            return false;
        if(timeTextField.getText().isEmpty())
            return false;

        return true;
    }

    public JPanel getPanel() {
        return panel;
    }
}
