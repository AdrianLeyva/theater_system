package controller.show_manager.reschedule;

import model.Show;

import java.util.ArrayList;
import java.util.Date;

public interface RescheduleProcess {
    void rescheduleShow(Show show, Date date);
    void rescheduleAllShows(ArrayList<Show> shows, ArrayList<Date> newDates);
}
