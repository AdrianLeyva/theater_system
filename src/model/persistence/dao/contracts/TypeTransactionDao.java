package model.persistence.dao.contracts;

import model.persistence.TypeTransaction;

import java.util.List;

public interface TypeTransactionDao {
    void register(TypeTransaction typeTrans) throws Exception;
    void modify(TypeTransaction typeTrans) throws Exception;
    void delete(TypeTransaction typeTrans) throws Exception;
    List<TypeTransaction> listTypeTransactions() throws Exception;
    TypeTransaction findById(int id) throws Exception;
}
