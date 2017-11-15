package model.persistence.dao;

import model.persistence.Users;
import model.persistence.dao.contracts.UsersDao;
import utils.FolioGenerator;

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
            String query = "INSERT into users (users_id, typeuser_id, email, password) VALUES (?,?,?,?)";
            PreparedStatement values = null;
            values = this.connection.prepareStatement(query);
            values.setInt(1,getLastID()+1);
            values.setInt(2, user.getTypeUser_ID());
            values.setString(3, user.getEmail());
            values.setString(4, user.getPassword());
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
            String query = "UPDATE users SET " +
                    "typeuser_id = " + user.getTypeUser_ID() +
                    ", email = \'"  + user.getEmail() +
                    "\' , password = \'"  + user.getPassword() +
                    "\' WHERE user_id = " + user.getUser_ID();
            System.out.println(query);
            PreparedStatement values = this.connection.prepareStatement(query);
            values.executeUpdate();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            this.close();
        }
    }

    @Override
    public void delete(Users user) throws Exception {
        try {
            this.connect();
            String query = " DELETE FROM users WHERE user_id="+user.getUser_ID();
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
        this.connect();
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

    @Override
    public Users findById(int id) throws Exception {
        this.connect();
        Statement statement = null;

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE user_id=" + id);

            Users user = null;
            while(resultSet.next()){
                user = extractPersonFromResultSet(resultSet);
            }

            return user;
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

    private Integer getLastID() throws Exception {
        List<Users> users = listUsers();
        return users.get(users.size()).getUser_ID();
    }

    public static void main(String[] args) {
        UsersDaoImpl usersDao = new UsersDaoImpl();
        Users user = new Users();
        user.setUser_ID(1);
        user.setTypeUser_ID(1);
        user.setEmail("correotest@gmail.com");
        user.setPassword("mipassword");
        try {
            Users user2 = usersDao.findById(6);
            System.out.printf("id: " + user2.getUser_ID() + ", email: " + user2.getEmail());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
