package utils;

import model.Ticket;

import java.util.List;

public interface TicketDao {

    public void register(Ticket ticket) throws Exception;
    public void modify(Ticket ticket) throws Exception;
    public void delete(Ticket ticket) throws Exception;
    public List<Ticket> listCustomer() throws Exception;
}
