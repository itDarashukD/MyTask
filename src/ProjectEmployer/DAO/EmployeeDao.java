package ProjectEmployer.DAO;

import ProjectEmployer.Entity.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDao {
    //create
    public void add(Employee employee) throws SQLException;

    //read
    public List<Employee> readAllEmployee() throws SQLException;

    public Employee readOneEmployee(Long id) throws SQLException;

    //update
    public void updateEmployee(Employee employee) throws SQLException;

    //delete
    public void deleteEmployee(Employee employee) throws SQLException;
}
