package view.cancellation;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class Reader extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus, int row, int column) {

        if(value instanceof JButton){
            JButton btn = (JButton)value;
            if(isSelected){
                btn.setForeground(table.getSelectionForeground());
                btn.setBackground(table.getSelectionBackground());
            }else{
                btn.setForeground(table.getForeground());
                btn.setBackground(UIManager.getColor("Button.background"));
            }
            return btn;
        }


        if(value instanceof JCheckBox){
            JCheckBox ch = (JCheckBox)value;
            return ch;
        }

        return super.getTableCellRendererComponent(table, value, isSelected,
                hasFocus, row, column); //To change body of generated methods, choose Tools | Templates.
    }


}
