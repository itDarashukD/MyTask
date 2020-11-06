package ProjectEmployer.Service;

import ProjectEmployer.Bl.Util;
import ProjectEmployer.DAO.AddressDao;
import ProjectEmployer.Entity.Adress;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdressService extends Util implements AddressDao {

    Connection connection;

    {
        try {
            connection = getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(Adress adress) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO Address (id,country,city,street,postCode) value(?,?,?,?,?)";
        preparedStatement = connection.prepareStatement(sql);
        try {
            preparedStatement.setLong(1, adress.getId());
            preparedStatement.setString(2, adress.getCountry());
            preparedStatement.setString(3, adress.getCity());
            preparedStatement.setString(4, adress.getStreet());
            preparedStatement.setString(5, adress.getPostCode());
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
    public List<Adress> readAllAdress() throws SQLException {
        List<Adress> addressList = new ArrayList<>();
        String sql = "SELECT * FROM Address";
        ResultSet resultSet = null;
        try (Statement statement = connection.createStatement();) {
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Adress adress = new Adress();
                adress.setId(resultSet.getLong("id"));
                adress.setCountry(resultSet.getString("country"));
                adress.setCity(resultSet.getString("city"));
                adress.setStreet(resultSet.getString("street"));
                adress.setPostCode(resultSet.getString("postCode"));

                addressList.add(adress);
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
    public Adress readOneAdress(Long id) throws SQLException {
        ResultSet resultSet = null;
        Adress adress = new Adress();
        String sql = "SELECT * FROM Address WHERE id=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);

            resultSet = preparedStatement.executeQuery();
            adress.setId(resultSet.getLong("Id"));
            adress.setCountry(resultSet.getString("Country"));
            adress.setCity(resultSet.getString("City"));
            adress.setStreet(resultSet.getString("Street"));
            adress.setPostCode(resultSet.getString("PostCode"));

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


        return adress;
    }

    @Override
    public void update(Adress adress) throws SQLException {
        String sql = "UPDATE ADDRESS SET Country=?,City=?,Street=?,PostCode=?,Id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, adress.getCountry());
            preparedStatement.setString(2, adress.getCity());
            preparedStatement.setString(3, adress.getStreet());
            preparedStatement.setString(4, adress.getPostCode());
            preparedStatement.setLong(5, adress.getId());

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
    public void remove(Adress adress) throws SQLException {

        String sql = "DELETE FROM Address WHERE Id=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, adress.getId());
            preparedStatement.executeUpdate();

        } finally {
            if (connection != null) {
                connection.close();
            }
        }


    }
}
