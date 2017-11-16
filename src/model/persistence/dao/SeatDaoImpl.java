package model.persistence.dao;

import controller.ticket_office.TicketOfficeManager;
import model.persistence.Seats;
import model.persistence.dao.contracts.SeatDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SeatDaoImpl extends ConnectionToPost implements SeatDao {
    private TicketOfficeManager mView;


    public SeatDaoImpl() {
    }

    public SeatDaoImpl(TicketOfficeManager mView) {
        this.mView = mView;
    }

    @Override
    public void register(Seats seat) throws Exception {
        int lastSeatId = getLastID();
        try {
            this.connect();
            String query = "INSERT into seats (seat_id, seatno, zone, show_id, status) VALUES(?,?,?,?,?)";
            PreparedStatement values = null;
            values = this.connection.prepareStatement(query);
            values.setInt(1, lastSeatId);
            values.setInt(2, seat.getSeatNo());
            values.setString(3, seat.getZone());
            values.setInt(4, seat.getShow_ID());
            values.setString(5, seat.getStatus());
            values.executeUpdate();

            System.out.println("LastSeatId: " + lastSeatId);
            mView.generateTickets(String.valueOf(lastSeatId));

        }catch (Exception e){
            throw e;
        }finally {
            this.close();
        }
    }

    @Override
    public void modify(Seats seat) throws Exception {
        try {
            this.connect();
            String query = "UPDATE seats SET seatno = "+seat.getSeatNo()+", zone = \'"+seat.getZone()+
                    "\', show_id = "+seat.getShow_ID()+", status = \'"+seat.getStatus()+
                    "\' WHERE seat_id="+seat.getSeat_ID();
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
    public void delete(Seats seat) throws Exception {
        try {
            this.connect();
            String query = " DELETE FROM seats WHERE seat_id=" + seat.getSeat_ID();
            PreparedStatement values = this.connection.prepareStatement(query);
            values.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.close();
        }
    }

    @Override
    public Seats findById(int id) throws Exception {
        this.connect();
        Statement statement = null;

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM seats WHERE seat_id=" +id);

            Seats seat = null;
            while (resultSet.next()) {
                seat = extractPersonFromResultSet(resultSet);
            }

            return seat;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Seats> listSeats() throws Exception {
        this.connect();
        Statement statement = null;

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM seats");

            ArrayList<Seats> people = new ArrayList<Seats>();
            while (resultSet.next()) {
                Seats seat = extractPersonFromResultSet(resultSet);
                people.add(seat);
            }

            return people;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    private Seats extractPersonFromResultSet(ResultSet rs) throws SQLException {
        Seats seat = new Seats();
        seat.setSeat_ID(rs.getInt("seat_id"));
        seat.setSeatNo(rs.getInt("seatno"));
        seat.setZone(rs.getString("zone"));
        seat.setShow_ID(rs.getInt("show_id"));
        seat.setStatus(rs.getString("status"));
        return seat;
    }

    private Integer getLastID() throws Exception {
        List<Seats> seats = listSeats();

        if(seats == null || seats.size() == 0)
            return 0;
        else
            return seats.get(seats.size()-1).getSeat_ID()+1;
    }
}
