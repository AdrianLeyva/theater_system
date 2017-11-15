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
            String query = "INSERT into tickets (stranssaction_id, seat_id) VALUES(?,?)";
            PreparedStatement values = null;
            values = this.connection.prepareStatement(query,values.RETURN_GENERATED_KEYS);
            values.setInt(1, ticket.getTranssaction_ID());
            values.setInt(2, ticket.getSeat_ID());
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
            String query = "UPDATE tickets SET stranssaction_id="+ticket.getTranssaction_ID()+", seat_id="+ticket.getSeat_ID()+"WHERE ticket_id="+ticket.getTicket_ID();
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
            String query = " DELETE FROM stickets WHERE ticket_id=" + ticket.getTicket_ID();
            PreparedStatement values = this.connection.prepareStatement(query);
            values.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.close();
        }
    }

    @Override
    public List<Tickets> listCustomer() throws Exception {
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
        ticket.setSeat_ID(rs.getInt("seat:id"));
        return ticket;
    }
}
