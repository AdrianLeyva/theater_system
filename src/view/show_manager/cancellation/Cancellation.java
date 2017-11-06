package view.show_manager.cancellation;

import controller.ConstantsApp;
import controller.show_manager.cancellation.CancellationProcess;
import utils.ViewHandler;
import view.show_manager.ShowManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

public class Cancellation implements CancellationProcess.Viewer{
    private JPanel panel1;
    private JTextField nametxt;
    private JButton searchbtn;
    private JTable table1;
    private JButton goBackButton;
    private JFrame frame;
    public DefaultTableModel t;


    private controller.show_manager.cancellation.Cancellation cancelController;

    public Cancellation() {


    }

    public Cancellation(JFrame frame) {
        this.frame = frame;
    }



    private void createUIComponents() {
        goBackButton = new JButton("Go back");
        goBackButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                ShowManager mManager = new ShowManager(frame);
                ViewHandler.sendTo(frame, mManager.getPanel(), ConstantsApp.ViewTitles.SHOW_MANAGER_VIEW);
            }
        });

        this.cancelController = new controller.show_manager.cancellation.Cancellation();
        searchbtn = new JButton();
        this.table1 = new JTable();
        table1.setDefaultRenderer(Object.class, new Reader());
        JButton btn1 = new JButton("Modifi");
        JButton btn2 = new JButton("Delete");
        btn1.setName("modifi");
        btn2.setName("delete");
        DefaultTableModel t = new DefaultTableModel(new Object[]{"Hour","Days","Modificar","Eliminar"}, 0){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        t.addRow(new Object[]{"1","Pedro",btn1,btn2});
        t.addRow(new Object[]{"2","Pedro",btn1,btn2});
        t.addRow(new Object[]{"3","Pedro",btn1,btn2});
        t.addRow(new Object[]{"4","Pedro",btn1,btn2});
        table1.setModel(t);

        table1.setPreferredScrollableViewportSize(table1.getPreferredSize());
        setMouseClick(table1,t);


    }

    @Override
    public void doCancel(){

    }

    public JPanel getjPanel() {
        return panel1;
    }

    private void setMouseClick(JTable tbl, final DefaultTableModel model){
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
