package model.persistence.dao.contracts;

import model.Reservation;

import java.util.List;

public interface ReservationDao {

    public void register(Reservation reservation) throws Exception;
    public void modify(Reservation reservation) throws Exception;
    public void delete(Reservation reservation) throws Exception;
    public List<Reservation> listCustomer() throws Exception;
}
