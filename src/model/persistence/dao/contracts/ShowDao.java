package model.persistence.dao.contracts;

import model.persistence.Shows;

import java.util.List;

public interface ShowDao {

    void register(Shows show) throws Exception;
    void modify(Shows show) throws Exception;
    void delete(Shows show) throws Exception;
    List<Shows> listShows() throws Exception;
    Shows findById(int id) throws Exception;
}
