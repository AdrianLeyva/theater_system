package controller.ticket_office.seats_manager;

public interface SeatSelector {
    void getAvailableSeats(String showId);
    void getReservedSeats(String showId);
    void getSoldSeats(String showId);
}
