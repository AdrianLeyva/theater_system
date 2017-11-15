package controller.show_manager.reschedule;

import controller.BaseController;
import model.Show;
import model.persistence.Shows;
import model.persistence.dao.ShowDaoImpl;
import utils.DateParser;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * This class handles all reschedule processes of show manager module.
 * @author Adrián Leyva Sánchez
 */
public class Reschedule extends BaseController implements RescheduleProcess{
    @Override
    protected void setupDependencies() {

    }

    @Override
    public void rescheduleShow(Shows show) {
        ShowDaoImpl dao = new ShowDaoImpl();
        try {
            dao.modify(show);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void rescheduleAllShows(ArrayList<Shows> shows, ArrayList<Date> dates, DefaultTableModel model) {
        ShowDaoImpl dao = new ShowDaoImpl();

        for(int i = 0; i < model.getRowCount(); i++){
            java.util.Date date = new java.util.Date();
            String showDate = model.getValueAt(i,1).toString();
            String[] splitsDate = showDate.split("/");

            System.out.println(showDate);
            date = new GregorianCalendar(Integer.valueOf(splitsDate[0]), Integer.valueOf(splitsDate[1]),
                    Integer.valueOf(splitsDate[2])).getTime();

            shows.get(i).setDate(date);
            shows.get(i).setSchedule(model.getValueAt(i,2).toString());

            try {
                dao.modify(shows.get(i));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean isAvailableShowDate(Show show) {

        /*
            Insert postgresql query
         */
        return false;
    }
}
