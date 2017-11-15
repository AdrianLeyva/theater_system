package model.persistence.dao;

import model.Transaction;
import model.persistence.Transactions;
import model.persistence.dao.contracts.TransactionDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionDaoImpl extends ConnectionToPost implements TransactionDao {
    @Override
    public void register(Transactions transaction) throws Exception {
        try {
            this.connect();
            String query = "INSERT into transactions (transaction_id,ticketsqty, funcion_id, total, typetransaction, " +
                    "user_id, date, clientName) VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement values = null;
            values = this.connection.prepareStatement(query);
            values.setInt(1,getLastID());
            values.setInt(2, transaction.getTicketsQty());
            values.setInt(3, transaction.getFuncion_ID());
            values.setInt(4, transaction.getTotal());
            values.setInt(5, transaction.getTypeTransaction());
            values.setInt(6, transaction.getUser_ID());
            values.setDate(7, (Date) transaction.getDate());
            values.setString(8, transaction.getClientName());
            values.executeUpdate();
        }catch (Exception e){
            throw e;
        }finally {
            this.close();
        }
    }

    @Override
    public void modify(Transactions transaction) throws Exception {
        try {
            this.connect();
            String query = "UPDATE transactions SET ticketsqty="+transaction.getTicketsQty()+
                    ", funcion_id="+transaction.getFuncion_ID()+", total="+transaction.getTotal()+
                    ", typetransaction="+transaction.getTypeTransaction()+", user_id="+transaction.getUser_ID()+
                    ", date="+transaction.getUser_ID()+", clientName = \'"+transaction.getClientName()+
                    "\' WHERE transaction_id="+transaction.getTransaction_ID();
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
    public void delete(Transactions transaction) throws Exception {
        try {
            this.connect();
            String query = " DELETE FROM transactions WHERE transaction_id="+transaction.getTransaction_ID();
            PreparedStatement values = this.connection.prepareStatement(query);
            values.executeUpdate();
        }catch (Exception e){
            throw e;
        }finally {
            this.close();
        }
    }

    @Override
    public Transactions findById(int id) throws Exception {
        this.connect();
        Statement statement = null;

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM transactions WHERE transaction_id="+id);

            Transactions transaction = null;
            while(resultSet.next()){
                transaction = extractPersonFromResultSet(resultSet);
            }

            return transaction;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Transactions> listTransactions() throws Exception {
        this.connect();
        Statement statement = null;

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM transactions");

            ArrayList<Transactions> people = new ArrayList<Transactions>();
            while(resultSet.next()){
                Transactions transaction = extractPersonFromResultSet(resultSet);
                people.add(transaction);
            }

            return people;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
    private Transactions extractPersonFromResultSet(ResultSet rs) throws SQLException {
        Transactions transaction = new Transactions();
        transaction.setTransaction_ID(rs.getInt("transaction_id"));
        transaction.setTicketsQty(rs.getInt("ticketsqty"));
        transaction.setFuncion_ID(rs.getInt("funcion_id"));
        transaction.setTotal(rs.getInt("total"));
        transaction.setTypeTransaction(rs.getInt("typetransaction"));
        transaction.setUser_ID(rs.getInt("user_id"));
        transaction.setDate(rs.getDate("date"));
        transaction.setClientName(rs.getString("clientname"));
        return transaction;
    }

    private Integer getLastID() throws Exception {
        List<Transactions> transactions = listTransactions();
        return transactions.get(transactions.size()-1).getTransaction_ID()+1;
    }
}
