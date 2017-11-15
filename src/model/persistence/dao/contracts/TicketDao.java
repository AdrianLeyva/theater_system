package model.persistence.dao.contracts;

import model.Ticket;
import model.persistence.Tickets;

import java.util.List;

public interface TicketDao {

    void register(Tickets ticket) throws Exception;
    void modify(Tickets ticket) throws Exception;
    void delete(Tickets ticket) throws Exception;
    List<Tickets> listTickets() throws Exception;
    Tickets findById(int id) throws Exception;
}
