package model.persistence.dao.contracts;

import model.persistence.Users;

import java.util.List;

public interface UsersDao {
    void register(Users user) throws Exception;
    void modify(Users user) throws Exception;
    void delete(Users user) throws Exception;
    List<Users> listUsers() throws Exception;
    Users findById(int id) throws Exception;
}
