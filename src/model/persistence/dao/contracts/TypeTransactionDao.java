package model.persistence.dao.contracts;

import model.persistence.TypeTransaction;

import java.util.List;

public interface TypeTransactionDao {
    public void register(TypeTransaction typeTrans) throws Exception;
    public void modify(TypeTransaction typeTrans) throws Exception;
    public void delete(TypeTransaction typeTrans) throws Exception;
    public List<TypeTransaction> listTypeTransactions() throws Exception;
}
