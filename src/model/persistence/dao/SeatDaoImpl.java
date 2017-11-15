package model.persistence.dao;

import model.persistence.Seats;
import model.persistence.dao.contracts.SeatDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SeatDaoImpl extends ConnectionToPost implements SeatDao {
    @Override
    public void register(Seats seat) throws Exception {
        try {
            this.connect();
            String query = "INSERT into seats (seatno, zone, show_id, status) VALUES(?,?,?,?)";
            PreparedStatement values = null;
            values = this.connection.prepareStatement(query,values.RETURN_GENERATED_KEYS);
            values.setInt(1, seat.getSeatNo());
            values.setString(2, seat.getZone());
            values.setInt(3, seat.getShow_ID());
            values.setString(4, seat.getStatus());
            values.executeUpdate();
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
            String query = "UPDATE seats SET seatno="+seat.getSeatNo()+", zone="+seat.getZone()+
                    ", show_id="+seat.getShow_ID()+", status="+seat.getStatus()+
                    "WHERE seat_id="+seat.getSeat_ID();
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
    public List<Seats> listCustomer() throws Exception {
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
}
