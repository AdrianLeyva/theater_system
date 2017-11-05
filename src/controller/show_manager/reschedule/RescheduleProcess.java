package controller.show_manager.reschedule;

import model.Show;

import java.util.ArrayList;
import java.util.Date;

public interface RescheduleProcess {
    void rescheduleShow(Show show);
    void rescheduleAllShows(ArrayList<Show> shows, ArrayList<Date> newDates);
    boolean isAvailableShowDate(Show show);
}
