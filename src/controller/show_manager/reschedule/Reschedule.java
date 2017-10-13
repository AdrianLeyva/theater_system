package controller.show_manager.reschedule;

import controller.BaseController;
import model.Show;

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

    }

    @Override
    public void rescheduleAllShows(ArrayList<Show> updatedShows) {

    }
}
