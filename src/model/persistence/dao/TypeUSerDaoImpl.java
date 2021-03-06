package model.persistence.dao;

import model.persistence.TypeUser;
import model.persistence.dao.contracts.TypeUserDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TypeUSerDaoImpl extends ConnectionToPost implements TypeUserDao {
    @Override
    public void register(TypeUser typeUser) throws Exception {
        try {
            this.connect();
            String query = "INSERT into typeuser (typeuser_id,name) VALUES(?,?)";
            PreparedStatement values = null;
            values = this.connection.prepareStatement(query);
            values.setInt(1, getLastID());
            values.setString(2, typeUser.getName());
            values.executeUpdate();
        }catch (Exception e){
            throw e;
        }finally {
            this.close();
        }
    }

    @Override
    public void modify(TypeUser typeUser) throws Exception {
        try {
            this.connect();
            String query = "UPDATE typetransaction SET name = \'"+typeUser.getName()+"\' WHERE typeuser_id="+typeUser.getTypeUser_ID();
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
    public void delete(TypeUser typeUser) throws Exception {
        try {
            this.connect();
            String query = " DELETE FROM typeuser WHERE typeuser_id="+typeUser.getTypeUser_ID();
            PreparedStatement values = this.connection.prepareStatement(query);
            values.executeUpdate();
        }catch (Exception e){
            throw e;
        }finally {
            this.close();
        }
    }

    @Override
    public List<TypeUser> listTypeUsers() throws Exception {
        this.connect();
        Statement statement = null;

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM typeuser");

            ArrayList<TypeUser> people = new ArrayList<TypeUser>();
            while(resultSet.next()){
                TypeUser typeUser = extractPersonFromResultSet(resultSet);
                people.add(typeUser);
            }

            return people;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public TypeUser findById(int id) throws Exception {
        this.connect();
        Statement statement = null;

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM typeuser");

            TypeUser typeUser = null;
            while(resultSet.next()){
                typeUser = extractPersonFromResultSet(resultSet);
            }

            return typeUser;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    private TypeUser extractPersonFromResultSet(ResultSet rs) throws SQLException {
        TypeUser typeUser = new TypeUser();
        typeUser.setTypeUser_ID(rs.getInt("typeuser_id"));
        typeUser.setName(rs.getString("name"));
        return typeUser;
    }

    private Integer getLastID() throws Exception {
        List<TypeUser> typeUsers = listTypeUsers();
        return typeUsers.get(typeUsers.size()-1).getTypeUser_ID()+1;
    }
}
