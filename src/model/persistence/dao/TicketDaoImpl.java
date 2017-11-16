package model.persistence.dao;

import model.persistence.Tickets;
import model.persistence.dao.contracts.TicketDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TicketDaoImpl extends ConnectionToPost implements TicketDao {
    @Override
    public void register(Tickets ticket) throws Exception {
        try {
            this.connect();
            String query = "INSERT into tickets (ticket_id, transsaction_id, seat_id) VALUES(?,?,?)";
            PreparedStatement values = null;
            values = this.connection.prepareStatement(query);
            values.setInt(1,getLastID());
            values.setInt(2, ticket.getTranssaction_ID());
            values.setInt(3, ticket.getSeat_ID());
            values.executeUpdate();
        }catch (Exception e){
            throw e;
        }finally {
            this.close();
        }
    }

    @Override
    public void modify(Tickets ticket) throws Exception {
        try {
            this.connect();
            String query = "UPDATE tickets SET stranssaction_id = "+ticket.getTranssaction_ID()+
                    ", seat_id = "+ticket.getSeat_ID()+" WHERE ticket_id="+ticket.getTicket_ID();
            PreparedStatement values = null;
            values = this.connection.prepareStatement(query);
            values.executeUpdate();
        }catch (Exception e){
            throw e;
        }finally {
            this.close();
        }
    }

    @Override
    public void delete(Tickets ticket) throws Exception {
        try {
            this.connect();
            String query = " DELETE FROM tickets WHERE ticket_id=" + ticket.getTicket_ID();
            PreparedStatement values = this.connection.prepareStatement(query);
            values.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.close();
        }
    }

    @Override
    public Tickets findById(int id) throws Exception {
        this.connect();
        Statement statement = null;

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM tickets WHERE ticket_id=" + id);

            Tickets ticket = null;
            while (resultSet.next()) {
                ticket = extractPersonFromResultSet(resultSet);
            }

            return ticket;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Tickets> listTickets() throws Exception {
        this.connect();
        Statement statement = null;

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM tickets");

            ArrayList<Tickets> people = new ArrayList<Tickets>();
            while (resultSet.next()) {
                Tickets ticket = extractPersonFromResultSet(resultSet);
                people.add(ticket);
            }

            return people;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    private Tickets extractPersonFromResultSet(ResultSet rs) throws SQLException {
        Tickets ticket = new Tickets();
        ticket.setTicket_ID(rs.getInt("ticket_id"));
        ticket.setTranssaction_ID(rs.getInt("transsaction_id"));
        ticket.setSeat_ID(rs.getInt("seat_id"));
        return ticket;
    }

    private Integer getLastID() throws Exception {
        List<Tickets> tickets = listTickets();

        if(tickets == null || tickets.size() == 0)
            return 0;
        else
            return tickets.get(tickets.size()-1).getTicket_ID()+1;
    }
}
