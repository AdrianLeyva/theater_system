package controller.show_manager.cancellation;

import model.Show;

import java.util.ArrayList;

public interface CancellationProcess {
    void cancelObra(int playId);
    void cancelShows(ArrayList<Show> shows);
    void cancelShows(int showId);
    void getSoldTicketsByShowCancellation(ArrayList<Show> shows);
    void getSoldTicketsByObraCancellation(String playId);
    void getTicketsByNamePlay(String name);

    interface Viewer{
        void doCancel();
    }
}
