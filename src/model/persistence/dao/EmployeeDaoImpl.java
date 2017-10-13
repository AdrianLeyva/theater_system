package model.persistence.dao;

import model.Employee;
import model.persistence.dao.contracts.EmployeeDao;

import java.util.List;

public class EmployeeDaoImpl extends ConnectionToPost implements EmployeeDao{
    @Override
    public void register(Employee employee) throws Exception {

    }

    @Override
    public void modify(Employee employee) throws Exception {

    }

    @Override
    public void delete(Employee employee) throws Exception {

    }

    @Override
    public List<Employee> listCustomer() throws Exception {
        return null;
    }
}
