package model.persistence.dao;

import model.Seat;
import model.persistence.dao.contracts.SeatDao;

import java.util.List;

public class SeatDaoImpl extends ConnectionToPost implements SeatDao {
    @Override
    public void register(Seat seat) throws Exception {

    }

    @Override
    public void modify(Seat seat) throws Exception {

    }

    @Override
    public void delete(Seat seat) throws Exception {

    }

    @Override
    public List<Seat> listCustomer() throws Exception {
        return null;
    }
}