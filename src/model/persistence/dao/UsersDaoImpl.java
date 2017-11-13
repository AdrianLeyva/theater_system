package model.persistence.dao;

import model.persistence.Users;
import model.persistence.dao.contracts.UsersDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsersDaoImpl extends ConnectionToPost implements UsersDao {
    @Override
    public void register(Users user) throws Exception {
        try {
            this.connect();
            String query = "INSERT into users (typeUser_ID, email, password) VALUES (?, ?,?)";
            PreparedStatement values = null;
            values = this.connection.prepareStatement(query,values.RETURN_GENERATED_KEYS);
            values.setInt(1, user.getTypeUser_ID());
            values.setString(2, user.getEmail());
            values.setString(3, user.getPassword());
            values.executeUpdate();
        }catch (Exception e){
            throw e;
        }finally {
            this.close();
        }
    }

    @Override
    public void modify(Users user) throws Exception {
        try {
            this.connect();
            String query = "UPDATE users set typeUser_ID="+user.getTypeUser_ID()+", email="+user.getEmail()+", password="+user.getPassword()+
                    " WHERE user_ID="+user.getUser_ID() ;
            PreparedStatement values = this.connection.prepareStatement(query);
            values.executeUpdate();
        }catch (Exception e){
            throw e;
        }finally {
            this.close();
        }
    }

    @Override
    public void delete(Users user) throws Exception {
        try {
            this.connect();
            String query = " DELETE FROM users WHERE user_ID="+user.getUser_ID();
            PreparedStatement values = this.connection.prepareStatement(query);
            values.executeUpdate();
        }catch (Exception e){
            throw e;
        }finally {
            this.close();
        }
    }

    @Override
    public List<Users> listUsers() throws Exception {
        Statement statement = null;

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");

            ArrayList<Users> people = new ArrayList<Users>();
            while(resultSet.next()){
                Users user = extractPersonFromResultSet(resultSet);
                people.add(user);
            }

            return people;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
    private Users extractPersonFromResultSet(ResultSet rs) throws SQLException {
        Users user = new Users();
        user.setUser_ID(rs.getInt("user_ID"));
        user.setTypeUser_ID(rs.getInt("typeUser_ID"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        return user;
    }
}
