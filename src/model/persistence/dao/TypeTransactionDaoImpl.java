package model.persistence.dao;

import model.persistence.TypeTransaction;
import model.persistence.dao.contracts.TypeTransactionDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TypeTransactionDaoImpl extends ConnectionToPost implements TypeTransactionDao {
    @Override
    public void register(TypeTransaction typeTrans) throws Exception {
        try {
            this.connect();
            String query = "INSERT into typetransaction (name) VALUES(?)";
            PreparedStatement values = null;
            values = this.connection.prepareStatement(query,values.RETURN_GENERATED_KEYS);
            values.setString(1, typeTrans.getName());
            values.executeUpdate();
        }catch (Exception e){
            throw e;
        }finally {
            this.close();
        }
    }

    @Override
    public void modify(TypeTransaction typeTrans) throws Exception {

            try {
                this.connect();
                String query = "UPDATE typetransaction SET name = \'"+typeTrans.getName()+"\' WHERE typetransaction="+typeTrans.getTypeTransaction();
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
    public void delete(TypeTransaction typeTrans) throws Exception {
        try {
            this.connect();
            String query = " DELETE FROM typetransaction WHERE typetransaction="+typeTrans.getTypeTransaction();
            PreparedStatement values = this.connection.prepareStatement(query);
            values.executeUpdate();
        }catch (Exception e){
            throw e;
        }finally {
            this.close();
        }
    }

    @Override
    public List<TypeTransaction> listTypeTransactions() throws Exception {
        this.connect();
        Statement statement = null;

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM typetransaction");

            ArrayList<TypeTransaction> people = new ArrayList<TypeTransaction>();
            while(resultSet.next()){
                TypeTransaction transaction = extractPersonFromResultSet(resultSet);
                people.add(transaction);
            }

            return people;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public TypeTransaction findById(int id) throws Exception {
        this.connect();
        Statement statement = null;

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM typetransaction WHERE typetransaction="+id);

            TypeTransaction transaction = null;
            while(resultSet.next()){
                transaction = extractPersonFromResultSet(resultSet);
            }

            return transaction;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    private TypeTransaction extractPersonFromResultSet(ResultSet rs) throws SQLException {
        TypeTransaction transaction = new TypeTransaction();
        transaction.setTypeTransaction(rs.getInt("typetrasaction"));
        transaction.setName(rs.getString("name"));
        return transaction;
    }

}
