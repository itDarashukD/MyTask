package ProjectEmployer.Service;

import ProjectEmployer.Bl.Util;
import ProjectEmployer.DAO.EmplProjDao;
import ProjectEmployer.Entity.EmplProj;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmplProjService extends Util implements EmplProjDao {


    Connection connection = null;

    {
        try {
            connection = getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void add(EmplProj emplProj) throws SQLException {

        String sql = "INSERT INTO EMPL_PROJ (EMPLOYEE_ID, PROJECT_ID) VALUES(?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setLong(1, emplProj.getEmployeeId());
            preparedStatement.setLong(2, emplProj.getProjectId());

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
    public List<EmplProj> readAllEmplProj() throws SQLException {
        List<EmplProj> emplProjList = new ArrayList<>();

        String sql = "SELECT EMPLOYEE_ID, PROJECT_ID FROM EMPL_PROJ";

        try (Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                EmplProj emplProj = new EmplProj();
                emplProj.setEmployeeId(resultSet.getLong("EMPLOYEE_ID"));
                emplProj.setProjectId(resultSet.getLong("PROJECT_ID"));

                emplProjList.add(emplProj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return emplProjList;
    }

    @Override
    public EmplProj readOneEmplProjIdAndProjectId(Long employeeID, Long progectId) throws SQLException {
        String sql = "SELECT EMPLOYEE_ID, PROJECT_ID FROM EMPL_PROJ WHERE EMPLOYEE_ID=? AND PROJECT_ID=?";

        EmplProj emplProj = new EmplProj();

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, employeeID);
            preparedStatement.setLong(2, progectId);

            ResultSet resultSet = preparedStatement.executeQuery();

            emplProj.setEmployeeId(resultSet.getLong("EMPLOYEE_ID"));
            emplProj.setProjectId(resultSet.getLong("PROJECT_ID"));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return emplProj;
    }

    @Override
    public void update(EmplProj emplProj) throws SQLException {
        String sql = "UPDATE  EmplProj SET Employee_Id=? ,Project_Id=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, emplProj.getEmployeeId());
            preparedStatement.setLong(1, emplProj.getProjectId());
            preparedStatement.executeUpdate();

        } finally {
            if (connection != null) {
                connection.close();
            }
        }

    }

    @Override
    public void delete(EmplProj emplProj) throws SQLException {
        String sql = "REMOVE FROM EmplProj WHERE Employee_Id=? ,Project_Id=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setLong(1, emplProj.getEmployeeId());
            preparedStatement.setLong(1, emplProj.getProjectId());


            preparedStatement.executeUpdate();

        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }
}