package model.persistence.dao.contracts;

import model.Obra;

import java.util.List;

public interface ObraDao {

    public void register(Obra obra) throws Exception;
    public void modify(Obra obra) throws Exception;
    public void delete(Obra obra) throws Exception;
    public List<Obra> listCustomer() throws Exception;
}
