package view.show_manager.cancellation;

import controller.ConstantsApp;
import controller.show_manager.cancellation.*;
import model.Obra;
import model.persistence.Plays;
import model.persistence.Shows;
import model.persistence.dao.PlaysDaoImpl;
import model.persistence.dao.ShowDaoImpl;
import utils.DateParser;
import utils.ViewHandler;
import view.show_manager.ShowManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Cancellation implements CancellationProcess.Viewer{
    private JPanel panel1;
    private JTextField nametxt;
    private JButton searchbtn;
    private JTable table1;
    private JButton goBackButton;
    private DefaultTableModel model;
    private JButton cancelPlayButton;
    private JFrame frame;
    public DefaultTableModel t;
    private ArrayList<Shows> showsList;
    public Cancellation controlCancel = null;
    private Obra currentObra = null;
    private ShowDaoImpl dao = null;
    private PlaysDaoImpl playsDao;


    private controller.show_manager.cancellation.Cancellation cancelController;

    public Cancellation() {


    }

    public Cancellation(JFrame frame) {
        this.showsList = new ArrayList<>();
        this.frame = frame;
        this.controlCancel = new Cancellation();
        dao = new ShowDaoImpl();
        playsDao = new PlaysDaoImpl();
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
        this.showsList = new ArrayList<>();
        this.cancelController = new controller.show_manager.cancellation.Cancellation();
        searchbtn = new JButton();
        cancelPlayButton = new JButton();
        this.table1 = new JTable();
        table1.setDefaultRenderer(Object.class, new Reader());

        final Object[] columnNames = {"Registro","Name", "Date", "Time","Eliminar"};

        table1.setDefaultRenderer(Object.class, new Reader());


        model = new DefaultTableModel(new Object[]{"Registro", "Name", "Date", "Time","Eliminar"}, 0){
           public boolean isCellEditable(int row, int column){
               return false;
         }
        };

        table1.setModel(model);

        table1.setPreferredScrollableViewportSize(table1.getPreferredSize());
        setMouseClick(table1,model);
        searchbtn.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getAllShows();
            }
        });
        cancelPlayButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Plays play = new Plays();
                play.setPlay_ID(Integer.parseInt(currentObra.getId()));
                try {
                    playsDao.delete(play);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                cleartbl();
            }
        });



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
                try {
                    TableFunctionMouseClicked(e, model);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    private void TableFunctionMouseClicked(java.awt.event.MouseEvent evt, DefaultTableModel model) throws Exception {//GEN-FIRST:event_TableAlarmsMouseClicked

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
                if(boton.getName().equals("Delete")){
                    JOptionPane.showConfirmDialog(null, "Desea eliminar este registro", "Confirmar", JOptionPane.OK_CANCEL_OPTION);
                    System.out.println("Click en el boton eliminar" + row);
                    int c = (int)model.getValueAt(row,0);
                    model.removeRow(row);
                    Shows s = new Shows();
                    s.setShow_ID(c);
                    dao.delete(s);
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

    private void getAllShows(){
        String obraName = nametxt.getText();
        dao = new ShowDaoImpl();
        System.out.println("entre");
        currentObra = dao.findShowByPlayName(obraName);
        JButton btn1 = new JButton("Delete");
        btn1.setName("Delete");
        showsList = currentObra.getShowsList();
        cleartbl();
        for (Shows shows: showsList){
            System.out.println(shows.getStatus());
            model.addRow(new Object[]{
                    shows.getShow_ID(),
                    currentObra.getName(),
                    DateParser.parseDateTimeFormat(DateParser.DATE_PATTERN, shows.getDate()),
                    shows.getSchedule(),btn1
            });
        }

    }

    private void cleartbl(){
        int filas = table1.getRowCount();
        if (filas != 0){
            for (int i = 0;filas>i; i++) {
                model.removeRow(0);
            }
        }
    }

}
