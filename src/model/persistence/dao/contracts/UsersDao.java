package model.persistence.dao.contracts;

import model.persistence.Users;

import java.util.List;

public interface UsersDao {
    public void register(Users user) throws Exception;
    public void modify(Users user) throws Exception;
    public void delete(Users user) throws Exception;
    public List<Users> listUsers() throws Exception;
}
