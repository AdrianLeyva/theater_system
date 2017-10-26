package view.main_manager;

public interface MainManagerProcesses {
    void doTransaction();
    void doReservation();
    void doCancellation();
    void isOnTimeReservation();
}
