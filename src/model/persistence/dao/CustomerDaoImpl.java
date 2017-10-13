package model.persistence.dao;

import model.Customer;
import model.persistence.dao.contracts.CustomerDao;

import java.sql.PreparedStatement;
import java.util.List;

public class CustomerDaoImpl extends ConnectionToPost implements CustomerDao{
    @Override
    public void register(Customer customer) throws Exception {
        try {
            this.connect();
            PreparedStatement ps = this.connection.prepareStatement("");
            ps.setString(1, customer.getName());
            ps.executeUpdate();
        }catch (Exception e){
            throw e;
        }finally {
            this.close();
        }
    }

    @Override
    public void modify(Customer customer) throws Exception {
        try {
            this.connect();
            PreparedStatement ps = this.connection.prepareStatement("");
            ps.setString(1, customer.getName());
            ps.executeUpdate();
        }catch (Exception e){
            throw e;
        }finally {
            this.close();
        }
    }

    @Override
    public void delete(Customer customer) throws Exception {
        try {
            this.connect();
            PreparedStatement ps = this.connection.prepareStatement("");
            ps.setString(1, customer.getName());
            ps.executeUpdate();
        }catch (Exception e){
            throw e;
        }finally {
            this.close();
        }
    }

    @Override
    public List<Customer> listCustomer(Customer customer) throws Exception {
        return null;
    }
}
