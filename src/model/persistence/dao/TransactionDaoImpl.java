package model.persistence.dao;

import model.Transaction;
import model.persistence.dao.contracts.TransactionDao;

import java.util.List;

public class TransactionDaoImpl extends ConnectionToPost implements TransactionDao {
    @Override
    public void register(Transaction transaction) throws Exception {

    }

    @Override
    public void modify(Transaction transaction) throws Exception {

    }

    @Override
    public void delete(Transaction transaction) throws Exception {

    }

    @Override
    public List<Transaction> listCustomer() throws Exception {
        return null;
    }
}
