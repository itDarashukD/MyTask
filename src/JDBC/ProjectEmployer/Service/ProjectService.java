package JDBC.ProjectEmployer.Service;

import ProjectEmployer.DAO.EntityDao;
import ProjectemployeerSecond.ProjectEmployer.Entity.Entity;
import ProjectemployeerSecond.ProjectEmployer.Entity.Project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectService extends Entity implements EntityDao {
    Project project;
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
        String sql = "INSERT INTO PROJECT (ID, TITLE) VALUES(?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, project.getId());
            preparedStatement.setString(2, project.getTitle());

            preparedStatement.executeUpdate();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    @Override
    public Object getById(Long id) throws SQLException {
        String sql = "SELECT ID, TITLE FROM PROJECT WHERE ID=?";

        ResultSet resultSet = null;

        Project project = new Project();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);

            resultSet = preparedStatement.executeQuery();
            project.setId(resultSet.getInt(1));
            project.setTitle(resultSet.getString(2));

            preparedStatement.executeQuery();
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (resultSet != null) {
                resultSet.close();

            }
            return project;
        }
    }

    @Override
    public List getAll() throws SQLException {
        List<Project> projectList = new ArrayList<>();

        ResultSet resultSet = null;

        String sql = "SELECT ID, TITLE FROM PROJECT";

        try (Statement Statement = connection.createStatement()) {
            resultSet = Statement.executeQuery(sql);

            Project project = new Project();

            while (resultSet.next()) {
                project.setId(resultSet.getInt(1));
                project.setTitle(resultSet.getString(2));

                projectList.add(project);
            }
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        }

        return projectList;
    }

    @Override
    public Boolean update(Object entity) throws SQLException {
        Statement statement = null;
        String sql = "UPDATE PROJECT SET TITLE=? WHERE ID=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            statement = connection.createStatement();
            preparedStatement.setString(1, project.getTitle());
            preparedStatement.setLong(2, project.getId());

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

        String sql = "DELETE FROM PROJECT WHERE ID=?";
        Statement statement = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            statement = connection.createStatement();
            preparedStatement.setLong(1, project.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return statement.execute(sql);
    }
}