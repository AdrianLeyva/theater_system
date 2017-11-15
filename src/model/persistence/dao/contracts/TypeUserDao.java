package model.persistence.dao.contracts;

import model.persistence.TypeUser;

import java.util.List;

public interface TypeUserDao {
    void register(TypeUser typeUser) throws Exception;
    void modify(TypeUser typeUser) throws Exception;
    void delete(TypeUser typeUser) throws Exception;
    List<TypeUser> listTypeUsers() throws Exception;
    TypeUser findById(int id) throws Exception;
}
