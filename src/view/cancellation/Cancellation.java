package view.cancellation;

import javax.swing.*;
import java.awt.event.*;

public class Cancellation extends JDialog {
    private JPanel contentPane;
    private JButton cancelBtn;
    private JButton exitBtn;
    private JButton searchBtn;
    private JTextField searchTxt;
    private JTable functionsTbl;
    private JFrame frame;
    private JPanel panel;

    public Cancellation() {

        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(cancelBtn);

        cancelBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        exitBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    public Cancellation(JFrame frame) {

    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        Cancellation dialog = new Cancellation();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    private void createUIComponents() {
        String[] columnNames = {"First Name", "Last Name"};
        Object[][] data = {{"Kathy", "Smith"},{"John", "Doe"}};
        functionsTbl = new JTable(data,columnNames);
        functionsTbl.setFillsViewportHeight(true);
        // TODO: place custom component creation code here
    }

    public JPanel getjPanel() {
        return JPanel;
    }
}
