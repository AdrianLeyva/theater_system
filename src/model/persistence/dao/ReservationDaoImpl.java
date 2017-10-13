package model.persistence.dao;

import model.Reservation;
import model.persistence.dao.contracts.ReservationDao;

import java.util.List;

public class ReservationDaoImpl extends ConnectionToPost implements ReservationDao {
    @Override
    public void register(Reservation reservation) throws Exception {

    }

    @Override
    public void modify(Reservation reservation) throws Exception {

    }

    @Override
    public void delete(Reservation reservation) throws Exception {

    }

    @Override
    public List<Reservation> listCustomer() throws Exception {
        return null;
    }
}
