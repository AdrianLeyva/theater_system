package controller.show_manager.reschedule;

import controller.BaseController;
import model.Show;
import utils.DateParser;

import java.util.ArrayList;
import java.util.Date;
/**
 * This class handles all reschedule processes of show manager module.
 * @author Adrián Leyva Sánchez
 */
public class Reschedule extends BaseController implements RescheduleProcess{
    @Override
    protected void setupDependencies() {

    }

    @Override
    public void rescheduleShow(Show show, Date date) {
        String newDate = DateParser.parseDateTimeFormat(DateParser.DATE_PATTERN, date);
        show.setDate(newDate);
         /*
            Insert postgresql query
         */

    }

    @Override
    public void rescheduleAllShows(ArrayList<Show> shows, ArrayList<Date> dates) {
        for(int i=0; i<shows.size(); i++){
            String newDate = DateParser.parseDateTimeFormat(DateParser.DATE_PATTERN, dates.get(i));
            shows.get(i).setDate(newDate);
        }

        /*
            Insert postgresql query
         */
    }
}
