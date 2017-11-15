package model.persistence.dao;

import model.persistence.PlayManagers;
import model.persistence.Users;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PlayManagersDaoImpl extends ConnectionToPost implements model.persistence.dao.contracts.PlayManagersDao {
    @Override
    public void register(PlayManagers playmanager) throws Exception {
        try {
            this.connect();
            String query = "INSERT into playmanagers (playmanager_id, email, telephone, name, alttelephone) VALUES(?,?,?,?,?)";
            PreparedStatement values = null;
            values = this.connection.prepareStatement(query);
            values.setInt(1,getLastID());
            values.setString(2, playmanager.getEmail());
            values.setInt(3, playmanager.getTelephone());
            values.setString(4, playmanager.getName());
            values.setInt(5, playmanager.getAltTelephone());
            values.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.close();
        }
    }

    @Override
    public void modify(PlayManagers playmanager) throws Exception {
        try {
            this.connect();
            String query = "UPDATE playmanagers SET email = \'" + playmanager.getEmail() + "\', telephone = " + playmanager.getTelephone() +
                    ", name = \'" + playmanager.getName() + "\', alttelephone = " + playmanager.getAltTelephone() +
                    "WHERE playmanager_id=" + playmanager.getPlayManager_ID();
            PreparedStatement values = null;
            values = this.connection.prepareStatement(query);
            values.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.close();
        }
    }

    @Override
    public void delete(PlayManagers playmanager) throws Exception {
        try {
            this.connect();
            String query = " DELETE FROM pplaymanagers WHERE playmanager_id=" + playmanager.getPlayManager_ID();
            PreparedStatement values = this.connection.prepareStatement(query);
            values.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.close();
        }
    }

    @Override
    public List<PlayManagers> listPlayManagers() throws Exception {
        this.connect();
        Statement statement = null;

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM playmanagers");

            ArrayList<PlayManagers> people = new ArrayList<PlayManagers>();
            while (resultSet.next()) {
                PlayManagers playmanager = extractPersonFromResultSet(resultSet);
                people.add(playmanager);
            }

            return people;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public PlayManagers findById(int id) throws Exception {
        this.connect();
        Statement statement = null;

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM playmanagers WHERE playmanager_id=" + id);

            PlayManagers playmanager = null;
            while (resultSet.next()) {
                 playmanager = extractPersonFromResultSet(resultSet);

            }

            return playmanager;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    private PlayManagers extractPersonFromResultSet(ResultSet rs) throws SQLException {
        PlayManagers playmanager = new PlayManagers();
        playmanager.setPlayManager_ID(rs.getInt("playmanager_id"));
        playmanager.setEmail(rs.getString("email"));
        playmanager.setTelephone(rs.getInt("telephone"));
        playmanager.setName(rs.getString("name"));
        playmanager.setAltTelephone(rs.getInt("alttelephone"));
        return playmanager;
    }

    private Integer getLastID() throws Exception {
        List<PlayManagers> playManagers = listPlayManagers();
        return playManagers.get(playManagers.size()-1).getPlayManager_ID()+1;
    }
}
