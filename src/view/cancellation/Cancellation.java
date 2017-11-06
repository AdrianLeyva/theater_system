package view.cancellation;

import controller.show_manager.cancellation.CancellationProcess;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseEvent;

public class Cancellation implements CancellationProcess.Viewer{
    private JPanel panel1;
    private JTextField nametxt;
    private JButton searchbtn;
    private JTable table1;
    private JFrame frame;
    public DefaultTableModel t;


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
        return panel1;
    }

    private void setMouseClick(JTable tbl, DefaultTableModel model){
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                TableFunctionMouseClicked(e, model);
            }
        });
    }

    private void TableFunctionMouseClicked(java.awt.event.MouseEvent evt, DefaultTableModel model) {//GEN-FIRST:event_TableAlarmsMouseClicked

        int column = table1.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY()/table1.getRowHeight();
        System.out.println("entre2");

        if(row < table1.getRowCount() && row >= 0 && column < table1.getColumnCount() && column >= 0){
            Object value = table1.getValueAt(row, column);
            if(value instanceof JButton){
                ((JButton)value).doClick();
                JButton boton = (JButton) value;

                System.out.println("entre1");

                if(boton.getName().equals("modifi")){
                    System.out.println("Click en el boton modificar");
                    //EVENTOS MODIFICAR
                }
                if(boton.getName().equals("delete")){
                    JOptionPane.showConfirmDialog(null, "Desea eliminar este registro", "Confirmar", JOptionPane.OK_CANCEL_OPTION);
                    System.out.println("Click en el boton eliminar" + row);
                    model.removeRow(row);
                    //deleteFunction(row);
                    //t.deleteAlarm(row);
                    //EVENTOS ELIMINAR
                }
            }
            if(value instanceof JCheckBox){
                //((JCheckBox)value).doClick();
                JCheckBox ch = (JCheckBox)value;
                if(ch.isSelected()==true){
                    ch.setSelected(false);
                }
                if(ch.isSelected()==false){
                    ch.setSelected(true);
                }

            }
        }

    }

    public void deleteFunction(int row){
        t.removeRow(row);
    }
}
