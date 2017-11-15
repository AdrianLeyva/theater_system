package model.persistence.dao;

import model.persistence.Shows;
import model.persistence.dao.contracts.ShowDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ShowDaoImpl extends ConnectionToPost implements ShowDao {
    @Override
    public void register(Shows show) throws Exception {
        try {
            this.connect();
            String query = "INSERT into shows (splay_id, schedule, date, status) VALUES(?,?,?,?)";
            PreparedStatement values = null;
            values = this.connection.prepareStatement(query,values.RETURN_GENERATED_KEYS);
            values.setInt(1, show.getPlay_ID());
            values.setString(2, show.getSchedule());
            values.setDate(3, (Date) show.getDate());
            values.setString(4, show.getStatus());
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
            String query = "UPDATE shows SET splay_id = "+show.getPlay_ID()+", schedule = \'"+show.getSchedule()+
                    "\', date = "+show.getDate()+", status = \'"+show.getStatus()+"\' WHERE show_id="+show.getShow_ID();
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
    public void delete(Shows show) throws Exception {
        try {
            this.connect();
            String query = " DELETE FROM shows WHERE show_id=" + show.getShow_ID();
            PreparedStatement values = this.connection.prepareStatement(query);
            values.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.close();
        }
    }

    @Override
    public Shows findById(int id) throws Exception {
        this.connect();
        Statement statement = null;

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM shows WHERE show_id=" + id);

            Shows show = null;
            while (resultSet.next()) {
                show = extractPersonFromResultSet(resultSet);
            }

            return show;
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
            ResultSet resultSet = statement.executeQuery("SELECT * FROM shows");

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
}
