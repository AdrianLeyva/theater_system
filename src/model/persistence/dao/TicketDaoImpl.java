package model.persistence.dao;

import model.Ticket;
import model.persistence.dao.contracts.TicketDao;

import java.util.List;

public class TicketDaoImpl extends ConnectionToPost implements TicketDao {
    @Override
    public void register(Ticket ticket) throws Exception {

    }

    @Override
    public void modify(Ticket ticket) throws Exception {

    }

    @Override
    public void delete(Ticket ticket) throws Exception {

    }

    @Override
    public List<Ticket> listCustomer() throws Exception {
        return null;
    }
}
