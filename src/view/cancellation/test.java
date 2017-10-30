package view.cancellation;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class test {
    private static JFrame frame;
    private JTextField nameTxt;
    private JButton SearchBtn;
    private JTable functions;
    private JPanel panel1;

    public test() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Date");
        model.addColumn("Hour");
        model.addColumn("Cancel");
        functions.setModel(model);
    }

    public  static void main(String[] args){
        frame = new JFrame("TableGUI");
        frame.setContentPane(new test().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(new Dimension(600, 400));
    }

}


