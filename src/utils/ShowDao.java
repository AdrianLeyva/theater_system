package utils;

import model.Show;

import java.util.List;

public interface ShowDao {

    public void register(Show show) throws Exception;
    public void modify(Show show) throws Exception;
    public void delete(Show show) throws Exception;
    public List<Show> listCustomer() throws Exception;
}
