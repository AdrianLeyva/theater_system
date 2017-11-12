package model.persistence.dao.contracts;

import model.persistence.PlayManagers;

import java.util.List;

public interface PlayManagersDao {

    public void register(PlayManagers playmanager) throws Exception;
    public void modify(PlayManagers playmanager) throws Exception;
    public void delete(PlayManagers playmanager) throws Exception;
    public List<PlayManagers> listPlayManagers() throws Exception;
}
