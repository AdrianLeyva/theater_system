package utils;

import model.Seat;

import java.util.List;

public interface SeatDao {

    public void register(Seat seat) throws Exception;
    public void modify(Seat seat) throws Exception;
    public void delete(Seat seat) throws Exception;
    public List<Seat> listCustomer() throws Exception;
}
