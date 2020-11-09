package JDBC.ProjectEmployer.Service;

import ProjectemployeerSecond.ProjectEmployer.DAO.EntityDao;
import ProjectemployeerSecond.ProjectEmployer.Entity.Employee;
import ProjectemployeerSecond.ProjectEmployer.Entity.Entity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeService extends Entity implements EntityDao {
    Employee employee;
    Connection connection = null;

    {
        try {
            connection = getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(Object entity) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO Address (id,firsrName,lastName,birthDay, addressId) value(?,?,?,?,?)";

        preparedStatement = connection.prepareStatement(sql);

        try {
            preparedStatement.setLong(1, employee.getId());
            preparedStatement.setString(2, employee.getFirstName());
            preparedStatement.setString(3, employee.getLastName());
            preparedStatement.setDate(4, (Date) employee.getBirthDay());
            preparedStatement.setInt(5, employee.getAddressId());
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }


    @Override
    public Object getById(Long id) throws SQLException {

        ResultSet resultSet = null;
        Employee employee = new Employee();
        String sql = "SELECT * FROM Employee WHERE id=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);

            resultSet = preparedStatement.executeQuery();
            employee.setId((int) resultSet.getLong(1));
            employee.setFirstName(resultSet.getString(2));
            employee.setLastName(resultSet.getString(3));
            employee.setBirthDay(resultSet.getDate(4));
            employee.setAddressId(resultSet.getInt(5));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

        return employee;
    }

    @Override
    public List getAll() throws SQLException {
        List<Employee> employeeList = new ArrayList<>();

        String sql = "SELECT * FROM Employee";
        ResultSet resultSet = null;


        try (Statement statement = connection.createStatement();) {
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setId((int) resultSet.getLong(1));
                employee.setFirstName(resultSet.getString(2));
                employee.setLastName(resultSet.getString(3));
                employee.setBirthDay(resultSet.getDate(4));
                employee.setAddressId(resultSet.getInt(5));

                employeeList.add(employee);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

        return employeeList;
    }

    @Override
    public Boolean update(Object entity) throws SQLException {
        Statement statement = null;
        String sql = "UPDATE Employee SET FirstName=?,LastName=?,BirthDay=?,AddressId=?,Id=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            statement = connection.createStatement();
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setDate(3, (Date) employee.getBirthDay());
            preparedStatement.setInt(4, employee.getAddressId());
            preparedStatement.setLong(5, employee.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        assert statement != null;
        return statement.execute(sql);
    }


    @Override
    public Boolean remove(Object entity) throws SQLException {
        Statement statement;
        String sql = "DELETE FROM Employee WHERE Id=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            statement = connection.createStatement();
            preparedStatement.setLong(1, employee.getId());
            preparedStatement.executeUpdate();

        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return statement.execute(sql);
    }

}

