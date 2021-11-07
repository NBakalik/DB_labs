package DAO.implementation;

import DAO.GeneralDAO;
import model.City;
import persistant.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CityDaoImpl implements GeneralDAO<City> {
    private static final String FIND_ALL = "SELECT * FROM bakalik_db.city";
    private static final String FIND_BY_ID = "SELECT * FROM bakalik_db.city WHERE id=?";
    private static final String CREATE = "INSERT INTO bakalik_db.city" +
            "(name, region_id) VALUES (?, ?);";
    private static final String UPDATE = "UPDATE bakalik_db.city" +
            " SET name = ?, region_id = ? WHERE id = ?;";
    private static final String DELETE = "DELETE FROM bakalik_db.city WHERE (`id` = ?);";

    @Override
    public List<City> findAll() throws SQLException {
        List<City> cities = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
                while (resultSet.next()) {
                    City city = new City(resultSet.getInt("id"),
                            resultSet.getString("name"), resultSet.getInt("region_id"));
                    cities.add(city);
                }
            }
        }
        return cities;
    }

    @Override
    public City findById(Integer id) throws SQLException {
        City city = null;
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(FIND_BY_ID)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    city = new City(resultSet.getInt("id"),
                            resultSet.getString("name"), resultSet.getInt("region_id"));
                }
            }
        }
        return city;
    }

    @Override
    public void create(City city) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(CREATE)) {
            statement.setString(1, city.getName());
            statement.setInt(2, city.getRegion());
            statement.executeUpdate();
        }
    }

    @Override
    public void update(City city) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(UPDATE)) {
            statement.setString(1, city.getName());
            statement.setInt(2, city.getRegion());
            statement.setInt(3, city.getId());
            statement.executeUpdate();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(DELETE)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
}
