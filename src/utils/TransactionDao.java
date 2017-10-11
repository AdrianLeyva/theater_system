package utils;

import model.Transaction;

import java.util.List;

public interface TransactionDao {

    public void register(Transaction transaction) throws Exception;
    public void modify(Transaction transaction) throws Exception;
    public void delete(Transaction transaction) throws Exception;
    public List<Transaction> listCustomer() throws Exception;
}
