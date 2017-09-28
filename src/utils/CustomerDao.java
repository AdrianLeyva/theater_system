package utils;

import model.Customer;

import java.util.List;

public interface CustomerDao  {

    public void register(Customer customer) throws Exception;
    public void modify(Customer customer) throws Exception;
    public void delete(Customer customer) throws Exception;
    public List<Customer> listCustomer(Customer customer) throws Exception;
}
