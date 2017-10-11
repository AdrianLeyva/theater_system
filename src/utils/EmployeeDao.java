package utils;

import model.Employee;

import java.util.List;

public interface EmployeeDao {

    public void register(Employee employee) throws Exception;
    public void modify(Employee employee) throws Exception;
    public void delete(Employee employee) throws Exception;
    public List<Employee> listCustomer() throws Exception;
}
