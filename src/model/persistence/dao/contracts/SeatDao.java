package model.persistence.dao.contracts;

import model.persistence.Seats;

import java.util.List;

public interface SeatDao {

    void register(Seats seat) throws Exception;
    void modify(Seats seat) throws Exception;
    void delete(Seats seat) throws Exception;
    List<Seats> listSeats() throws Exception;
    Seats findById(int id) throws Exception;
}
