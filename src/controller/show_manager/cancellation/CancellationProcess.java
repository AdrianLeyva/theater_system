package controller.show_manager.cancellation;

import model.Show;

import java.util.ArrayList;

public interface CancellationProcess {
    void cancelObra(String obraId);
    void  cancelShows(ArrayList<Show> shows);
    void getSoldTicketsByShowCancellation(ArrayList<Show> shows);
    void getSoldTicketsByObraCancellation(String obraId);
}
