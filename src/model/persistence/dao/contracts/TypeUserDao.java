package model.persistence.dao.contracts;

import model.persistence.TypeUser;

import java.util.List;

public interface TypeUserDao {
    public void register(TypeUser typeUser) throws Exception;
    public void modify(TypeUser typeUser) throws Exception;
    public void delete(TypeUser typeUser) throws Exception;
    public List<TypeUser> listTypeUsers() throws Exception;
}
