package model.persistence.dao;

import model.persistence.Plays;
import model.persistence.dao.contracts.PlaysDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PlaysDaoImpl extends  ConnectionToPost implements PlaysDao {
    @Override
    public void register(Plays play) throws Exception {
        try {
            this.connect();
            String query = "INSERT into plays (playmanager_id, name, classification, status, description) VALUES(?,?,?,?,?)";
            PreparedStatement values = null;
            values = this.connection.prepareStatement(query,values.RETURN_GENERATED_KEYS);
            values.setInt(1, play.getPlayManager_ID());
            values.setString(2, play.getName());
            values.setString(3, play.getClassification());
            values.setString(4,play.getStatus());
            values.setString(5,play.getDescription());
            values.executeUpdate();
        }catch (Exception e){
            throw e;
        }finally {
            this.close();
        }
    }

    @Override
    public void modify(Plays play) throws Exception {
        try {
            this.connect();
            String query = "UPDATE plays SET playmanager_id="+play.getPlayManager_ID()+", name="+play.getName()+
                    ", calssification="+play.getClassification()+", status="+play.getStatus()+", description="
                    +play.getDescription()+"WHERE play_id="+play.getPlay_ID();
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
    public void delete(Plays play) throws Exception {
        try {
            this.connect();
            String query = " DELETE FROM plays WHERE play_id="+play.getPlay_ID();
            PreparedStatement values = this.connection.prepareStatement(query);
            values.executeUpdate();
        }catch (Exception e){
            throw e;
        }finally {
            this.close();
        }

    }

    @Override
    public List<Plays> listPlays() throws Exception {
        this.connect();
        Statement statement = null;

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM plays");

            ArrayList<Plays> people = new ArrayList<Plays>();
            while(resultSet.next()){
                Plays play = extractPersonFromResultSet(resultSet);
                people.add(play);
            }

            return people;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
    private Plays extractPersonFromResultSet(ResultSet rs) throws SQLException {
        Plays play = new Plays();
        play.setPlay_ID(rs.getInt("play_id"));
        play.setPlayManager_ID(rs.getInt("playmanager_id"));
        play.setName(rs.getString("name"));
        play.setClassification(rs.getString("classification"));
        play.setStatus(rs.getString("status"));
        play.setDescription(rs.getString("description"));
        return play;
    }
}
