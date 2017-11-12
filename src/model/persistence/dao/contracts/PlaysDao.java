package model.persistence.dao.contracts;

import model.persistence.Plays;

import java.util.List;

public interface PlaysDao {
    public void register(Plays play) throws Exception;
    public void modify(Plays play) throws Exception;
    public void delete(Plays play) throws Exception;
    public List<Plays> listPlays() throws Exception;
}
