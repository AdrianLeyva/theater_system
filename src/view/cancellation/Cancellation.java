package view.cancellation;

import controller.show_manager.cancellation.*;

import javax.swing.*;

public class Cancellation implements CancellationProcess.Viewer{
    private JPanel jPanel;
    private JButton cancelBtn;
    private JButton exitBtn;
    private JButton searchBtn;
    private JTextField searchTxt;
    private JTable functionsTbl;
    private JFrame frame;
    private controller.show_manager.cancellation.Cancellation cancelController;

    public Cancellation() {


    }

    public Cancellation(JFrame frame) {
        this.frame = frame;
    }

    private void createUIComponents() {
        this.cancelController = new controller.show_manager.cancellation.Cancellation();
        String[] columnNames = {"Name", "Date"};
        Object[][] data = {{"Otelo", "02/12/17)"},{"Edipo Rey", "04/12/17"}};
        functionsTbl = new JTable(data,columnNames);
        functionsTbl.setFillsViewportHeight(true);
        // TODO: place custom component creation code here
    }

    @Override
    public void doCancel(){

    }

    public JPanel getjPanel() {
        return jPanel;
    }

}
