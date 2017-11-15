package model.persistence.dao.contracts;

import model.Transaction;
import model.persistence.Transactions;

import java.util.List;

public interface TransactionDao {

    void register(Transactions transaction) throws Exception;
    void modify(Transactions transaction) throws Exception;
    void delete(Transactions transaction) throws Exception;
    List<Transactions> listTransactions() throws Exception;
    Transactions findById(int id) throws Exception;
}
