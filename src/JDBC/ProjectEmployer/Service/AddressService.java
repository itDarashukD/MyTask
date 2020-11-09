package JDBC.ProjectEmployer.Service;


import ProjectemployeerSecond.ProjectEmployer.DAO.EntityDao;
import ProjectemployeerSecond.ProjectEmployer.Entity.Address;
import ProjectemployeerSecond.ProjectEmployer.Entity.Entity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AddressService extends Entity implements EntityDao {
    Connection connection = null;
    Address address;

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
        String sql = "INSERT INTO Address (id,country,city,street,postCode) value(?,?,?,?,?)";
        preparedStatement = connection.prepareStatement(sql);
        try {
            preparedStatement.setLong(1, address.getId());
            preparedStatement.setString(2, address.getCountry());
            preparedStatement.setString(3, address.getCity());
            preparedStatement.setString(4, address.getStreet());
            preparedStatement.setString(5, address.getPostCode());
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
        Address address = new Address();
        String sql = "SELECT * FROM Address WHERE id=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);

            resultSet = preparedStatement.executeQuery();
            address.setId(resultSet.getLong("Id"));
            address.setCountry(resultSet.getString("Country"));
            address.setCity(resultSet.getString("City"));
            address.setStreet(resultSet.getString("Street"));
            address.setPostCode(resultSet.getString("PostCode"));

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
        return address;
    }

    @Override
    public List getAll() throws SQLException {
        List<Address> addressList = new ArrayList<>();
        String sql = "SELECT * FROM Address";
        ResultSet resultSet = null;
        try (Statement statement = connection.createStatement();) {
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Address address = new Address();
                address.setId(resultSet.getLong("id"));
                address.setCountry(resultSet.getString("country"));
                address.setCity(resultSet.getString("city"));
                address.setStreet(resultSet.getString("street"));
                address.setPostCode(resultSet.getString("postCode"));

                addressList.add(address);
            }
            return addressList;
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (connection != null) {
                connection.close();
            }

        }

    }

    @Override
    public Boolean update(Object entity) throws SQLException {
        String sql = "UPDATE ADDRESS SET Country=?,City=?,Street=?,PostCode=?,Id=?";
        Statement statement = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            statement = connection.createStatement();


            preparedStatement.setString(1, address.getCountry());
            preparedStatement.setString(2, address.getCity());
            preparedStatement.setString(3, address.getStreet());
            preparedStatement.setString(4, address.getPostCode());
            preparedStatement.setLong(5, address.getId());

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
        Statement statement = null;
        String sql = "DELETE FROM Address WHERE Id=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, address.getId());
            preparedStatement.executeUpdate();

        } finally {
            if (connection != null) {
                connection.close();
            }
        }

        return statement.execute(sql);

    }
}