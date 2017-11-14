package model.persistence.dao.contracts;

import model.persistence.Shows;

import java.util.List;

public interface ShowDao {

    public void register(Shows show) throws Exception;
    public void modify(Shows show) throws Exception;
    public void delete(Shows show) throws Exception;
    public List<Shows> listCustomer() throws Exception;
}
