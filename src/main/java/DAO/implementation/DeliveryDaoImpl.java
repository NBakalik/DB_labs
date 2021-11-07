package DAO.implementation;


import DAO.GeneralDAO;
import model.Delivery;
import persistant.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DeliveryDaoImpl implements GeneralDAO<Delivery> {
    private static final String FIND_ALL = "SELECT * FROM bakalik_db.delivery";
    private static final String FIND_BY_ID = "SELECT * FROM bakalik_db.delivery WHERE id=?";
    private static final String CREATE = "INSERT INTO bakalik_db.delivery" +
            "(name) VALUES (?);";
    private static final String UPDATE = "UPDATE bakalik_db.delivery" +
            " SET name = ? WHERE id = ?;";
    private static final String DELETE = "DELETE FROM bakalik_db.delivery WHERE (`id` = ?);";

    @Override
    public List<Delivery> findAll() throws SQLException {
        List<Delivery> deliveries = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
                while (resultSet.next()) {
                    Delivery delivery = new Delivery(resultSet.getInt("id"),
                            resultSet.getString("name"));
                    deliveries.add(delivery);
                }
            }
        }
        return deliveries;
    }

    @Override
    public Delivery findById(Integer id) throws SQLException {
        Delivery delivery = null;
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(FIND_BY_ID)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    delivery = new Delivery(resultSet.getInt("id"),
                            resultSet.getString("name"));
                }
            }
        }
        return delivery;
    }

    @Override
    public void create(Delivery delivery) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(CREATE)) {
            statement.setString(1, delivery.getName());
            statement.executeUpdate();
        }
    }

    @Override
    public void update(Delivery delivery) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(UPDATE)) {
            statement.setString(1, delivery.getName());
            statement.setInt(2, delivery.getId());
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

