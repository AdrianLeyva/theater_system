package model.persistence.dao.contracts;

import model.Ticket;
import model.persistence.Tickets;

import java.util.List;

public interface TicketDao {

    public void register(Tickets ticket) throws Exception;
    public void modify(Tickets ticket) throws Exception;
    public void delete(Tickets ticket) throws Exception;
    public List<Tickets> listCustomer() throws Exception;
}
