package model.persistence.dao.contracts;

import model.Transaction;
import model.persistence.Transactions;

import java.util.List;

public interface TransactionDao {

    public void register(Transactions transaction) throws Exception;
    public void modify(Transactions transaction) throws Exception;
    public void delete(Transactions transaction) throws Exception;
    public List<Transactions> listCustomer() throws Exception;
}
