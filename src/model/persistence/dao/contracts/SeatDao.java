package model.persistence.dao.contracts;

import model.persistence.Seats;

import java.util.List;

public interface SeatDao {

    public void register(Seats seat) throws Exception;
    public void modify(Seats seat) throws Exception;
    public void delete(Seats seat) throws Exception;
    public List<Seats> listCustomer() throws Exception;
}
