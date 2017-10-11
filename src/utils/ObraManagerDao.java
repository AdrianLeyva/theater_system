package utils;

import model.ObraManager;

import java.util.List;

public interface ObraManagerDao {

    public void register(ObraManager obraManager) throws Exception;
    public void modify(ObraManager obraManager) throws Exception;
    public void delete(ObraManager obraManager) throws Exception;
    public List<ObraManager> listCustomer() throws Exception;

}
