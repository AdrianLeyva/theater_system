package controller.show_manager.reschedule;

import model.Show;
import model.persistence.Shows;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Date;

public interface RescheduleProcess {
    void rescheduleShow(Shows show);
    void rescheduleAllShows(ArrayList<Shows> shows, ArrayList<Date> newDates, DefaultTableModel model);
    boolean isAvailableShowDate(Show show);
}
