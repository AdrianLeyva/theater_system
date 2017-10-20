package controller.show_manager.cancellation;

import controller.BaseController;
import model.Show;

import java.util.ArrayList;
/**
 * This class handles all cancellation processes of show manager module.
 * @author Adrián Leyva Sánchez
 */
public class Cancellation extends BaseController implements CancellationProcess{
    @Override
    protected void setupDependencies() {

    }

    @Override
    public void cancelObra(String obraId) {
        /*
            Insert postgresql query
         */
    }

    @Override
    public void cancelShows(ArrayList<Show> shows) {
        for (Show i: shows){
            String showId = i.getId();
            /*
                Insert postgresql query
             */
        }
    }

    @Override
    public void getSoldTicketsByShowCancellation(ArrayList<Show> shows) {
        /*
           Insert postgresql query
        */
    }

    @Override
    public void getSoldTicketsByObraCancellation(String obraId) {
        /*
           Insert postgresql query
        */
    }
}
