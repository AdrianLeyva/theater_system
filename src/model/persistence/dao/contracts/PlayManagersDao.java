package model.persistence.dao.contracts;

import model.persistence.PlayManagers;

import java.util.List;

public interface PlayManagersDao {

    void register(PlayManagers playmanager) throws Exception;
    void modify(PlayManagers playmanager) throws Exception;
    void delete(PlayManagers playmanager) throws Exception;
    List<PlayManagers> listPlayManagers() throws Exception;
    PlayManagers findById(int id) throws Exception;
}
