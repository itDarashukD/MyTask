package JDBC.ProjectEmployer.Service;

import ProjectEmployer.DAO.EntityDao;
import ProjectemployeerSecond.ProjectEmployer.Entity.EmployeeProject;
import ProjectemployeerSecond.ProjectEmployer.Entity.Entity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeProjectService extends Entity implements EntityDao {

    EmployeeProject employeeProject;
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

        String sql = "INSERT INTO EMPL_PROJ (EMPLOYEE_ID, PROJECT_ID) VALUES(?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setLong(1, employeeProject.getEmployeeId());
            preparedStatement.setLong(2, employeeProject.getProjectId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    @Override
    public Object getById(Long id) throws SQLException {

        String sql = "SELECT EMPLOYEE_ID, PROJECT_ID FROM EMPL_PROJ WHERE EMPLOYEE_ID=? AND PROJECT_ID=?";

        EmployeeProject employeeProject = new EmployeeProject();

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, getId());
            preparedStatement.setLong(2, getId());

            ResultSet resultSet = preparedStatement.executeQuery();

            employeeProject.setEmployeeId(resultSet.getLong("EMPLOYEE_ID"));
            employeeProject.setProjectId(resultSet.getLong("PROJECT_ID"));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return employeeProject;
    }


    @Override
    public List getAll() throws SQLException {

        List<EmployeeProject> employeeProjectList = new ArrayList<>();

        String sql = "SELECT EMPLOYEE_ID, PROJECT_ID FROM EMPL_PROJ";

        try (Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                EmployeeProject employeeProject = new EmployeeProject();
                employeeProject.setEmployeeId(resultSet.getLong("EMPLOYEE_ID"));
                employeeProject.setProjectId(resultSet.getLong("PROJECT_ID"));

                employeeProjectList.add(employeeProject);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return employeeProjectList;
    }

    @Override
    public Boolean update(Object entity) throws SQLException {
        String sql = "UPDATE  EmplProj SET Employee_Id=? ,Project_Id=?";
        Statement statement;

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {
            statement = connection.createStatement();
            preparedStatement.setLong(1, employeeProject.getEmployeeId());
            preparedStatement.setLong(1, employeeProject.getProjectId());
            preparedStatement.executeUpdate();

        } finally {
            if (connection != null) {
                connection.close();
            }
        }

        return statement.execute(sql);

    }

    @Override
    public Boolean remove(Object entity) throws SQLException {

        String sql = "REMOVE FROM EmplProj WHERE Employee_Id=? ,Project_Id=?";
        Statement statement;

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            statement = connection.createStatement();
            preparedStatement.setLong(1, employeeProject.getEmployeeId());
            preparedStatement.setLong(1, employeeProject.getProjectId());

            preparedStatement.executeUpdate();

        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return statement.execute(sql);
    }
}
