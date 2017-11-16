package model.persistence.dao.contracts;

import model.persistence.Plays;

import java.util.List;

public interface PlaysDao {
    int register(Plays play) throws Exception;
    void modify(Plays play) throws Exception;
    void delete(Plays play) throws Exception;
    List<Plays> listPlays() throws Exception;
    Plays findById(int id) throws Exception;
}
