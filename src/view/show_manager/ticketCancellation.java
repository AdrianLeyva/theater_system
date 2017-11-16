package view.show_manager;

import controller.ConstantsApp;
import model.persistence.Tickets;
import model.persistence.dao.TicketDaoImpl;
import utils.ViewHandler;
import view.show_manager.cancellation.Reader;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

public class ticketCancellation {
    private JPanel panel1;
    private JTextField textField1;
    private JButton deleteButton;

    private JButton goBackButton;
    private Frame frame;
    private TicketDaoImpl ticketDao;

    public ticketCancellation(JFrame frame) {
        this.frame = frame;
        this.ticketDao = new TicketDaoImpl();
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

        //this.cancelController = new controller.show_manager.cancellation.Cancellation();
        deleteButton = new JButton();
        deleteButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String noTicket = textField1.getText();
                Tickets ticket = new Tickets();
                ticket.setTicket_ID(Integer.parseInt(noTicket));
                try {
                    ticketDao.delete(ticket);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

// TODO: place custom component creation code here
    }


    public JPanel getPanel1() {
        return panel1;
    }
}
