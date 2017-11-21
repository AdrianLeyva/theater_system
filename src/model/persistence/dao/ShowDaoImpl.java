package model.persistence.dao;

import model.Obra;
import model.persistence.Seats;
import model.persistence.Shows;
import model.persistence.dao.contracts.ShowDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class ShowDaoImpl extends ConnectionToPost implements ShowDao {
    @Override
    public void register(Shows show) throws Exception {
        try {
            this.connect();
            String query = "INSERT into shows (show_id, play_id, schedule, date, status) VALUES(?,?,?,?,?)";
            PreparedStatement values = null;
            values = this.connection.prepareStatement(query);
            values.setInt(1, getLastID());
            values.setInt(2, show.getPlay_ID());
            values.setString(3, show.getSchedule());
            values.setDate(4, new Date(show.getDate().getTime()));
            values.setString(5, show.getStatus());
            values.executeUpdate();
        }catch (Exception e){
            throw e;
        }finally {
            this.close();
        }
    }

    @Override
    public void modify(Shows show) throws Exception {
        try {
            this.connect();
            String query = "UPDATE shows SET schedule = \'"+show.getSchedule()+
                    "\', date = \'"+show.getDate()+"\' , status = \'"+show.getStatus()+"\' WHERE show_id="+show.getShow_ID();
            PreparedStatement values = null;
            System.out.println(query);
            values = this.connection.prepareStatement(query);
            values.executeUpdate();
        }catch (Exception e){
            throw e;
        }finally {
            this.close();
        }

    }

    @Override
    public void delete(Shows show) throws Exception {
        try {
            this.connect();

            String transactionQuery = "DELETE FROM transactions  WHERE show_id=" + show.getShow_ID();
            PreparedStatement values0 = this.connection.prepareStatement(transactionQuery);
            values0.executeUpdate();

            List<Seats> seatsList = new SeatDaoImpl().listSeats(show.getShow_ID());

            for(Seats seat : seatsList){
                String ticketsQuery = " DELETE FROM tickets WHERE seat_id=" + seat.getSeat_ID();
                PreparedStatement values = this.connection.prepareStatement(ticketsQuery);
                values.executeUpdate();
            }

            String seatsQuery = "DELETE FROM seats WHERE show_id=" + show.getShow_ID();
            PreparedStatement values2 = this.connection.prepareStatement(seatsQuery);
            values2.executeUpdate();

            String showQuery = " DELETE FROM shows WHERE show_id=" + show.getShow_ID();
            PreparedStatement values3 = this.connection.prepareStatement(showQuery);
            values3.executeUpdate();


        } catch (Exception e) {
            throw e;
        } finally {
            this.close();
        }
    }

    @Override
    public List<Shows> findById(int id) throws Exception {
        this.connect();
        Statement statement = null;

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM shows WHERE show_id=" + id);

            ArrayList<Shows> people = new ArrayList<Shows>();
            while (resultSet.next()) {
                Shows show = extractPersonFromResultSet(resultSet);
                people.add(show);
            }

            return people;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Shows> findByIdPlay(int id) throws Exception {
        this.connect();
        Statement statement = null;

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM shows WHERE play_id=" + id);

            ArrayList<Shows> people = new ArrayList<Shows>();
            while (resultSet.next()) {
                Shows show = extractPersonFromResultSet(resultSet);
                people.add(show);
            }

            return people;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Shows> listShows() throws Exception {
        this.connect();
        Statement statement = null;

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM shows ORDER BY show_id ASC");

            ArrayList<Shows> people = new ArrayList<Shows>();
            while (resultSet.next()) {
                Shows show = extractPersonFromResultSet(resultSet);
                people.add(show);
            }

            return people;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    private Shows extractPersonFromResultSet(ResultSet rs) throws SQLException {
        Shows show = new Shows();
        show.setShow_ID(rs.getInt("show_id"));
        show.setSchedule(rs.getString("schedule"));
        show.setDate(rs.getDate("date"));
        show.setStatus(rs.getString("status"));
        return show;
    }

    private Integer getLastID() throws Exception {
        List<Shows> shows = listShows();
        if (shows.size()==0){
            return 0;
        }else {
            return shows.get(shows.size() - 1).getShow_ID() + 1;
        }
    }

    public Obra findShowByPlayName(String playName){
        this.connect();
        Statement statement = null;

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM shows INNER JOIN plays ON plays.play_id = shows.play_id " +
                    "WHERE name= \'" + playName + "\'");

            ArrayList<Shows> shows = new ArrayList<>();
            Obra obra = new Obra();


            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
                if(resultSet.getString("name").equals(playName)){
                    obra.setId(String.valueOf(resultSet.getInt("play_id")));
                    obra.setName(resultSet.getString("name"));
                    obra.setClasification(resultSet.getString("classification"));
                    Shows show = extractPersonFromResultSet(resultSet);
                    shows.add(show);
                }
            }

            obra.setShowsList(shows);

            return obra;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
